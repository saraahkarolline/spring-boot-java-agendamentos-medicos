package com.example.demo_api_rest.medico;
import jakarta.persistence.*;
import lombok.*;
import com.example.demo_api_rest.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosListagemMedicoAtualizar dadosAtualizar) {
        if (dadosAtualizar.nome() != null){
            this.nome = dadosAtualizar.nome();
        }
        if (dadosAtualizar.telefone() != null){
            this.telefone = dadosAtualizar.telefone();
        }
        if (dadosAtualizar.endereco() != null){
            this.endereco.atualizarInformacoes(dadosAtualizar.endereco());
        }
       

    }

    public void excluir(){
        this.ativo = false;
    }

    
}
