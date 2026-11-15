package br.com.projeto.model;

import br.com.projeto.exception.SalarioInvalidoException;
import br.com.projeto.exception.CodigoIdentificadorInvalidoException;

public abstract class Funcionario implements Identificavel{
    private final int codigo;
    private final String nome;
    private final String cpf;
    private final double salarioBase;

    protected Funcionario(int codigo, String nome, String cpf, double salarioBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;

        if  (codigo < 0) {
            throw new CodigoIdentificadorInvalidoException("Código identificador deve ser diferente de 0");
        }
        if (salarioBase < 0) {
            throw new SalarioInvalidoException("Salario base deve ser diferente de 0");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    ;

    public abstract double calcularRemuneracao();
    }


