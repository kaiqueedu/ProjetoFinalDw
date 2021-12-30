package com.ifsp.dw2.ProjetoFinalDw.service;

import com.ifsp.dw2.ProjetoFinalDw.model.Setor;
import com.ifsp.dw2.ProjetoFinalDw.repository.SetorRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public List<Setor> getAll() {
        return repository.findAll();
    }

    public Setor createSetor(Setor setor) {
        return repository.save(setor);
    }

    public Setor updateSetor(Long id, Setor setor) {
        var setorSalvo = getSetorById(id);
        BeanUtils.copyProperties(setor, setorSalvo, "codigo");
        return repository.save(setorSalvo);
    }

    public void removeSetor(Long id) {
        var setorSalvo = getSetorById(id);
        repository.delete(setorSalvo);
    }

    private Setor getSetorById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

}
