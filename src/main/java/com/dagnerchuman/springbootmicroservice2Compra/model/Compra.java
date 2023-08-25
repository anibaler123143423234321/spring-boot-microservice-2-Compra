package com.dagnerchuman.springbootmicroservice2Compra.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "precio", nullable = false)
    private Double precioCompra;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Agrega el campo estadoCompra y establece su valor por defecto
    @Column(name = "estado_compra", nullable = false)
    private String estadoCompra = "Pendiente Por Revisar";

}
