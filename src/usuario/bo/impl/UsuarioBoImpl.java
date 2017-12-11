package usuario.bo.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usuario.bo.UsuarioBo;
import usuario.dao.UsuarioDao;
import usuario.modelo.Usuario;


@Service("usuarioBo")
public class UsuarioBoImpl implements UsuarioBo{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Transactional
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Transactional
	public void guarda(Usuario usuario){
		usuarioDao.guarda(usuario);
	}
	
	@Transactional
	public void actualiza(Usuario usuario){
		usuarioDao.actualiza(usuario);
	}
	
	@Transactional(readOnly=true)
	public void elimina(Usuario usuario){
		usuarioDao.elimina(usuario);
	}
}
