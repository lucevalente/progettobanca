package test;	//questi non sono gli oggetti, o si?


import java.util.ArrayList;
import java.util.List;

import bancaProject.ContoCorrente;

public class TestObject {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		List<ContoCorrente> listaConti = new ArrayList<ContoCorrente>();
		ContoCorrente c1 = new ContoCorrente("iban", "nome", "cognome");
		listaConti.add(c1);

	}

}
