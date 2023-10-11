package com.turistrazo.turistrazo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.Tour;
import com.turistrazo.turistrazo.services.TourService;

@RestController
@RequestMapping("/api/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("")
    public List<Tour> getAllTour() {
        return tourService.getAll();
    }
}
