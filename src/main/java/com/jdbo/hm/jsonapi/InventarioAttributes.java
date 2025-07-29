package com.jdbo.hm.jsonapi;

public class InventarioAttributes {
	private Long cantidad;
	private String nombre;
	private int precio;
	private String descripcion;
	
	public InventarioAttributes(String nombre, int precio, String descripcion, Long simulatedQuantity) {
		super();
		this.cantidad = simulatedQuantity;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public InventarioAttributes() {
		super();
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	 
	
	
	 
	

}
