package com.example.msmarca.controller;

import com.example.msmarca.entity.Marca;
import com.example.msmarca.service.MarcaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;                // ✅ Lombok para el constructor
import org.springframework.data.domain.Page;        // ✅ Spring Data
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor                           // ✅ genera constructor con 'service'
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    public Page<Marca> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort,
            @RequestParam(required = false) String q
    ) {
        Pageable pageable = PageRequest.of(page, size, parseSort(sort));
        return service.listar(pageable, q);
    }

    @GetMapping("/{id}")
    public Marca obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Marca crear(@Valid @RequestBody Marca m) {
        return service.crear(m);
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable Long id, @Valid @RequestBody Marca m) {
        return service.actualizar(id, m);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    private Sort parseSort(String[] sort) {
        if (sort == null || sort.length == 0) return Sort.by("id").ascending();
        Sort result = Sort.unsorted();
        for (String s : sort) {
            String[] parts = s.split(",");
            String prop = parts[0];
            boolean asc = parts.length < 2 || parts[1].equalsIgnoreCase("asc");
            result = result.and(asc ? Sort.by(prop).ascending() : Sort.by(prop).descending());
        }
        return result;
    }
}
