package br.com.henrique.sgps.controller;

import br.com.henrique.sgps.dtos.CreateParticipanteRequest;
import br.com.henrique.sgps.service.ParticipanteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {


   private final ParticipanteService service;


    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateParticipanteRequest request){
        var response = service.create(request);
        return ResponseEntity.ok(null);
    }

}
