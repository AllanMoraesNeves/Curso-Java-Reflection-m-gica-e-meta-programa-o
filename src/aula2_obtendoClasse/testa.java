package aula2_obtendoClasse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testa {

	public static void main(String[] args) throws Exception {
		
		Mapeador m = new Mapeador();
		m.load("classes.prop");
		List l = m.getInstancia(List.class);
		
		InterfaceExemplo i = m.getInstancia(InterfaceExemplo.class, "teste");
		
		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));
		System.out.println(l.getClass());
	}

}
