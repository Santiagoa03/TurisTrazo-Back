package com.turistrazo.turistrazo.dto;

import java.util.List;

import com.turistrazo.turistrazo.models.Tour;

import lombok.Data;

@Data
public class ImagenDataSaveDTO {
    private Tour tour;
    private List<String> nameImages;
}