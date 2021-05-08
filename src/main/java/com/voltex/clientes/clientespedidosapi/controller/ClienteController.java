package com.voltex.clientes.clientespedidosapi.controller;

import java.util.List;

import com.voltex.clientes.clientespedidosapi.model.Cliente;
import com.voltex.clientes.clientespedidosapi.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/list", produces = "application/json")
    public ResponseEntity<List<Cliente>> getClientesList() {
        return ResponseEntity.ok(clienteService.listAllClientes());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }
}