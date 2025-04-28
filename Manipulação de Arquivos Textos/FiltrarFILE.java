//Este exemplo mostra como listar o conteúdo de um diretório
//filtrado por extensão

import java.io.*;

public class FiltrarFILE{
	public static void main(String[] args){

		File diretorio = new File("C:\\Documents and Settings\\pbarreto\\Configurações locais\\Dados de aplicativos\\Microsoft\\Outlook\\Microsoft\\Outlook\\"); 

		FilenameFilter ff = new FilenameFilter() { 
			public boolean accept(File b, String name) { 
				return name.endsWith(".pst"); 
			} 
		}; 

		String[] arquivos = diretorio.list(ff); 

		if(arquivos != null){ 
			int length = arquivos.length; 

			for(int i = 0; i < length; ++i){ 
				System.out.println(arquivos[i]); 
				
			} 
		}
	}
}