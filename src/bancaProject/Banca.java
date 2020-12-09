package bancaProject;

import java.util.Arrays;
import java.util.Iterator;

import conteiners.Contenitore;

public class Banca implements GestioneBanca {

	private String nomeBanca;
	private String iban;
	private int num_prodotti = 0;
	ContoCorrente[] conti1 = new ContoCorrente[10];

	private Contenitore conti; //oggetto di tipo contenitore 

	// il costruttore riceve come parametro un oggetto di tipo interfaccia che è un
	// contenitore

	//costruttore manuale
	public Banca(String nomeBanca) {
		this.nomeBanca=nomeBanca;
	} 

	// costruttore
	public Banca(String nomeBanca, Contenitore conti) {
		this.nomeBanca = nomeBanca;
		this.conti = conti;
	}

	@Override
	public String aperturaConto(String nome, String cognome) {
		String iban = "IT0000" + num_prodotti;
		conti1[num_prodotti] = new ContoCorrente(iban, nome, cognome);
		conti.aggiungiContoCorrente(new ContoCorrente(iban, nome, cognome));
		num_prodotti++;
		return iban;
	}

	@Override
	public String aperturaCartaCredito(String nome, String cognome) {
		String iban = "IT0000" + num_prodotti;
		conti1[num_prodotti] = new CartaCredito(iban, nome, cognome);
//		conti.aggiungiContoCorrente(new CartaCredito(iban, nome, cognome, 2000));
		num_prodotti++;
		return iban;
	}

	@Override
	public double disponibilita(String iban) {
//		System.out.println("Il tuo saldo attuale è: ");
		return conti.getContoCorrente(iban).getSaldo();
	}

	// una riga, il metodo deve essere chiamato dal conto
	@Override
	public boolean versa(String iban, double somma_da_versare) {
//		System.out.println("Stai versando " + somma_da_versare + "€. Il tuo nuovo saldo è: ");
		return conti.getContoCorrente(iban).versa(somma_da_versare);
	}

	@Override
	public boolean preleva(String iban, double somma_da_prelevare) {
//		System.out.println("Stai versando " + somma_da_prelevare + "€. Il tuo nuovo saldo è: ") ;
		return conti.getContoCorrente(iban).preleva(somma_da_prelevare);
	}

	@Override
	public String chiusuraConto(String iban) {
		conti.rimuoviContoCorrente(iban);
		return "Chiusura avvenuta con successo";
	}

	@Override
	public String chiusuraCartaCredito(String iban) {
		conti.rimuoviContoCorrente(iban);
		return "Chiusura avvenuta con successo";
	}

//	@Override
	public ContoCorrente[] conti() { // lista di conti
		return conti.getConti();
	}

	// tostring
	@Override
	public String toString() {
		return "Banca [nomeBanca=" + nomeBanca + ", conti=" + Arrays.toString(conti.getConti()) + "]";
	}

	// iteratore
	@Override
	public Iterator<ContoCorrente> iterator() { //generalizzato
		return conti.iterator();
	}
}
