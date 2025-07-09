package com.jdbo.hm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdbo.hm.entity.Cliente;
import com.jdbo.hm.services.ClienteServices;

@Controller
@RequestMapping("/htmlclientes")
public class ClienteController {
    @Autowired
	private ClienteServices cs; 
	
    @GetMapping("/listadototal")
    public String getListadoTotal(Model modelo) {
    	List<Cliente> listac = cs.obtenerTodos();
    	modelo.addAttribute("listaClientes", listac);
    	return "listadoClientes";
    }
    
}
