package ttt;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListarCandidatos")
public class ListarCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		List<Candidato> candidatos = dao.listar();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarcandidatos.jsp");
		request.setAttribute("lista", candidatos);
		request.setAttribute("mensagem", request.getParameter("mensagem"));
		rd.forward(request, response);
		
	}

	

}
