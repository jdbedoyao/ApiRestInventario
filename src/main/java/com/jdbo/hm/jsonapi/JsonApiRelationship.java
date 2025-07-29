package com.jdbo.hm.jsonapi;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiRelationship {
    private Map<String, String> links;
    private List<JsonApiDataIdentifier> data; // Identificadores de los recursos relacionados
    private Map<String, Object> meta;
	
    
    public Map<String, String> getLinks() {
		return links;
	}


	public void setLinks(Map<String, String> links) {
		this.links = links;
	}


	public List<JsonApiDataIdentifier> getData() {
		return data;
	}


	public void setData(List<JsonApiDataIdentifier> data) {
		this.data = data;
	}


	public Map<String, Object> getMeta() {
		return meta;
	}


	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}


	public JsonApiRelationship() {
		super();
	}


	public JsonApiRelationship(Map<String, String> links, List<JsonApiDataIdentifier> data, Map<String, Object> meta) {
		super();
		this.links = links;
		this.data = data;
		this.meta = meta;
	}
    
    
}
