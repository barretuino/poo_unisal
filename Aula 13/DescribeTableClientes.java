import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DescribeTableClientes {

    public static void main(String[] args) {
        // Informações de conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua pelo seu URL
        String usuario = "seu_usuario"; // Substitua pelo seu usuário
        String senha = "sua_senha"; // Substitua pela sua senha
        String nomeTabela = "clientes";

        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Carregar o driver JDBC do MySQL (a partir da versão 8.0, não é estritamente necessário)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, usuario, senha);

            // 3. Criar um objeto Statement para executar comandos SQL
            statement = conexao.createStatement();

            // 4. Executar o comando SQL DESCRIBE para obter a descrição da tabela
            String sql = "DESCRIBE " + nomeTabela;
            resultSet = statement.executeQuery(sql);

            // 5. Processar o resultado da consulta
            System.out.println("Descrição da tabela: " + nomeTabela);
            System.out.println("--------------------------------------------------");
            System.out.printf("%-15s %-10s %-8s %-5s %-10s %s%n", "Field", "Type", "Null", "Key", "Default", "Extra");
            System.out.println("--------------------------------------------------");

            while (resultSet.next()) {
                String field = resultSet.getString("Field");
                String type = resultSet.getString("Type");
                String nullValue = resultSet.getString("Null");
                String key = resultSet.getString("Key");
                String defaultValue = resultSet.getString("Default");
                String extra = resultSet.getString("Extra");

                System.out.printf("%-15s %-10s %-8s %-5s %-10s %s%n", field, type, nullValue, key, defaultValue, extra);
            }

            System.out.println("--------------------------------------------------");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar a consulta SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 6. Fechar os recursos (ResultSet, Statement, Connection) na ordem inversa da criação
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar os recursos: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}