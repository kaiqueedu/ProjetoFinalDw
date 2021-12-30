package com.ifsp.dw2.ProjetoFinalDw.controller;

import com.ifsp.dw2.ProjetoFinalDw.model.Projeto;
import com.ifsp.dw2.ProjetoFinalDw.service.ProjetoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> getProjeto() {
        return ResponseEntity.ok(projetoService.getAll());
    }

    @PostMapping
    public ResponseEntity createProjeto(@RequestBody Projeto projeto){
        Projeto projetoSalvo = projetoService.createProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto){
        return ResponseEntity.ok(projetoService.updateProjeto(id, projeto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProjeto(@PathVariable Long id) {
        projetoService.removeProjeto(id);
    }

}
