package com.turistrazo.turistrazo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.ReservarTour;
import com.turistrazo.turistrazo.services.ReservaTourService;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaTourService reservaTourService;

    @PostMapping("/save")
    public void postSave(@RequestBody ReservarTour reservarTour) {
        reservaTourService.postSave(reservarTour);
    }

    @GetMapping("/{id}")
    public List<ReservarTour> getFindReserva(@PathVariable("id") Integer id) {
        return reservaTourService.findReservaByIdGuia(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        reservaTourService.deleteById(id);
    }
}
