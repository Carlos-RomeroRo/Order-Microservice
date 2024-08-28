package com.UniversidadDelMagdalena.Orden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UniversidadDelMagdalena.Orden.Service.OrdenService;
import com.UniversidadDelMagdalena.Orden.dto.OrdenDTO;;

@RestController
@RequestMapping("/orders")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<?> postOrder(@RequestBody OrdenDTO ordenDTO) { //
        try {
            return ResponseEntity.ok(ordenService.postOrder(ordenDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Se ha producido un error creando la orden.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) { //
        try {
            return ResponseEntity.ok(ordenService.getOrderById(id));
        } catch (Exception IllegalArgumentException) {
            return ResponseEntity.status(404).body("La id " + id + " no ha sido encontrada.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putOrder(@RequestBody OrdenDTO ordenDTO, @PathVariable("id") Long id) { //
        try {
            return ResponseEntity.status(204).body(ordenService.putOrder(ordenDTO, id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Ha ocurrido un error actualizando la orden.");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchOrder(@RequestBody OrdenDTO ordenDTO, @PathVariable("id") Long id) { //
        try {
            return ResponseEntity.status(204).body(ordenService.patchOrder(ordenDTO, id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Ha ocurrido un error modificando algunos datos de la orden.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) { //
        try {
            ordenService.deleteOrder(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Ha ocurrido un error eliminando la orden.");
        }
    }

}
