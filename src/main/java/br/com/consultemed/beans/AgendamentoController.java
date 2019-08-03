package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Agendamento;
import br.com.consultemed.models.StatusAgendamento;
import br.com.consultemed.services.AgendamentoService;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class AgendamentoController {
	
	@Inject
	private Agendamento agendamento;

	private Agendamento agendamentoEditar;
	
	private List<Agendamento> agendamentos;
	
	@Inject
	private AgendamentoService service;
	
	public String editar() {
		this.agendamento = this.agendamentoEditar;
		return "/pages/agendamentos/addAgendamentos.xhtml";
	}
	
	public String excluir() throws Exception {
		this.agendamento = this.agendamentoEditar;
		this.service.deletarAgendamento(this.agendamento.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/agendamentos/agendamentos.xhtml?faces-redirect=true";
	}
	
	public String novoAgendamento() {
		this.agendamento = new Agendamento();
		return "/pages/agendamentos/addAgendamentos.xhtml?faces-redirect=true";
	}
	
//	public String addAgendamento() {
////		System.out.println("addAgendamento");
////		this.agendamento.setStatus(StatusAgendamento.AGENDADO);
//		this.service.salvarAgendamento(this.agendamento);
//		return "/pages/agendamentos/agendamentos.xhtml?faces-redirect=true";
//	}
	
	public String addAgendamento() {
		this.service.salvarAgendamento(this.agendamento);
		return "/pages/agendamentos/agendamentos.xhtml?faces-redirect=true";
	}
	
	public List<Agendamento> listaAgendamentos(){
		this.agendamentos = this.service.listaAgendamento();
		return agendamentos;
	}
}
