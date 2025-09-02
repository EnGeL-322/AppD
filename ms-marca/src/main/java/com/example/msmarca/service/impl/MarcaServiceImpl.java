package com.example.msmarca.service.impl;

import com.example.msmarca.entity.Marca;
import com.example.msmarca.repository.MarcaRepository;
import com.example.msmarca.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;       // ✅ Spring Data
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public Page<Marca> listar(Pageable pageable, String q) {
        if (q != null && !q.isBlank()) {
            return repo.findByNombreContainingIgnoreCase(q, pageable);
        }
        return repo.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Marca obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca no encontrada"));
    }

    @Override
    public Marca crear(Marca m) {
        if (repo.existsByNombreIgnoreCase(m.getNombre())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe una marca con ese nombre");
        }
        m.setId(null);
        return repo.save(m);
    }

    @Override
    public Marca actualizar(Long id, Marca m) {
        Marca actual = obtener(id);
        if (m.getNombre() != null &&
                !m.getNombre().equalsIgnoreCase(actual.getNombre()) &&
                repo.existsByNombreIgnoreCase(m.getNombre())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre ya en uso");
        }
        actual.setNombre(m.getNombre());
        actual.setDescripcion(m.getDescripcion());
        if (m.getActivo() != null) actual.setActivo(m.getActivo());
        return repo.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca no encontrada");
        }
        repo.deleteById(id);
    }
}
