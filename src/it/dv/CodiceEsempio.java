package it.dv;

import java.util.ArrayList;
import java.util.List;

public class CodiceEsempio {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(12);
		System.out.println("la prima posizione e'  il numero " +lista.get(0));
		lista.add(89);
		lista.add(0, 55);
		System.out.println("la prima posizione e'  il numero " +lista.get(0));
		
		for ( int i=0 ; i<lista.size(); i++)
			System.out.println( "numero " + lista.get(i));
		
		List<String> listaPersona = new ArrayList();

			
		
		
	}

}
