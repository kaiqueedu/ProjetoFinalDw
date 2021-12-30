package com.ifsp.dw2.ProjetoFinalDw.controller;

import com.ifsp.dw2.ProjetoFinalDw.model.Setor;
import com.ifsp.dw2.ProjetoFinalDw.service.SetorService;
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
@RequestMapping(value = "/setor")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    public ResponseEntity<List<Setor>> getSetor() {
        return ResponseEntity.ok(setorService.getAll());
    }

    @PostMapping
    public ResponseEntity createSetor(@RequestBody Setor setor){
        Setor setorSalvo = setorService.createSetor(setor);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity updateSetor(@PathVariable Long id, @RequestBody Setor setor){
        return ResponseEntity.ok(setorService.updateSetor(id, setor));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSetor(@PathVariable Long id) {
        setorService.removeSetor(id);
    }

}
