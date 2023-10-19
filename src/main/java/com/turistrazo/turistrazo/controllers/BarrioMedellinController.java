package com.turistrazo.turistrazo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.BarrioMedellin;
import com.turistrazo.turistrazo.services.BarrioMedellinService;

@RestController
@RequestMapping("/api/neighborhood")
public class BarrioMedellinController {

    @Autowired
    private BarrioMedellinService barrioMedellinService;

    @GetMapping("")
    public List<BarrioMedellin> getAllBarrios() {
        return barrioMedellinService.getAll();
    }

}
