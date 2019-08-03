/**
 * 
 */
package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.repositories.UsuarioRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class UsuarioService {

	@Inject
	private UsuarioRepository dao;
	
	public List<Usuario> listaUsuario(){
		return this.dao.listaUsuarios();
	}
	
	public boolean getUsuarioByEmail(String email) {
		if(this.dao.buscarUsuarioPorEmail(email)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void salvarUsuario(Usuario usuario) {
		this.dao.salvarUsuario(usuario);
	}
	
	public void deletarUsuario(Long id) throws Exception {
		this.dao.deleteById(id);
	}
}
