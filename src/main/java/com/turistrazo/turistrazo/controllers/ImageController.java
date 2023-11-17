package com.turistrazo.turistrazo.controllers;

import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Value("${media.location}")
    private String uploadFolder;

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        Path imagePath = Paths.get(uploadFolder).resolve(imageName);
        try {
            Resource imageFile = new UrlResource(imagePath.toUri());
            if (imageFile.exists() && imageFile.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // o MediaType.IMAGE_PNG, dependiendo del tipo de imagen
                        .body(imageFile);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
