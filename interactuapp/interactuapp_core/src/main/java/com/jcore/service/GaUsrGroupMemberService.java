package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.repository.GaUsrGroupMemberRepository;
import com.jcore.service_interface.GaUsrGroupMemberCrudService;

@Named
public class GaUsrGroupMemberService implements GaUsrGroupMemberCrudService, Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private GaUsrGroupMemberRepository gaUsrGroupMemberRepository;
	
	@Transactional
	@Override
	public void insert(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.insert(t);
	}
	@Transactional
	@Override
	public void update(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.update(t);
	}
	@Transactional
	@Override
	public void delete(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.delete(t);
	}

	@Override
	public GaUsrGroupMember findById(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaUsrGroupMember> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrGroupMemberRepository.findAll();
	}
	@Override
	public GaUsrGroupMember buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrGroupMemberRepository.buscaPorUsr(p_cod_usr);
	}
	@Override
	public GaUsrGroupMember buscaPorDoc(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrGroupMemberRepository.buscaPorDoc(p_cod_usr);
	}
	

}
