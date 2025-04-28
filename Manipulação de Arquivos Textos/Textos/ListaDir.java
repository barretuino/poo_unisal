import java.io.File;

class ListaDir {
		
public static void main(String args[]) {
  // Para pegar um diretório fixo use as linhas abaixo:
  //  String nomeDir ="/jdk1.1";
  //  File f1 = new File(nomeDir);
  // Para pegar diretório corrente:
  File f1 = new File(".");   // para pegar o diretório corrente
  String nomeDir;
  if (f1.isDirectory()) {
    nomeDir = f1.getAbsolutePath();  // pega o caminho completo
    System.out.println("Diretorio: "+ nomeDir);
    String s[] = f1.list(); // pega tudo o que existe no dir. corrente
    for (int i=0; i<s.length; i++){
  	File f = new File(nomeDir + "/" + s[i]);
  	if (f.isDirectory())
  	     System.out.println("Diretorio: "+ s[i]);
  	else System.out.println("Arquivo: "+ s[i]);
        }
    }
}
}
