package com.example.demo_api_rest.paciente;
import jakarta.validation.constraints.NotNull;
import com.example.demo_api_rest.endereco.DadosEndereco;

public record DadosListagemPacienteAtualizar(
    @NotNull
    Long id,
    String nome,
    String email,
    String telefone,
    DadosEndereco endereco
) {}
