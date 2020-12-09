package test; //non so come farlo funzionare onestamente

import bancaProject.Banca;
import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;
import conteiners.Contenitore;

public class TestArray {

	public static void main(String[] args) {
		
		ContoCorrente[] conti=new ContoCorrente[10];
		Banca b1 = new Banca("Banca");
		ContoCorrente cb = new ContoCorrente("Anna", "Pullace", "iban");
		ContoCorrente cc = new CartaCredito("Anna", "Pullace", "iban", 2000);
		b1.aperturaConto("Maria", "Elisabetta");
		System.out.println(b1);
		


	}

}
