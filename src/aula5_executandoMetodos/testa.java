package aula5_executandoMetodos;

import java.lang.reflect.InvocationTargetException;

import aula5_executandoMetodos.Usuario;

public class testa {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Usuario u = new Usuario();
		u.setEmail("email");
		u.setLogin("allan");
		u.setSenha("2123456846486");
		boolean valido = Validador.validarObjeto(u);
		if(valido) {
			System.out.println("valido");
		}else {
			System.out.println("invalido");
		}
	
	}

}
