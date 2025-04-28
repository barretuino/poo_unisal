import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class TesteFile {	
	public static void main(String[] args) {
		String texto = "Programação Orientada a Objetos II";	
		try {			
			FileWriter fileWriter = new FileWriter(new File("Ai.txt"));			
			fileWriter.write(texto);
			fileWriter.write("\nPaulo");
			fileWriter.close();					
			BufferedReader in = new BufferedReader(new FileReader("Ai.txt"));
			//LÊ 1ª Linha
			System.out.println(in.readLine());
			//LÊ 2ª Linha
			System.out.println(in.readLine());		
		}
		catch (IOException e) {	
			e.printStackTrace();
		}
	
	}	
}