package com.example.msmarca.controller;



import com.example.msmarca.entity.Marca;
import com.example.msmarca.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping
    public List<Marca> listar() {
        return marcaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Marca> buscarPorId(@PathVariable Integer id) {
        return marcaService.buscarPorId(id);
    }

    @PostMapping
    public Marca guardar(@RequestBody Marca marca) {
        return marcaService.guardar(marca);
    }

    @PutMapping
    public Marca actualizar(@RequestBody Marca marca) {
        return marcaService.actualizar(marca);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        marcaService.borrarPorId(id);
        return "Marca eliminada";
    }
}
