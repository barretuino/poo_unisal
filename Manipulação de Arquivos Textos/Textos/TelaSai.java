import java.io.*;
import java.util.*;

class TelaSai{

public static void main(String args[]) throws Exception{

  ByteArrayOutputStream f0 = new ByteArrayOutputStream(12);
  System.out.println("Digite 10 caracteres e pressione <return>");   
  while (f0.size() != 10 ){
	f0.write(System.in.read());
     }
  System.out.println("Buffer como uma string");
  System.out.println( f0.toString() );
  System.out.println("Para um array");
  byte b[] = f0.toByteArray();
  for (int i=0; i < b.length; i++){
     System.out.println((char) b[i]);
   }
  System.out.println("Para um FileOutputStream ...");
  OutputStream f1 = new FileOutputStream("testando.txt");
  f0.writeTo(f1);
  System.out.println("Acabou ... ");
}
}