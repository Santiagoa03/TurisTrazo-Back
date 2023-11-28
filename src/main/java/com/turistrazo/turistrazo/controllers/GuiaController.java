package com.turistrazo.turistrazo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.Guia;
import com.turistrazo.turistrazo.services.GuiaService;

@RestController
@RequestMapping("/api/guide")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @GetMapping("{id}")
    public Guia getGuideById(@PathVariable Integer id) {
        return guiaService.findById(id);
    }

}
