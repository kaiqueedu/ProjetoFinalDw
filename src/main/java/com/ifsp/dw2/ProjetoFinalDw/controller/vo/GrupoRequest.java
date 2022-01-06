package com.ifsp.dw2.ProjetoFinalDw.controller.vo;

import lombok.Data;
import lombok.NonNull;

@Data
public class GrupoRequest {

    @NonNull
    private String nome;

    public GrupoRequest(){}

}
