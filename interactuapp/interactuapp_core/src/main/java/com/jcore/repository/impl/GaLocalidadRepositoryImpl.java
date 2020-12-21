package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.repository.GaLocalidadRepository;

public class GaLocalidadRepositoryImpl implements GaLocalidadRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	
	@Override
	public List<GaLocalidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaLocalidad a",GaLocalidad.class).getResultList();
	}


	@Override
	public void insert(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public GaLocalidad findById(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		return em.find(GaLocalidad.class, t.getId());
	}


	@Override
	public List<GaLocalidad> devLocalidadesPorCiudad(String cod_pais, String cod_ciudad) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaLocalidad a "
				+ "WHERE a.id.codPais = ?1 and a.id.codCiudad = ?2",GaLocalidad.class)
				.setParameter(1, cod_pais)
				.setParameter(2, cod_ciudad).getResultList();
	}

	

}
