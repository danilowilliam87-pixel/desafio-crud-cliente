package com.io.desafiocrudcliente.service;

import com.io.desafiocrudcliente.dto.ClienteDTO;
import com.io.desafiocrudcliente.model.Cliente;
import com.io.desafiocrudcliente.repository.ClienteRepository;
import com.io.desafiocrudcliente.service.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

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
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("cliente inexistente"));
        String name = Objects.requireNonNullElse(clienteDTO.getName(), cliente.getName());
        String cpf = Objects.requireNonNullElse(clienteDTO.getCpf(), cliente.getCpf());
        Double income = Objects.requireNonNullElse(clienteDTO.getIncome(), cliente.getIncome());
        LocalDate birthDate = Objects.requireNonNullElse(clienteDTO.getBirthDate(), cliente.getBirthDate());
        Integer children = Objects.requireNonNullElse(clienteDTO.getChildren(), cliente.getChildren());
        cliente.setName(name);
        cliente.setCpf(cpf);
        cliente.setIncome(income);
        cliente.setBirthDate(birthDate);
        cliente.setChildren(children);
        cliente = this.clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }

    public void delete(Long id){
        this.clienteRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("cliente inexistente"));
        this.clienteRepository.deleteById(id);
    }

}
