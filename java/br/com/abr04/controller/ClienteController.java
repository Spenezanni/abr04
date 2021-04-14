package br.com.abr04.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.abr04.dto.ClienteDto;
import br.com.abr04.model.Cliente;
import br.com.abr04.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClienteDto> cadastrarClienteDto(@RequestBody Cliente cliente){
		ClienteDto clienteDto = clienteService.cadastrarClienteDto(cliente);
		return ResponseEntity.ok().body(clienteDto);
	}
	
	@GetMapping
	public ResponseEntity<ClienteDto> retornarPorNome(String nome){
		ClienteDto clienteDto = clienteService.retornarPorNome(nome);
		return ResponseEntity.ok().body(clienteDto);
	}
	

	
}
