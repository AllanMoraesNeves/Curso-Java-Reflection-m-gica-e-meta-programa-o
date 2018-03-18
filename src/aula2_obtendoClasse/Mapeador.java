package aula2_obtendoClasse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	public void load(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for (Object key : p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> inpl = Class.forName(p.get(key).toString());
			// dath vade é pai de luke
			if (!interf.isAssignableFrom(inpl)) {
				throw new RuntimeException(
						"A classe " + inpl.getName() + " não implementa a interface " + interf.getName());
			}
			mapa.put(interf, inpl);
		}
	}

	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}

	@SuppressWarnings("unchecked")
	public <e> e getInstancia(Class<e> interf) throws InstantiationException, IllegalAccessException {
		Class<?> impl = mapa.get(interf);
		return (e) impl.newInstance();
	}

	public <e> e getInstancia(Class<e> interf, Object... params) throws Exception{
		Class<?> impl = mapa.get(interf);
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		for (int i = 0; i < tiposConstrutor.length; i++) {
			tiposConstrutor[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(tiposConstrutor);
		return (e) c.newInstance(params);
	}
}
