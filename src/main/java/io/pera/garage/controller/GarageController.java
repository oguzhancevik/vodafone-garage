package io.pera.garage.controller;

import io.pera.garage.service.GarageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/garage")
@AllArgsConstructor
public class GarageController {

    private final GarageService garageService;

    @PostMapping
    public ResponseEntity<String> command(@RequestBody String request) {
        return ResponseEntity.ok(garageService.command(request));
    }

}
