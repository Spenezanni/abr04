package br.com.abr04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abr04.dto.TopicoDto;
import br.com.abr04.model.Topico;
import br.com.abr04.service.TopicoService;

@RestController
@RequestMapping("/topico")
public class TopicosController {
	
	@Autowired
	private TopicoService topicoService;
	
	public TopicoDto cadastrarTopico(@RequestBody Topico topico) {
		Topico topicoCadastrado = topicoService.cadastrarTopico(topico);
		return new TopicoDto(topicoCadastrado);
	}

}
