package com.jcore.repository;

import com.jcore.model.entity.GaUser;

public interface Ga_Int_User extends JpaRepository<GaUser>{
	GaUser buscaPorLLaveTabla(String p_cod_usr) throws Exception;
}
