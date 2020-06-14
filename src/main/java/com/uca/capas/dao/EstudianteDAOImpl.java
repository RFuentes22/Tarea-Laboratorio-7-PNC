package com.uca.capas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Computadora;
import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	
	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;

	@Override
	public List<Estudiante> findAllEstudiante() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> res = query.getResultList();
		
		return res;
	}

	@Override
	public List<Computadora> findAllComputadora() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.computadora");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Computadora> res = query.getResultList();
		
		return res;
	}
	
	public Estudiante findOne(Integer code) throws DataAccessException {
		
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		
		return estudiante;
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(estudiante.getCodigoEstudiante()==null) {
				entityManager.persist(estudiante);
			}
			else {
				entityManager.merge(estudiante);
				entityManager.flush();
				
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer CodigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = entityManager.find(Estudiante.class, CodigoEstudiante);
		entityManager.remove(estudiante);
	}

	
	
}
