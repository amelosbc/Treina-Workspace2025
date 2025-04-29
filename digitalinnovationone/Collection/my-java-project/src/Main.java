import java.util.List;

import list.OperacoesBasicas.Tarefa;
// Ensure the correct package is imported
import list.OperacoesBasicas.ListaTarefas;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();
        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa(new Tarefa("Estudar Java"));
        listaTarefas.adicionarTarefa(new Tarefa("Fazer exercícios de programação"));
        listaTarefas.adicionarTarefa(new Tarefa("Ler um livro"));
        // Listando todas as tarefas
        System.out.println("Lista de Tarefas:");
        listaTarefas.listarTarefas();
        // Buscando uma tarefa pela descrição
        String descricaoBusca = "Fazer exercícios de programação";
        Tarefa tarefaEncontrada = listaTarefas.buscarTarefaPorDescricao(descricaoBusca);
        if (tarefaEncontrada != null) {
            System.out.println("Tarefa encontrada: " + tarefaEncontrada.getDescricao());
        } else {
            System.out.println("Tarefa não encontrada.");
        }
        // Atualizando a descrição de uma tarefa
        String descricaoAntiga = "Estudar Java";
        String novaDescricao = "Estudar Java e Spring";
        boolean atualizacaoSucesso = listaTarefas.atualizarDescricaoTarefa(descricaoAntiga, novaDescricao);
        if (atualizacaoSucesso) {
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar a tarefa.");
        }
       // Removendo uma tarefa pela descrição
       String descricaoRemocao = "Ler um livro";
         boolean remocaoSucesso = listaTarefas.removerTarefaPorDescricao(descricaoRemocao);
            if (remocaoSucesso) {
                System.out.println("Tarefa removida com sucesso.");
            } else {
                System.out.println("Falha ao remover a tarefa.");
            }
    }
}