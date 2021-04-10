package br.com.abr04.dto;

import br.com.abr04.model.Cliente;

public class ClienteDto {
	
	private String nome;
	
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
