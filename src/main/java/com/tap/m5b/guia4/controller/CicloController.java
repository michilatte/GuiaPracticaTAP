/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.guia4.controller;

import com.tap.m5b.guia4.modelo.*;
import com.tap.m5b.guia4.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lisse
 */
@RestController
@RequestMapping("/ciclo")
public class CicloController {

    @Autowired
    CicloServiceImpl cicloService;

    @GetMapping("/listar")
    public ResponseEntity<List<Ciclo>> listaCiclo() {
        return new ResponseEntity<>(cicloService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Ciclo> crearCiclo(@RequestBody Ciclo c) {
        return new ResponseEntity<>(cicloService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ciclo> actualizarCiclo(@PathVariable Integer id, @RequestBody Ciclo c) {
        Ciclo ciclo = cicloService.findById(id);

        if (ciclo != null) {
            try {
                ciclo.setNombre(c.getNombre());
                ciclo.setDescripcion(c.getDescripcion());
                ciclo.setPeriodos(c.getPeriodos());
                return new ResponseEntity<>(cicloService.save(ciclo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Ciclo> eliminarCiclo(@PathVariable Integer id) {
        cicloService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
