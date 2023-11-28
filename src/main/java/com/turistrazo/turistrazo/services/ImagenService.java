package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.dto.ImagenDataSaveDTO;
import com.turistrazo.turistrazo.models.Imagen;
import com.turistrazo.turistrazo.repositories.ImagenRepository;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> getAll() {
        return imagenRepository.findAll();
    }

    public List<Imagen> getAllByTourId(Integer tourId) {
        return imagenRepository.findAllByTourId(tourId);
    }

    public List<Imagen> getAllBySitioId(Integer sitioId) {
        return imagenRepository.findAllBySitioId(sitioId);
    }

    public List<Imagen> getAllImagen() {
        return imagenRepository.findAll();
    }

    public void saveImageS(ImagenDataSaveDTO infoImages) {
        for (int i = 0; i < infoImages.getNameImages().size(); i++) {
            Imagen imagenx = new Imagen();
            imagenx.setImagen(infoImages.getNameImages().get(i));
            imagenx.setTour(infoImages.getTour());
            imagenRepository.save(imagenx);
        }
    }
}