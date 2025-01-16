package com.example.demo_api_rest.paciente;


import com.example.demo_api_rest.endereco.Endereco;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String datanascimento;
    private String telefone;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.datanascimento = dados.datanascimento();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }
    public void atualizarInformacoes(DadosListagemPacienteAtualizar dadosAtualizarPaciente) {
        if (dadosAtualizarPaciente.nome() != null){
            this.nome = dadosAtualizarPaciente.nome();
        }
        if (dadosAtualizarPaciente.email() != null){
            this.email = dadosAtualizarPaciente.email();
        }
        if (dadosAtualizarPaciente.telefone() != null){
            this.telefone = dadosAtualizarPaciente.telefone();
        }
        if (dadosAtualizarPaciente.endereco() != null){
            this.endereco.atualizarInformacoes(dadosAtualizarPaciente.endereco());
        }
       

    }

    public void excluir(){
        this.ativo = false;
    }
}


