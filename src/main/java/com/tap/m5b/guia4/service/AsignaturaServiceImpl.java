/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.guia4.service;

import com.tap.m5b.guia4.modelo.Asignatura;
import com.tap.m5b.guia4.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisse
 */
@Service
public class AsignaturaServiceImpl extends GenericServiceImpl<Asignatura, Integer> implements GenericService<Asignatura, Integer> {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public CrudRepository<Asignatura, Integer> getDao() {
        return asignaturaRepository;
    }  
}