package teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Finder {
	
	public static void main(String[] args) throws IOException {
	
		/*
		 * try { Scanner leitor = new Scanner(System.in);
		 * System.out.println("Informe a sigla do estado:"); String uf =
		 * leitor.nextLine();
		 * 
		 * BufferedReader Buffer = new BufferedReader(new FileReader(new
		 * File("UF.csv")));
		 * 
		 * String linha = null;
		 * 
		 * while ((linha = Buffer.readLine()) != null) { String arr[] =
		 * linha.slipt(" "); for(int i = 0; i< arr.length; i++) { if
		 * (arr[i].trim().equals(uf)) { System.out.println(linha); } } } } catch
		 * (Exception e) { System.out.print("" + e); }
		 */
		
		//retorna nome do estado e a regiao 1 2 3
		
		Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo texto: ");
        String nomeArq = leitor.nextLine();
        
        Scanner uf = new Scanner(System.in);
        System.out.println("Digite a UF: ");
        String nomeUf = uf.nextLine();
        

        System.out.println("Conteúdo do arquivo texto:");
        try {
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while(linha != null){
                if (linha.contains(nomeUf)) {
            	System.out.println(linha);
            	System.out.println(nomeUf);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        }catch (IOException e){
            System.err.printf("Erro na abertura do arquivo: ", e.getMessage());
        }
		
	
	 }

}
