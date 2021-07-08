package io.github.glaucials.controleveiculos.response;

import java.util.List;

public class ListaModelosResponse {

    private List<ModeloResponse> modelos;

    public List<ModeloResponse> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloResponse> modelos) {
        this.modelos = modelos;
    }

    public ListaModelosResponse() {
    }

    public ListaModelosResponse(List<ModeloResponse> modelos) {
        this.modelos = modelos;
    }

}
