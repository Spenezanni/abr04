package br.com.abr04.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPOSTAS")
public class Resposta {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String mensagem;
	private Topico topico;
	private LocalDateTime dataCriacao;
	private User autor;
	private Boolean solucao = false;
		
	
	

}
