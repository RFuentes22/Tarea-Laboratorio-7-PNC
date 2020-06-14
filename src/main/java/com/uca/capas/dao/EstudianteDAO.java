package com.uca.capas.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Computadora;
import com.uca.capas.domain.Estudiante;

public interface EstudianteDAO {

	
	public List<Estudiante> findAllEstudiante() throws DataAccessException;
	
	public List<Computadora> findAllComputadora() throws DataAccessException;
	
	public Estudiante findOne(Integer codigo) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer CodigoEstudiante) throws DataAccessException;
	
}
