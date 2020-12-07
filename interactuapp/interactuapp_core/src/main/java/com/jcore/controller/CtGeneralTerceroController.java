package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.model.entity.CtLogPersonRegistry;
import com.jcore.model.entity.CtLogPersonRegistryPK;
import com.jcore.model.entity.GaCiudad;
import com.jcore.model.entity.GaEstado;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.model.entity.GaProfesion;
import com.jcore.service_interface.CtGeneralTerceroCrudService;
import com.jcore.service_interface.CtLogPersonRegistryCrudService;
import com.jcore.service_interface.GaCiudadCrudService;
import com.jcore.service_interface.GaEstadoCrudService;
import com.jcore.service_interface.GaLocalidadCrudService;
import com.jcore.service_interface.GaProfesionCrudService;
import com.jcore.utils.GlobalSession;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class CtGeneralTerceroController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaProfesionCrudService gaProfesionCrudService;
	private List<GaProfesion> gaProfesiones;
	
	@Inject
	private GaEstadoCrudService gaEstadoCrudService;
	private List<GaEstado> gaEstados;
	
	@Inject
	private GaCiudadCrudService gaCiudadCrudService;
	private List<GaCiudad> gaCiudades;
	
	@Inject
	private GaLocalidadCrudService gaLocalidadCrudService;
	private List<GaLocalidad> gaLocalidades;
	@Inject
	private CtGeneralTerceroCrudService  ctGeneralTerceroCrudService;
	private CtGeneralTercero ctGeneralTercero;
	private CtGeneralTercero ctGeneralTerceroSele;
	private List<CtGeneralTercero> ctGeneralTerceros;
	
	@Inject
	private CtLogPersonRegistryCrudService  ctLogPersonRegistryCrudService;
	private CtLogPersonRegistry ctLogPersonRegistry;
	
	private String g_cod_usr;
	private int g_cod_compania;
	private int g_cod_campaing;
	private String g_rol_usr;
	String lista ="";
	public void recupera_globales_usr()
	{
		
		this.g_cod_usr 		= GlobalSession.devuelveGlobalS("cod_usr");
		this.g_cod_compania = GlobalSession.devuelveGlobalN("cod_compania");
		this.g_cod_campaing = GlobalSession.devuelveGlobalN("cod_campaing");
		this.g_rol_usr 		= GlobalSession.devuelveGlobalS("rol_usr");
		
	}
	public void verGlobales()
	{
		Message.registra_Info("this.g_cod_usr:"+this.g_cod_usr);
		Message.registra_Info("this.g_cod_compania:"+this.g_cod_compania);
		Message.registra_Info("this.g_cod_campaing:"+this.g_cod_campaing);
		Message.registra_Info("this.g_rol_usr:"+this.g_rol_usr);
		this.loadPersonas();
		Message.registra_Info("this.lista:"+this.lista);
		
	}
	
	public void  loadPersonas() {

		try 
		{
			if (this.g_rol_usr.equals("ADMIN"))
			{
				Message.registra_Info("entro a consulta ADMIN");
				this.ctGeneralTerceros = this.ctGeneralTerceroCrudService.devuelvePersonasPorCia(this.g_cod_compania,this.g_cod_campaing);
				Message.registra_Info("Termino a consulta ADMIN");
			}
			else if (this.g_rol_usr.equals("LIDER"))
			{
				this.ctGeneralTerceros = this.ctGeneralTerceroCrudService.devuelvePersonasPorUsr(this.g_cod_compania,this.g_cod_campaing, this.g_cod_usr);
			}
			
			
			
			for (CtGeneralTercero e : this.ctGeneralTerceros)
			{
				Message.registra_Info("entro ciclo");
				this.lista = this.lista + e.getId().getTipDocum() + e.getId().getCodDocum();
			}
			
		}
		catch (Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
			
	}
	
	public void resetForm() {
		this.ctGeneralTercero = new CtGeneralTercero();
		this.ctGeneralTercero.setCodPais("CO");
		this.ctGeneralTerceroSele = null;
	}
	
	@PostConstruct
	public void init() {
		
		this.ctGeneralTercero = new CtGeneralTercero();
		this.ctGeneralTercero.setCodPais("CO");
		this.ctGeneralTerceroSele = new CtGeneralTercero();
		this.ctLogPersonRegistry = new CtLogPersonRegistry();
		this.recupera_globales_usr();
		this.loadPersonas();
	}
	
	public void saveTercero() {
		
		try
		{
			CtLogPersonRegistry auxLogPersonRegistry;
			CtGeneralTercero auxGeneralTercero;
			
			
			
			try
			{
				auxGeneralTercero = this.ctGeneralTerceroCrudService.devuelvePersonaPorDocum(this.g_cod_compania, this.ctGeneralTercero.getId().getTipDocum(), this.ctGeneralTercero.getId().getCodDocum());
			}
			catch (Exception e)
			{
				auxGeneralTercero = null;
			}
			
			this.ctGeneralTercero.setCodUsr(this.g_cod_usr);
			this.ctGeneralTercero.setFecActu(this.ctGeneralTercero.getId().getFecValidez());
			
			if (auxGeneralTercero == null)//ojo qUE PUEDE ESTAR INHABILITADO EL TERCERO
			{
				//tenemos que hacer insert directamente y registrar Log de que usuario creo esta person
				boolean insertoTerceroCorrecto = false;
				boolean updateTerceroInhaCorrecto = false; 
				
				try
				{
					this.ctGeneralTerceroCrudService.insert(this.ctGeneralTercero);
					insertoTerceroCorrecto = true;
				}
				catch(Exception e)
				{
					//si llegara a fallar la insercion por algun motivo no deberiamos intentar registrar el log
					try
					{
						this.ctGeneralTerceroCrudService.update(this.ctGeneralTercero);
						updateTerceroInhaCorrecto = true;
					}
					catch(Exception e1)
					{
						updateTerceroInhaCorrecto = false;
					}
				}
				
				if (insertoTerceroCorrecto || updateTerceroInhaCorrecto )
				{
					//registramos el Log por usuario de sistema
					try 
					{
						auxLogPersonRegistry = this.ctLogPersonRegistryCrudService.buscarPorCodDocum(this.g_cod_compania, this.g_cod_campaing, this.ctGeneralTercero.getId().getTipDocum(), this.ctGeneralTercero.getId().getCodDocum());
					}
					catch(Exception e)
					{
						auxLogPersonRegistry = null;
					}
					
					if ((auxLogPersonRegistry == null) || (updateTerceroInhaCorrecto) )
					{
						auxLogPersonRegistry = new CtLogPersonRegistry();
						auxLogPersonRegistry.setFecActu(this.ctGeneralTercero.getFecActu());
						auxLogPersonRegistry.setFecRegistry(this.ctGeneralTercero.getFecActu());
						
						CtLogPersonRegistryPK idLog = new CtLogPersonRegistryPK();
						idLog.setCodCampaign(this.g_cod_campaing);
						idLog.setCodCompania(this.g_cod_compania);
						idLog.setCodUsr(this.g_cod_usr);
						idLog.setTipDocum(this.ctGeneralTercero.getId().getTipDocum());
						idLog.setCodDocum(this.ctGeneralTercero.getId().getCodDocum());
						auxLogPersonRegistry.setId(idLog);
						
						try
						{
							this.ctLogPersonRegistryCrudService.insert(auxLogPersonRegistry);
						}
						catch(Exception e)
						{
							if (updateTerceroInhaCorrecto)
							{
								this.ctLogPersonRegistryCrudService.update(auxLogPersonRegistry);
							}
						}
						
					}
				}
			}
			else//EXISTE UN TERCERO VIGENTE EN ESTE MOMENTO
			{
				// se hace update de ser nesesario
				try
				{
					//si no falla el insert es porque la fecha de validez del registro es nueva
					
					this.ctGeneralTerceroCrudService.insert(this.ctGeneralTercero);
				}
				catch(Exception e)
				{
					//si llegara a existe ya un registro con la fecha validez de hoy se hace update
					this.ctGeneralTerceroCrudService.update(this.ctGeneralTercero);
				}
			}
		
			
			this.loadPersonas();
			this.resetForm();
		}
		catch(Exception e)
		{
			Message.registra_Error(e.getMessage()+" stackTrace"+e.getStackTrace() );
		}
		
	}
	
	public void selectCtTercero(SelectEvent e) {
		this.ctGeneralTerceroSele = (CtGeneralTercero)e.getObject();
		
	}
	
	public void editTercero() {
		
		try
		{
			if( this.ctGeneralTerceroSele != null)
			{
				this.ctGeneralTercero = this.ctGeneralTerceroSele;
			}
			else
			{
				Message.registra_Error("Porfavor seleccione un registro");
			}
		}
		catch(Exception e)
		{
			Message.registra_Error("al actualizar el registro "+e.getMessage() );
		}
		
	}
	public void deleteTercero() {
		
		try
		{
			if( this.ctGeneralTerceroSele != null)
			{
				Message.registra_Info("usuario a eliminar"+ this.ctGeneralTerceroSele.getCodUsr());
				this.ctGeneralTercero = this.ctGeneralTerceroSele;
				this.ctGeneralTercero.setMcaInh(Ga.YES);// inhabilita el tercero con vigencia 
				this.ctGeneralTerceroCrudService.update(this.ctGeneralTercero);				
				this.loadPersonas();
				this.resetForm();
				Message.registra_Info("PERSONA INHABILITADA");
			}
			else
			{
				Message.registra_Error("Porfavor seleccione un registro");
			}
		}
		catch(Exception e)
		{
			Message.registra_Error("al borrar el registro "+e.getMessage() );
		}
		
	}

	public CtGeneralTercero getCtGeneralTercero() {
		return ctGeneralTercero;
	}

	public void setCtGeneralTercero(CtGeneralTercero ctGeneralTercero) {
		this.ctGeneralTercero = ctGeneralTercero;
	}

	public CtGeneralTercero getCtGeneralTerceroSele() {
		return ctGeneralTerceroSele;
	}

	public void setCtGeneralTerceroSele(CtGeneralTercero ctGeneralTerceroSele) {
		this.ctGeneralTerceroSele = ctGeneralTerceroSele;
	}

	public List<CtGeneralTercero> getCtGeneralTerceros() {
		return ctGeneralTerceros;
	}

	public void setCtGeneralTerceros(List<CtGeneralTercero> ctGeneralTerceros) {
		this.ctGeneralTerceros = ctGeneralTerceros;
	}
	
	public List<GaProfesion> getGaProfesiones() {
		
		try
		{
			this.gaProfesiones = this.gaProfesionCrudService.findAll();
		}
		catch(Exception e)
		{
			this.gaProfesiones = null;
		}
		
		return this.gaProfesiones;
	}
	public List<GaEstado> getGaEstados() {
		try
		{	
			this.gaEstados = this.gaEstadoCrudService.devEstadosPorPais("CO");
		}
		catch(Exception e)
		{
			this.gaEstados = null;
		}
		return gaEstados;
	}
	public List<GaCiudad> getGaCiudades() {
		return gaCiudades;
	}

	public List<GaLocalidad> getGaLocalidades() {
		return gaLocalidades;
	}
	
	public void onCodEstadoChange() {
        
        try
        {
        	this.gaCiudades = this.gaCiudadCrudService.devCiudadPorPaisYEstado(this.ctGeneralTercero.getCodPais(), this.ctGeneralTercero.getCodEstado());
        }
        catch(Exception e)
        {
        	this.gaCiudades = null;
        }
            
    }
	public void onCodProvChange() {
        
        try
        {
        	this.gaLocalidades = this.gaLocalidadCrudService.devLocalidadesPorCiudad(this.ctGeneralTercero.getCodPais(), this.ctGeneralTercero.getCodProv());
        }
        catch(Exception e)
        {
        	this.gaLocalidades = null;
        	Message.registra_Error("Porfavor seleccione un departamento" );
        }
            
    }
}
