import java.time.LocalDate;

enum Prioridade { ALTA, MEDIA, BAIXA }
enum Estado { PENDENTE, CONCLUIDA }

public class Tarefa {
    private String nome;
    private String descricao;
    private Prioridade prioridade;
    private LocalDate dataVencimento;
    private Estado estado;

    public Tarefa(String nome, String descricao, Prioridade prioridade, LocalDate dataVencimento, Estado estado) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataVencimento = dataVencimento;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDate getdataVencimento() {
        return dataVencimento;
    }

    public Estado getEstado() {
        return estado;
    }
}
