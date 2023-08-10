/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.guia4.service;

import com.tap.m5b.guia4.modelo.Profesor;
import com.tap.m5b.guia4.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisse
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Integer> implements GenericService<Profesor, Integer> {

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public CrudRepository<Profesor, Integer> getDao() {
        return profesorRepository;
    }  
}