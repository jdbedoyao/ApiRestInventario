package com.jdbo.hm.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbo.hm.entity.Inventario;
import com.jdbo.hm.jsonapi.JsonApiData;
import com.jdbo.hm.jsonapi.JsonApiDocument;
import com.jdbo.hm.jsonapi.JsonApiError;
import com.jdbo.hm.jsonapi.ProductoAttributes;
import com.jdbo.hm.jsonapi.InventarioAttributes;
import com.jdbo.hm.services.InventarioServices;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    // Aquí configuramos timeouts básicos.
    private final OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    // URL del microservicio de productos al que se va  a llamar.
    private static final String PRODUCTOS_API_URL = "http://localhost:8084/ExApiRestProducto/V.1/productos"; 
	
    // ObjectMapper para deserializar las respuestas JSON:API del otro microservicio
    private final ObjectMapper objectMapper = new ObjectMapper();
    
	@Autowired
    public InventarioServices inventarioServCont;
	
	
	
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/{id}/cantidad")
    @ResponseBody
	public ResponseEntity<JsonApiDocument<InventarioAttributes>> getProducto(@PathVariable Long id) {
     
		Optional<Inventario> invenOptional = null;
		try {
			invenOptional = Optional.of(inventarioServCont.obtenerporId(id));
		} catch (Exception e) {
			e.printStackTrace();
			JsonApiError error = new JsonApiError();
			error.setStatus("404");
			error.setTitle("Inventario no encontrado");
			error.setDetail("No se pudo Encontrar el codigo de producto : " + id +" en la tabla de inventario de productos");
			return new ResponseEntity<>(new JsonApiDocument<>(List.of(error), InventarioAttributes.class),
					HttpStatus.NOT_FOUND);
		}
    	  Inventario inv = null;
          if (invenOptional.isPresent()) {
              inv = invenOptional.get();
          } else {
              // Si el post no se encuentra, retorna un error JSON:API
              JsonApiError error = new JsonApiError();
              error.setStatus("404");
              error.setTitle("Not Found");
              error.setDetail("Inventario con codigo de producto ID " + id + " no encontrado.");
              return new ResponseEntity<>(new JsonApiDocument<>(List.of(error), InventarioAttributes.class), HttpStatus.NOT_FOUND);
          }
          
    	  String productoApiUrl = PRODUCTOS_API_URL + "/" + id;
          Request request = new Request.Builder()
                  .url(productoApiUrl)
                  .method("GET", null)
                  .header(HttpHeaders.ACCEPT, "application/vnd.api+json")
                  .build();

          try {
              Response response = httpClient.newCall(request).execute();

              if (response.isSuccessful() && response.body() != null) {
                  String responseBody = response.body().string();
                  
                  // Deserializa la respuesta JSON:API del microservicio de productos
                  JsonApiDocument<ProductoAttributes> productDocument = 
                      objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructParametricType(JsonApiDocument.class, ProductoAttributes.class));

                  // Verifica si se encontró el producto en el servicio remoto
                  if (productDocument != null && productDocument.getData() != null && !productDocument.getData().isEmpty()) {
                      JsonApiData<ProductoAttributes> productData = productDocument.getData().get(0);
                      ProductoAttributes prodOrigAttributes = productData.getAttributes();

                      // Crea nuevos atributos con la cantidad disponible
                      InventarioAttributes responseAttributes = new InventarioAttributes(
                    	  prodOrigAttributes.getNombre(),
                    	  prodOrigAttributes.getPrecio(),
                    	  prodOrigAttributes.getDescripcion(),
                          inv.getCantidad()
                      );

                      // Crea un nuevo JsonApiData con los atributos actualizados
                      JsonApiData<InventarioAttributes> responseData = new JsonApiData<>(
                          productData.getId(),
                          productData.getType(),
                          responseAttributes
                      );

                      // Envuelve en un JsonApiDocument y retorna
                      JsonApiDocument<InventarioAttributes> finalDocument = new JsonApiDocument<>(responseData);
                      return new ResponseEntity<>(finalDocument, HttpStatus.OK);

                  } else {
                      // Si el servicio de productos no devolvió datos o devolvió un error JSON:API
                      // Puedes analizar productDocument.getErrors() si el servicio remoto envía errores JSON:API
                      JsonApiError error = new JsonApiError();
                      error.setStatus(String.valueOf(response.code()));
                      error.setTitle("Producto no encontrado en servicio remoto");
                      error.setDetail("El producto con ID " + id + " no fue encontrado en el microservicio de productos.");
                      return new ResponseEntity<>(new JsonApiDocument<>(List.of(error), InventarioAttributes.class), HttpStatus.NOT_FOUND);
                  }

              } else {
                  // Si la llamada al microservicio de productos no fue exitosa (ej. 404, 500)
                  String errorDetail = "Error al consultar el servicio de productos. Código: " + response.code();
                  if (response.body() != null) {
                      errorDetail += ". Mensaje: " + response.body().string();
                  }

                  JsonApiError error = new JsonApiError();
                  error.setStatus(String.valueOf(response.code()));
                  error.setTitle("Fallo en la comunicación con servicio externo");
                  error.setDetail(errorDetail.replace("\"", "\\\""));
                  return new ResponseEntity<>(new JsonApiDocument<>(List.of(error), InventarioAttributes.class), HttpStatus.INTERNAL_SERVER_ERROR);
              }
          } catch (IOException e) {
              System.err.println("Excepción de I/O al llamar al microservicio de productos: " + e.getMessage());
              e.printStackTrace();

              JsonApiError error = new JsonApiError();
              error.setStatus("500");
              error.setTitle("Error de comunicación de red");
              error.setDetail("No se pudo conectar con el servicio de productos: " + e.getMessage().replace("\"", "\\\""));
              return new ResponseEntity<>(new JsonApiDocument<>(List.of(error), InventarioAttributes.class), HttpStatus.INTERNAL_SERVER_ERROR);
          }
    	
	}
    
    
  
     
    

    
    
    
    	
}
