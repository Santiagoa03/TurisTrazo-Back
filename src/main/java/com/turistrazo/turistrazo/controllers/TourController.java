package com.turistrazo.turistrazo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.Tour;
import com.turistrazo.turistrazo.services.TourService;

@RestController
@RequestMapping("/api/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("")
    public ResponseEntity<List<Tour>> getAllTour() {
        List<Tour> listaTour = tourService.getAll();
        listaTour = listaTour.stream()
                .map(this::mapTour)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaTour);
    }

    @GetMapping("/notvalidated")
    public ResponseEntity<List<Tour>> getAllTourNotValidated() {
        List<Tour> listaTour = tourService.getAllWithotValidado();
        listaTour = listaTour.stream()
                .map(this::mapTour)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaTour);
    }

    private Tour mapTour(Tour tourS) {
        String imageUrl = "/api/images/" + tourS.getImagen();

        Tour tour = new Tour();
        tour.setId(tourS.getId());
        tour.setBarrioMedellin(tourS.getBarrioMedellin());
        tour.setDescripcion(tourS.getDescripcion());
        tour.setGuia(tourS.getGuia());
        tour.setNombre(tourS.getNombre());
        tour.setPrecioPersona(tourS.getPrecioPersona());
        tour.setValidado(tourS.getValidado());
        tour.setTemperatura(tourS.getTemperatura());
        tour.setImagen(imageUrl);

        return tour;
    }

    @GetMapping("{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Integer id) {
        Optional<Tour> tour = tourService.findById(id);

        if (tour.isPresent() && !tour.isEmpty() && tour != null) {

            Tour tourS = mapTour(tour.get());

            return ResponseEntity.ok(tourS);

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("")
    public Tour saveTour(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        tourService.deleteById(id);
    }
}
