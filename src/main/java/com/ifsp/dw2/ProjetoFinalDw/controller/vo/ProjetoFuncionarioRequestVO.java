package com.ifsp.dw2.ProjetoFinalDw.controller.vo;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjetoFuncionarioRequestVO {

    private Long codigo;
    private int CargaHoraria;
    private Boolean gestor;
    private LocalDate inicioParticipacao;
    private LocalDate fimParticipacao;
    private Long funcionarioId;
    private Long projetoId;

    public ProjetoFuncionarioRequestVO(){};

}
