package com.jdbo.hm.services;

import java.util.List;

import com.jdbo.hm.entity.Inventario;

public interface InventarioServices {
	
	Inventario obtenerporId(Long id);
	
	Inventario actualizarInventario(Long id , Inventario cliente);
	
}
