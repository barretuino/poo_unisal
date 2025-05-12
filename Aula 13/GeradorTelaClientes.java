import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeradorTelaClientes extends JFrame {

    private List<JLabel> labels = new ArrayList<>();
    private List<JTextField> textFields = new ArrayList<>();
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JButton salvarButton;
    private JButton excluirButton;
    private JButton novoButton;
    private JButton listarButton;

    private String url;
    private String usuario;
    private String senha;
    private String nomeTabela;
    private List<Coluna> colunas;

    private static class Coluna {
        String field;
        String type;
        String nullValue;
        String key;
        String defaultValue;
        String extra;

        public Coluna(String field, String type, String nullValue, String key, String defaultValue, String extra) {
            this.field = field;
            this.type = type;
            this.nullValue = nullValue;
            this.key = key;
            this.defaultValue = defaultValue;
            this.extra = extra;
        }
    }

    public GeradorTelaClientes(String url, String usuario, String senha, String nomeTabela) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        this.nomeTabela = nomeTabela;
        this.colunas = obterEstruturaTabela();

        setTitle("Cadastro de " + nomeTabela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputPanel = new JPanel(new GridLayout(colunas.size(), 2, 5, 5));
        buttonPanel = new JPanel();

        salvarButton = new JButton("Salvar");
        excluirButton = new JButton("Excluir");
        novoButton = new JButton("Novo");
        listarButton = new JButton("Listar");

        buttonPanel.add(salvarButton);
        buttonPanel.add(excluirButton);
        buttonPanel.add(novoButton);
        buttonPanel.add(listarButton);

        for (Coluna coluna : colunas) {
            JLabel label = new JLabel(coluna.field + ":");
            JTextField textField = new JTextField(20);
            labels.add(label);
            textFields.add(textField);
            inputPanel.add(label);
            inputPanel.add(textField);
        }

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private List<Coluna> obterEstruturaTabela() {
        List<Coluna> colunas = new ArrayList<>();
        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            statement = conexao.createStatement();
            String sql = "DESCRIBE " + nomeTabela;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                colunas.add(new Coluna(
                        resultSet.getString("Field"),
                        resultSet.getString("Type"),
                        resultSet.getString("Null"),
                        resultSet.getString("Key"),
                        resultSet.getString("Default"),
                        resultSet.getString("Extra")
                ));
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return colunas;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua
        String usuario = "seu_usuario"; // Substitua
        String senha = "sua_senha"; // Substitua
        String nomeTabela = "clientes";

        SwingUtilities.invokeLater(() -> new GeradorTelaClientes(url, usuario, senha, nomeTabela).setVisible(true));
    }
}