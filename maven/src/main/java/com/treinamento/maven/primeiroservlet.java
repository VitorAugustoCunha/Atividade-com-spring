package com.treinamento.maven;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "primeiroservlet", urlPatterns = { "/primeiroservlet", "/primeiroservlet/*" })
public class primeiroservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet");
//	    String nome = request.getParameter("nome");
//	    String email = request.getParameter("email");
//	    String sexo = request.getParameter("sexo");
//	    
//	    String idadeStr = request.getParameter("idade");
//
//	    int idade = 0;
//
//	    if (idadeStr != null && !idadeStr.isEmpty()) {
//	        try {
//	            idade = Integer.parseInt(idadeStr);
//	        } catch (NumberFormatException e) {
//	            idade = 0;
//	        }
//	    }
//
//	    DadosUsuario dadosUsuario = new DadosUsuario(nome, email, idade, sexo);
//	    response.setContentType("application/json");
//	    response.getWriter().print(dadosUsuario.toJSON().toString());
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            List<DadosUsuario> usuarios = DataBaseFake.obterUsuarios();
            String jsonUsuarios = convertToJSON(usuarios);
            response.setContentType("application/json");
            response.getWriter().print(jsonUsuarios);
        } else {
            String idStr = pathInfo.substring(1);
            int id = 0;

            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().print("ID inválido");
                return;
            }

            DadosUsuario usuario = buscarUsuarioPorId(id);

            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().print("Usuário não encontrado");
                return;
            }

            String jsonUsuario = usuario.toJSON();
            response.setContentType("application/json");
            response.getWriter().print(jsonUsuario);
        }
    }

	private String convertToJSON(Object object) {
	    if (object instanceof List<?>) {
	        List<?> lista = (List<?>) object;
	        if (!lista.isEmpty() && lista.get(0) instanceof DadosUsuario) {
	            List<DadosUsuario> usuarios = (List<DadosUsuario>) object;
	            return DadosUsuario.toJSONLista(usuarios);
	        }
	    }
	    return "[]";
	}

	private DadosUsuario buscarUsuarioPorId(int id) {
	    List<DadosUsuario> usuarios = DataBaseFake.obterUsuarios();

	    for (DadosUsuario usuario : usuarios) {
	        if (usuario.getId() == id) {
	            return usuario;
	        }
	    }

	    return null;
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

	    DadosUsuario dadosUsuario = new DadosUsuario(nome, email, idade, sexo);

	    DataBaseFake.adicionarUsuario(dadosUsuario);

	    response.setContentType("text/html");
	    response.getWriter().println("<html><body>");
	    response.getWriter().println("<h1>Dados recebidos com sucesso!</h1>");
	    response.getWriter().println("<p>Nome: " + nome + "</p>");
	    response.getWriter().println("<p>Email: " + email + "</p>");
	    response.getWriter().println("<p>Idade: " + idade + "</p>");
	    response.getWriter().println("<p>Sexo: " + sexo + "</p>");

	    response.getWriter().println("<h2>Usuários no banco de dados:</h2>");
	    List<DadosUsuario> usuarios = DataBaseFake.obterUsuarios();
	    for (DadosUsuario usuario : usuarios) {
	        response.getWriter().println("<p>ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail() + ", Idade: " + usuario.getIdade() + ", Sexo: " + usuario.getSexo() + "</p>");
	    }

	    response.getWriter().println("</body></html>");
	}


}

