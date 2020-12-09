package bancaProject; //funzioni di ogni banca


public interface GestioneBanca extends Iterable<ContoCorrente>{

	public String aperturaConto(String nome, String cognome);

	public String aperturaCartaCredito(String nome, String cognome);

	public double disponibilita(String iban);

	public boolean versa(String iban, double somma_da_versare);

	public boolean preleva(String iban, double somma_da_prelevare);

//	public ContoCorrente[] conti();
	
	public String chiusuraConto(String iban);
	
	public String chiusuraCartaCredito(String iban);

	// la classe banca deve implementare l'interfaccia

	// classe conto e classe carta, classe sportello
	// nel conto servono nome cognome iban e saldo

}
