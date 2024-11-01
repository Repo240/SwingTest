package it.dv;

import java.util.ArrayList;
import java.util.List;

public class CodiceEsempio {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(12);//aggiuno alla lista il numero 12 nella posizione 0
		System.out.println("la prima posizione e'  il numero " +lista.get(0));
		lista.add(89);
		lista.add(0, 55);//aggiungo alla lista in posizione 0 il numero 55, gli altri scalano
		System.out.println("la prima posizione e' ora il numero " +lista.get(0));
		
		for ( int i=0 ; i<lista.size(); i++)
			System.out.println( "numero alla posizione " + i +" = " + lista.get(i));
		
		//altro modo di stampare il contenuto della lista
		for(Integer intero: lista) //oppure int
			System.out.println("il numero è: " + intero);
		//con arrays
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		for (String i : cars) {
		  System.out.println(i);
		}
		
		
		//Posso fare altre lista di altre cose o liste di altre classi
		List<String> listaNomi = new ArrayList<String>();
		
		
			
		
		
	}
		

}


