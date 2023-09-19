package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonModel {
	
	@JsonProperty("nome")
    private String nome;
	
	@JsonProperty("email")
    private String email;
	
	@JsonProperty("idade")
    private int idade;
	
	@JsonProperty("sexo")
    private String sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
    
    
}
