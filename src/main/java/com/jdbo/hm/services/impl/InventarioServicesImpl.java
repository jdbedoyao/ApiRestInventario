package com.jdbo.hm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbo.hm.entity.Inventario;
import com.jdbo.hm.repository.InventarioRepository;
import com.jdbo.hm.services.InventarioServices;

@Service
public class InventarioServicesImpl implements InventarioServices {
    @Autowired
	private InventarioRepository ir;

	@Override
	public Inventario obtenerporId(Long id) {
		return ir.findById(id).orElse(null);
	}

	@Override
	public Inventario actualizarInventario(Long id, Inventario inventario) {
		Inventario inventarioDB= ir.findById(id).orElse(null);
		if(inventarioDB!=null) {
			inventarioDB.setId(id);
			inventarioDB.setCantidad(inventario.getCantidad());
			inventarioDB.setProducto_id(inventario.getProducto_id());
			return ir.save(inventarioDB);			
		}
		return null;
	}


}
