<%@page import="java.util.ArrayList"%>
<%@page import="ttt.Candidato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	List<Candidato> candidatos = (List<Candidato>) request.getAttribute("lista");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Lista de Candidatos</title>
</head>
<body>
	<h3>Lista de candidatos</h3>
	<% if (request.getAttribute("mensagem") != null) {%>
		<p style="color:red"><%=request.getAttribute("mensagem") %></p>
	<%} %>
	<table border="1">
		<tr>
			<td>Código</td>
			<td>Nome</td>
			<td>Sexo</td>
			<td>Data de nascimento</td>
			<td>Cargo pretendido</td>
			<td>Texto do currículo</td>
		</tr>
		<% for(Candidato can : candidatos) { %>
			<tr>
				<td><%=can.getCodigo() %></td>
				<td><%=can.getNome()%></td>
				<td><%=can.getSexo()%></td>
				<td><%=can.getData_nasc()%></td>
				<td><%=can.getCargo_pretendido()%></td>
				<td><%=can.getTexto_curriculo()%></td>
				<td> <a href="ExcluirCandidato?codigo=<%=can.getCodigo()%>"> X </a> </td>		
			</tr>
		<% } %>
	</table>
</body>
</html>