package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaProfesion;
import com.jcore.repository.GaProfesionRepository;
import com.jcore.service_interface.GaProfesionCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaProfesionService implements GaProfesionCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaProfesionRepository gaProfesionRepository;

	@Transactional
	@Override
	public void insert(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public GaProfesion findById(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaProfesion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaProfesionRepository.findAll();
	}

	
	
	
	
}
