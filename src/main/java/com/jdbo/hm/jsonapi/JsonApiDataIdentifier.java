package com.jdbo.hm.jsonapi;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiDataIdentifier {
    private String id;
    private String type;
    private Map<String, Object> meta;
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
	public Map<String, Object> getMeta() {
		return meta;
	}
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}
	public JsonApiDataIdentifier(String id, String type, Map<String, Object> meta) {
		super();
		this.id = id;
		this.type = type;
		this.meta = meta;
	}
	
	public JsonApiDataIdentifier() {
		super();
	}
    
    
}
