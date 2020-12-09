package test;

import java.util.LinkedList;
import java.util.List;

import bancaProject.Banca;
import bancaProject.ContoCorrente;
import conteiners.Contenitore;
import conteiners.ContenitoreLista;

public class TestLista {

	public static void main(String[] args) {
		List<ContoCorrente> list1 = new LinkedList<ContoCorrente>();
		Contenitore list = new ContenitoreLista(list1);
		Banca b1 = new Banca("Banca", list1);

	}

}
