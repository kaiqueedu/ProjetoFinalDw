package com.ifsp.dw2.ProjetoFinalDw.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NonNull
    private String nome;
    @OneToMany
    private List<Funcionario> funcionario;

    public Grupo(){}

}
