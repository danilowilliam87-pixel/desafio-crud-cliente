package com.io.desafiocrudcliente.service;

import com.io.desafiocrudcliente.dto.ClienteDTO;
import com.io.desafiocrudcliente.model.Cliente;
import com.io.desafiocrudcliente.repository.ClienteRepository;
import com.io.desafiocrudcliente.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO findById(Long id){
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("cliente inexistente"));
        return new ClienteDTO(cliente);
    }
}
