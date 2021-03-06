package com.jcore.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.jcore.utils.Ga_Gbl_Var;
import com.jcore.utils.GlobalSession;
import com.jcore.utils.Message;
import com.jcore.utils.Pair;

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
	
	public class VistaTercero implements Serializable
	{
		private static final long serialVersionUID = 1L;
		public Pair<CtGeneralTercero,String> tercero;
		public VistaTercero(CtGeneralTercero tercero,String usuarioReg)
		{
			this.tercero = new Pair<CtGeneralTercero,String>(tercero,usuarioReg);
		}
		public VistaTercero()
		{
			this.tercero = new Pair<CtGeneralTercero,String>(new CtGeneralTercero(),new String());
		}
		public Pair<CtGeneralTercero, String> getTercero() {
			return tercero;
		}

		public void setTercero(Pair<CtGeneralTercero, String> tercero) {
			this.tercero = tercero;
		}
		
	}
	List<VistaTercero> vistaTerceros;
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

		List<CtGeneralTercero> auxTerceros;
		this.vistaTerceros = new ArrayList<VistaTercero>();
		try 
		{
			if (this.g_rol_usr.equals("ADMIN"))
			{
				this.ctGeneralTerceros = this.ctGeneralTerceroCrudService.devuelvePersonasPorCia(this.g_cod_compania,this.g_cod_campaing);

			}
			else if (this.g_rol_usr.equals("LIDER"))
			{
				this.ctGeneralTerceros = this.ctGeneralTerceroCrudService.devuelvePersonasPorUsr(this.g_cod_compania,this.g_cod_campaing, this.g_cod_usr);
			}
			
			
			CtLogPersonRegistry auxLogPersonRegistry;
			for (CtGeneralTercero tercero : this.ctGeneralTerceros)
			{
				try
				{
					auxLogPersonRegistry = this.ctLogPersonRegistryCrudService.buscarPorCodDocum(this.g_cod_compania, this.g_cod_campaing, tercero.getId().getTipDocum(), tercero.getId().getCodDocum());
				}
				catch(Exception e)
				{
					auxLogPersonRegistry = null;
				}
				
				if (auxLogPersonRegistry != null)
				{
					VistaTercero auxVista = new VistaTercero(tercero,auxLogPersonRegistry.getId().getCodUsr());
					this.vistaTerceros.add(auxVista);
				}
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
			
			this.ctGeneralTercero.getId().setFecValidez(Ga_Gbl_Var.getFecActual());
			
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
			this.ctGeneralTercero.setMcaInh(Ga.NOT);
			this.ctGeneralTercero.getId().setCodActTercero(1);
			this.ctGeneralTercero.getId().setCodCompania(this.g_cod_compania);
			
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
					
					if (auxLogPersonRegistry == null )// solo se inserta en el primer usuario que ingreso esa cedula.
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
				if (this.g_rol_usr.equals("ADMIN"))//SI ES ADMIN PERMITE MODIFICAR CUALQUIER TERCERO
				{
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
				else
				{
					//SOLO DEBE PERMITIR MODIFICAR LOS QUE EL LIDER HAYA CREADO NINGUNO OTRO
					CtLogPersonRegistry auxPersonRegistry;
					try
					{
						auxPersonRegistry = this.ctLogPersonRegistryCrudService.buscarPersonaPorUsr(this.g_cod_compania, this.g_cod_campaing, 
																									auxGeneralTercero.getId().getTipDocum(), 
																									auxGeneralTercero.getId().getCodDocum(), this.g_cod_usr);
					}
					catch(Exception e)
					{
						auxPersonRegistry = null;
					}
					
					if (auxPersonRegistry != null)
					{
						//esta persona si la registro este usuario... debe permitir ponerla vigente de nuevo o modificarla
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
					else
					{
						// no debe permitir cambiar nada con esta cedula
						Message.registra_Info("PERSONA REGISTRADA POR OTRO LIDER NO PUEDES HACER CAMBIOS");
					}
					
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
		try
		{
			VistaTercero auxVistaTercero = new VistaTercero();
			auxVistaTercero = (VistaTercero)e.getObject();
			this.ctGeneralTerceroSele = auxVistaTercero.tercero.getFirst();
		}
	    catch(Exception error)
		{
	    	Message.registra_Error(error.getMessage());
		}
		
		
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
	public List<VistaTercero> getVistaTerceros() {
		return vistaTerceros;
	}
	public void setVistaTerceros(List<VistaTercero> vistaTerceros) {
		this.vistaTerceros = vistaTerceros;
	}
	
}
