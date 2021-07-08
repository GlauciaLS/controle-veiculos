package io.github.glaucials.controleveiculos.controller;

import io.github.glaucials.controleveiculos.dto.VeiculoDTO;
import io.github.glaucials.controleveiculos.exception.UsuarioNaoExisteException;
import io.github.glaucials.controleveiculos.exception.VeiculoNaoEncontradoException;
import io.github.glaucials.controleveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoDTO> consultarVeiculos() {
        return veiculoService.consultarVeiculos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO cadastrarVeiculo(@RequestBody @Valid VeiculoDTO veiculo) throws VeiculoNaoEncontradoException, UsuarioNaoExisteException {
        return veiculoService.cadastrarVeiculo(veiculo);
    }
}
