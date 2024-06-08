package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    String cidade;
    String cargo;
    Integer numero;
    Integer votos;

    public Candidato(){
        this.nome = null;
        this.cidade = null;
        this.cargo = null;
        this.numero = null;
        this.votos = null;
    }
    public Candidato(String nome, String cidade, String cargo, Integer numero, Integer votos){
        this.nome = nome;
        this.cidade = cidade;
        this.cargo = cargo;
        this.numero = numero;
        this.votos = votos;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Integer getVotos() {
        return votos;
    }
    public void setVotos(Integer votos) {
        this.votos = votos;
    }
}
