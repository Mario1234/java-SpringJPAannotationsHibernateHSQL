package usuario.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import usuario.dao.UsuarioDao;
import usuario.modelo.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
	
	@PersistenceContext
	private EntityManager administradorEntidades;
	
	public void guarda(Usuario usuario){
		administradorEntidades.persist(usuario);
	}
	
	public void actualiza(Usuario usuario){
		administradorEntidades.merge(usuario);
	}
	
	public void elimina(Usuario usuario){
		administradorEntidades.remove(administradorEntidades.contains(usuario) ? usuario : administradorEntidades.merge(usuario));
//		em.remove(usuario);
	}

}