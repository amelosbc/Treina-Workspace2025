package listas.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefas;

    // Construtor
    public ListaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    // Método para adicionar uma tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    // Método para remover uma tarefa
    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    // Método para listar todas as tarefas
    public void listarTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.getDescricao());
        }
    }

    // Método para buscar uma tarefa pela descrição
    public Tarefa buscarTarefaPorDescricao(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                return tarefa;
            }
        }
        return null; // Retorna null se nenhuma tarefa for encontrada
    }

    // Método para atualizar a descrição de uma tarefa
    public boolean atualizarDescricaoTarefa(String descricaoAntiga, String novaDescricao) {
        Tarefa tarefa = buscarTarefaPorDescricao(descricaoAntiga);
        if (tarefa != null) {
            tarefa.setDescricao(novaDescricao);
            return true; // Atualização bem-sucedida
        }
        return false; // Tarefa não encontrada
    }

    // Método para remover uma tarefa pela descrição
    public boolean removerTarefaPorDescricao(String descricao) {
        Tarefa tarefa = buscarTarefaPorDescricao(descricao);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            return true; // Remoção bem-sucedida
        }
        return false; // Tarefa não encontrada
    }

}