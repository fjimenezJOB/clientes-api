package com.voltex.clientes.clientespedidosapi.service;

import java.util.List;


import com.voltex.clientes.clientespedidosapi.dao.ClienteRepository;
import com.voltex.clientes.clientespedidosapi.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> listAllClientes(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
