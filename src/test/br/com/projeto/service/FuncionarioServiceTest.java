package br.com.projeto.service;

import br.com.projeto.model.FuncionarioCLT;
import br.com.projeto.model.FuncionarioComissionado;
import br.com.projeto.model.FuncionarioPJ;
import br.com.projeto.repository.FuncionarioRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {
    private FuncionarioService service;

    @BeforeEach
    void setUp() {
        service = new FuncionarioService(new FuncionarioRepository());
    }

    @Test
    void deveRejeitarCadastroComCpfInvalido() {
        FuncionarioCLT invalido = new FuncionarioCLT(1, "Ana", "123", 5000.0, 500.0);
        assertThrows(IllegalArgumentException.class, () -> service.cadastrarFuncionario(invalido));
    }

    @Test
    void deveCalcularTotalDaFolhaEGerarRelatorio() {
        service.cadastrarFuncionario(new FuncionarioCLT(1, "Ana", "111.111.111-11", 5000.0, 1000.0));
        service.cadastrarFuncionario(new FuncionarioPJ(2, "Bruno", "222.222.222-22", 1000.0, 500.0, 4));
        service.cadastrarFuncionario(new FuncionarioComissionado(3, "Carlos", "333.333.333-33", 1000.0, 5000.0, 10.0));

        assertEquals(10500.0, service.calcularTotalFolha(), 0.01);
        String relatorio = service.gerarRelatorioFolha();
        assertTrue(relatorio.contains("Ana"));
        assertTrue(relatorio.contains("10500.00"));
    }
}
