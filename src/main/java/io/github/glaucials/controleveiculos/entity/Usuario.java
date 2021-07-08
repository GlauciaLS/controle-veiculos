package io.github.glaucials.controleveiculos.entity;

import io.github.glaucials.controleveiculos.dto.UsuarioDTO;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String dataNascimento;

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

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(UsuarioDTO usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        cpf = usuario.getCpf();
        dataNascimento = usuario.getDataNascimento();
    }

}
