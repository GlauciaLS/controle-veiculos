package io.github.glaucials.controleveiculos.dto;

import io.github.glaucials.controleveiculos.entity.Usuario;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private Long id;
    @NotBlank private String nome;
    @NotBlank private String email;
    @NotBlank private String cpf;
    @NotBlank private String dataNascimento;
    private List<VeiculoDTO> veiculos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<VeiculoDTO> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoDTO> veiculos) {
        this.veiculos = veiculos;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, String cpf, String dataNascimento, List<VeiculoDTO> veiculos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.veiculos = veiculos;
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        cpf = usuario.getCpf();
        dataNascimento = usuario.getDataNascimento();
    }

}
