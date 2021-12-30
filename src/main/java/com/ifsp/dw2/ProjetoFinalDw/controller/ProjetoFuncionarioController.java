package com.ifsp.dw2.ProjetoFinalDw.controller;

import com.ifsp.dw2.ProjetoFinalDw.controller.vo.ProjetoFuncionarioRequestVO;
import com.ifsp.dw2.ProjetoFinalDw.model.ProjetoFuncionario;
import com.ifsp.dw2.ProjetoFinalDw.service.ProjetoFuncionarioService;
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
@RequestMapping(value = "/projetoFuncionario")
public class ProjetoFuncionarioController {

    @Autowired
    private ProjetoFuncionarioService projetoFuncionarioService;

    @GetMapping
    public ResponseEntity<List<ProjetoFuncionario>> getProjetoFuncionario() {
        return ResponseEntity.ok(projetoFuncionarioService.getAll());
    }

    @PostMapping
    public ResponseEntity createProjetoFuncionario(@RequestBody ProjetoFuncionarioRequestVO projetoFuncionarioVO){
        ProjetoFuncionario projetoFuncionarioSalvo = projetoFuncionarioService.registryProjetoFuncionario(projetoFuncionarioVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoFuncionarioSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity updateProjetoFuncionario(@PathVariable Long id, @RequestBody ProjetoFuncionario projetoFuncionario){
        return ResponseEntity.ok(projetoFuncionarioService.updateProjetoFuncionario(id, projetoFuncionario));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProjetoFuncionario(@PathVariable Long id) {
        projetoFuncionarioService.removeProjetoFuncionario(id);
    }

}
