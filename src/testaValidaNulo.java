import modelo.Usuario;
import validador.ValidadorNulo;

public class testaValidaNulo {

	public static void main(String args[]) {
		Usuario u = new Usuario();
		u.ativo = true;
		u.email = "allan@hotmail";
		u.papel = "escravo";
		u.senha = null;
		u.login = "allan";
		ValidadorNulo validador = new ValidadorNulo();
		validador.getAtributosNulos(u);
	}
}
