package com.io.desafiocrudcliente.config;

import com.io.desafiocrudcliente.model.Cliente;
import com.io.desafiocrudcliente.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class LoadData implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public LoadData(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpa a base caso já existam dados
        clienteRepository.deleteAll();

        Cliente c1 = new Cliente(null, "Maria Silva", "12345678901", 3500.0, LocalDate.of(1990, 5, 15), 2);
        Cliente c2 = new Cliente(null, "João Pereira", "23456789012", 4200.0, LocalDate.of(1985, 8, 22), 1);
        Cliente c3 = new Cliente(null, "Ana Souza", "34567890123", 5800.0, LocalDate.of(1992, 11, 30), 0);
        Cliente c4 = new Cliente(null, "Carlos Oliveira", "45678901234", 2900.0, LocalDate.of(1978, 3, 10), 3);
        Cliente c5 = new Cliente(null, "Beatriz Santos", "56789012345", 7100.0, LocalDate.of(1995, 7, 5), 0);
        Cliente c6 = new Cliente(null, "Lucas Ferreira", "67890123456", 3100.0, LocalDate.of(2000, 1, 18), 1);
        Cliente c7 = new Cliente(null, "Fernanda Lima", "78901234567", 6400.0, LocalDate.of(1988, 9, 25), 2);
        Cliente c8 = new Cliente(null, "Rafael Almeida", "89012345678", 4800.0, LocalDate.of(1982, 12, 12), 4);
        Cliente c9 = new Cliente(null, "Juliana Costa", "90123456789", 5300.0, LocalDate.of(1997, 4, 3), 0);
        Cliente c10 = new Cliente(null, "Eduardo Rocha", "01234567890", 8200.0, LocalDate.of(1975, 6, 20), 2);

        clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }
}
