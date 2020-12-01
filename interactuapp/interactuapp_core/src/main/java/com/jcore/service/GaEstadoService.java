package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaEstado;
import com.jcore.model.entity.GaProfesion;
import com.jcore.repository.GaEstadoRepository;
import com.jcore.repository.GaProfesionRepository;
import com.jcore.service_interface.GaEstadoCrudService;
import com.jcore.service_interface.GaProfesionCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaEstadoService implements GaEstadoCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaEstadoRepository gaEstadoRepository;

	@Transactional
	@Override
	public void insert(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GaEstado findById(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaEstado> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaEstado> devEstadosPorPais(String p_cod_pais) throws Exception {
		// TODO Auto-generated method stub
		return this.gaEstadoRepository.devEstadosPorPais(p_cod_pais);
	}
	
	

	
	
	
	
}
