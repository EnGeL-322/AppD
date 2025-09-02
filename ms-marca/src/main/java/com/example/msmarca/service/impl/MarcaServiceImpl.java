package com.example.msmarca.service.impl;

import com.example.msmarca.entity.Marca;
import com.example.msmarca.repository.MarcaRepository;
import com.example.msmarca.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> buscarPorId(Integer id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca actualizar(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void borrarPorId(Integer id) {
        marcaRepository.deleteById(id);
    }
}
