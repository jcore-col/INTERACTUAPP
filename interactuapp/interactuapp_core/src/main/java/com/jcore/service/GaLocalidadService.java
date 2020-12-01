package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaLocalidad;
import com.jcore.repository.GaLocalidadRepository;
import com.jcore.service_interface.GaLocalidadCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaLocalidadService implements GaLocalidadCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaLocalidadRepository gaLocalidadRepository;

	@Transactional
	@Override
	public void insert(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GaLocalidad findById(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaLocalidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaLocalidad> devLocalidadesPorCiudad(String cod_pais, String cod_ciudad) throws Exception {
		// TODO Auto-generated method stub
		return this.gaLocalidadRepository.devLocalidadesPorCiudad(cod_pais, cod_ciudad);
	}
	
	
	
	
	

	
	
	
	
}
