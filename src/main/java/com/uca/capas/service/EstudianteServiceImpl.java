package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.EstudianteDTO.EstudianteDTO;
import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Computadora;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteRepository estudianteRepo;

	// @Autowired
	// EstudianteDAO estudianteDAO;

	@Override
	public List<Estudiante> showAllStudents() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.mostrarTodosEstudiantes();
	}

	@Override
	public List<Estudiante> findAllEstudiante() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
	}

	@Override
	public List<Estudiante> findByName(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.mostrarPorNombre(cadena);
	}

	@Override
	public List<EstudianteDTO> showNamLastDTO() throws DataAccessException {
		List<EstudianteDTO> estudiantes = estudianteRepo.mostrarSoloNombApelPruebaDTO().stream().map(obj -> {
			EstudianteDTO e = new EstudianteDTO();
			e.setNombre(obj[0].toString());
			e.setApellido(obj[1].toString());
			return e;
		}).collect(Collectors.toList());
		
		return estudiantes;
	}

	/*
	 * @Override public List<Computadora> findAllComputadora() throws
	 * DataAccessException { // TODO Auto-generated method stub return null; }
	 */

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(codigo);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);

	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteRepo.deleteById(codigoEstudiante);

	}

	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		// return null;
		return estudianteRepo.findByNombre(cadena);

	}

	@Override
	public List<Estudiante> lastnameStartingWith(String cadena) throws DataAccessException {
		// return null;
		return estudianteRepo.findByApellidoStartingWith(cadena);

	}

}
