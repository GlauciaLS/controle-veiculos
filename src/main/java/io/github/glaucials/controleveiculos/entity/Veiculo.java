package io.github.glaucials.controleveiculos.entity;

import io.github.glaucials.controleveiculos.dto.VeiculoDTO;

import javax.persistence.*;

@Entity
@Table
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long idProprietario;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private String diaRodizio;

    private Boolean rodizioAtivo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(long idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public Boolean getRodizioAtivo() {
        return rodizioAtivo;
    }

    public void setRodizioAtivo(Boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public Veiculo() {
    }

    public Veiculo(long id, long idProprietario, String marca, String modelo, String ano, String valor, String diaRodizio, Boolean rodizioAtivo) {
        this.id = id;
        this.idProprietario = idProprietario;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.diaRodizio = diaRodizio;
        this.rodizioAtivo = rodizioAtivo;
    }

    public Veiculo(VeiculoDTO veiculo) {
        id = veiculo.getId();
        idProprietario = veiculo.getIdProprietario();
        marca = veiculo.getMarca();
        modelo = veiculo.getModelo();
        ano = veiculo.getAno();
        valor = veiculo.getValor();
        diaRodizio = veiculo.getDiaRodizio();
        rodizioAtivo = veiculo.getRodizioAtivo();
    }
}
