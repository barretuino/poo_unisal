package br.unisal.model;

import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CriadorJFrame {

    public static void criarJFrameComAtributos(Class<?> classe) {
        JFrame frame = new JFrame("Visualização de " + classe.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2)); // Layout em grade com duas colunas

        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            JLabel label = new JLabel(campo.getName() + ":");
            frame.add(label);

            Class<?> tipoCampo = campo.getType();
            JTextField textField = null;
            JCheckBox checkBox = null;

            if (tipoCampo == String.class) {
                textField = new JTextField(20);
                frame.add(textField);
            } else if (tipoCampo == int.class || tipoCampo == double.class || tipoCampo == float.class) {
                textField = new JTextField(10);
                frame.add(textField);
                // Adicionar lógica de validação aqui se necessário
            } else if (tipoCampo == boolean.class) {
                checkBox = new JCheckBox();
                frame.add(checkBox);
            } else {
                // Para outros tipos, você pode adicionar um JLabel com o nome do tipo
                frame.add(new JLabel("(" + tipoCampo.getSimpleName() + ")"));
            }
        }

        frame.pack(); // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Exemplo de uma classe que você gostaria de visualizar
        criarJFrameComAtributos(Produto.class);
    }
}
