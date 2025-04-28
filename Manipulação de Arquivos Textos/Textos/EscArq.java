
import java.io.*;
import java.util.*;

class EscArq {
		
  public static void main(String args[]) throws Exception {
    int tamanho = 0;
    String linha = "apenas um teste\napenas um teste de escrita\napenas um teste de escrita usando BufferedWriter\n";
    String nome_arq = "testeBufferedWriter.txt";

    FileWriter arqSai = new FileWriter(nome_arq);
    BufferedWriter bufferW = new BufferedWriter(arqSai);
    for (int i=0; i<10; i++)
        bufferW.write(i+": "+linha);
    bufferW.close ( );
     
    // Se não houver "Ai.txt": java.io.FileNotFoundException: Ais.txt
    FileReader arqLe = new FileReader(nome_arq);
    BufferedReader bufferR = new BufferedReader(arqLe);
     
    System.out.println("\nLeitura do arquivo: " + nome_arq );
    linha = bufferR.readLine( );
    while ( linha != null ) {
   	System.out.println( ++tamanho + ": " + linha );
        linha = bufferR.readLine( );
        }
    bufferR.close();
    }
  }
