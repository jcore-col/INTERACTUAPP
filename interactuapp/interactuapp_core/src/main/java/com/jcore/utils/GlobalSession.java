package com.jcore.utils;

import java.sql.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GlobalSession {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}
	
	public static void asignaGlobal(String p_cod_object, Object p_val_object)
	{
		getSession().setAttribute(p_cod_object, p_val_object);
	}

	public static String devuelveGlobalS(String p_cod_object) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute(p_cod_object).toString();
	}
	
	public static int devuelveGlobalN(String p_cod_object) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return Integer.parseInt(session.getAttribute(p_cod_object).toString());
	}
	
	public static Date devuelveGlobalF(String p_cod_object) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return Date.valueOf(session.getAttribute(p_cod_object).toString());
	}

}

