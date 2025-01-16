package com.example.demo_api_rest.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
