package treinamento;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aulas
 */
@WebServlet(name = "primeiroservlet", urlPatterns = { "/primeiroservlet" })
public class aulas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int idade = Integer.parseInt(request.getParameter("idade"));
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
