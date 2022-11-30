

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.CursoDAO;
import biblioteca.FabricaDeConexao;
import modelo.Curso;

/**
 * Servlet implementation class Incluir
 */
@WebServlet("/Incluir")
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigoCurso = Integer.valueOf(request.getParameter("txtNumero"));
		String nomeCurso = request.getParameter("txtNome");
		String tipoCurso = request.getParameter("selTipo");
		Float valorCurso = Float.valueOf(request.getParameter("txtValor"));
		
		Curso curso = new Curso(codigoCurso, nomeCurso, tipoCurso, valorCurso);
		
		Connection con = FabricaDeConexao.obterConexao();
		CursoDAO dao = new CursoDAO(con);
		dao.incluir(curso);
		
		response.sendRedirect("ListarCursos");
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
