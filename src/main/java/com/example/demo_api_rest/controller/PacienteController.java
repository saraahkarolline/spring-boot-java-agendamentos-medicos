package com.example.demo_api_rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_api_rest.paciente.DadosCadastroPaciente;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @PostMapping              
        public String cadastrar(@RequestBody DadosCadastroPaciente dadosPaciente) {
            System.out.println(dadosPaciente);
           return "Paciente cadastrado com sucesso!";
        }

}
