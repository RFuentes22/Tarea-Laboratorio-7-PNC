package com.uca.capas.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Computadora;
import com.uca.capas.domain.Estudiante;

public interface EstudianteService {

	public List<Estudiante> findAllEstudiante() throws DataAccessException;
	
	//public List<Computadora> findAllComputadora() throws DataAccessException;

	public Estudiante findOne(Integer codigo) throws DataAccessException;

	public void save(Estudiante estudiante) throws DataAccessException;

	public void delete(Integer CodigoEstudiante) throws DataAccessException;
	
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException;

}
