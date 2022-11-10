package teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReaderFuncionarioXML {
	
	public static void main(String[] args) throws IOException
	 {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o cpf: ");
		String nomeArq = leitor.nextLine();
		
		try {
			
			XStream xstream = new XStream(new DomDriver());
			File file = new File (nomeArq + ".xml");
			FileInputStream input = new FileInputStream(file);
			
			xstream.alias("Funcionario", Funcionario.class);
			
			Funcionario xml = (Funcionario) xstream.fromXML(input);			
					
			System.out.println("Dados do objeto originados do JSON:");
			System.out.println ("CPF: "+ xml.getCpf());
			System.out.println ("Nome: "+ xml.getNome());
			System.out.println ("Idade: "+ xml.getIdade());
			System.out.println ("Cargo: "+ xml.getCargo());
			System.out.println ("Habilidades: "+ xml.getHabilidades());
					
		} catch (IOException e){
			System.err.printf("Nenhum arquivo encontrado com o CPF informado", e.getMessage());
		}
		
		
	 }

}
