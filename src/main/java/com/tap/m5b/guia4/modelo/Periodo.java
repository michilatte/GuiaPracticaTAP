/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.guia4.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author lisse
 */

@Data
@Entity
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private int id_periodo;

    @Column(name = "periodo")
    private String periodo;

    @Column(name = "year")
    private int year;
    
    @JsonIgnore  //solo va en la relacion principal
    @OneToMany(mappedBy = "periodos")
    private List<Ciclo> listaciclos;

}
