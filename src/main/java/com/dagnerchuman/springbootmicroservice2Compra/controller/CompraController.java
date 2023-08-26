package com.dagnerchuman.springbootmicroservice2Compra.controller;

import com.dagnerchuman.springbootmicroservice2Compra.model.Compra;
import com.dagnerchuman.springbootmicroservice2Compra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra)
    {
        // Calcula el total multiplicando precio por cantidad
        double total = compra.getPrecioCompra() * compra.getCantidad();
        compra.setPrecioCompra(total);

        Compra nuevaCompra = compraService.saveCompra(compra);
        return ResponseEntity.ok(nuevaCompra);
    }


    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(compraService.findAllComprasOfUser(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompra(@PathVariable Long id, @RequestBody Compra compra) {
        try {
            Compra updatedCompra = compraService.updateCompra(id, compra);
            if (updatedCompra != null) {
                return ResponseEntity.ok(updatedCompra);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la compra: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCompras() {
        return ResponseEntity.ok(compraService.findAllCompras());
    }

}
