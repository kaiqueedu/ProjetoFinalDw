package com.ifsp.dw2.ProjetoFinalDw.repository;

import com.ifsp.dw2.ProjetoFinalDw.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
