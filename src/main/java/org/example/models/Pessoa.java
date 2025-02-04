package org.example.models;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa {

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    // Construtor padrão
    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


}
