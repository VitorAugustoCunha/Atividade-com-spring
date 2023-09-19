package com.treinamento.maven;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class primeiroservlet
 */
@WebServlet(name = "primeiroservlet", urlPatterns = { "/primeiroservlet" })
public class primeiroservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	    String nome = request.getParameter("nome");
	    String email = request.getParameter("email");
	    String idade = request.getParameter("idade");
	    String sexo = request.getParameter("sexo");
	    DadosUsuario dadosUsuario = new DadosUsuario(nome, email, idade, sexo);
	    response.setContentType("application/json");
	    response.getWriter().print(dadosUsuario.toJSON().toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("doPost");
	    System.out.println("Método doPost");
	    String nome = request.getParameter("nome");
	    String email = request.getParameter("email");
	    String idadeStr = request.getParameter("idade");

	    int idade = 0; 

	    if (idadeStr != null && !idadeStr.isEmpty()) {
	        try {
	            idade = Integer.parseInt(idadeStr);
	        } catch (NumberFormatException e) {
	            idade = 0;
	        }
	    }

	    String sexo = request.getParameter("sexo");

	    response.setContentType("text/html");
	    response.getWriter().println("<html><body>");
	    response.getWriter().println("<h1>Dados recebidos com sucesso!</h1>");
	    response.getWriter().println("<p>Nome: " + nome + "</p>");
	    response.getWriter().println("<p>Email: " + email + "</p>");
	    response.getWriter().println("<p>Idade: " + idade + "</p>");
	    response.getWriter().println("<p>Sexo: " + sexo + "</p>");
	    response.getWriter().println("</body></html>");
	}

}

