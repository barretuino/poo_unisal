import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeradorJFrame {

    public static void main(String[] args) {
        if (args.length != 1) {
            JOptionPane.showMessageDialog(null, "Por favor, forneça o nome da classe como argumento.");
            return;
        }

        String nomeClasse = args[0];

        try {
            Class<?> classe = Class.forName(nomeClasse);
            criarJFrame(classe);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada: " + nomeClasse);
            e.printStackTrace();
        }
    }

    public static void criarJFrame(Class<?> classe) {
        JFrame frame = new JFrame("Editor de " + classe.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2, 5, 5)); // Layout em grade para rótulos e campos

        List<JTextField> camposTexto = new ArrayList<>();
        List<Field> atributosPersistiveis = new ArrayList<>();

        // Obtém os campos declarados na classe
        Field[] campos = classe.getDeclaredFields();
        for (Field campo : campos) {
            // Vamos considerar apenas atributos não estáticos e não finais para edição
            if (!Modifier.isStatic(campo.getModifiers()) && !Modifier.isFinal(campo.getModifiers())) {
                JLabel label = new JLabel(campo.getName() + ":");
                JTextField textField = new JTextField(20);
                frame.add(label);
                frame.add(textField);
                camposTexto.add(textField);
                atributosPersistiveis.add(campo);
            }
        }

        JButton salvarButton = new JButton("Salvar Dados");
        salvarButton.addActionListener(e -> {
            StringBuilder linhaDados = new StringBuilder();
            for (int i = 0; i < camposTexto.size(); i++) {
                linhaDados.append(camposTexto.get(i).getText());
                if (i < camposTexto.size() - 1) {
                    linhaDados.append(","); // Usando vírgula como delimitador, você pode escolher outro
                }
            }
            salvarEmArquivo(classe.getSimpleName() + ".txt", linhaDados.toString());
        });

        frame.add(new JLabel()); // Espaço em branco para alinhar o botão
        frame.add(salvarButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void salvarEmArquivo(String nomeArquivo, String dados) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) { // Append para adicionar novas entradas
            writer.write(dados + System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Dados salvos em " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
