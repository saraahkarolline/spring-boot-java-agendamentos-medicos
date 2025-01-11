package com.example.demo_api_rest.medico;

import com.example.demo_api_rest.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosListagemMedicoAtualizar(
    @NotNull
    Long id, 
    String nome, 
    String email, 
    String telefone,
    DadosEndereco endereco){}
    //  {
    // public DadosListagemMedicoAtualizar(Medico medico) {
    //     this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getTelefone());
    // }


