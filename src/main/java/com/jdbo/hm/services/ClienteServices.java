package com.jdbo.hm.services;

import java.util.List;

import com.jdbo.hm.entity.Cliente;

public interface ClienteServices {
	
	List<Cliente> obtenerTodos();
	
	Cliente obtenerporId(Long id);
	
	Cliente crearCliente(Cliente cliente);
	
	Cliente actualizarCliente(Long id , Cliente cliente);
	
	void eliminarCliente(Long id);
	
	long contarClientes(); 
}
