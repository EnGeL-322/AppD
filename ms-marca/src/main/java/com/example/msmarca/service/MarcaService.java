package com.example.msmarca.service;



import com.example.msmarca.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> listar();
    Optional<Marca> buscarPorId(Integer id);
    Marca guardar(Marca marca);
    Marca actualizar(Marca marca);
    void borrarPorId(Integer id);
}
