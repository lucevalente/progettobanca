package conteiners; //salva conti su una lista

import java.util.Iterator;
import java.util.List;

import bancaProject.ContoCorrente;

public class ContenitoreLista implements Contenitore {
	private List<ContoCorrente> conti; //crea una lista di ContiCorrenti chiamata conti

	//costruttore 
	public ContenitoreLista(List<ContoCorrente> conti) {
		this.conti = conti;
	}

	// senza l'equal non funziona
	// altrimenti bisogna fare un for e controllare l'iban a mano
	@Override
	public ContoCorrente getContoCorrente(String iban) {
		return conti.get(conti.indexOf(new ContoCorrente(iban, "", ""))); //non ho capito indexOf
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {
		conti.add(cb);
	}

	@Override
	public void rimuoviContoCorrente(String iban) {
		conti.remove(conti.indexOf(new ContoCorrente(iban, "", "")));
	}

	@Override
	public ContoCorrente[] getConti() {
		return (ContoCorrente[]) conti.toArray(new ContoCorrente[conti.size()]); //non ho capito
	}

	@Override
	public String toString() {
		return "ContenitoreCustom [conti=" + conti + "]";
	}

	//iteratore
	@Override
	public Iterator<ContoCorrente> iterator() {
		return conti.iterator();
	}

}
