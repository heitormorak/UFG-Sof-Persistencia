package teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
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
			
			//xstream.alias("produto", Funcionario.class);
			FileInputStream inputStream = new FileInputStream(new File(nomeArq + ".xml"));
			Funcionario fun = (Funcionario) xstream.fromXML(inputStream);
			//List<Produto> produtos = (List<Produto>) xstream.fromXML(inputStream);
			
			
			/*
			 * FileReader arq = new FileReader(nomeArq + ".xml"); 
			 * BufferedReader lerArq =
			 * new BufferedReader(arq);
			 * 
			 * String linha = lerArq.readLine();
			 * 
			 * Gson objGson = new Gson(); 
			 * Funcionario fun = objGson.fromJson(linha,
			 * Funcionario.class);
			 */
			System.out.println("Dados do objeto originados do JSON:");
			System.out.println ("CPF: "+ fun.getCpf());
			System.out.println ("Nome: "+ fun.getNome());
			System.out.println ("Idade: "+ fun.getIdade());
			System.out.println ("Cargo: "+ fun.getCargo());
			System.out.println ("Habilidades: "+ fun.getHabilidades());
			
			//arq.close();			
		} catch (IOException e){
			System.err.printf("Nenhum arquivo encontrado com o CPF informado", e.getMessage());
		}
		
		
	 }

}
