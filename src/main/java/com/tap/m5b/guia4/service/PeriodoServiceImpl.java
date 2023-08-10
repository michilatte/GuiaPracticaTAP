/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.guia4.service;

import com.tap.m5b.guia4.modelo.*;
import com.tap.m5b.guia4.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisse
 */
@Service
public class PeriodoServiceImpl extends GenericServiceImpl<Periodo, Integer> implements GenericService<Periodo, Integer> {

    @Autowired
    PeriodoRepository periodoRepository;

    @Override
    public CrudRepository<Periodo, Integer> getDao() {
        return periodoRepository;
    }  
}