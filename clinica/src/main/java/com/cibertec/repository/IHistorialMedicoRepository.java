package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.HistorialMedico;

public interface IHistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer>{
	
}
