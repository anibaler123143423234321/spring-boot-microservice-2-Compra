package com.dagnerchuman.springbootmicroservice2Compra.service;

import com.dagnerchuman.springbootmicroservice2Compra.model.Compra;

import java.util.List;

public interface CompraService {
    Compra saveCompra(Compra compra);

    List<Compra> findAllComprasOfUser(Long userId);


    Compra updateCompra(Long id, Compra compra);


    // Nuevo método para listar todas las compras
    List<Compra> findAllCompras();

}
