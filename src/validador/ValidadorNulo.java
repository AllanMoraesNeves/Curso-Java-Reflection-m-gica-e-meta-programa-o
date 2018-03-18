package validador;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorNulo {

	public static List<String> getAtributosNulos(Object o) {

		try {
			List<String> lista = new ArrayList<>();
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				//f.getName pega o nome do atributo
				Object value = f.get(o);
				if (value == null) {
					lista.add(f.getName() + f.get(o));
				}
			}
			return lista;
		} catch (Exception e) {
			throw new RuntimeException("erro" + e.getMessage());
		}
	}
}
