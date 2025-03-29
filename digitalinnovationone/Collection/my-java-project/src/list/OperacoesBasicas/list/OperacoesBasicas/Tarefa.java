package list.OperacoesBasicas;

// Classe Tarefa que representa uma tarefa com uma descrição
// e métodos para manipular essa descrição.
public class Tarefa {
    private String descricao;

    // Construtor
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    // Getter
    public String getDescricao() {
        return descricao;
    }

    // Setter
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}