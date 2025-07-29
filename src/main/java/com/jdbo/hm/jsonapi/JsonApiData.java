package com.jdbo.hm.jsonapi;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiData<T> {
    private String id;
    private String type;
    private T attributes; // Los atributos específicos del recurso (ej. ProductAttributes)
    private Map<String, String> links; // Enlaces específicos del recurso
    private Map<String, JsonApiRelationship> relationships; // Relaciones con otros recursos
    private Map<String, Object> meta; // Metadatos específicos del recurso
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public T getAttributes() {
		return attributes;
	}
	public void setAttributes(T attributes) {
		this.attributes = attributes;
	}
	public Map<String, String> getLinks() {
		return links;
	}
	public void setLinks(Map<String, String> links) {
		this.links = links;
	}
	public Map<String, JsonApiRelationship> getRelationships() {
		return relationships;
	}
	public void setRelationships(Map<String, JsonApiRelationship> relationships) {
		this.relationships = relationships;
	}
	public Map<String, Object> getMeta() {
		return meta;
	}
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}
	
	
	
	public JsonApiData() {
		super();
	}
	
	public JsonApiData(String id, String type, T attributes, Map<String, String> links,
			Map<String, JsonApiRelationship> relationships, Map<String, Object> meta) {
		super();
		this.id = id;
		this.type = type;
		this.attributes = attributes;
		this.links = links;
		this.relationships = relationships;
		this.meta = meta;
	}
	
	public JsonApiData(String id, String type, T attributes) {
	    this.id = id;
	    this.type = type;
	    this.attributes = attributes;
	    this.links =null;
	    this.relationships=null;
	    this.meta=null;
	}
    
    
}