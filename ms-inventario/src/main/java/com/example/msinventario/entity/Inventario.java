package com.example.msinventario.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación lógica al producto (simple por ahora)
    private Integer productoId;

    // Datos de stock
    private Integer cantidad;       // stock actual
    private Integer stockMinimo;    // umbral de alerta
    private String almacen;         // nombre o código de almacén
}