package com.example.msmarca.repository;

import com.example.msmarca.entity.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    boolean existsByNombreIgnoreCase(String nombre);
    Page<Marca> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}
