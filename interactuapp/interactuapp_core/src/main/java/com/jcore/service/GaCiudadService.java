package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaCiudad;
import com.jcore.repository.GaCiudadRepository;
import com.jcore.service_interface.GaCiudadCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaCiudadService implements GaCiudadCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaCiudadRepository gaCiudadRepository;

	@Transactional
	@Override
	public void insert(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GaCiudad findById(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaCiudad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaCiudad> devCiudadPorPaisYEstado(String p_cod_pais, String p_cod_estado) throws Exception {
		// TODO Auto-generated method stub
		return this.gaCiudadRepository.devCiudadPorPaisYEstado(p_cod_pais, p_cod_estado);
	}

	
	

	
	
	
	
}
