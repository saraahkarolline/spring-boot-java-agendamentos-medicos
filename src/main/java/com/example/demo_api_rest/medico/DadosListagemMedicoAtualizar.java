package com.example.demo_api_rest.medico;

public record DadosListagemMedicoAtualizar(Long id, String nome, String email) {
    public DadosListagemMedicoAtualizar(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail());
    }

}
