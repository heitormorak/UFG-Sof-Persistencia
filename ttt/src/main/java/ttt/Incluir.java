package ttt;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Incluir
 */
@WebServlet("/Incluir")
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int candidatoCodigo = Integer.valueOf(request.getParameter("intCodigo"));
		String candidatoNome = request.getParameter("txtNome");
		String candidatoSexo = request.getParameter("txtSexo");
		String candidatoDataNasc = request.getParameter("txtDN");
		String candidatoCargo = request.getParameter("txtCargo");
		String candidatoTexto = request.getParameter("txtTexto");
		
		
		Candidato candidato = new Candidato(candidatoCodigo, candidatoNome, candidatoSexo, candidatoDataNasc,
											candidatoCargo, candidatoTexto);
		
		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		dao.incluir(candidato);
		
		response.sendRedirect("ListarCandidatos");
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
