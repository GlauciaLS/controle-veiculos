package io.github.glaucials.controleveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoExisteException extends Exception {

    public UsuarioNaoExisteException() {
        super("O usuário não foi encontrado, verifique o id informado.");
    }
}
