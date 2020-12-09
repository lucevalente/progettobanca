package test; //non funziona l'iban

import bancaProject.Banca;
import conteiners.Contenitore;
import conteiners.ContenitoreMappa;

public class TestMappa {

	public static void main(String[] args) {
		Contenitore c_map = new ContenitoreMappa(); // ci devo mettere <ContoCorrente>?
		Banca b2 = new Banca("Banca", c_map);

		b2.aperturaConto("Mario", "Rossi");
		System.out.println(c_map);

	}

}
