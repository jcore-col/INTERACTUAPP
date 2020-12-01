package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.repository.CtGeneralTerceroRepository;
import com.jcore.service_interface.CtGeneralTerceroCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class CtGeneralTerceroService implements CtGeneralTerceroCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CtGeneralTerceroRepository ctGeneralTerceroRepository;
	
	@Transactional
	@Override
	public void insert(CtGeneralTercero t) throws Exception {
		// TODO Auto-generated method stub
		this.ctGeneralTerceroRepository.insert(t);
		
	}
	
	@Transactional
	@Override
	public void update(CtGeneralTercero t) throws Exception {
		// TODO Auto-generated method stub
		this.ctGeneralTerceroRepository.update(t);
		
	}

	@Transactional
	@Override
	public void delete(CtGeneralTercero t) throws Exception {
		// TODO Auto-generated method stub
		
		this.ctGeneralTerceroRepository.delete(t);
	}

	@Override
	public CtGeneralTercero findById(CtGeneralTercero t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania, String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.ctGeneralTerceroRepository.devuelvePersonasPorUsr(p_cod_compania, p_cod_usr);
	}

	@Override
	public List<CtGeneralTercero> devuelvePersonasPorCia(int p_cod_compania) throws Exception {
		// TODO Auto-generated method stub
		return this.ctGeneralTerceroRepository.devuelvePersonasPorCia(p_cod_compania);
	}

	@Override
	public CtGeneralTercero devuelvePersonaPorDocum(int p_cod_compania, String p_tip_docum, String p_cod_docum)
			throws Exception {
		// TODO Auto-generated method stub
		return this.ctGeneralTerceroRepository.devuelvePersonaPorDocum(p_cod_compania, p_tip_docum, p_cod_docum);
	}

	@Override
	public List<CtGeneralTercero> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
