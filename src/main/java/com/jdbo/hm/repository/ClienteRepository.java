package com.jdbo.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdbo.hm.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
