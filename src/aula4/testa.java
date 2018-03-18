package aula4;

public class testa {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Usuario u = new Usuario();
		u.setEmail("email");
		u.setLogin("allan");
		GeradorXml g = new GeradorXml();
		System.out.println(g.getXml(u));
	}

}
