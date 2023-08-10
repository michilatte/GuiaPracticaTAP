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
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    AsignaturaServiceImpl asignaturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Asignatura>> listaAsignatura() {
        return new ResponseEntity<>(asignaturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura a) {
        return new ResponseEntity<>(asignaturaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable Integer id, @RequestBody Asignatura a) {
        Asignatura asignatura = asignaturaService.findById(id);

        if (asignatura != null) {
            try {
                asignatura.setNumhoras(a.getNumhoras());
                asignatura.setNumhoras_practicas(a.getNumhoras_practicas());
                asignatura.setNumhoras_autonomas(a.getNumhoras_autonomas());
                asignatura.setProfesores(a.getProfesores());
                asignatura.setCarreras(a.getCarreras());
                asignatura.setCiclos(a.getCiclos());

                return new ResponseEntity<>(asignaturaService.save(asignatura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Asignatura> eliminarAsignatura(@PathVariable Integer id) {
        asignaturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
