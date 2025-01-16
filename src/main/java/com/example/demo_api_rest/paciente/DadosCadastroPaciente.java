package com.example.demo_api_rest.paciente;

import com.example.demo_api_rest.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String cpf, String datanascimento, String telefone, DadosEndereco endereco) {

}
