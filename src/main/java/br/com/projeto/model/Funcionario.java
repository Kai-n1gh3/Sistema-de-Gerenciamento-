package main.java.br.com.projeto.model;

import main.java.br.com.projeto.exception.SalarioInvalidoException;
import main.java.br.com.projeto.exception.CodigoIdentificadorInvalido;

public abstract class Funcionario {
    private final int cod_ident;
    private final String nome;
    private final String cpf;
    private final double salarioBase;

    protected Funcionario(int cod_ident, String nome, String cpf, double salarioBase) {
        this.cod_ident = cod_ident;
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;

        if  (cod_ident < 0) {
            throw new CodigoIdentificadorInvalido("Código identificador deve ser diferente de 0");
        }
        if (salarioBase < 0) {
            throw new SalarioInvalidoException("Salario base deve ser diferente de 0");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCod_ident() {
        return cod_ident;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalario() {
        return 0.0;
    }

}
