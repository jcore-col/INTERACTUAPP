package com.jcore.repository;

import com.jcore.model.entity.GaUser;

public interface GaUserRepository extends JpaRepository<GaUser>{
	GaUser buscaPorUsr(String p_cod_usr) throws Exception;
}
