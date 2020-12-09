package conteiners; //salva conti su una mappa

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bancaProject.ContoCorrente;

public class ContenitoreMappa implements Contenitore {

	// mappa struttura dati formata da coppia e chiave valore
	Map<String, ContoCorrente> conti = new HashMap<>();

	@Override
	public ContoCorrente getContoCorrente(String iban) {
		return conti.get(iban);
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {
		conti.put(cb.getIban(), cb); //put aggiunge alla mappa
	}

	// basta eliminare la key, ovvero l'iban
	@Override
	public void rimuoviContoCorrente(String iban) {
		conti.remove(iban);
	}

	@Override
	public ContoCorrente[] getConti() {
		return conti.values().toArray(new ContoCorrente[conti.size()]); // non ho capito
	}
	
	//tostring
	@Override
	public String toString() {
		return "ContenitoreMappa [conti=" + conti + "]";
	}

	@Override
	public Iterator<ContoCorrente> iterator() {
		return conti.values().iterator(); //vogliamo tutti i conti 
	}

}
