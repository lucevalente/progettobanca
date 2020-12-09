package conteiners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import bancaProject.CartaCredito;
import bancaProject.ContoCorrente;

public class ContenitorePrepare implements Contenitore {
	private static final String INSERT_CONTO = "INSERT INTO banca.conti (iban, nome, cognome, saldo, fido, status)"
			+ "VALUES ( ? , ? , ? , ? , ? , ? )"; // non sono sicura di questo
	private static final String SELECT = "SELECT * FROM banca.conti";

	private static final String DB_URL = "jdbc:mysql://localhost/banca", USERNAME = "root", PASS = "Fuckmylife1!";

	public ContenitorePrepare() {
	}

	@Override
	public ContoCorrente getContoCorrente(String iban) {
		Connection conn = null;

		return null;
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
			PreparedStatement prep = conn.prepareStatement(INSERT_CONTO);
			if (cb instanceof CartaCredito) {
				salvaCarta(cb, prep);
			} else {
				salvaConto(cb, prep);
			}
			prep.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void salvaCarta(ContoCorrente cb, PreparedStatement prep) throws SQLException {
		CartaCredito carta = (CartaCredito) cb;
		inserisciConto(prep, carta);
		prep.setDouble(5, carta.getFido());
		boolean risultato = prep.execute();
		if (!risultato) {
			System.out.print("Carta inserita");
		}
	}

	private void inserisciConto(PreparedStatement prep, ContoCorrente conto) throws SQLException {
		prep.setString(1, conto.getIban());
		prep.setString(2, conto.getNome());
		prep.setString(3, conto.getCognome());
		prep.setDouble(4, conto.getSaldo());
	}

	private void salvaConto(ContoCorrente cb, PreparedStatement prep) throws SQLException {
		inserisciConto(prep, cb);
		boolean risultato = prep.execute();
		if (!risultato) {
			System.out.print("Conto inserito");
		}
	}

	@Override
	public void rimuoviContoCorrente(String iban) {
		// update status

	}

	@Override
	public ContoCorrente[] getConti() {
		return null;
	}

	@Override
	public Iterator<ContoCorrente> iterator() {
		return null;
	}

}
