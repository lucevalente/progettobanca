package bancaProject;

public class ContoCorrente implements Carta {
	private String iban;
	private String nome;
	private String cognome;
	private double saldo;

	// costruttore
	public ContoCorrente(String iban, String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	// costruttore per contenitoreFile
	public ContoCorrente(String iban_dato, String nome, String cognome, double saldo) {
	}

	// getter e setter
	public String getIban() {
		return iban;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// versa
	public boolean versa(double somma_da_versare) {
		if (somma_da_versare > 0) {
			saldo = saldo + somma_da_versare;
			return true;
		}
		return false;
	}

	// preleva
	@Override
	public boolean preleva(double cifra_da_prelevare) {
		if (saldo >= cifra_da_prelevare && cifra_da_prelevare > 0) {
			saldo = saldo - cifra_da_prelevare;
			return true;
		}
		return false;
	}

	// tostring
	@Override
	public String toString() {
		return "Conto Corrente [iban=" + iban + ", nome=" + nome + ", cognome=" + cognome + ", saldo=" + getSaldo()
				+ "]";
	}

	// non ricordo a cosa serve
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	// dovrebbe servire per contenitoreLista
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}
}
