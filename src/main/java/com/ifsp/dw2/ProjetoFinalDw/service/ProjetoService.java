package com.ifsp.dw2.ProjetoFinalDw.service;

import com.ifsp.dw2.ProjetoFinalDw.model.Projeto;
import com.ifsp.dw2.ProjetoFinalDw.repository.ProjetoRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public List<Projeto> getAll() {
        return repository.findAll();
    }

    public Projeto createProjeto(Projeto projeto) {
        return repository.save(projeto);
    }

    public Projeto updateProjeto(Long id, Projeto projeto) {
        var projetoSalvo = getProjetoById(id);
        BeanUtils.copyProperties(projeto, projetoSalvo, "codigo");
        return repository.save(projetoSalvo);
    }

    public void removeProjeto(Long id) {
        var projetoSalvo = getProjetoById(id);
        repository.delete(projetoSalvo);
    }

    public Projeto getProjetoById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

}
