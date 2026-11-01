package com.io.desafiocrudcliente.dto;

import com.io.desafiocrudcliente.model.Cliente;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Objects;

public class ClienteDTO {

    @NotBlank(message = "{cliente.nome.obrigatorio}")
    @Size(min = 3, message = "{cliente.nome.tamanho}")
    private String name;

    @NotBlank(message = "{cliente.cpf.obrigatorio}")
    @CPF(message = "{cliente.cpf.invalido}")
    private String cpf;
    private Double income;

    @PastOrPresent(message = "{cliente.dataNascimento.invalido}")
    private LocalDate birthDate;
    private Integer children;

    public ClienteDTO() {
    }

    public ClienteDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClienteDTO(Cliente cliente){
        this.name = cliente.getName();
        this.cpf = cliente.getCpf();
        this.income = cliente.getIncome();
        this.birthDate = cliente.getBirthDate();
        this.children = cliente.getChildren();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf);
    }
}
