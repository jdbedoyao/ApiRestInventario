package com.jdbo.hm.jsonapi;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonApiError {
    private String id;
    private Map<String, String> links;
    private String status;
    private String code;
    private String title;
    private String detail;
    private Map<String, Object> source;
    private Map<String, Object> meta;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, String> getLinks() {
		return links;
	}
	public void setLinks(Map<String, String> links) {
		this.links = links;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Map<String, Object> getSource() {
		return source;
	}
	public void setSource(Map<String, Object> source) {
		this.source = source;
	}
	public Map<String, Object> getMeta() {
		return meta;
	}
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}
	public JsonApiError(String id, Map<String, String> links, String status, String code, String title, String detail,
			Map<String, Object> source, Map<String, Object> meta) {
		super();
		this.id = id;
		this.links = links;
		this.status = status;
		this.code = code;
		this.title = title;
		this.detail = detail;
		this.source = source;
		this.meta = meta;
	}
	public JsonApiError() {
		super();
	}
    
    
}
