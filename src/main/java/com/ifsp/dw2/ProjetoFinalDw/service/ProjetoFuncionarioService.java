package com.ifsp.dw2.ProjetoFinalDw.service;

import com.ifsp.dw2.ProjetoFinalDw.controller.vo.ProjetoFuncionarioRequestVO;
import com.ifsp.dw2.ProjetoFinalDw.model.Funcionario;
import com.ifsp.dw2.ProjetoFinalDw.model.Projeto;
import com.ifsp.dw2.ProjetoFinalDw.model.ProjetoFuncionario;
import com.ifsp.dw2.ProjetoFinalDw.repository.ProjetoFuncionarioRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoFuncionarioService {

    @Autowired
    private ProjetoFuncionarioRepository repository;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ProjetoService projetoService;


    public List<ProjetoFuncionario> getAll() {
        return repository.findAll();
    }

    public ProjetoFuncionario registryProjetoFuncionario(ProjetoFuncionarioRequestVO projetoFuncionarioVO) {
        var projetoFuncionario = projetoFunVOtoProjetoFuncionario(projetoFuncionarioVO);
        return repository.save(projetoFuncionario);
    }

    public ProjetoFuncionario updateProjetoFuncionario(Long id, ProjetoFuncionario projetoFuncionario) {
        var projetoFunSalvo = getProjetoFuncionarioById(id);
        BeanUtils.copyProperties(projetoFuncionario, projetoFunSalvo, "codigo");
        return repository.save(projetoFunSalvo);
    }

    public void removeProjetoFuncionario(Long id) {
        var projetoFunSalvo = getProjetoFuncionarioById(id);
        repository.delete(projetoFunSalvo);
    }

    private ProjetoFuncionario getProjetoFuncionarioById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

    private ProjetoFuncionario projetoFunVOtoProjetoFuncionario(ProjetoFuncionarioRequestVO projetoFuncionarioVO){
        Projeto projeto = projetoService.getProjetoById(projetoFuncionarioVO.getProjetoId());
        Funcionario funcionario = funcionarioService.getFuncionarioById(projetoFuncionarioVO.getFuncionarioId());

        ProjetoFuncionario projetoFuncionario = new ProjetoFuncionario();
        projetoFuncionario.setProjeto(projeto);
        projetoFuncionario.setFuncionario(funcionario);
        projetoFuncionario.setCargaHoraria(projetoFuncionarioVO.getCargaHoraria());
        projetoFuncionario.setGestor(projetoFuncionarioVO.getGestor());
        projetoFuncionario.setInicioParticipacao(projetoFuncionarioVO.getInicioParticipacao());
        projetoFuncionario.setFimParticipacao(projetoFuncionarioVO.getFimParticipacao());

        return projetoFuncionario;
    }

}
