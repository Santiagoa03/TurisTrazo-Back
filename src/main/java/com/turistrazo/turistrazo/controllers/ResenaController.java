package com.turistrazo.turistrazo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.ResenaCalificacion;
import com.turistrazo.turistrazo.services.ResenaService;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping("")
    public List<ResenaCalificacion> getAllResena() {
        return resenaService.getAllResenas();
    }

    @GetMapping("/{id}")
    public List<ResenaCalificacion> getFindResena(@PathVariable("id") Integer id) {
        return resenaService.getAllByIdTour(id);
    }

    @PostMapping("/save")
    public void saveResena(@RequestBody ResenaCalificacion resenaNew) {
        resenaService.saveResena(resenaNew);
    }

}
