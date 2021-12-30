package com.ifsp.dw2.ProjetoFinalDw.service;

import com.ifsp.dw2.ProjetoFinalDw.model.Grupo;
import com.ifsp.dw2.ProjetoFinalDw.repository.GrupoRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    public List<Grupo> getAll() {
        return repository.findAll();
    }

    public Grupo createGrupo(Grupo grupo) {
        return repository.save(grupo);
    }

    public Grupo updateGrupo(Long id, Grupo grupo) {
        var grupoSalvo = getGrupoById(id);
        BeanUtils.copyProperties(grupo, grupoSalvo, "codigo");
        return repository.save(grupoSalvo);
    }

    public void removeGrupo(Long id) {
        var grupoSalvo = getGrupoById(id);
        repository.delete(grupoSalvo);
    }

    private Grupo getGrupoById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

}
