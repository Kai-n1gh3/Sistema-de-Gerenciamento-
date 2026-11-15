package br.com.projeto.model;

public class FuncionarioComissionado extends Funcionario implements Tributavel {
    private final double totalVendas;
    private final double percentualComissao;

    public FuncionarioComissionado(int codigo, String nome, String cpf, double salarioBase, double totalVendas, double percentualComissao) {
        super(codigo, nome, cpf, salarioBase);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + (totalVendas * (percentualComissao/ 100));
    }

    @Override
    public double calcularTributos() {
        return calcularRemuneracao() * 0.08;
    }

}
