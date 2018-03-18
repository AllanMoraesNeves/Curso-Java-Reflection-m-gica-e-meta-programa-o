package aula4;

import java.lang.reflect.Field;

public class GeradorXml {

	public static String getXml(Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		
		Class<?> c = obj.getClass();
		sb.append("<" + c.getSimpleName() + ">");
		//pega os privados tambem
		for (Field f : c.getDeclaredFields()) {
			f.setAccessible(true);
			sb.append("<" + f.getName() + ">");
			sb.append("<" + f.get(obj) + ">");
			sb.append("</" + f.getName() + "> \n");
		}
		sb.append("<" + c.getSimpleName() + ">");
		return sb.toString();
	}
}
