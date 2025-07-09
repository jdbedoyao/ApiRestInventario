package com.jdbo.hm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbo.hm.entity.Cliente;
import com.jdbo.hm.repository.ClienteRepository;
import com.jdbo.hm.services.ClienteServices;

@Service
public class ClienteServicesImpl implements ClienteServices {
    @Autowired
	private ClienteRepository cr;
	@Override
	public List<Cliente> obtenerTodos() {
           
		return cr.findAll();
	}

	@Override
	public Cliente obtenerporId(Long id) {
		return cr.findById(id).orElse(null);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		return cr.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Long id, Cliente cliente) {
		Cliente clienteDB= cr.findById(id).orElse(null);
		if(clienteDB!=null) {
			clienteDB.setCuenta(cliente.getCuenta());
			clienteDB.setId_servicio(cliente.getId_servicio());
			clienteDB.setNodo(cliente.getNodo());
			clienteDB.setNombre_cliente(cliente.getNombre_cliente());
			clienteDB.setUsuario(cliente.getUsuario());
			return cr.save(clienteDB);			
		}
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
       cr.deleteById(id);   
		
	}

	@Override
	public long contarClientes() {
		return cr.count();
	}

}
