package ttt;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExcluirCandidato")
public class ExcluirCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.valueOf(request.getParameter("codigo"));
		
		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		Candidato candidato = dao.obterCandidato(codigo);
		dao.excluir(codigo);
		
		String nome = "O candidato " + candidato.getNome() + " foi excluído!!!";
		
		response.sendRedirect("ListarCursos?mensagem="+nome);
	}

}
