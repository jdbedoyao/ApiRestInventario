package com.jdbo.hm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="inventario")
public class Inventario {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Long producto_id;
 private Long cantidad;

 public Inventario(Long id, Long producto_id, Long cantidad) {
	super();
	this.id = id;
	this.producto_id = producto_id;
	this.cantidad = cantidad;
 }

 public Inventario() {
	super();
 }

 public Long getId() {
	return id;
 }

 public void setId(Long id) {
	this.id = id;
 }

 public Long getProducto_id() {
	return producto_id;
 }

 public void setProducto_id(Long porducto_id) {
	this.producto_id = porducto_id;
 }

 public Long getCantidad() {
	return cantidad;
 }

 public void setCantidad(Long cantidad) {
	this.cantidad = cantidad;
 }
 

 
 
}
