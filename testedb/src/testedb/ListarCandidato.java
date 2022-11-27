import java.sql.SQLException;
import java.util.List;

public class ListarCandidato {
	
	public static void listar() throws SQLException {
		CandidatoDAO dao = new CandidatoDAO();
		System.out.println(String.format("%-35s %c, nome, sexo,"));
		List<Candidato> lista = dao.listar();
		lista.forEach(c -> {
			System.out.println(String.format("%i %-35s %-1s %d %-40s %-800s", c.getCodigo(), c.getNome(), c.getSexo()));
		});
	}

}
