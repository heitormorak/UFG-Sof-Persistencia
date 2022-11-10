package teste;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

public class WriterFuncionarioXML {

	public static void main(String[] args) throws IOException {
		
		Scanner leitor = new Scanner(System.in);
		ArrayList<String> habilidades = new ArrayList<String>();
		
        System.out.println("Digite o cpf: ");
        String cpf = leitor.nextLine();
        
        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();
        
        System.out.println("Digite o cargo: ");
        String cargo = leitor.nextLine(); 
        
        System.out.println("Digite a idade: ");
        int idade = leitor.nextInt();
        
        System.out.println("Digite o salario: ");
        double salario = leitor.nextDouble();    
        String input = leitor.nextLine(); //para não armazenar o espaço em branco no scanner da linha abaixo
               
        while(true) {
	  
		  System.out.println("Digite uma habilidade: ");
		  habilidades.add(leitor.nextLine());
		  
		  System.out.println("Inserir outra habilidade y/n?"); 
		  String answer = leitor.next();
		  String input1 = leitor.nextLine(); //para não armazenar o espaço em branco no scanner da linha abaixo
		  
		  if (answer.equals("n")){ 
			  System.out.println(answer); 
			  break; 
		  } 
        }
	         
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setIdade(idade);
		funcionario.setSalario(salario);
		funcionario.setCargo(cargo);
		funcionario.setHabilidades(habilidades);
		
		try {
			//usando xstream 
			XStream xstream = new XStream();						
			xstream.alias("Funcionario", Funcionario.class);
			
			//cria o arquivo com o cpf informado
			FileWriter file = new FileWriter(cpf + ".xml", true);
			
			//grava a classe convertida para xml
			file.write(xstream.toXML(funcionario));
			file.close();
				
			
		} catch (Exception e) {
			  System.out.print("" + e);
		}		
		
	}
	
}
