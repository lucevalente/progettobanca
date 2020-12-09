package conteiners; //java bancaProject.ContenitoreObject

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bancaProject.ContoCorrente;

public class ContenitoreObject implements Contenitore {
	private String nomeFile;

	@Override
	public ContoCorrente getContoCorrente(String iban) {

		ObjectInputStream in = null;
//		Map<String, ContoCorrente> contiSalvati = (Map<String, ContoCorrente>) in.readObject();

		try {
//			List<ContoCorrente> contiSalvati = (List<ContoCorrente>) in.readObject();
//			System.out.println("Visualizzo la lista " + contiSalvati);
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // non ci va il null, che ci va?
	}

	@Override
	public void aggiungiContoCorrente(ContoCorrente cb) {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new FileInputStream(nomeFile));
			Map<String, ContoCorrente> contiSalvati = (Map<String, ContoCorrente>) in.readObject();
			contiSalvati.put(cb.getIban(), cb);
//			List<ContoCorrente> contiSalvati = (List<ContoCorrente>) in.readObject();
//			contiSalvati.add(cb);

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.nomeFile));
			System.out.println("Salvo la lista " + contiSalvati);
			out.writeObject(contiSalvati);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rimuoviContoCorrente(String iban) {
//		ObjectInputStream in=null;
//		try {
//			in=new ObjectInputStream(new FileInputStream(this.nomeFile));
//			Map<String, ContoCorrente> contiSalvati = (Map<String, ContoCorrente>) in.readObject();
//			conti.remove(iban);
//			
//			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(this.nomeFile));
//			out.writeObject(conti);
//		}

	}

	@Override
	public ContoCorrente[] getConti() {

		return null;
	}


	@Override
	public Iterator<ContoCorrente> iterator() {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new FileInputStream(nomeFile));
			Map<String, ContoCorrente> contiSalvati = (Map<String, ContoCorrente>) in.readObject();
			return contiSalvati.values().iterator();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
