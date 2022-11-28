
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestarConexao {

	public static void main(String[] args) throws SQLException {
		
		//cria novo Candidato. Dentro da classe ja existe a criaçao da conexao com o banco
		IncluirCandidato novoCandidato = new IncluirCandidato();
		
		//chama o metodo incluir para adicionar Candidato no banco
		novoCandidato.incluir();
		
		CandidatoDAO dao = new CandidatoDAO();
		
		//após criar, lista os candidatos da tabela
		List<Candidato> candidatos = dao.listar();
		for(Candidato can : candidatos) {
			System.out.println(can.getNome());
		}
		
	}

}
