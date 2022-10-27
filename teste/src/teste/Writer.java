package teste;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {	
	
    public static void main(String[] args) throws IOException {
    	
    	try {
    		FileOutputStream arquivo = new FileOutputStream("pessoas.dat");
	        DataOutputStream gravarArq = new DataOutputStream(arquivo);    		
    		
    		Scanner leitor = new Scanner(System.in);
    		
			System.out.println("Informe o nome:"); 
			String nome = leitor.nextLine();
			
			System.out.println("Informe a idade:"); 
			String idade = leitor.nextLine();
			
			System.out.println("Informe o salário:"); 
			String salario = leitor.nextLine();
    	
			System.out.printf("Nome: " + nome + "\nIdade: " + idade + "\nSalario: " + salario);
					      	        
	        gravarArq.writeUTF(nome);
	        gravarArq.writeUTF(idade);
	        gravarArq.writeUTF(salario);

	        arquivo.close();

	        System.out.println("\nDados gravados com sucesso.\n");
			
    
		} catch (Exception e) {
			  System.out.print("" + e);
		}

    }
}
