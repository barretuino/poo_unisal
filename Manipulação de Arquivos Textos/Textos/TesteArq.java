import java.io.File;

class TesteArq {
  static void p (String s){
    System.out.println(s);
     }

  public static void main (String args[]) {
    File f1 = new File("testando.txt");
    p("Nome do arquivo: " + f1.getName());
    p("Caminho: " + f1.getPath());
    p("Caminho abs: " + f1.getAbsolutePath());
    p("Pai do arquivo: " + f1.getParent());
    p(f1.exists() ? "existe" : "nao existe");
    p(f1.canWrite() ? "pode ser gravado" : "nao pode ser gravado");
    p(f1.canRead() ? "pode ser lido" : "nao pode ser lido");
    p(f1.isDirectory() ? "eh " : "nao eh " +"um diretorio");
    p(f1.isFile() ? "eh " : "nao eh " +"um arquivo");
    p("Ultima modificacao: " + f1.lastModified());
    p("Tamanho do arquivo: " + f1.length() + " bytes");
    }
}
