package io.github.glaucials.controleveiculos.client;

import io.github.glaucials.controleveiculos.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "veiculoClient", url = "https://parallelum.com.br/fipe")
public interface VeiculoClient {

    @GetMapping("/api/v1/carros/marcas")
    List<MarcaResponse> consultaMarcas();

    @GetMapping("/api/v1/carros/marcas/{idMarca}/modelos")
    ListaModelosResponse consultaModelos(@PathVariable String idMarca);

    @GetMapping("/api/v1/carros/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<AnoResponse> consultaAnos(@PathVariable String idMarca, @PathVariable String idModelo);

    @GetMapping("/api/v1/carros/marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    ValorResponse consultaValor(@PathVariable String idMarca, @PathVariable String idModelo, @PathVariable String ano);

}
