package com.voltex.clientes.clientespedidosapi.dao;

import com.voltex.clientes.clientespedidosapi.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
