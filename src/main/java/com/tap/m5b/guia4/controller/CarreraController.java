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
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    CarreraServiceImpl carreraService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carrera>> listaCarrera() {
        return new ResponseEntity<>(carreraService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Carrera> crearCarrera(@RequestBody Carrera c) {
        return new ResponseEntity<>(carreraService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera c) {
        Carrera carrera = carreraService.findById(id);

        if (carrera != null) {
            try {
                carrera.setNombre(c.getNombre());
                carrera.setDescripcion(c.getDescripcion());
                return new ResponseEntity<>(carreraService.save(carrera), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarCarrera(@PathVariable Integer id) {
        carreraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
