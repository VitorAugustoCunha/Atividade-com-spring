package com.treinamento.maven;

import java.util.List;

public class DadosUsuario {
    private int id;
    private String nome;
    private String email;
    private int idade;
    private String sexo;

    public DadosUsuario(String nome, String email, int idade, String sexo) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":").append(this.id).append(",");
        json.append("\"nome\":\"").append(this.nome).append("\",");
        json.append("\"email\":\"").append(this.email).append("\",");
        json.append("\"idade\":").append(this.idade).append(",");
        json.append("\"sexo\":\"").append(this.sexo).append("\"");
        json.append("}");
        return json.toString();
    }
    
    public static String toJSONLista(List<DadosUsuario> usuarios) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        boolean first = true;
        for (DadosUsuario usuario : usuarios) {
            if (!first) {
                json.append(",");
            }
            json.append(usuario.toJSON());
            first = false;
        }
        json.append("]");
        return json.toString();
    }
}
