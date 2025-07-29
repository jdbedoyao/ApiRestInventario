package com.jdbo.hm.jsonapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL) // No incluye campos nulos en la serialización JSON
public class JsonApiDocument<T> {
    private List<JsonApiData<T>> data; // Lista de recursos primarios
    private List<JsonApiError> errors; // Lista de objetos de error
    private Map<String, Object> meta; // Objeto de metadatos
    private Map<String, String> links; // Objeto de enlaces (self, related, etc.)
    private JsonApiJsonapi jsonapi = new JsonApiJsonapi(); // Información sobre la versión de JSON:API

    // Constructor para un solo recurso
    public JsonApiDocument(JsonApiData<T> singleData) {
        this.data = List.of(singleData);
        this.jsonapi = new JsonApiJsonapi();
    }

    // Constructor para una lista de recursos
    public JsonApiDocument(List<JsonApiData<T>> dataList) {
        this.data = dataList;
        this.jsonapi = new JsonApiJsonapi();
    }

	public List<JsonApiData<T>> getData() {
		return data;
	}

	public void setData(List<JsonApiData<T>> data) {
		this.data = data;
	}

	public List<JsonApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<JsonApiError> errors) {
		this.errors = errors;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public Map<String, String> getLinks() {
		return links;
	}

	public void setLinks(Map<String, String> links) {
		this.links = links;
	}

	public JsonApiJsonapi getJsonapi() {
		return jsonapi;
	}

	public void setJsonapi(JsonApiJsonapi jsonapi) {
		this.jsonapi = jsonapi;
	}

	public JsonApiDocument() {
		super();
	}

	public JsonApiDocument(List<JsonApiData<T>> data, List<JsonApiError> errors, Map<String, Object> meta,
			Map<String, String> links, JsonApiJsonapi jsonapi) {
		super();
		this.data = data;
		this.errors = errors;
		this.meta = meta;
		this.links = links;
		this.jsonapi = jsonapi;
	}
	
	public JsonApiDocument(List<JsonApiError> errors , Class<T> typeHint) {
		super();
		this.data = null;
		this.errors = errors;
		this.meta = null;
		this.links = null;
		this.jsonapi = new JsonApiJsonapi();
	}
    
    
    
}
