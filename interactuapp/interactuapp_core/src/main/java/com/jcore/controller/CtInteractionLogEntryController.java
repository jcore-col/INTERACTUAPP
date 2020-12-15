package com.jcore.controller;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtInteractionLogEntry;
import com.jcore.model.entity.GaCiudad;
import com.jcore.model.entity.GaEstado;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.service_interface.CtCampaignEntryCrudService;
import com.jcore.service_interface.CtInteractionLogEntryCrudService;
import com.jcore.service_interface.GaCiudadCrudService;
import com.jcore.service_interface.GaEstadoCrudService;
import com.jcore.service_interface.GaLocalidadCrudService;
import com.jcore.utils.Ga_Gbl_Var;
import com.jcore.utils.GlobalSession;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class CtInteractionLogEntryController implements Serializable {

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
	private CtInteractionLogEntryCrudService ctInteractionLogEntryCrudService;
	private CtInteractionLogEntry ctInteractionLogEntry;
	private List<CtInteractionLogEntry> ctInteractionLogEntrys;
	@Inject
	private CtCampaignEntryCrudService ctCampaignEntryCrudService;
	private CtCampaignEntry ctCampaignEntry;
	private List<CtCampaignEntry> ctCampaignEntrys;
	private CtInteractionLogEntry ctInteractionLogEntrySele;
	
	
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
			this.ctInteractionLogEntrys = this.ctInteractionLogEntryCrudService.devPersonasReunion(this.g_cod_compania, this.g_cod_campaing,this.ctInteractionLogEntry.getId().getNumSecuEntryDay(),(Date) this.ctInteractionLogEntry.getFecEntry());

		} catch (Exception e) {
			Message.registra_Error(e.getMessage());
		}

	}

	public void resetForm() {
		this.ctInteractionLogEntry = new CtInteractionLogEntry();
		this.ctInteractionLogEntrySele = null;
		this.editandoReg = false;
	}

	@PostConstruct
	public void init() {

		this.ctInteractionLogEntry = new CtInteractionLogEntry();
		this.ctCampaignEntry       = new CtCampaignEntry();
		this.ctInteractionLogEntrySele = new CtInteractionLogEntry();
		this.editandoReg = false;
		this.recupera_globales_usr();
		
		
		this.loadCampaignEntrys();
	}

	public void selectCtInteractionLogEntry(SelectEvent e) {
		this.ctInteractionLogEntrySele = (CtInteractionLogEntry) e.getObject();

	}

	public void saveInteractionLogEntry() {
		
		try 
		{
			this.ctInteractionLogEntry.setCodUsr(this.g_cod_usr);
			this.ctInteractionLogEntry.setFecActu(Ga_Gbl_Var.getFecActual());
			this.ctInteractionLogEntry.setCodUsrReg(this.g_cod_usr);
			this.ctInteractionLogEntry.setFecEntry(Ga_Gbl_Var.getFecActual());
			this.ctInteractionLogEntry.setCodUsrReg(this.g_cod_usr);
			this.ctInteractionLogEntry.getId().setCodCampaign(this.g_cod_campaing);
			this.ctInteractionLogEntry.getId().setCodCompania(this.g_cod_compania);
			try
			{
				this.ctInteractionLogEntryCrudService.insert(this.ctInteractionLogEntry);
				Message.registra_Info("Persona "+this.ctInteractionLogEntry.getId().getCodDocum()+" regitrada ");
			}
			catch(Exception e)
			{
				this.ctInteractionLogEntryCrudService.update(this.ctInteractionLogEntry);
				Message.registra_Info("Registro Persona "+this.ctInteractionLogEntry.getId().getCodDocum()+" actualizado");
			}


		} catch (Exception e) {
			Message.registra_Error(e.getMessage() + " stackTrace" + e.getStackTrace());
		}
	}

	public void editInteractionLogEntry() {

		try {
			if (this.ctInteractionLogEntrySele != null) {
				
				this.ctInteractionLogEntry = this.ctInteractionLogEntrySele;
				this.editandoReg = true;
			} else {
				Message.registra_Error("Porfavor seleccione un registro");
			}
		} catch (Exception e) {
			Message.registra_Error("al actualizar el registro " + e.getMessage());
		}

	}

	public void deleteInteractionLogEntry() {

		try 
		{
			if (this.ctInteractionLogEntrySele != null) {
				
				this.ctInteractionLogEntry = this.ctInteractionLogEntrySele;
				
				
				try
				{
					this.ctInteractionLogEntryCrudService.delete(this.ctInteractionLogEntry);
					Message.registra_Info("Registro de asistencia eliminado");
				}
				catch(Exception e)
				{
					Message.registra_Error(e.getStackTrace().toString());
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


	public boolean isEditandoReg() {
		return editandoReg;
	}

	public CtInteractionLogEntry getCtInteractionLogEntry() {
		
		return ctInteractionLogEntry;
		
		
	}

	public void setCtInteractionLogEntry(CtInteractionLogEntry ctInteractionLogEntry) {
		this.ctInteractionLogEntry = ctInteractionLogEntry;
	}

	public CtInteractionLogEntry getCtInteractionLogEntrySele() {
		return ctInteractionLogEntrySele;
	}

	public void setCtInteractionLogEntrySele(CtInteractionLogEntry ctInteractionLogEntrySele) {
		this.ctInteractionLogEntrySele = ctInteractionLogEntrySele;
	}

	public List<CtInteractionLogEntry> getCtInteractionLogEntrys() {
		return ctInteractionLogEntrys;
	}

	public void setCtInteractionLogEntrys(List<CtInteractionLogEntry> ctInteractionLogEntrys) {
		this.ctInteractionLogEntrys = ctInteractionLogEntrys;
	}

	public CtCampaignEntry getCtCampaignEntry() {
		return ctCampaignEntry;
	}

	public void setCtCampaignEntry(CtCampaignEntry ctCampaignEntry) {
		this.ctCampaignEntry = ctCampaignEntry;
	}

	public List<CtCampaignEntry> getCtCampaignEntrys() {
		return ctCampaignEntrys;
	}

	public void setCtCampaignEntrys(List<CtCampaignEntry> ctCampaignEntrys) {
		this.ctCampaignEntrys = ctCampaignEntrys;
	}

	public void onFecEntryChange() {

		try {
			this.ctCampaignEntrys = this.ctInteractionLogEntryCrudService.devReunionesPorFecha(this.g_cod_compania, this.g_cod_campaing, (Date)this.ctInteractionLogEntry.getFecEntry());

		} catch (Exception e) {
			this.ctCampaignEntrys = null;
		}

	}
	
	public void onReunionSelected()
	{
		try 
		{
			this.ctInteractionLogEntrys = this.ctInteractionLogEntryCrudService.devPersonasReunion(this.g_cod_compania, 
																								   this.g_cod_campaing, 
																								   this.ctInteractionLogEntry.getId().getNumSecuEntryDay(), 
																								   (Date)this.ctInteractionLogEntry.getFecEntry());

		} catch (Exception e) {
			this.ctInteractionLogEntrys = null;
				
		}
		try
		{
			this.ctCampaignEntry.getId().setCodCompania(this.g_cod_compania);
			this.ctCampaignEntry.getId().setCodCampaign(this.g_cod_campaing);
			this.ctCampaignEntry.getId().setNumSecuEntryDay(this.ctInteractionLogEntry.getId().getNumSecuEntryDay());
			this.ctCampaignEntry = this.ctCampaignEntryCrudService.findById(this.ctCampaignEntry);
		}
		catch(Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
	}

	public List<GaEstado> getGaEstados() {
		return gaEstados;
	}

	public void setGaEstados(List<GaEstado> gaEstados) {
		this.gaEstados = gaEstados;
	}

	public List<GaCiudad> getGaCiudades() {
		return gaCiudades;
	}

	public void setGaCiudades(List<GaCiudad> gaCiudades) {
		this.gaCiudades = gaCiudades;
	}

	public List<GaLocalidad> getGaLocalidades() {
		return gaLocalidades;
	}

	public void setGaLocalidades(List<GaLocalidad> gaLocalidades) {
		this.gaLocalidades = gaLocalidades;
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
}
