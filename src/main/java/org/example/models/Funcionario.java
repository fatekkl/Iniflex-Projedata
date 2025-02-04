package org.example.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "funcao")
    private String funcao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Funcionario() {

    }

    public int getId() {
        return id;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super( nome, dataNascimento );
        this.salario = salario;
        this.funcao = funcao;
        this.id = getId();
    }


    public BigDecimal getSalario() {
        return salario;
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", salario=" + salario +
                ", funcao='" + funcao + '\'' +
                '}';
    }

    public BigDecimal getPorcentagem(Double value) {
        BigDecimal salarioAtual = getSalario();

        return salarioAtual.multiply( BigDecimal.valueOf( value ) );
    }

    public int getIdade() {
        return Period.between( getDataNascimento(),  LocalDate.now()).getYears();
    }

    public BigDecimal getSalariosMinimos() {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212);
        BigDecimal salariosMinimos = getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_EVEN);

        return salariosMinimos;
    }

}
