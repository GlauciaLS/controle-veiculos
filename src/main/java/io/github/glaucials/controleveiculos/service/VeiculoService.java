package io.github.glaucials.controleveiculos.service;

import io.github.glaucials.controleveiculos.client.VeiculoClient;
import io.github.glaucials.controleveiculos.dto.VeiculoDTO;
import io.github.glaucials.controleveiculos.entity.Usuario;
import io.github.glaucials.controleveiculos.entity.Veiculo;
import io.github.glaucials.controleveiculos.exception.UsuarioNaoExisteException;
import io.github.glaucials.controleveiculos.exception.VeiculoNaoEncontradoException;
import io.github.glaucials.controleveiculos.repository.UsuarioRepository;
import io.github.glaucials.controleveiculos.repository.VeiculoRepository;
import io.github.glaucials.controleveiculos.response.*;
import io.github.glaucials.controleveiculos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoClient veiculoClient;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<VeiculoDTO> consultarVeiculos() {
        List<Veiculo> veiculoLista = veiculoRepository.findAll();
        List<VeiculoDTO> veiculos = veiculoLista.stream().map(VeiculoDTO::new).collect(Collectors.toList());
        veiculos.forEach(Utils::verificaRodizioAtivo);
        return veiculos;
    }

    @Transactional
    public VeiculoDTO cadastrarVeiculo(VeiculoDTO veiculoDTO) throws VeiculoNaoEncontradoException, UsuarioNaoExisteException {
        validaDadosAntesDoCadastro(veiculoDTO);
        Veiculo veiculo = new Veiculo(veiculoDTO);
        veiculo = veiculoRepository.save(veiculo);
        return new VeiculoDTO(veiculo);
    }

    public void encontrarValorVeiculo(VeiculoDTO veiculoDTO) throws VeiculoNaoEncontradoException {
        List<MarcaResponse> marcas = veiculoClient.consultaMarcas();
        MarcaResponse marca = marcas.stream()
                .filter(marcaEncontrada -> marcaEncontrada.getNome().equals(veiculoDTO.getMarca()))
                .findFirst()
                .orElseThrow(VeiculoNaoEncontradoException::new);

        ListaModelosResponse modelos = veiculoClient.consultaModelos(marca.getCodigo());
        ModeloResponse modelo = modelos.getModelos().stream()
                .filter(modeloEncontrado -> modeloEncontrado.getNome().equals(veiculoDTO.getModelo()))
                .findFirst()
                .orElseThrow(VeiculoNaoEncontradoException::new);

        List<AnoResponse> anos = veiculoClient.consultaAnos(marca.getCodigo(), modelo.getCodigo());
        AnoResponse ano = anos.stream()
                .filter(anoEncontrado -> anoEncontrado.getNome().equals(veiculoDTO.getAno()))
                .findFirst()
                .orElseThrow(VeiculoNaoEncontradoException::new);

        ValorResponse valorResponse = veiculoClient.consultaValor(marca.getCodigo(), modelo.getCodigo(), ano.getCodigo());
        veiculoDTO.setValor(valorResponse.getValor());
    }

    public void validaDadosAntesDoCadastro(VeiculoDTO veiculoDTO) throws UsuarioNaoExisteException, VeiculoNaoEncontradoException {
        verificaUsuarioExiste(veiculoDTO.getIdProprietario());
        encontrarValorVeiculo(veiculoDTO);
        verificaDiaRodizio(veiculoDTO);
        Utils.verificaRodizioAtivo(veiculoDTO);
    }

    public void verificaUsuarioExiste(long id) throws UsuarioNaoExisteException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isEmpty()) {
            throw new UsuarioNaoExisteException();
        }
    }

    private void verificaDiaRodizio(VeiculoDTO veiculoDTO) {
        char finalAno = veiculoDTO.getAno().substring(0, 4).charAt(3);
        veiculoDTO.setDiaRodizio(Utils.diaRodizio.get(finalAno));
    }

}
