package webtest;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import CandidatoDAO;
import FabricaDeConexao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Candidato;


@WebServlet("/ListarCandidatos")
public class ListarCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		List<Candidato> candidatos = dao.obterCursos();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarcandidatos.jsp");
		request.setAttribute("lista", candidatos);
		request.setAttribute("mensagem", request.getParameter("mensagem"));
		rd.forward(request, response);
		
	}

	

}
