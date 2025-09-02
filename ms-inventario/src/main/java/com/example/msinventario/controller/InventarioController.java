package com.example.msinventario.controller;

import com.example.msinventario.entity.Inventario;
import com.example.msinventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> buscarPorId(@PathVariable Integer id) {
        return inventarioService.buscarPorId(id);
    }

    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @PutMapping
    public Inventario actualizar(@RequestBody Inventario inventario) {
        return inventarioService.actualizar(inventario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        inventarioService.borrarPorId(id);
        return "Inventario eliminado";
    }
}
