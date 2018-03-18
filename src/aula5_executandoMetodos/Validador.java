package aula5_executandoMetodos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validador {

	public static boolean validarObjeto(Object obj)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean resultado = true;

		Class<?> clazz = obj.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("validar") && m.getReturnType() == boolean.class
					&& m.getParameterTypes().length == 0) {
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}
		return resultado;
	}

}
