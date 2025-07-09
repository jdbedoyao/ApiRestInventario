package com.jdbo.hm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_cliente_3")
public class Cliente {
 @Id	
 private Long id_cliente;
 private int cuenta;
 private String nombre_cliente;
 private String id_servicio;
 private String nodo;
 private String usuario;
 
 public Cliente() {
	super();
 }

 public Long getId_cliente() {
	return id_cliente;
 }

 public void setId_cliente(Long id_cliente) {
	this.id_cliente = id_cliente;
 }

 public int getCuenta() {
	return cuenta;
 }

 public void setCuenta(int cuenta) {
	this.cuenta = cuenta;
 }

 public String getNombre_cliente() {
	return nombre_cliente;
 }

 public void setNombre_cliente(String nombre_cliente) {
	this.nombre_cliente = nombre_cliente;
 }

 public String getId_servicio() {
	return id_servicio;
 }

 public void setId_servicio(String id_servicio) {
	this.id_servicio = id_servicio;
 }

 public String getNodo() {
	return nodo;
 }

 public void setNodo(String nodo) {
	this.nodo = nodo;
 }

 public String getUsuario() {
	return usuario;
 }

 public void setUsuario(String usuario) {
	this.usuario = usuario;
 }
 
 
 
}
