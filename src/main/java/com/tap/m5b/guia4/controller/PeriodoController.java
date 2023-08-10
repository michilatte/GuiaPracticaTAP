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
@RequestMapping("/periodo")
public class PeriodoController {

    @Autowired
    PeriodoServiceImpl periodoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Periodo>> listaPeriodo() {
        return new ResponseEntity<>(periodoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Periodo> crearPeriodo(@RequestBody Periodo p) {
        return new ResponseEntity<>(periodoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Periodo> actualizarPeriodo(@PathVariable Integer id, @RequestBody Periodo p) {
        Periodo periodo = periodoService.findById(id);

        if (periodo != null) {
            try {
                periodo.setPeriodo(p.getPeriodo());
                periodo.setYear(p.getYear());
                return new ResponseEntity<>(periodoService.save(periodo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Periodo> eliminarPeriodo(@PathVariable Integer id) {
        periodoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
