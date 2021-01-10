package movida.cicconewanga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import movida.cicconewanga.Sort.sortMovieByTitle;
import movida.commons.*;


public class test {

	public static void main(String[] args) {
		
		Dictionary<String, Movie> lista = new ListaNonOrdinata<String, Movie>(true);

		Movie[] film = new Movie[5];
		film[0] = new Movie("Titanic", 1999, 5, null, null);
		film[1] = new Movie("Filmone", 1984, 9, null, null);
		film[2] = new Movie("Alla ricerca della valle incantata", 1992, 10, null, null);
		film[3] = new Movie("2012", 2012, 1, null, null);
		film[4] = new Movie("Winnie the Poo", 2003, 10, null, null);
		
		for(int i = 0; i<5; i++) {
			lista.insert(film[i].getTitle(), film[i]);
		}
		//Movie titanic = (Movie) lista.search("Titanic");
		//System.out.println(titanic);
		//System.out.print(lista.toString());
		System.out.println(lista.getSize());
		lista.clear();
		System.out.println(lista.getSize());
		
		Dictionary<Integer, Movie> lista1 = new ListaNonOrdinata<Integer, Movie>(true);
		Movie[] film2 = new Movie[5];
		film[0] = new Movie("Titanic", 1999, 5, null, null);
		film[1] = new Movie("Filmone", 1984, 9, null, null);
		film[2] = new Movie("Alla ricerca della valle incantata", 1992, 10, null, null);
		film[3] = new Movie("2012", 2012, 1, null, null);
		film[4] = new Movie("Winnie the Poo", 2003, 10, null, null);
		
		for(int i = 0; i<5; i++) {
			lista1.insert(film[i].getVotes(), film[i]);
		}
		//System.out.print(lista1.toString());
		
		Entry[] array = lista1.toArray();
		
		for(int i = 0; i<5; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("Sorted:");
		Sort<Entry> sort = new Sort<Entry>();
		sort.selectionSort(array, new Sort.sortByKey().reversed());
		for(int i = 0; i<5; i++) {
			System.out.println(array[i]);
		}
		lista1.search(3515);

	}

}
