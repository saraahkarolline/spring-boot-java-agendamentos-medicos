package com.example.demo_api_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_api_rest.medico.DadosCadastroMedico;
import com.example.demo_api_rest.medico.DadosListagemMedico;
import com.example.demo_api_rest.medico.DadosListagemMedicoAtualizar;
import com.example.demo_api_rest.medico.Medico;
import com.example.demo_api_rest.medico.MedicoRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("medicos")
public class MedicoController {
      /*  @GetMapping("id")
        public String getMethodName(@RequestBody DadosCadastroMedico dados) {
                return "Médico cadastrado com sucesso!";
        }*/
           

        @Autowired //injeção de dependência
        private MedicoRepository repository;  
        
                 


        @PostMapping    
        @Transactional          
        public String cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
            repository.save(new Medico(dados));
            
            System.out.println(dados);
           return "Médico cadastrado com sucesso!";
        }

        @GetMapping
        public Page<DadosListagemMedico> listar(Pageable paginacao) {
        //public Page<DadosListagemMedico> listar(Pageable paginacao) {
                //retorna do repositório todos os médicos cadastrados e converte para uma lista de DadosListagemMedico
            return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        }
        @PutMapping
        @Transactional  
        public String atualizar(@RequestBody @Valid DadosListagemMedicoAtualizar dadosAtualizar) {
                var medico = repository.getReferenceById( dadosAtualizar.id());
                medico.atualizarInformacoes(dadosAtualizar);
            
            return "Médico atualizado com sucesso!";
        }    

        @DeleteMapping("/{id}")
        @Transactional
        public void excluir(@PathVariable Long id){
                var medico = repository.getReferenceById(id);
                medico.excluir();

        }
                
       


}
