package com.example.demo_api_rest.medico;

import com.example.demo_api_rest.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
