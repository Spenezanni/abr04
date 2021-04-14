package br.com.abr04.service;

import br.com.abr04.dto.ClienteDto;
import br.com.abr04.model.Cliente;


public interface ClienteService {

	ClienteDto cadastrarClienteDto(Cliente cliente);

	ClienteDto retornarPorNome(String nome);

}
