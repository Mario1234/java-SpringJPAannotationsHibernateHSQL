package usuario.bo;

import usuario.modelo.Usuario;

public interface UsuarioBo {
	
	void guarda(Usuario usuario);
	
	void actualiza(Usuario usuario);
	
	void elimina(Usuario usuario);

}
