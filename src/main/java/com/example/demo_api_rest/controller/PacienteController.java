package com.example.demo_api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.*;

import com.example.demo_api_rest.paciente.*;

import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.PathVariable;



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

        @GetMapping
        public Page<DadosListagemPaciente> listar(Pageable paginacao) {
            //return repository.findAll(paginacao).map(DadosListagemPaciente::new);
            return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        }

        @PutMapping
        @Transactional
        public String atualizarPaciente(@RequestBody DadosListagemPacienteAtualizar dadosAtualizarPaciente) {
            var paciente = repository.getReferenceById(dadosAtualizarPaciente.id());
            paciente.atualizarInformacoes(dadosAtualizarPaciente);
            
            return "Paciente atualizado com sucesso!";
        }


        @GetMapping("/pacientes")
        public ResponseEntity<List<Paciente>> getAllPacientes() {
            List<Paciente> pacientes = repository.findAll();
            return ResponseEntity.ok(pacientes);
        }

        @DeleteMapping("/{id}")
        @Transactional
        public void excluirPaciente(@PathVariable Long id) {
            var paciente = repository.getReferenceById(id);
            paciente.excluir();
        }

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




        
//@PageableDefault(page = 0, size = 10, sort = {"nome"}) 

