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
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
        @Query(value = "Select * from profesor p where p.nombre = :nombre", nativeQuery = true)
    public Profesor buscarProfesor(String nombre);
}

