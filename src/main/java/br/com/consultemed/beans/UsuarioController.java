/**
 * 
 */
package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */
//@ManagedBean
@Named
@RequestScoped
public class UsuarioController{

	@Getter
	@Setter
	private List<Usuario> usuarios;

	@Inject
	@Getter
	@Setter
	private Usuario usuario;
	
	@Getter
	@Setter
	private Usuario usuarioEditar;
	
	@Inject
	private UsuarioService service;
	
	
	public String editar() {
		this.usuario = this.usuarioEditar;
		return "/pages/usuarios/addUsuarios.xhtml";
	}
	
	public String excluir() throws Exception {
		this.usuario = this.usuarioEditar;
		this.service.deletarUsuario(this.usuario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario removido."));
		 
		  FacesContext.getCurrentInstance()
		      .getExternalContext()
		      .getFlash().setKeepMessages(true);
		return "/pages/usuarios/usuarios.xhtml?faces-redirect=true";
	}
	
	public String novoUsuario() {
		this.usuario = new Usuario();
		return "/pages/usuarios/addUsuarios.xhtml?faces-redirect=true";
	}
	
	public String addUsuario() {
		boolean existe = this.service.getUsuarioByEmail(this.usuario.getEmail());
		
		if(existe) {
			FacesContext.getCurrentInstance().addMessage(
			        null, new FacesMessage("Usuário já existe"));
			 
			  FacesContext.getCurrentInstance()
			      .getExternalContext()
			      .getFlash().setKeepMessages(true);
		} else {
			this.service.salvarUsuario(this.usuario);
			FacesContext.getCurrentInstance().addMessage(
			        null, new FacesMessage("Usuário adicionado com sucesso."));
			 
			  FacesContext.getCurrentInstance()
			      .getExternalContext()
			      .getFlash().setKeepMessages(true);
		}
		  
		return "/pages/usuarios/usuarios.xhtml?faces-redirect=true";
	}
	
	public List<Usuario> listaUsuarios(){
		this.usuarios = this.service.listaUsuario();
		return usuarios;
	}
	
	
}
