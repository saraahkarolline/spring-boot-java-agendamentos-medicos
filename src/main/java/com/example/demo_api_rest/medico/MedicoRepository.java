package com.example.demo_api_rest.medico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}