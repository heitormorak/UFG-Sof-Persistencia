import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {

	private Connection conexao;
	
	public CandidatoDAO() throws SQLException{
		conexao = FabricaDeConexao.obterConexao();
	}
	
	public void criar(Candidato can) {
		String sql = "INSERT INTO candidato(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement instrucao = conexao.prepareStatement(sql);
			instrucao.setInt(1, can.getCodigo());
			instrucao.setString(2, can.getNome());
			instrucao.setString(3, can.getSexo());
			instrucao.setString(4, can.getData_nasc());
			instrucao.setString(5, can.getCargo_pretendido());
			instrucao.setString(6, can.getTexto_curriculo());
		} catch (SQLException e) {
			System.err.println("Erro durante a inserção dos dados");
		}
	}
	
	public List<Candidato> listar() {
		List<Candidato> listaDeCandidatos = new ArrayList<Candidato>();
		String sql = "SELECT nome, sexo, data_nac, cargo_pretendido, texto_curriculo FROM candidato ";
		try {
			PreparedStatement instrucao = conexao.prepareStatement(sql);
			ResultSet resultado = instrucao.executeQuery();
			
			while(resultado.next()) {
				Candidato c = new Candidato(resultado.getInt("codigo"),
											resultado.getString("nome"),
											resultado.getString("sexo"),
											resultado.getString("data_nasc"),
											resultado.getString("cargo_pretendido"),
											resultado.getString("texto_curriculo"));
				listaDeCandidatos.add(c);
			}
		} catch(SQLException e) {
			System.err.println("Erro durante a consulta dos dados");
		}
		return listaDeCandidatos;
	}
	
}
