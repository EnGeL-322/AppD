package com.example.msmarca.service;

import com.example.msmarca.entity.Marca;
import org.springframework.data.domain.Page;       // ✅ Spring Data
import org.springframework.data.domain.Pageable;

public interface MarcaService {
    Page<Marca> listar(Pageable pageable, String q);
    Marca obtener(Long id);
    Marca crear(Marca m);
    Marca actualizar(Long id, Marca m);
    void eliminar(Long id);
}
