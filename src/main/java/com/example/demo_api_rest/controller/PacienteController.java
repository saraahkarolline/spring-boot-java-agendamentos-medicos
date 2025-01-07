package com.example.demo_api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_api_rest.paciente.DadosCadastroPaciente;
import com.example.demo_api_rest.paciente.DadosListagemPaciente;
import com.example.demo_api_rest.paciente.Paciente;
import com.example.demo_api_rest.paciente.PacienteRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("paciente")
public class PacienteController {

         @Autowired //injeção de dependência
        private PacienteRepository repository;  
        

    @PostMapping 
    @Transactional             
        public String cadastrar(@RequestBody @Valid  DadosCadastroPaciente dadosPaciente) {
            System.out.println(dadosPaciente);
            repository.save(new Paciente(dadosPaciente));
           return "Paciente cadastrado com sucesso!";
        }

        // @PostMapping    
        // @Transactional          
        // public String cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        //     repository.save(new Medico(dados));
            
        //     System.out.println(dados);
        //    return "Médico cadastrado com sucesso!";
        // }

        @GetMapping
        public Page<DadosListagemPaciente> listar(Pageable paginacao) {
            return repository.findAll(paginacao).map(DadosListagemPaciente::new);
        }

        //   @GetMapping("id")
        // public String getMethodName(@RequestBody DadosCadastroPaciente dados) {
        //         return repository.findBy(dados);
        // }

        // @GetMapping("/{id}")
        // public ResponseEntity<Paciente> getPaciente(@PathVariable Long id) {
        //     Optional<Paciente> pacienteOptional = repository.findById(id);
        //     if (pacienteOptional.isPresent()) {
        //         return ResponseEntity.ok(pacienteOptional.get());
        //     } else {
        //         return ResponseEntity.notFound().build();
        //     }
        // }
        @GetMapping("/pacientes")
        public ResponseEntity<List<Paciente>> getAllPacientes() {
            List<Paciente> pacientes = repository.findAll();
            return ResponseEntity.ok(pacientes);
        }


}

        
//@PageableDefault(page = 0, size = 10, sort = {"nome"}) 

