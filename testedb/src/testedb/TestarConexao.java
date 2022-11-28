
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestarConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = FabricaDeConexao.obterConexao();
		
		//Curso novoCurso = new Curso(20, "Sistema de Informação", "B", 1000);
		
		IncluirCandidato novoCandidato = new IncluirCandidato();
		
		novoCandidato.incluir();
		
		//CandidatoDAO dao = new CandidatoDAO();
		
		//List<Candidato> candidatos = dao.listar();
		//for(Candidato can : candidatos) {
		//	System.out.println(can.getNome());
		//}
		
	}

}
