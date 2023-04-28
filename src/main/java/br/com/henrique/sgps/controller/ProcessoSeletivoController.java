package br.com.henrique.sgps.controller;

import br.com.henrique.sgps.dtos.seletivo.*;
import br.com.henrique.sgps.service.seletivo.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/processo-seletivo")
public class ProcessoSeletivoController {


    private final CreateProcessoSeletivo createProcessoSeletivo;

    private final FindProcessoSeletivoDetailById findProcessoSeletivoDetailById;

    private final FindAllProcessoSeletivoDetail findAllProcessoSeletivoDetail;

    private final UpdateProcessoSeletivo updateProcessoSeletivo;

    @PostMapping
    public ResponseEntity<CreateProcessoSeletivoResponse> create(@Valid @RequestBody CreateProcessoSeletivoRequest request) {
        var response = createProcessoSeletivo.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindProcessoSeletivoDetailByIdResponse> findById(@PathVariable Integer id){
        FindProcessoSeletivoDetailByIdResponse response = this.findProcessoSeletivoDetailById.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<FindAllProcessoSeletivoDetailResponse>> findAll(){
        List<FindAllProcessoSeletivoDetailResponse> response = this.findAllProcessoSeletivoDetail.execute();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProcessoSeletivoResponse> update(
            @PathVariable Integer id,
            @RequestBody UpdateProcessoSeletivoRequest request
    ){
        UpdateProcessoSeletivoResponse response = this.updateProcessoSeletivo.execute(id, request);
        return ResponseEntity.ok(response);
    }

}
