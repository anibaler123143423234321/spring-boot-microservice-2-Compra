package com.dagnerchuman.springbootmicroservice2Compra.repository;

import com.dagnerchuman.springbootmicroservice2Compra.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByUserId(Long userId);
}
