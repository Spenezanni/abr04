package br.com.abr04.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abr04.dto.ClienteDto;
import br.com.abr04.model.Cliente;
import br.com.abr04.repository.ClienteRepository;
import br.com.abr04.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteDto cadastrarClienteDto(Cliente cliente) {
		Cliente clienteCadastrado = clienteRepository.save(cliente);
		return new ClienteDto(clienteCadastrado);
	}
}
