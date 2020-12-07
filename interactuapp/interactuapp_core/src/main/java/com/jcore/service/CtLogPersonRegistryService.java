package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.CtLogPersonRegistry;
import com.jcore.repository.CtLogPersonRegistryRepository;
import com.jcore.service_interface.CtLogPersonRegistryCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class CtLogPersonRegistryService implements CtLogPersonRegistryCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CtLogPersonRegistryRepository ctLogPersonRegistryRepository;

	@Transactional
	@Override
	public void insert(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctLogPersonRegistryRepository.insert(t);
	}

	@Transactional
	@Override
	public void update(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctLogPersonRegistryRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctLogPersonRegistryRepository.delete(t);
	}

	@Override
	public CtLogPersonRegistry findById(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CtLogPersonRegistry> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CtLogPersonRegistry buscarPorCodDocum(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum) throws Exception {
		// TODO Auto-generated method stub
		return this.ctLogPersonRegistryRepository.buscarPorCodDocum(p_cod_compania, p_cod_campaign, p_tip_docum, p_cod_docum);
	}
	
	
	
	
}
