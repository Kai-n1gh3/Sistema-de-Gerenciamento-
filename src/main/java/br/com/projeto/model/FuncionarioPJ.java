package br.com.projeto.model;

import br.com.projeto.exception.SalarioInvalidoException;

public class FuncionarioPJ extends Funcionario implements Tributavel {
    private final double valorPorProjeto;
    private final int projetosRealizados;

    public FuncionarioPJ(int codigo, String nome, String cpf, double salarioBase, double valorPorProjeto, int projetosRealizados) {
        super(codigo, nome, cpf, salarioBase);
        if (valorPorProjeto < 0) {
            throw new SalarioInvalidoException("Valor por projeto não pode ser negativo.");
        }
        this.valorPorProjeto = valorPorProjeto;
        this.projetosRealizados = projetosRealizados;
    }

    public double getValorPorProjeto() {
        return valorPorProjeto;
    }

    public int getProjetosRealizados() {
        return projetosRealizados;
    }

    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + (valorPorProjeto * projetosRealizados);
    }

    @Override
    public double calcularTributos() {
        return calcularRemuneracao() * 0.05;
    }
}
