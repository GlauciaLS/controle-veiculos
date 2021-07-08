package io.github.glaucials.controleveiculos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValorResponse {

    @JsonProperty("Valor")
    private String valor;

}
