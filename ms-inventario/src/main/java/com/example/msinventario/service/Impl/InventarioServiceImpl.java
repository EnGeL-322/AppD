package com.example.msinventario.service.Impl;

import com.example.msinventario.entity.Inventario;
import com.example.msinventario.repository.InventarioRepository;
import com.example.msinventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> listar() {
        return inventarioRepository.findAll();
    }

    @Override
    public Optional<Inventario> buscarPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario actualizar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public void borrarPorId(Integer id) {
        inventarioRepository.deleteById(id);
    }
}
