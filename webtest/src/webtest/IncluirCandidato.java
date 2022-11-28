package webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import CandidatoDAO;
import FabricaDeConexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Candidato;

@WebServlet("/IncluirCandidato")
public class IncluirCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigoCandidato = Integer.valueOf(request.getParameter("txtNumero"));
		String nomeCandidato = request.getParameter("txtNome");
		String sexoCandidato = request.getParameter("txtSexo");
		String data_nascCandidato = request.getParameter("txtData");
		String cargo_pretendidoCandidato = Float.valueOf(request.getParameter("txtCargo"));
		String texto_curriculoCandidato = Float.valueOf(request.getParameter("txtCargo"));
		
		Candidato candidato = new Candidato(codigoCandidato, nomeCandidato, sexoCandidato, data_nascCandidato, cargo_pretendidoCandidato, texto_curriculoCandidato);
		
		Connection con = FabricaDeConexao.obterConexao();
		CandidatoDAO dao = new CandidatoDAO(con);
		dao.incluir(candidato);
		
		
		response.sendRedirect("ListarCandidatos");

	}

}

