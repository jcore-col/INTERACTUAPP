package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaUser;
import com.jcore.repository.GaUserRepository;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.utils.Ga_Gbl_Var;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaUserService implements GaUserCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaUserRepository gaUserRepository;
	
	@Transactional
	@Override
	public void insert(GaUser t) throws Exception {
		// TODO Auto-generated method stub
		t.setFecActu(Ga_Gbl_Var.getFecActual());
		this.gaUserRepository.insert(t);
		
	}
	
	@Transactional
	@Override
	public void update(GaUser t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUserRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(GaUser t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUserRepository.delete(t);
	}

	@Override
	public GaUser findById(GaUser t) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUserRepository.findById(t);
	}

	@Override
	public List<GaUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaUserRepository.findAll();
	}

	@Override
	public GaUser buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUserRepository.buscaPorUsr(p_cod_usr);
	}
	
	
}
