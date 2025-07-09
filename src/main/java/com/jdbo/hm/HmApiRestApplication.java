package com.jdbo.hm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jdbo.hm.entity.Cliente;
import com.jdbo.hm.services.ClienteServices;

@SpringBootApplication
@ComponentScan
public class HmApiRestApplication implements CommandLineRunner {
	@Autowired
    public ClienteServices clienteServ;
    
	public static void main(String[] args) {
		SpringApplication.run(HmApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente c = new Cliente();
		c.setId_cliente(3L);
		c.setCuenta(23218769);
		c.setId_servicio("Nevera");
		c.setNodo("San berardino");
		c.setNombre_cliente("Kamil medina");
		c.setUsuario("KMMB");
		clienteServ.crearCliente(c);
		System.out.println("Número de Clientes en la BD:"+clienteServ.contarClientes());

		for(int i=0; i<=clienteServ.obtenerTodos().size()-1; i++) {
			System.out.println(clienteServ.obtenerTodos().get(i).getNombre_cliente());	
		}
		
	}

}
