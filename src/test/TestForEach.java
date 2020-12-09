package test;

import java.util.LinkedList;
import java.util.List;

import bancaProject.Banca;
import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;
import conteiners.Contenitore;
import conteiners.ContenitoreLista;
import conteiners.ContenitoreMappa;

public class TestForEach {
	public static void main(String[] args) {
		// lista
		List<ContoCorrente> list1 = new LinkedList<ContoCorrente>();
		Contenitore list = new ContenitoreLista(list1);
		Banca b1 = new Banca("Banca", list1);

		ContoCorrente cb = new ContoCorrente("Anna", "Pullace", "iban");
		ContoCorrente cc = new CartaCredito("Anna", "Pullace", "iban", 2000);
		list1.add(cb);
		list1.add(cc);

		for (ContoCorrente conto : b1) {
			conto.versa(10);
			System.out.println("Sono nel for each: " + conto);
		}

		// mappa
		Contenitore c_map = new ContenitoreMappa(); // ci devo mettere <ContoCorrente>?
		Banca b2 = new Banca("Banca", c_map);

		b2.aperturaCartaCredito("Anna", "Pullace");
		b2.aperturaConto("Mario", "Rossi");

		for (ContoCorrente conto : b2) {
			conto.versa(10);
			System.out.println("Sono nel for each: " + conto);
		}
	}

}
