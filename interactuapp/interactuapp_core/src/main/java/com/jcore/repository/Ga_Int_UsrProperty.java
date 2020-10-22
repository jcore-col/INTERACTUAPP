package com.jcore.repository;

import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;

public interface Ga_Int_UsrProperty extends JpaRepository<GaUsrProperty>{
	GaUsrProperty buscaPorLLaveTabla(String p_cod_usr) throws Exception;
}
