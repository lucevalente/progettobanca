package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import bancaProject.Banca;
import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;
import bancaProject.GestioneBanca;
import conteiners.Contenitore;
import conteiners.ContenitoreLista;
import conteiners.ContiContainer;

public class Test {

	public static void main(String[] args) {
//		//test per vede se funziona

		List<ContoCorrente> list = new LinkedList<ContoCorrente>();
		Contenitore contenitore = new ContenitoreLista(list);

		Banca banca = new Banca("Intesa", contenitore);
		String iban = banca.aperturaConto("Anna", "Pullace");
		banca.versa(iban, 1000);
		System.out.println(banca);
		banca.chiusuraConto(iban);
		System.out.println(banca);
		// perchè non mi ha creato l'iban?????
		



		

	}
}
