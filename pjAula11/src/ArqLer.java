import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

class ArqLer {
		
  public static void main(String args[]) throws Exception {
        
    int tamanho;
    // Se não houver "MeuTexto.txt": java.io.FileNotFoundException: Ais.txt
    InputStream  f1 = new FileInputStream("MeuTexto.txt");
    tamanho = f1.available();
    System.out.println("Lê arquivo usando: FileInputStream\ntotal de bytes: "+ tamanho);
    
    for (int i=0; i< tamanho; i++){
    	System.out.print((char) f1.read());
    }
    System.out.println();
    f1.close();

    // Usando a classe BufferedReader
    tamanho = 0;
    // Se não houver "MeuTexto.txt": java.io.FileNotFoundException: Ais.txt
    
    String nome_arq = "MeuTexto.txt";
    FileReader arq = new FileReader(nome_arq);
    BufferedReader buffer = new BufferedReader(arq);
     
    System.out.println("Lê arquivo usando: BufferedReader\nArquivo " + nome_arq );
    String linha = buffer.readLine( );
    while ( linha != null ) {
   	System.out.println( ++tamanho + ": " + linha );
        linha = buffer.readLine( );
        }
    buffer.close();
    }     
  }
