package com.example.demo_api_rest.medico;

import com.example.demo_api_rest.endereco.DadosEndereco;
import jakarta.validation.constraints.*;

public record DadosCadastroMedico(
        @NotBlank 
        String nome, 
        @NotBlank
        @Email
        String email, 
        @NotBlank
        String telefone, 
        @NotBlank
        String crm, 
        Especialidade especialidade, 
        DadosEndereco endereco) {

}
