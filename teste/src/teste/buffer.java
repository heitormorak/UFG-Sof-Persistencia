package teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class buffer {
	
	public static void main(String[] args) throws IOException
	 {
		Scanner leitor = new Scanner(System.in);
		System.out.println("digite o nome do arquivo: ");
		String nomeArq = leitor.nextLine();
		
		System.out.println("conteudo do arquivo: ");
		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = lerArq.readLine();
			}
			arq.close();			
		} catch (IOException e){
			System.err.printf("Erro", e.getMessage());
		}
		
		
	 }

}
