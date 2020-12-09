package conteiners; //non ho capito

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;

public class ContenitoreFile implements Contenitore {
	private String nome;

	public ContenitoreFile(String nome) {
		this.nome = nome;
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente conto) {
		DataOutputStream out;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.nome, true)));
			if (conto instanceof CartaCredito) {
				CartaCredito carta = (CartaCredito) conto;
				out.writeUTF(carta.getIban());
				out.writeUTF(carta.getNome());
				out.writeUTF(carta.getCognome());
				out.writeDouble(carta.getSaldo());
				out.writeDouble(carta.getFido());
			} else {
				out.writeUTF(conto.getIban());
				out.writeUTF(conto.getNome());
				out.writeUTF(conto.getCognome());
				out.writeDouble(conto.getSaldo());
				// -1
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ContoCorrente getContoCorrente(String iban) {
		ContoCorrente cb = new ContoCorrente(iban, "", "");
		ContoCorrente ris = null;
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(this.nome)));

			do {
				String iban_dato = in.readUTF();
				String nome = in.readUTF();
				String cognome = in.readUTF();
				double saldo = in.readDouble();
				double fido = in.readDouble();

				if (fido == -1) {
					ris = new ContoCorrente(iban_dato, nome, cognome, saldo);
				} else {
					ris = new CartaCredito(iban_dato, nome, cognome, saldo, fido);
				}
				if (cb.equals(ris)) {
					break;
				}
			} while (in.available() > 0);
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ris;
	}

	@Override
	public void rimuoviContoCorrente(String iban) {
		// nse po fa
		// magari con null, ma rimane salvato
	}

	@Override
	public ContoCorrente[] getConti() {
		// manco so se serve più
		return null;
	}

	@Override
	public Iterator<ContoCorrente> iterator() {
		return null;
	}

}
