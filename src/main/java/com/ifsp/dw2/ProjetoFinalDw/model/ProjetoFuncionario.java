package com.ifsp.dw2.ProjetoFinalDw.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ProjetoFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private int CargaHoraria;
    private Boolean gestor;
    private LocalDate inicioParticipacao;
    private LocalDate fimParticipacao;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Projeto projeto;

    public ProjetoFuncionario(){};

}
