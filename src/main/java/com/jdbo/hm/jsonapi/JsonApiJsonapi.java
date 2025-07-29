package com.jdbo.hm.jsonapi;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiJsonapi {
	private String version = "1.0"; // Versión del estándar JSON:API

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public JsonApiJsonapi(String version) {
		super();
		this.version = version;
	}

	public JsonApiJsonapi() {
		super();
	}
	
}

