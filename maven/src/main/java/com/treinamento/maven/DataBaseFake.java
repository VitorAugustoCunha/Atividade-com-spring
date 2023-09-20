package com.treinamento.maven;

import java.util.ArrayList;
import java.util.List;

public class DataBaseFake {
	 private static int nextId = 1;
	    private static List<DadosUsuario> bancoDados = new ArrayList<>();

	    public static synchronized void adicionarUsuario(DadosUsuario usuario) {
	        usuario.setId(nextId++);
	        bancoDados.add(usuario);
	    }

	    public static synchronized List<DadosUsuario> obterUsuarios() {
	        return bancoDados;
	    }
}
