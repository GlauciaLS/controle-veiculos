package io.github.glaucials.controleveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VeiculoNaoEncontradoException extends Exception {

    public VeiculoNaoEncontradoException() {
        super("O veículo não foi encontrado, verifique a marca, modelo e ano informados.");
    }
}
