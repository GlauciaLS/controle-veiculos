package io.github.glaucials.controleveiculos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValorResponse {

    @JsonProperty("Valor")
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ValorResponse() {
    }

    public ValorResponse(String valor) {
        this.valor = valor;
    }
}
