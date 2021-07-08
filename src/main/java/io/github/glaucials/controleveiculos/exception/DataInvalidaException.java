package io.github.glaucials.controleveiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataInvalidaException extends Throwable {

    public DataInvalidaException() {
        super("A data informada é inválida, deve estar dentro do padrão dd/MM/yyyy");
    }
}
