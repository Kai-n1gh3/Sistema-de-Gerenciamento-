package java.br.com.projeto.model;

import main.java.br.com.projeto.exception.SalarioInvalidoException;
import main.java.br.com.projeto.exception.CodigoIdentificadorInvalido;

import main.java.br.com.projeto.model.Funcionario;
import main.java.br.com.projeto.model.FuncionarioCLT;
import main.java.br.com.projeto.model.FuncionarioComissionado;
import main.java.br.com.projeto.model.FuncionarioPJ;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveLancarExcecaoSalarioBaseZeroOuNegativo() {
        assertThrows(SalarioInvalidoException.class, () ->  new FuncionarioCLT(4562, "Ana", "000000555",0.0));
        assertThrows(SalarioInvalidoException.class, () -> new FuncionarioComissionado(5643, "Garry", "020212", -1500));
    }

    @Test
    void deveLancarExcecaoCodigoIdentificadorZeroOuNegativo() {
        assertThrows(CodigoIdentificadorInvalido.class, () -> new FuncionarioComissionado(0, "Garry", "020212", 1000));
        assertThrows(CodigoIdentificadorInvalido.class, () -> new FuncionarioCLT(-10, "Ana", "000000555", 5000));
    }

    @Test
    void deveCalcularSalarioDeFuncionarioCLTComBonus() {
        Funcionario CLT = new FuncionarioCLT(4562, "Ana", "000000555", 5000);
        assertEquals(5000, CLT.calcularSalario(), 0.03);
    }

    @Test
    void deveCalcularSalarioDeFuncionarioComissionadoComBonus() {
        Funcionario Comissionado = new FuncionarioComissionado(5643, "Garry", "020212", 1000);
        assertEquals(1500, Comissionado.calcularSalario(), 0.05);
    }
    @Test
    void deveCalcularFolhaComPoliformismo(){
        List<Funcionario> equipe = List.of(
                new FuncionarioCLT(4562, "Ana", "000000555", 5000),
                new FuncionarioComissionado(5643, "Garry", "020212", 1000)
        );

        double total = equipe.stream().mapToDouble(Funcionario::getSalarioBase).sum();
    }
}
