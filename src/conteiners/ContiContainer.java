package conteiners; //dovrebbe salvare i conti su un array?

import java.util.Iterator;

import bancaProject.ContoCorrente;

public class ContiContainer implements Contenitore {
	private ContoCorrente[] conti;
	private int contatore = 0;

	// funzioni
	@Override
	public ContoCorrente getContoCorrente(String iban) {
		return conti[index(iban)];
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {
		if (contatore == conti.length) {
			conti = aggiungiConti(new ContoCorrente(cb.getIban(), cb.getNome(), cb.getCognome()));
		}
		conti[contatore] = new ContoCorrente(cb.getIban(), cb.getNome(), cb.getCognome());
		contatore++;
	}

	// aggiunge nuovi conti se il vecchio array è pieno
	public ContoCorrente[] aggiungiConti(ContoCorrente conto_da_aggiungere) {
		ContoCorrente[] nuoviConti = new ContoCorrente[contatore + 1];
		for (int i = 0; i < contatore - 1; i++) {
			nuoviConti[i] = conti[i];
		}
		nuoviConti[contatore] = conto_da_aggiungere;
		return nuoviConti;

	}

	@Override
	public void rimuoviContoCorrente(String iban) {
		if (index(iban) != -1) {
			spostaArray(iban); // non ho capito
		}
	}

	private void spostaArray(String iban) {
		conti[index(iban)] = null;
		for (int i = index(iban); i < contatore; i++) {
			conti[i] = conti[i + 1];
		}
		conti[contatore] = null;
	}

	private int index(String iban) {
		int indice = -1; //perchè parte da -1?
		for (int i = 0; i < contatore; i++) {
			if (conti[i].getIban().compareTo(iban) == 0) {
				indice = i;
			}
		}
		return indice; 
	}

	@Override
	public ContoCorrente[] getConti() {
		ContoCorrente[] conti_tot = new ContoCorrente[contatore];
		for (int i = 0; i < contatore; i++) {
			conti_tot[i] = conti[i];
		}
		return conti_tot;
	}

	@Override
	public Iterator<ContoCorrente> iterator() {
		return null;
	}

}
