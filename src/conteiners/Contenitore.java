package conteiners;

import java.util.Iterator;

import bancaProject.ContoCorrente;

public interface Contenitore extends Iterable<ContoCorrente> {
	ContoCorrente getContoCorrente(String iban);

	void aggiungiContoCorrente(ContoCorrente cb);

	void rimuoviContoCorrente(String iban);

	ContoCorrente[] getConti();
	// l'array di conti deve sparire dalla classe banca

}
