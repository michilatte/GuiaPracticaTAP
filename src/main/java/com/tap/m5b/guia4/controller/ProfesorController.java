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
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl profesorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listaProfesor() {
        return new ResponseEntity<>(profesorService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor p) {
        return new ResponseEntity<>(profesorService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor p) {
        Profesor profesor = profesorService.findById(id);

        if (profesor != null) {
            try {
                profesor.setNombre(p.getNombre());
                profesor.setApellido(p.getApellido());
                profesor.setCelular(p.getCelular());
                profesor.setCorreo(p.getCorreo());
                profesor.setDireccion(p.getDireccion());
                return new ResponseEntity<>(profesorService.save(profesor), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Integer id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
