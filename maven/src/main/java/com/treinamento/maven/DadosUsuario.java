package com.treinamento.maven;


public class DadosUsuario {
    private String nome;
    private String email;
    private String idade;
    private String sexo;

    public DadosUsuario(String nome, String email, String idade, String sexo) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"nome\":\"").append(this.nome).append("\",");
        json.append("\"email\":\"").append(this.email).append("\",");
        json.append("\"idade\":\"").append(this.idade).append("\",");
        json.append("\"sexo\":\"").append(this.sexo).append("\"");
        json.append("}");
        return json.toString();
    }
}
