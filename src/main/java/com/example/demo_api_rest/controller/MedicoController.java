package com.example.demo_api_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_api_rest.medico.DadosCadastroMedico;
import com.example.demo_api_rest.medico.DadosListagemMedico;
import com.example.demo_api_rest.medico.Medico;
import com.example.demo_api_rest.medico.MedicoRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;




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
                //retorna do repositório todos os médicos cadastrados e converte para uma lista de DadosListagemMedico
            return repository.findAll(paginacao).map(DadosListagemMedico::new);
        }
        


}
