package io.github.glaucials.controleveiculos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloResponse {

    private String codigo;
    private String nome;

}