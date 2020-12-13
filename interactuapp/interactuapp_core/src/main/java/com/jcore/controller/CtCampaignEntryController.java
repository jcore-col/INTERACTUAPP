package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.GaCiudad;
import com.jcore.model.entity.GaEstado;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.service_interface.CtCampaignEntryCrudService;
import com.jcore.service_interface.GaCiudadCrudService;
import com.jcore.service_interface.GaEstadoCrudService;
import com.jcore.service_interface.GaLocalidadCrudService;
import com.jcore.utils.Ga_Gbl_Var;
import com.jcore.utils.GlobalSession;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class CtCampaignEntryController implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private CtCampaignEntryCrudService ctCampaignEntryCrudService;
	private CtCampaignEntry ctCampaignEntry;
	private CtCampaignEntry ctCampaignEntrySele;
	private List<CtCampaignEntry> ctCampaignEntrys;

	private String g_cod_usr;
	private int g_cod_compania;
	private int g_cod_campaing;
	private String g_rol_usr;
	String lista = "";
	private boolean editandoReg;

	public void recupera_globales_usr() {

		this.g_cod_usr = GlobalSession.devuelveGlobalS("cod_usr");
		this.g_cod_compania = GlobalSession.devuelveGlobalN("cod_compania");
		this.g_cod_campaing = GlobalSession.devuelveGlobalN("cod_campaing");
		this.g_rol_usr = GlobalSession.devuelveGlobalS("rol_usr");

	}

	public void verGlobales() {
		Message.registra_Info("this.g_cod_usr:" + this.g_cod_usr);
		Message.registra_Info("this.g_cod_compania:" + this.g_cod_compania);
		Message.registra_Info("this.g_cod_campaing:" + this.g_cod_campaing);
		Message.registra_Info("this.g_rol_usr:" + this.g_rol_usr);
		this.loadCampaignEntrys();
		Message.registra_Info("this.lista:" + this.lista);

	}

	public void loadCampaignEntrys() {
		try 
		{
			this.ctCampaignEntrys = this.ctCampaignEntryCrudService.devCampaignsEntry(this.g_cod_compania, this.g_cod_campaing);

		} catch (Exception e) {
			Message.registra_Error(e.getMessage());
		}

	}

	public void resetForm() {
		this.ctCampaignEntry = new CtCampaignEntry();
		this.ctCampaignEntry.setCodPais("CO");
		this.ctCampaignEntrySele = null;
		this.editandoReg = false;
	}

	@PostConstruct
	public void init() {

		this.ctCampaignEntry = new CtCampaignEntry();
		
		this.ctCampaignEntry.setCodPais("CO");
		this.ctCampaignEntrySele = new CtCampaignEntry();
		this.editandoReg = false;
		this.recupera_globales_usr();
		
		
		this.loadCampaignEntrys();
	}

	public void selectCtCampaignEntry(SelectEvent e) {
		this.ctCampaignEntrySele = (CtCampaignEntry) e.getObject();

	}

	public void saveCampaignEntry() {
		boolean ocurrioException = false;
		try 
		{
			this.ctCampaignEntry.setCodUsr(this.g_cod_usr);
			this.ctCampaignEntry.setFecActu(Ga_Gbl_Var.getFecActual());
			
			//
			if (this.editandoReg) {
				
				// si estamos en edicion tenemos que recuperar el registro original para obtener
				// todos los datos no modifibles
				CtCampaignEntry auxCampaignEntry;
						
				try
				{
					this.ctCampaignEntry.getId().setCodCompania(this.g_cod_compania);
					this.ctCampaignEntry.getId().setCodCompania(this.g_cod_campaing);
					
					auxCampaignEntry = this.ctCampaignEntryCrudService.findById(this.ctCampaignEntry);
					
				}
				catch(Exception e)
				{					
					auxCampaignEntry = null;
				}
				
				if (auxCampaignEntry != null)
				{
				
					if (auxCampaignEntry.getTipSituacion().equals(Ga.ESTADO_TERMINADA)
						||auxCampaignEntry.getTipSituacion().equals(Ga.ESTADO_CANCELADA))
					{
						Message.registra_Info("No puede modificar una reunion terminada o cancelada");
					}
					else
					{
						try 
						{
							this.ctCampaignEntryCrudService.update(this.ctCampaignEntry);
							Message.registra_Info("Reunion "+this.ctCampaignEntry.getId().getNumSecuEntryDay()+" Actualizada");
						}
						
						catch (Exception e) 
						{
							ocurrioException = true;
							Message.registra_Error(e.getMessage() + " stackTrace" + e.getStackTrace());
						}
					}
						
				}
				
				
			} 
			else 
			{
				this.ctCampaignEntry.setMcaInh(Ga.NOT);
				//
				int secuenciaReuniones = 0;
				try
				{
					secuenciaReuniones =this.ctCampaignEntryCrudService.next_secu_entry_day(this.g_cod_compania, this.g_cod_campaing);
					secuenciaReuniones++;
					
				}
				catch(Exception e)
				{
					secuenciaReuniones++;
				}
				
				this.ctCampaignEntry.getId().setNumSecuEntryDay(secuenciaReuniones);
				this.ctCampaignEntry.getId().setCodCampaign(this.g_cod_campaing);
				this.ctCampaignEntry.getId().setCodCompania(this.g_cod_compania);
				this.ctCampaignEntry.setCreateBy(this.g_cod_usr);// el usuario que crea la reunion
				
				try
				{
					this.ctCampaignEntryCrudService.insert(this.ctCampaignEntry);
					Message.registra_Info("Reunion "+this.ctCampaignEntry.getId().getNumSecuEntryDay()+" Creada");
				}
				catch(Exception e)
				{
					ocurrioException = true;
					Message.registra_Error(e.getMessage() + " stackTrace" + e.getStackTrace());
				}
				

			}

			if (!ocurrioException)
			{
				
				this.loadCampaignEntrys();				
				this.resetForm();
				
			}
			

		} catch (Exception e) {
			Message.registra_Error(e.getMessage() + " stackTrace" + e.getStackTrace());
		}
	}

	public void editCampaignEntry() {

		try {
			if (this.ctCampaignEntrySele != null) {
				
				this.ctCampaignEntry = this.ctCampaignEntrySele;
				this.editandoReg = true;
			} else {
				Message.registra_Error("Porfavor seleccione un registro");
			}
		} catch (Exception e) {
			Message.registra_Error("al actualizar el registro " + e.getMessage());
		}

	}

	public void deleteCampaignEntry() {

		try 
		{
			if (this.ctCampaignEntrySele != null) {
				
				this.ctCampaignEntry = this.ctCampaignEntrySele;
				
				if ( this.ctCampaignEntry.getTipSituacion().equals(Ga.ESTADO_CREADA))
				{
					try
					{
						this.ctCampaignEntryCrudService.delete(this.ctCampaignEntry);
						Message.registra_Info("REUNION "+this.ctCampaignEntry.getId().getNumSecuEntryDay() +"ELIMINADA");
					}
					catch(Exception e)
					{
						Message.registra_Error(e.getStackTrace().toString());
					}
				}
				else
				{
					Message.registra_Info("No puede eliminar una reunion que ya ha sido iniciada debe cancelarla.");
				}
				
				this.loadCampaignEntrys();
				this.resetForm();
				
			} 
			else {
				Message.registra_Error("Porfavor seleccione un registro");
			}
			
		} 
		catch (Exception e) 
		{
			Message.registra_Error("al borrar el registro " + e.getMessage());
		}

	}

	public List<GaEstado> getGaEstados() {
		try {
			this.gaEstados = this.gaEstadoCrudService.devEstadosPorPais("CO");
		} catch (Exception e) {
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

		try {
			this.gaCiudades = this.gaCiudadCrudService.devCiudadPorPaisYEstado(this.ctCampaignEntry.getCodPais(),
					this.ctCampaignEntry.getCodEstado());
		} catch (Exception e) {
			this.gaCiudades = null;
		}

	}

	public void onCodProvChange() {

		try {
			this.gaLocalidades = this.gaLocalidadCrudService.devLocalidadesPorCiudad(this.ctCampaignEntry.getCodPais(),
					this.ctCampaignEntry.getCodProv());
		} catch (Exception e) {
			this.gaLocalidades = null;
			Message.registra_Error("Porfavor seleccione un departamento");
		}

	}

	public boolean isEditandoReg() {
		return editandoReg;
	}

	public CtCampaignEntry getCtCampaignEntry() {
		
		return ctCampaignEntry;
		
		
	}

	public void setCtCampaignEntry(CtCampaignEntry ctCampaignEntry) {
		this.ctCampaignEntry = ctCampaignEntry;
	}

	public CtCampaignEntry getCtCampaignEntrySele() {
		return ctCampaignEntrySele;
	}

	public void setCtCampaignEntrySele(CtCampaignEntry ctCampaignEntrySele) {
		this.ctCampaignEntrySele = ctCampaignEntrySele;
	}

	public List<CtCampaignEntry> getCtCampaignEntrys() {
		return ctCampaignEntrys;
	}

	public void setCtCampaignEntrys(List<CtCampaignEntry> ctCampaignEntrys) {
		this.ctCampaignEntrys = ctCampaignEntrys;
	}

	
}
