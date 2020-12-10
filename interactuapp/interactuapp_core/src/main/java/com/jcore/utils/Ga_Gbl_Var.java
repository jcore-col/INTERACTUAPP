package com.jcore.utils;

import java.sql.Date;

import javax.faces.context.FacesContext;

public class Ga_Gbl_Var {
	
	public static Date getFecActual()
	{
		return  new java.sql.Date(new java.util.Date().getTime());
	}
	
	public static void asigna (String p_cod_global, Object p_val_global )
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(p_cod_global, p_val_global);
		
	}
	
	
	public static String devuelve_c (String p_cod_global)
	{
		return (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(p_cod_global);
	}
	
	public static int devuelve_n (String p_cod_global)
	{
		return (int)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(p_cod_global);
	}
	
	public static Date devuelve_f (String p_cod_global )
	{
		return (Date)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(p_cod_global);
	}
	
	public static void limpiar_globales_session()
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
	}
}
