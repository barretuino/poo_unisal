import java.io.*;

class ArqSai{

public static byte getInput() [] throws Exception {
  byte buffer[] = new byte[12];
  System.out.print("Digite uma franse com ao menos 12 letras finalizadas por ENTER");
  for (int i=0; i<12 ; i++){
      buffer[i] = (byte) System.in.read();
  }
  return (buffer);
}

public static void main(String args[]) throws Exception{
  byte buf[] = getInput();
  OutputStream f0 = new FileOutputStream("Saida0.txt");
  OutputStream f1 = new FileOutputStream("Saida1.txt");
  OutputStream f2 = new FileOutputStream("Saida2.txt");
  for (int i=0; i<12 ; i++)
	f0.write(buf[i]);
  f0.close();
  f1.write(buf);
  f1.close();
  f2.write(buf, 12/4, 12/2);
	// comeca na posição buf[ 12/4] e
	// imprime 12/2 elementos
  f2.close();
  }
}
