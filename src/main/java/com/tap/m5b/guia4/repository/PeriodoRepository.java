/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.guia4.repository;

import com.tap.m5b.guia4.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{
        @Query(value = "Select * from periodo p where p.periodo = :periodo", nativeQuery = true)
    public Periodo buscarPeriodo(String periodo);
}

