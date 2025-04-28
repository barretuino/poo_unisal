import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeradorClasseJFrame extends JFrame implements ActionListener {

    private JTextField nomeClasseField;
    private DefaultTableModel atributosTableModel;
    private JTable atributosTable;
    private JButton adicionarAtributoButton;
    private JButton gerarClasseButton;
    private List<Atributo> atributos = new ArrayList<>();

    public GeradorClasseJFrame() {
        setTitle("Gerador de Classe Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel nomeClasseLabel = new JLabel("Nome da Classe:");
        nomeClasseField = new JTextField(20);

        atributosTableModel = new DefaultTableModel(new Object[]{"Nome", "Tipo"}, 0);
        atributosTable = new JTable(atributosTableModel);
        JScrollPane atributosScrollPane = new JScrollPane(atributosTable);
        atributosScrollPane.setPreferredSize(new Dimension(300, 150));

        adicionarAtributoButton = new JButton("Adicionar Atributo");
        adicionarAtributoButton.addActionListener(this);
        adicionarAtributoButton.setActionCommand("adicionarAtributo");

        gerarClasseButton = new JButton("Gerar Classe");
        gerarClasseButton.addActionListener(this);
        gerarClasseButton.setActionCommand("gerarClasse");

        add(nomeClasseLabel);
        add(nomeClasseField);
        add(new JLabel("Atributos:"));
        add(atributosScrollPane);
        add(adicionarAtributoButton);
        add(gerarClasseButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GeradorClasseJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if ("adicionarAtributo".equals(comando)) {
            // Lógica para adicionar um novo atributo (abrir um diálogo?)
            String nomeAtributo = JOptionPane.showInputDialog(this, "Nome do atributo:");
            if (nomeAtributo != null && !nomeAtributo.isEmpty()) {
                String tipoAtributo = JOptionPane.showInputDialog(this, "Tipo do atributo:");
                if (tipoAtributo != null && !tipoAtributo.isEmpty()) {
                    atributosTableModel.addRow(new Object[]{nomeAtributo, tipoAtributo});
                    atributos.add(new Atributo(nomeAtributo, tipoAtributo));
                }
            }
        } else if ("gerarClasse".equals(comando)) {
            String nomeClasse = nomeClasseField.getText();
            if (nomeClasse != null && !nomeClasse.isEmpty()) {
                String codigoClasse = gerarCodigoJava(nomeClasse, atributos);
                salvarCodigoEmArquivo(nomeClasse + ".java", codigoClasse);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, digite o nome da classe.");
            }
        }
    }

    private String gerarCodigoJava(String nomeClasse, List<Atributo> atributos) {
        StringBuilder codigo = new StringBuilder();
        codigo.append("public class ").append(nomeClasse).append(" {\n\n");

        // Adicionar atributos
        for (Atributo atributo : atributos) {
            codigo.append("    private ").append(atributo.getTipo()).append(" ").append(atributo.getNome()).append(";\n");
        }

        codigo.append("\n");

        // Adicionar construtor padrão (opcional)
        codigo.append("    public ").append(nomeClasse).append("() {\n");
        codigo.append("    }\n\n");

        // Adicionar construtor com argumentos (opcional)
        if (!atributos.isEmpty()) {
            codigo.append("    public ").append(nomeClasse).append("(");
            for (int i = 0; i < atributos.size(); i++) {
                codigo.append(atributos.get(i).getTipo()).append(" ").append(atributos.get(i).getNome());
                if (i < atributos.size() - 1) {
                    codigo.append(", ");
                }
            }
            codigo.append(") {\n");
            for (Atributo atributo : atributos) {
                codigo.append("        this.").append(atributo.getNome()).append(" = ").append(atributo.getNome()).append(";\n");
            }
            codigo.append("    }\n\n");
        }

        // Adicionar getters e setters (opcional)
        for (Atributo atributo : atributos) {
            String nomeAtributoCapitalizado = atributo.getNome().substring(0, 1).toUpperCase() + atributo.getNome().substring(1);
            // Getter
            codigo.append("    public ").append(atributo.getTipo()).append(" get").append(nomeAtributoCapitalizado).append("() {\n");
            codigo.append("        return ").append(atributo.getNome()).append(";\n");
            codigo.append("    }\n\n");
            // Setter
            codigo.append("    public void set").append(nomeAtributoCapitalizado).append("(").append(atributo.getTipo()).append(" ").append(atributo.getNome()).append(") {\n");
            codigo.append("        this.").append(atributo.getNome()).append(" = ").append(atributo.getNome()).append(";\n");
            codigo.append("    }\n\n");
        }

        codigo.append("}\n");
        return codigo.toString();
    }

    private void salvarCodigoEmArquivo(String nomeArquivo, String codigo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(codigo);
            JOptionPane.showMessageDialog(this, "Classe salva em " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Classe auxiliar para representar um atributo
    private static class Atributo {
        private String nome;
        private String tipo;

        public Atributo(String nome, String tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }

        public String getNome() {
            return nome;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
