package io.github.glaucials.controleveiculos.service;

import io.github.glaucials.controleveiculos.dto.UsuarioDTO;
import io.github.glaucials.controleveiculos.dto.VeiculoDTO;
import io.github.glaucials.controleveiculos.entity.Usuario;
import io.github.glaucials.controleveiculos.exception.DataInvalidaException;
import io.github.glaucials.controleveiculos.exception.UsuarioNaoExisteException;
import io.github.glaucials.controleveiculos.repository.UsuarioRepository;
import io.github.glaucials.controleveiculos.repository.VeiculoRepository;
import io.github.glaucials.controleveiculos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> consultarUsuarios() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        List<UsuarioDTO> usuarios = usuarioList.stream().map(UsuarioDTO::new).collect(Collectors.toList());

        List<VeiculoDTO> veiculos = veiculoRepository.findAll().stream()
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
        veiculos.forEach(Utils::verificaRodizioAtivo);

        usuarios.forEach(usuarioDTO -> {
            usuarioDTO.setVeiculos(veiculos.stream()
                    .filter(veiculoDTO -> veiculoDTO.getIdProprietario() == usuarioDTO.getId())
                    .collect(Collectors.toList()));
        });

        return usuarios;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO encontrarUsuario(long id) throws UsuarioNaoExisteException {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        UsuarioDTO usuarioDTO = usuarioList.stream().filter(usuario -> usuario.getId().equals(id))
                .map(UsuarioDTO::new)
                .findFirst()
                .orElseThrow(UsuarioNaoExisteException::new);

        List<VeiculoDTO> veiculos = veiculoRepository.findAll().stream()
                .filter(veiculo -> veiculo.getIdProprietario() == id)
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());

        veiculos.forEach(Utils::verificaRodizioAtivo);

        usuarioDTO.setVeiculos(veiculos);
        return usuarioDTO;
    }

    @Transactional
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) throws DataInvalidaException {
        validaNascimentoUsuario(usuarioDTO);
        Usuario usuario = new Usuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public static void validaNascimentoUsuario(UsuarioDTO usuarioDTO) throws DataInvalidaException {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatada = formatador.parse(usuarioDTO.getDataNascimento());
        }
        catch (Exception e) {
            throw new DataInvalidaException();
        }
    }

}
