package movida.cicconewanga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import movida.cicconewanga.Sort.sortMovieByTitle;
import movida.commons.*;


public class test {

	public static void main(String[] args) {
		
		/*Dictionary<String, Movie> lista = new ListaNonOrdinata<String, Movie>(true);

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
		lista1.search(3515);*/
		
		Dictionary<String, Movie> film = new ListaNonOrdinata<String, Movie>();
		Dictionary<String, Person> persone = new ListaNonOrdinata<String, Person>();
		
		
		Person[] attori1 = new Person[2];
		Person[] attori2 = new Person[2];
		Person[] attori3 = new Person[2];
		Person[] attori4 = new Person[2];
		attori1[0] = new Person("Di Capra xD");
		attori1[1] = new Person("Gianni xD");
		attori2[0] = new Person("Caprini");
		attori2[1] = new Person("Olivero");
		attori3[0] = new Person("Di Capra xD");
		attori3[1] = new Person("Walt");
		attori4[0] = new Person("Di Capra xD");
		attori4[1] = new Person("Walt");
		
		Sort<Entry[]> sort = new Sort<Entry[]>();
		Movie[] movie = new Movie[5];
		movie[0] = new Movie("Forza juve", 2000, 4, attori1, attori1[1]);
		movie[1] = new Movie("Biancaneve", 1960, 8, attori2, attori1[1]);
		movie[2] = new Movie("2012", 2012, 0, attori1, attori1[0]);
		movie[3] = new Movie("Aladin", 2012, 1, attori3, attori1[0]);
		movie[4] = new Movie("L'Era Glaciale", 2012, 10, attori4, attori2[1]);
		
		for(Integer i = 0; i<5; i++) {
			film.insert(i.toString(), movie[i]);
		}
		
		/*List<Movie> movieMatch = new LinkedList<Movie>();
		Entry[] movieArray = (Entry[]) film.toArray();
		for(int i = 0; i<movieArray.length; i++) {
			Movie m = (Movie) movieArray[i].getElem();
			if(m.getYear().equals(20122)) movieMatch.add(m);
		}
		
		Movie[] arr = new Movie[movieMatch.size()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = movieMatch.get(i);
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i].toString());
		}*/
		
		/*Entry[] allMovies = (Entry[]) film.toArray();
		Movie[] mostPopularMovies = new Movie[6];
		sort.selectedSort(allMovies, SortingAlgorithm.InsertionSort, new Sort.sortMovieByVotes().reversed());
		for(int i = 0; i<6 && i<allMovies.length; i++) {
			mostPopularMovies[i] = (Movie) allMovies[i].getElem();
		}
		for(int i = 0; i<mostPopularMovies.length && i<allMovies.length; i++) {
			System.out.println(mostPopularMovies[i].toString());
		}*/
		
			/*List<Movie> movieMatch = new LinkedList<Movie>();
			Entry[] movieArray = (Entry[]) film.toArray();
			for(int i = 0; i<movieArray.length; i++) {
				Movie m = (Movie) movieArray[i].getElem();
				Person[] cast = m.getCast();
				for(int i1 = 0; i1<cast.length; i1++) {
					if (cast[i1].getName().equalsIgnoreCase("Gianni xd")) movieMatch.add(m);
				}
			}
			Movie[] arr = new Movie[movieMatch.size()];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = movieMatch.get(i);
			}
			for(int i = 0; i<arr.length; i++) {
				System.out.println(arr[i].toString());
			}*/
	}



}
