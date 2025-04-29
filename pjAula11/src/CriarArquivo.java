import java.io.File;

public class CriarArquivo {
	public static void main(String[] args) {
		File tree = new File("C:\\aulas");

		for(int i=0; i<tree.list().length; i++) {
			System.out.println(tree.list()[i]);
		}
	}
}
