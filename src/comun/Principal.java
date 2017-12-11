package comun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import comun.config.ConfiguracionAplicacion;
import usuario.bo.UsuarioBo;
import usuario.modelo.Usuario;

@Component
public class Principal 
{	
	@Autowired UsuarioBo usuarioBo;
	
	private void guarda(Usuario usuario) {
		usuarioBo.guarda(usuario);
	}
	private void actualiza(Usuario usuario) {
		usuarioBo.actualiza(usuario);
	}
	private void elimina(Usuario usuario) {
		usuarioBo.elimina(usuario);
	}
    public static void main( String[] argumentos )
    {
    	AnnotationConfigApplicationContext contexto = 
                new AnnotationConfigApplicationContext(ConfiguracionAplicacion.class);

		Principal princi = contexto.getBean(Principal.class);
		/** insert **/
		Usuario usuario = new Usuario();
		usuario.setUsuarioNombre("Alfred");
		usuario.setUsuarioApellido("Hitch");
		princi.guarda(usuario);
		
		/** select **/
		//Usuario usuario2 = usuBo.encuentraUsuarioPorId(0);
		//System.out.println(usuario2);
		
		/** update **/
		usuario.setUsuarioNombre("Paco");
		princi.actualiza(usuario);
		
		/** delete **/
		princi.elimina(usuario);
		
		System.out.println("Hecho");
		contexto.close();
    }	
}
