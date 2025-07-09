package com.jdbo.hm;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jdbo.hm.entity.Cliente;
import com.jdbo.hm.repository.ClienteRepository;
import com.jdbo.hm.services.ClienteServices;
import com.jdbo.pojos.*;

@RestController
@RequestMapping("/controller")
public class Primera {
	@Autowired
    public ClienteServices clienteServCont;
	
    @GetMapping(value = "/hm", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<List> MostrarMensaje1() {    	
		System.out.println("Número de Clientes en la BD:"+clienteServCont.contarClientes());
		return new ResponseEntity<List>(clienteServCont.obtenerTodos(), HttpStatus.OK);
	}
    
    
    @ResponseBody
    @GetMapping(value = "/consultaClienteId/{idUsuario}") // , produces = MediaType.APPLICATION_JSON_VALUE
	public ResponseEntity<Vector> ConsulClienteId(@PathVariable Long idUsuario) {
    	Vector<Respuesta> vec = new Vector<>();
    	Cliente cliente = clienteServCont.obtenerporId(idUsuario);
    	    if(cliente!=null) {
    	      Respuesta resp = new Respuesta();
          	  resp.setId(cliente.getId_cliente());
        	  resp.setSuccess("true");
        	  resp.setMsg(cliente.getNombre_cliente());
        	  vec.add(resp);
    	    }
    	return new ResponseEntity<Vector>(vec, HttpStatus.OK );
    }
    
    
    @ResponseBody
    @PostMapping(value = "/consultaClienteObj/")
    //@PostMapping(value = "/consultaCliente/{idUsuario}") // , produces = MediaType.APPLICATION_JSON_VALUE
	public ResponseEntity<Vector> ConsulCliente(@RequestBody Cliente us) {
    	Vector<Respuesta> vec = new Vector<>();
    	Cliente cliente = clienteServCont.obtenerporId(us.getId_cliente());
    	    if(cliente!=null) {
    	      Respuesta resp = new Respuesta();
          	  resp.setId(cliente.getId_cliente());
        	  resp.setSuccess("true");
        	  resp.setMsg(cliente.getNombre_cliente());
        	  vec.add(resp);
    	    }
    	return new ResponseEntity<Vector>(vec, HttpStatus.OK );
    }    
    	
}
