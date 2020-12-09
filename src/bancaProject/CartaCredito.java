package bancaProject;

public class CartaCredito extends ContoCorrente implements Carta {
	private double fido;

	// questo serve per aperturaCarta
	public CartaCredito(String nome, String cognome, String iban) {
		super(nome, cognome, iban);
	}

	// costruttore manuale
	public CartaCredito(String iban, String nome, String cognome, double fido) {
		super(iban, nome, cognome);
		this.fido = fido;
	}

	// questo serve per contenitoreFile
	public CartaCredito(String iban, String nome, String cognome, double saldo, double fido) {
		super(iban, nome, cognome);
		this.fido = fido;
	}

	// getter
	public double getFido() {
		return fido;
	}

	public double getSaldo() {
		return super.getSaldo() + fido; // super.getSaldo prende il metodo getSaldo del padre
	}

	// versa //non è finito del tutto, manca la condizione di saldo negativo
	@Override
	public boolean versa(double somma_da_versare) {
		if (somma_da_versare > 0) {
			super.setSaldo(super.getSaldo() + somma_da_versare);
			return true;
		}
		return false;
	}

	// forse dovevo usare uno switch
	@Override
	public boolean preleva(double cifra_da_prelevare) {
		// prima situazione, saldo maggiore della cifra da prelevare, funziona bene
		if (super.getSaldo() >= cifra_da_prelevare && cifra_da_prelevare > 0) {
			super.setSaldo(super.getSaldo() - cifra_da_prelevare);
			return true;
			// saldo non sufficiente, va prelevato sia da saldo e da fido
		} else if (super.getSaldo() < cifra_da_prelevare && getSaldo() >= cifra_da_prelevare
				&& cifra_da_prelevare > 0) {
			fido = fido - (cifra_da_prelevare - super.getSaldo()); // dovrebbe essere al contrario ma non funziona
			super.setSaldo(0);
//			super.setSaldo(super.getSaldo() - (cifra_da_prelevare - (cifra_da_prelevare - super.getSaldo())));
			return true;
		} else {
			System.out.println("Mi dispiace non puoi prelevare");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Carta di credito " + super.toString().substring(14) + " [fido=" + fido + "]";
	}

}
