package ttt;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {
	private Connection con;
	
	public CandidatoDAO(Connection conexao) {
		this.con = conexao;
	}
	
	public void incluir(Candidato can) {
		
		try {
			String sql = "INSERT INTO candidato(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			instrucao.setInt(1, can.getCodigo());
			instrucao.setString(2, can.getNome());
			instrucao.setString(3, can.getSexo());
			instrucao.setString(4, can.getData_nasc());
			instrucao.setString(5, can.getCargo_pretendido());
			instrucao.setString(6, can.getTexto_curriculo());
			instrucao.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro durante a inserção dos dados");
			e.printStackTrace();
		}
	}
	
	public void excluir(Candidato can) {
		excluir(can.getCodigo());
	}
	public void excluir(int codigo) {
		try {
			String sql = "DELETE FROM curso WHERE codigo = ?";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			instrucao.setInt(1, codigo);
			instrucao.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Candidato can) {
		try {
			String sql = "UPDATE curso "
					+ " SET codigo = ?, nome = ?, sexo = ? "
					+ " SET data_nasc = ?, cargo_pretendido = ?, texto_curriculo = ? "
					+ " WHERE codigo = ?";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			instrucao.setInt(1, can.getCodigo());
			instrucao.setString(2, can.getNome());
			instrucao.setString(3, can.getSexo());
			instrucao.setString(4, can.getData_nasc());
			instrucao.setString(5, can.getCargo_pretendido());
			instrucao.setString(6, can.getTexto_curriculo());
			instrucao.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Candidato obterCandidato(int codigo) {
		try {
			String sql = "SELECT * FROM curso WHERE codigo = ?";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			instrucao.setInt(1, codigo);

			ResultSet rs = instrucao.executeQuery();
			if (rs.next()) {
				Candidato candidato = new Candidato( 
						rs.getInt("codigo"),
						rs.getString("nome"),
						rs.getString("sexo"),
						rs.getString("data_nasc"),
						rs.getString("cargo_pretendido"),
						rs.getString("texto_curriculo")
						);
				return candidato;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Candidato> listar(){
		try {
			List<Candidato> listaDeCandidatos = new ArrayList<Candidato>();
			String sql = "SELECT * FROM candidato ";
			
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			ResultSet resultado = instrucao.executeQuery();
			
			while (resultado.next()) {
				Candidato c = new Candidato(resultado.getInt("codigo"),
						resultado.getString("nome"),
						resultado.getString("sexo"),
						resultado.getString("data_nasc"),
						resultado.getString("cargo_pretendido"),
						resultado.getString("texto_curriculo"));
						listaDeCandidatos.add(c);
			}
			return listaDeCandidatos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}