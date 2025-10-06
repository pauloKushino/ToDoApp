import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private GerenciadorTarefas gerenciador = new GerenciadorTarefas();
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> listaTarefas = new JList<>(modeloLista);

    public TelaPrincipal() {
        setTitle("Gerenciador de Tarefas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel(new GridLayout(5, 2));
        JTextField campoNome = new JTextField();
        JTextField campoDescricao = new JTextField();
        JComboBox<Prioridade> comboPrioridade = new JComboBox<>(Prioridade.values());
        JTextField campoData = new JTextField("2025-10-10");

        painelEntrada.add(new JLabel("Nome:"));
        painelEntrada.add(campoNome);
        painelEntrada.add(new JLabel("Descrição:"));
        painelEntrada.add(campoDescricao);
        painelEntrada.add(new JLabel("Prioridade:"));
        painelEntrada.add(comboPrioridade);
        painelEntrada.add(new JLabel("Data Vencimento (YYYY-MM-DD):"));
        painelEntrada.add(campoData);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> {
            Tarefa tarefa = new Tarefa(
                campoNome.getText(),
                campoDescricao.getText(),
                (Prioridade) comboPrioridade.getSelectedItem(),
                java.time.LocalDate.parse(campoData.getText()),
                Estado.PENDENTE
            );
            gerenciador.adicionarTarefa(tarefa);
            atualizarLista();
        });

        painelEntrada.add(btnAdicionar);

        add(painelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(listaTarefas), BorderLayout.CENTER);

        setVisible(true);
    }

    private void atualizarLista() {
        modeloLista.clear();
        for (Tarefa t : gerenciador.listarTarefas()) {
            modeloLista.addElement(t.getNome() + " - " + t.getPrioridade() + " - " + t.getEstado());
        }
    }
}
