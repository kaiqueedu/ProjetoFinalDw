package com.ifsp.dw2.ProjetoFinalDw.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;


@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    private BigDecimal salario;
    private Boolean ativo = false;
    @ManyToOne
    private Grupo grupo;

    public Funcionario(){}

}
