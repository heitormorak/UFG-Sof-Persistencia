package webtest;

import java.io.IOException;
import java.sql.Connection;

import biblioteca.CursoDAO;
import biblioteca.FabricaDeConexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Curso;


@WebServlet("/ExcluirCandidato")
public class ExcluirCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.valueOf(request.getParameter("codigo"));
		
		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		//criar obterCandidato em DAO
		Candidato candidato = dao.obterCandidato(codigo);
		dao.excluir(codigo);
		
		String nome = "O candidato " + candidato.getNome() + " foi excluído!!!";
		
		response.sendRedirect("ListarCandidatos?mensagem="+nome);
	}

}
