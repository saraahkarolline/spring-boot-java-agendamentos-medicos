package com.example.demo_api_rest.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    //construtor
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
