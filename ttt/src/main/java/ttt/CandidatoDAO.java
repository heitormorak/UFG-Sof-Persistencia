package ttt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Candidato;

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
					+ " SET nome = ?, tipo = ?, valor = ? "
					+ " WHERE numero = ?";
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
	
	
	
	public Curso obterCurso(int numero) {
		try {
			String sql = "SELECT nome, tipo, valor FROM curso WHERE numero = ?";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			instrucao.setInt(1, numero);

			ResultSet rs = instrucao.executeQuery();
			if (rs.next()) {
				Curso curso = new Curso(numero, 
						rs.getString("nome"),
						rs.getString("tipo"),
						rs.getFloat("valor")
						);
				return curso;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Curso> obterCursos(){
		try {
			List<Curso> lista = new ArrayList<Curso>();
			
			String sql = "SELECT numero, nome, tipo, valor FROM curso";
			PreparedStatement instrucao = this.con.prepareStatement(sql);
			ResultSet rs = instrucao.executeQuery();
			while (rs.next()) {
				Curso curso = new Curso(rs.getInt("numero"), 
						rs.getString("nome"),
						rs.getString("tipo"),
						rs.getFloat("valor")
						);
				lista.add(curso);
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}