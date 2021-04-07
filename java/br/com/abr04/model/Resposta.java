package br.com.abr04.model;

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
	

}
