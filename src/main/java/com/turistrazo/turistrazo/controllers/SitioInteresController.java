package com.turistrazo.turistrazo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.SitioInteres;
import com.turistrazo.turistrazo.services.SitioInteresService;

@RestController
@RequestMapping("/api/interest-site")
public class SitioInteresController {

    @Value("${media.location}")
    private String uploadFolder;

    @Autowired
    private SitioInteresService sitioInteresService;

    @GetMapping("")
    public ResponseEntity<List<SitioInteres>> getAllSitiosInteres() {
        List<SitioInteres> sitiosInteres = sitioInteresService.getAll();

        sitiosInteres = sitiosInteres.stream()
                .map(this::mapToSitioInteres)
                .collect(Collectors.toList());
        return ResponseEntity.ok(sitiosInteres);
    }

    private SitioInteres mapToSitioInteres(SitioInteres sitioInteres) {
        String imageUrl = "/api/images/" + sitioInteres.getImagen();

        SitioInteres sitioInteresS = new SitioInteres();
        sitioInteresS.setId(sitioInteres.getId());
        sitioInteresS.setNombreSitio(sitioInteres.getNombreSitio());
        sitioInteresS.setBarrioMedellin(sitioInteres.getBarrioMedellin());
        sitioInteresS.setDescripcion(sitioInteres.getDescripcion());
        sitioInteresS.setImagen(imageUrl);

        return sitioInteresS;
    }

    @GetMapping("{id}")
    public ResponseEntity<SitioInteres> getSitioInteresById(@PathVariable Integer id) {
        Optional<SitioInteres> sitioInteres = sitioInteresService.findById(id);

        if (sitioInteres.isPresent() && !sitioInteres.isEmpty() && sitioInteres != null) {

            SitioInteres sitio = mapToSitioInteres(sitioInteres.get());

            return ResponseEntity.ok(sitio);

        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
