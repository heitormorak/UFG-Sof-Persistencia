package teste;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ler {
	
	 public static void main(String[] args) throws IOException
	 {
		
		Scanner ler = new Scanner(System.in);
		int numero;
		
		System.out.print("Informe o número para a tabuada: ");
		numero = ler.nextInt();
		
		FileWriter arquivo = new FileWriter("arq.txt");
		PrintWriter gravarArq = new PrintWriter(arquivo);
		
		gravarArq.printf("teste");
		for(int i=1; i<=10; i++) {
			gravarArq.printf("\n teste %d %d", i, numero);			
		}
		
		gravarArq.printf("fim do arquivo");
		
		arquivo.close();
		
		System.out.println("finalizada gravação");
		
	 }
		
	

}
