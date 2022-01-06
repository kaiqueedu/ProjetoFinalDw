package com.ifsp.dw2.ProjetoFinalDw.controller;

import com.ifsp.dw2.ProjetoFinalDw.model.Funcionario;
import com.ifsp.dw2.ProjetoFinalDw.service.FuncionarioService;
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
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionario() {
        return ResponseEntity.ok(funcionarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getServicoById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.getFuncionarioById(id));
    }

    @PostMapping
    public ResponseEntity createFuncionario(@RequestBody Funcionario funcionario){
        Funcionario funcionarioSalvo = funcionarioService.createFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.updateFuncionario(id, funcionario));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFuncionario(@PathVariable Long id) {
        funcionarioService.removeFuncionario(id);
    }

}
