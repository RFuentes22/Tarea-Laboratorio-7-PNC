package com.uca.capas.repositories;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.Estudiante;


public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
}
