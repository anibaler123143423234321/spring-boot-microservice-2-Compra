package com.dagnerchuman.springbootmicroservice2Compra.service;

import com.dagnerchuman.springbootmicroservice2Compra.model.Compra;
import com.dagnerchuman.springbootmicroservice2Compra.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra saveCompra(Compra compra)
    {
        compra.setFechaCompra(LocalDateTime.now());

        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> findAllComprasOfUser(Long userId)
    {

        return compraRepository.findAllByUserId(userId);
    }


    @Override
    public Compra updateCompra(Long id, Compra compra) {
        Optional<Compra> existingCompra = compraRepository.findById(id);

        if (existingCompra.isPresent()) {
            Compra updatedCompra = existingCompra.get();
            updatedCompra.setEstadoCompra(compra.getEstadoCompra());
            return compraRepository.save(updatedCompra);
        } else {
            return null; // La compra no existe
        }
    }

    @Override
    public List<Compra> findAllCompras() {
        return compraRepository.findAll();
    }

}
