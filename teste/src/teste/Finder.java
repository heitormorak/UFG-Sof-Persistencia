package teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Finder {
	
	public static void main(String[] args) throws IOException {
	
		
		  try { 
			  Scanner leitor = new Scanner(System.in);
			  System.out.println("Informe a sigla do estado:"); 
			  String uf = leitor.nextLine();
			  
			  BufferedReader Buffer = new BufferedReader(new FileReader(new File("UF.csv")));
			  
			  String linha = null;
			  
			  while ((linha = Buffer.readLine()) != null) { 
			  String arr[] = linha.split(",");
			  String regiao = null;
			  	for(int i = 0; i< arr.length; i++) { 
			  		if (arr[i].trim().equals(uf)) {
			  			if (arr[i+2].equals("1")) {
			  				regiao = "Norte";
			  			}
			  			if (arr[i+2].equals("2")) {
			  				regiao = "Nordeste";
			  			}
			  			if (arr[i+2].equals("3")) {
			  				regiao = "Sudeste";
			  			}
			  			if (arr[i+2].equals("4")) {
			  				regiao = "Sul";
			  			}
			  			if (arr[i+2].equals("5")) {
			  				regiao = "Centro-Oeste";
			  			}
			  			
			  			System.out.printf("Nome do estado: %s \n", arr[i+1]);
			  			System.out.printf("Região: %s", regiao);
			  		} 
			  	} 
			  } 
		  } catch (Exception e) {
			  System.out.print("" + e); 
		  }		 		
			
	 }

}
