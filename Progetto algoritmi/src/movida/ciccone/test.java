package movida.ciccone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import movida.ciccone.Sort.sortMovieByTitle;
import movida.commons.*;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Sort<String[]> sort = new Sort();
		
		String[] frasi = new String[8];
		frasi[0] = "aiaiif";
		frasi[1] = "vndsng";
		frasi[2] = "ccaiif";
		frasi[3] = "asndsng";
		frasi[4] = "gaiif";
		frasi[5] = "zndsng";
		frasi[6] = "caaiif";
		frasi[7] = "bbndsng";
		System.out.println(Arrays.toString(frasi));
		
		
		Sort.selectionSort(frasi, new Sort.sortByAlphabet());
		System.out.println(Arrays.toString(frasi));
		
		frasi[0] = "aiaiif";
		frasi[1] = "vndsng";
		frasi[2] = "ccaiif";
		frasi[3] = "asndsng";
		frasi[4] = "gaiif";
		frasi[5] = "zndsng";
		frasi[6] = "caaiif";
		frasi[7] = "bbndsng";
		System.out.println(Arrays.toString(frasi));
		
		Sort.mergeSort(frasi, new Sort.sortByAlphabet());
		System.out.println(Arrays.toString(frasi));*/
		
		List<Movie> movie = new LinkedList();
		Person[] attori = new Person[5];
		for(Integer i = 0; i<5; i++) {
			attori[i] = new Person("Attore " + i.toString());
			System.out.println(attori[i].getName());
		}
		
		Person direttore = new Person("Direttore");
		Movie[] film = new Movie[5];
		film[0] = new Movie("arwegera", 1947, 5, attori, direttore);
		film[1] = new Movie("gwegszgf", 1999, 7, attori, direttore);
		film[2] = new Movie("Zczqr", 1988, 4, attori, direttore);
		film[3] = new Movie("BBasdadfadf", 2000, 3, attori, direttore);
		film[4] = new Movie("Ciao qs700", 1989, 10, attori, direttore);
		
		System.out.println();
		
		
		
		/*for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		
		System.out.println();
		
		Sort<Movie> sort = new Sort();
		
		sort.selectionSort(film, new Sort.sortMovieByTitle().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.selectionSort(film, new Sort.sortMovieByTitle());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByTitle().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByTitle());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}*/
		
		/*for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		
		System.out.println();
		
		Sort<Movie> sort = new Sort();
		
		sort.selectionSort(film, new Sort.sortMovieByVotes().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.selectionSort(film, new Sort.sortMovieByVotes());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByVotes().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByVotes());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}*/
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		
		System.out.println();
		
		Sort<Movie> sort = new Sort();
		
		sort.selectionSort(film, new Sort.sortMovieByYear().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.selectionSort(film, new Sort.sortMovieByYear());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByYear().reversed());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		System.out.println();
		
		sort.mergeSort(film, new Sort.sortMovieByYear());
		
		for(Integer i = 0; i < 5; i++) {
			System.out.println(film[i].toString());
		}
		
		
		

	}

}
