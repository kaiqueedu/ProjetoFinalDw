package com.ifsp.dw2.ProjetoFinalDw.controller;

import com.ifsp.dw2.ProjetoFinalDw.model.Grupo;
import com.ifsp.dw2.ProjetoFinalDw.service.GrupoService;
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
@RequestMapping(value = "/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<Grupo>> getGrupo() {
        return ResponseEntity.ok(grupoService.getAll());
    }

    @PostMapping
    public ResponseEntity createGrupo(@RequestBody Grupo grupo){
        Grupo grupoSalvo = grupoService.createGrupo(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity updateGrupo(@PathVariable Long id, @RequestBody Grupo grupo){
        return ResponseEntity.ok(grupoService.updateGrupo(id, grupo));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeGrupo(@PathVariable Long id) {
        grupoService.removeGrupo(id);
    }

}
