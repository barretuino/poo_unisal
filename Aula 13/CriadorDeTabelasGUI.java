import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CriadorDeTabelasGUI extends JFrame implements ActionListener {

    private JTextField nomeTabelaField;
    private DefaultTableModel tableModel;
    private JTable colunasTable;
    private JButton adicionarColunaButton;
    private JButton removerColunaButton;
    private JButton criarTabelaButton;
    private CriadorDeTabelas criadorDeTabelas;

    private String url;
    private String usuario;
    private String senha;

    public CriadorDeTabelasGUI(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        this.criadorDeTabelas = new CriadorDeTabelas(url, usuario, senha);

        setTitle("Criador de Tabelas MySQL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(800, 600));

        JPanel nomeTabelaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nomeTabelaLabel = new JLabel("Nome da Tabela:");
        nomeTabelaField = new JTextField(20);
        nomeTabelaPanel.add(nomeTabelaLabel);
        nomeTabelaPanel.add(nomeTabelaField);
        add(nomeTabelaPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Tipo", "NOT NULL", "PRIMARY KEY", "AUTO_INCREMENT", "DEFAULT", "UNIQUE KEY"}, 0);
        colunasTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(colunasTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        adicionarColunaButton = new JButton("Adicionar Coluna");
        adicionarColunaButton.addActionListener(this);
        removerColunaButton = new JButton("Remover Coluna");
        removerColunaButton.addActionListener(this);
        criarTabelaButton = new JButton("Criar Tabela");
        criarTabelaButton.addActionListener(this);

        botoesPanel.add(adicionarColunaButton);
        botoesPanel.add(removerColunaButton);
        botoesPanel.add(criarTabelaButton);
        add(botoesPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adicionarColunaButton) {
            tableModel.addRow(new Object[]{"", "VARCHAR(255)", false, false, false, "", ""});
        } else if (e.getSource() == removerColunaButton) {
            int selectedRow = colunasTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == criarTabelaButton) {
            String nomeTabela = nomeTabelaField.getText().trim();
            if (nomeTabela.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome da tabela não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<CriadorDeTabelas.Coluna> colunas = new ArrayList<>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String nomeColuna = (String) tableModel.getValueAt(i, 0);
                String tipoColuna = (String) tableModel.getValueAt(i, 1);
                boolean notNull = (Boolean) tableModel.getValueAt(i, 2);
                boolean primaryKey = (Boolean) tableModel.getValueAt(i, 3);
                boolean autoIncrement = (Boolean) tableModel.getValueAt(i, 4);
                String defaultValue = (String) tableModel.getValueAt(i, 5);
                String uniqueKeyName = (String) tableModel.getValueAt(i, 6);

                if (nomeColuna == null || nomeColuna.trim().isEmpty() || tipoColuna == null || tipoColuna.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "O nome e o tipo da coluna não podem estar vazios na linha " + (i + 1) + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CriadorDeTabelas.Coluna coluna = new CriadorDeTabelas.Coluna(nomeColuna.trim(), tipoColuna.trim());
                if (notNull) coluna.notNull();
                if (primaryKey) coluna.primaryKey();
                if (autoIncrement) coluna.autoIncrement();
                if (defaultValue != null && !defaultValue.trim().isEmpty()) coluna.defaultValue(defaultValue.trim());
                if (uniqueKeyName != null && !uniqueKeyName.trim().isEmpty()) coluna.unique(uniqueKeyName.trim());

                colunas.add(coluna);
            }

            if (colunas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Adicione pelo menos uma coluna para criar a tabela.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean sucesso = criadorDeTabelas.criarTabela(nomeTabela, colunas);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Tabela '" + nomeTabela + "' criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao criar a tabela '" + nomeTabela + "'. Verifique o console para mais detalhes.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua
        String usuario = "seu_usuario"; // Substitua
        String senha = "sua_senha"; // Substitua

        SwingUtilities.invokeLater(() -> new CriadorDeTabelasGUI(url, usuario, senha).setVisible(true));
    }

    // Reutilize a classe CriadorDeTabelas do exemplo anterior
    public static class CriadorDeTabelas {
        private String url;
        private String usuario;
        private String senha;

        public CriadorDeTabelas(String url, String usuario, String senha) {
            this.url = url;
            this.usuario = usuario;
            this.senha = senha;
        }

        public static class Coluna {
            private String nome;
            private String tipo;
            private boolean notNull = false;
            private boolean primaryKey = false;
            private boolean autoIncrement = false;
            private String defaultValue;
            private String uniqueKeyName;

            public Coluna(String nome, String tipo) {
                this.nome = nome;
                this.tipo = tipo.toUpperCase();
            }

            public Coluna notNull() {
                this.notNull = true;
                return this;
            }

            public Coluna primaryKey() {
                this.primaryKey = true;
                return this;
            }

            public Coluna autoIncrement() {
                this.autoIncrement = true;
                return this;
            }

            public Coluna defaultValue(String defaultValue) {
                this.defaultValue = defaultValue;
                return this;
            }

            public Coluna unique(String uniqueKeyName) {
                this.uniqueKeyName = uniqueKeyName;
                return this;
            }

            public String getNome() {
                return nome;
            }

            public String getTipo() {
                return tipo;
            }

            public boolean isNotNull() {
                return notNull;
            }

            public boolean isPrimaryKey() {
                return primaryKey;
            }

            public boolean isAutoIncrement() {
                return autoIncrement;
            }

            public String getDefaultValue() {
                return defaultValue;
            }

            public String getUniqueKeyName() {
                return uniqueKeyName;
            }
        }

        public boolean criarTabela(String nomeTabela, List<Coluna> colunas) {
            Connection conexao = null;
            Statement statement = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(url, usuario, senha);
                statement = conexao.createStatement();

                StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS `").append(nomeTabela).append("` (");
                List<String> constraints = new ArrayList<>();

                for (int i = 0; i < colunas.size(); i++) {
                    Coluna coluna = colunas.get(i);
                    sqlBuilder.append("`").append(coluna.getNome()).append("` ").append(coluna.getTipo());

                    if (coluna.isNotNull()) sqlBuilder.append(" NOT NULL");
                    if (coluna.isAutoIncrement()) sqlBuilder.append(" AUTO_INCREMENT");
                    if (coluna.getDefaultValue() != null && !coluna.getDefaultValue().isEmpty()) sqlBuilder.append(" DEFAULT '").append(coluna.getDefaultValue()).append("'");

                    if (coluna.isPrimaryKey()) constraints.add("PRIMARY KEY (`" + coluna.getNome() + "`)");
                    if (coluna.getUniqueKeyName() != null && !coluna.getUniqueKeyName().isEmpty()) constraints.add("UNIQUE KEY `" + coluna.getUniqueKeyName() + "` (`" + coluna.getNome() + "`)");

                    if (i < colunas.size() - 1) sqlBuilder.append(", ");
                }

                if (!constraints.isEmpty()) {
                    sqlBuilder.append(", ").append(String.join(", ", constraints));
                }

                sqlBuilder.append(")");

                String sql = sqlBuilder.toString();
                System.out.println("SQL Gerado: " + sql);
                statement.executeUpdate(sql);
                System.out.println("Tabela '" + nomeTabela + "' criada com sucesso!");
                return true;

            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC do MySQL não encontrado!");
                e.printStackTrace();
                return false;
            } catch (SQLException e) {
                System.err.println("Erro ao criar a tabela '" + nomeTabela + "': " + e.getMessage());
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (statement != null) statement.close();
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}