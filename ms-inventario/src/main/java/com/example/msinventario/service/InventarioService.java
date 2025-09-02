package com.example.msinventario.service;

import com.example.msinventario.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    List<Inventario> listar();
    Optional<Inventario> buscarPorId(Integer id);
    Inventario guardar(Inventario inventario);
    Inventario actualizar(Inventario inventario);
    void borrarPorId(Integer id);
}