package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaAccessControl;
import com.jcore.repository.GaAccessControlRepository;
import com.jcore.service_interface.GaAccessControlCrudService;

@Named
public class GaAccessControlService implements GaAccessControlCrudService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaAccessControlRepository gaAccessControlRepository;
	
	@Transactional
	@Override
	public void insert(GaAccessControl t) throws Exception {
		// TODO Auto-generated method stub
		this.gaAccessControlRepository.insert(t);
	}
	
	@Transactional
	@Override
	public void update(GaAccessControl t) throws Exception {
		// TODO Auto-generated method stub
		this.gaAccessControlRepository.update(t);
	}
	
	@Transactional
	@Override
	public void delete(GaAccessControl t) throws Exception {
		// TODO Auto-generated method stub
		this.gaAccessControlRepository.delete(t);
	}

	@Override
	public GaAccessControl findById(GaAccessControl t) throws Exception {
		// TODO Auto-generated method stub
		return this.gaAccessControlRepository.findById(t);
	}

	@Override
	public List<GaAccessControl> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaAccessControlRepository.findAll();
	}

	@Override
	public List<GaAccessControl> buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.gaAccessControlRepository.buscaPorUsr(p_cod_usr);
	}
	
	

}
