package com.ifsp.dw2.ProjetoFinalDw.service;

import com.ifsp.dw2.ProjetoFinalDw.model.Funcionario;
import com.ifsp.dw2.ProjetoFinalDw.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
        var funcionarioSalvo = getFuncionarioById(id);
        BeanUtils.copyProperties(funcionario, funcionarioSalvo, "codigo, codi");
        return repository.save(funcionarioSalvo);
    }

    public void removeFuncionario(Long id) {
        var funcionarioSalvo = getFuncionarioById(id);
        repository.delete(funcionarioSalvo);
    }

    public Funcionario getFuncionarioById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

}
