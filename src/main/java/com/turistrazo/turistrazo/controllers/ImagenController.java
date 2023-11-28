package com.turistrazo.turistrazo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.dto.ImagenDataDTO;
import com.turistrazo.turistrazo.models.Imagen;
import com.turistrazo.turistrazo.services.ImagenService;

@RestController
@RequestMapping("/api/imagen")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @PostMapping("")
    public ResponseEntity<List<Imagen>> getAllImagen(@RequestBody ImagenDataDTO imagenData) {

        List<Imagen> imagenes = new ArrayList<Imagen>();

        if (imagenData.getIsSitio()) {
            imagenes = imagenService.getAllBySitioId(imagenData.getId());
        } else {
            imagenes = imagenService.getAllByTourId(imagenData.getId());
        }
        imagenes = imagenes.stream()
                .map(this::mapImagen)
                .collect(Collectors.toList());

        return ResponseEntity.ok(imagenes);
    }

    private Imagen mapImagen(Imagen imagen) {
        String imageUrl = "/api/images/" + imagen.getImagen();

        Imagen imagenS = new Imagen();
        imagenS.setId(imagen.getId());
        imagenS.setSitioInteres(imagen.getSitioInteres());
        imagenS.setTour(imagen.getTour());
        imagenS.setImagen(imageUrl);

        return imagenS;
    }

}
