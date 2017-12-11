package comun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import comun.config.ConfiguracionAplicacion;
import usuario.bo.UsuarioBo;
import usuario.modelo.Usuario;

public class Principal 
{	
    public static void main( String[] argumentos )
    {
    	AnnotationConfigApplicationContext contexto = 
                new AnnotationConfigApplicationContext(ConfiguracionAplicacion.class);

		UsuarioBo usuBo = contexto.getBean(UsuarioBo.class);
		/** insert **/
		Usuario usuario = new Usuario();
		usuario.setUsuarioNombre("Alfred");
		usuario.setUsuarioApellido("Hitch");
		usuBo.guarda(usuario);
		
		/** select **/
		//Usuario usuario2 = usuBo.encuentraUsuarioPorId(0);
		//System.out.println(usuario2);
		
		/** update **/
		usuario.setUsuarioNombre("Paco");
		usuBo.actualiza(usuario);
		
		/** delete **/
		usuBo.elimina(usuario);
		
		System.out.println("Hecho");
		contexto.close();
    }

	

	
}
