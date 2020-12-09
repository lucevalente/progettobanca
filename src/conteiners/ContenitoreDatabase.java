package conteiners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;

public class ContenitoreDatabase implements Contenitore {
	private static final String insert = "INSERT INTO banca.conti (iban, nome, cognome, saldo, fido, status)";

	public ContenitoreDatabase() {
	}

	@Override
	public ContoCorrente getContoCorrente(String iban) {
//		// select
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/banca", "root", "Fuckmylife1!");
			String query = "SELECT * FROM banca.conti where iban=' '";
			Statement state = conn.createStatement();
			ResultSet ris = state.executeQuery(query); // legge tutti i risultati della query
			int i = 1;
			while (ris.next()) {
				String iban = ris.getString("iban");
				String nome = ris.getString("nome");
				String cognome = ris.getString("cognome");
				double saldo = ris.getDouble("saldo");
				System.out.print(" Iban: " + iban);
				System.out.print(" Nome: " + nome);
				System.out.println(" Cognome: " + cognome);
				System.out.println(" Saldo: " + saldo);
				i++;
			}
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {
		Connection conn = null;
		boolean ris1 = true;
//		String query = insert;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/banca", "root", "Fuckmylife1!");
			Statement state = conn.createStatement();
			if (cb instanceof CartaCredito) {
				salvaCarta(cb, state);
			} else {
				salvaConto(cb, state);
			}
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	private void salvaConto(ContoCorrente cb, Statement state) throws SQLException {
		String query=insert;
		query += "VALUES (" + cb.getIban() + ", " + cb.getNome() + ", " + cb.getCognome() + ", " + cb.getSaldo()
				+ " Aperto.)";
		boolean ris = state.execute(query);
		if (!ris) {
			System.out.print("Conto inserito");
		}
	}

	private void salvaCarta(ContoCorrente cb, Statement state) throws SQLException {
		boolean ris1;
		String query=insert;
		CartaCredito carta = (CartaCredito) cb;
		query += "VALUES (" + carta.getIban() + ", " + carta.getNome() + ", " + carta.getCognome() + ", "
				+ carta.getSaldo() + ", " + carta.getFido() + " Aperto.)";
		ris1 = state.execute(query);
		if (!ris1) {
			System.out.print("Carta inserita");
		}
	}

	@Override
	public void rimuoviContoCorrente(String iban) {
		// update
	}

	@Override
	public ContoCorrente[] getConti() {
		// select
		return null;
	}

	@Override
	public Iterator<ContoCorrente> iterator() {
		return null;
	}

}
