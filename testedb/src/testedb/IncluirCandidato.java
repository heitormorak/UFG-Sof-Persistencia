import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class IncluirCandidato {
	public static void incluir() throws SQLException {
		Scanner reader = new Scanner(System.in);
		int codigo;
		String nome, cargo_pretendido, texto_curriculo;
		String sexo;
		String data_nasc;
		
		System.out.println("Digite o codigo do candidato: ");
		codigo = reader.nextInt();
		System.out.println("Digite o nome do candidato: ");
		reader.nextLine();
		nome = reader.nextLine();
		System.out.println("Digite o sexo do candidato: ");
		sexo = reader.next();
		System.out.println("Digite a data de nascimento do candidato: ");
		reader.nextLine();
		data_nasc = reader.nextLine();
		System.out.println("Digite o cargo pretendido do candidato: ");
		cargo_pretendido = reader.nextLine();
		System.out.println("Digite o texto do currículo do candidato: ");
		texto_curriculo = reader.nextLine();
		
		Candidato candidato = new Candidato(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo);
		
		CandidatoDAO dao = new CandidatoDAO();
		dao.criar(candidato);
	}
	
}
