/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.guia4.service;

import com.tap.m5b.guia4.modelo.*;
import com.tap.m5b.guia4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisse
 */
@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, Integer> implements GenericService<Carrera, Integer> {

    @Autowired
    CarreraRepository carreraRepository;

    @Override
    public CrudRepository<Carrera, Integer> getDao() {
        return carreraRepository;
    }  
}