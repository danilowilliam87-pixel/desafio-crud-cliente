package com.io.desafiocrudcliente.service;

import com.io.desafiocrudcliente.dto.ClienteDTO;
import com.io.desafiocrudcliente.model.Cliente;
import com.io.desafiocrudcliente.repository.ClienteRepository;
import com.io.desafiocrudcliente.service.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public ClienteDTO insert(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        cliente = this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    public Page<ClienteDTO> findAll(Pageable pageable) {
        return this.clienteRepository.findAll(pageable).map(ClienteDTO::new);
    }

    public ClienteDTO update(Long id, @Valid ClienteDTO clienteDTO){
        ClienteDTO dto = this.findById(id);
        dto.setCpf(clienteDTO.getCpf());
        dto.setChildren(clienteDTO.getChildren());
        dto.setName(clienteDTO.getName());
        dto.setBirthDate(clienteDTO.getBirthDate());
        Cliente cliente = new Cliente(dto);
        cliente = this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

}
