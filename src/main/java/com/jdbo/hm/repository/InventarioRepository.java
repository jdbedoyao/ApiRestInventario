package com.jdbo.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdbo.hm.entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long> {

}
