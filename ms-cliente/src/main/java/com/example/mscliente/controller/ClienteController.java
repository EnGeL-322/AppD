package com.example.mscliente.controller;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.sercice.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @PutMapping
    public Cliente actualizar(@RequestBody Cliente cliente) {
        return clienteService.actualizar(cliente);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.borrarPorId(id);
        return "Cliente eliminado";
    }
}
