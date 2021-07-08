package io.github.glaucials.controleveiculos.controller;

import io.github.glaucials.controleveiculos.dto.UsuarioDTO;
import io.github.glaucials.controleveiculos.exception.DataInvalidaException;
import io.github.glaucials.controleveiculos.exception.UsuarioNaoExisteException;
import io.github.glaucials.controleveiculos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> consultarUsuarios() {
        return usuarioService.consultarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO encontrarUsuario(@PathVariable long id) throws UsuarioNaoExisteException {
        return usuarioService.encontrarUsuario(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuario) throws DataInvalidaException {
        return usuarioService.cadastrarUsuario(usuario);
    }

}
