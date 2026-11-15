package main.java.br.com.projeto.main;

import br.com.projeto.model.Funcionario;
import br.com.projeto.model.FuncionarioCLT;
import br.com.projeto.model.FuncionarioComissionado;
import br.com.projeto.model.FuncionarioPJ;
import br.com.projeto.repository.FuncionarioRepository;
import br.com.projeto.service.FuncionarioService;
import br.com.projeto.view.FuncionarioView;


public class Main {
    public static void main(String[] args) {
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);
        FuncionarioView view = new FuncionarioView(service);

        try {
            Funcionario clt = new FuncionarioCLT(1, "Ana Silva", "111.111.111-11", 5000.0, 1000.0);
            Funcionario pj = new FuncionarioPJ(2, "Bruno Costa", "222.222.222-22", 1000.0, 500.0, 4);
            Funcionario comissionado = new FuncionarioComissionado(3, "Carlos Lima", "333.333.333-33", 1000.0, 5000.0, 10.0);

            service.cadastrarFuncionario(clt);
            service.cadastrarFuncionario(pj);
            service.cadastrarFuncionario(comissionado);

            view.exibirLista(service.listarFuncionarios());
            System.out.println();
            view.exibirRelatorio(service.gerarRelatorioFolha());

        } catch(IllegalArgumentException e) {
            view.exibirMensagem("Erro: " + e.getMessage());
        }
    }
}

