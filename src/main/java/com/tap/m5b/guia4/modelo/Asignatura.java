/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.guia4.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author lisse
 */
@Data
@Entity
public class Asignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private int id_asignatura;

    @Column(name = "numhoras")
    private int numhoras;
    
    @Column(name = "numhoras_practicas")
    private int numhoras_practicas;
    
    @Column(name = "numhoras_autonomas")
    private int numhoras_autonomas;

    
    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    private Profesor profesores;
    @ManyToOne
    @JoinColumn(name = "id_ciclo", referencedColumnName = "id_ciclo")
    private Ciclo ciclos;
    @ManyToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    private Carrera carreras;
}
