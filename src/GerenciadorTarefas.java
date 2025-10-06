import java.util.ArrayList;

public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(int i) {
        if (i >= 0 && i < tarefas.size()) {
            tarefas.remove(i);
        }
    }

    public void editarTarefa(int i, Tarefa novaTarefa) {
        if (i >= 0 && i < tarefas.size()) {
            tarefas.set(i, novaTarefa);
        }
    }

    public void concluirTarefa(int i) {
        if (i >= 0 && i < tarefas.size()) {
            Tarefa tarefa = tarefas.get(i);
            Tarefa tarefaConcluida = new Tarefa(
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getdataVencimento(),
                Estado.CONCLUIDA
            );
            tarefas.set(i, tarefaConcluida);
        }
    }

    public ArrayList<Tarefa> listarTarefas() {
        return tarefas;
    }
}
