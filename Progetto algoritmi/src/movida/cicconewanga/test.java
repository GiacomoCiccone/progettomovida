package movida.cicconewanga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
		
		/*Dictionary<String, Movie> film = new ListaNonOrdinata<String, Movie>();
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
		}*/
		
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
		/*Scanner x = null;
		try {
			x = new Scanner(new File("Esempio-Formato-Dati.txt"));
			while(x.hasNext()) {
				x.next();
				String title = x.nextLine().trim();
				x.next();
				Integer year = Integer.parseInt(x.nextLine().trim());
				x.next();
				String directorName = x.nextLine().trim();
				Person nuovoDirector = new Person(directorName);
				x.next();
				String castString = x.nextLine().trim();
				LinkedList<Person> cast = new LinkedList<Person>();
				int i = 0;
				while(true) {
					String name = castString.substring(i, castString.indexOf(','));
					Person attore = new Person(name);	
					cast.add(attore);
					castString = castString.substring(castString.indexOf(',')+2);
					if(castString.indexOf(',') == -1) {
						Person attoreFinale = new Person(castString);
						cast.add(attoreFinale);
						break;}
				}
				Person[] castArray = new Person[cast.size()];
				for(int j = 0; j<castArray.length; j++) {
					castArray[j] = cast.get(j);
				}
				//fare ricerca in dizionario attori, se gia presente aumentare solo di 1 il numero di film.
				x.next();
				Integer vote = Integer.parseInt(x.nextLine().trim());
				Movie nuovoFilm = new Movie(title, year, vote, castArray, nuovoDirector);
				System.out.println(nuovoFilm.toString());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		MovidaCore test = new MovidaCore(MapImplementation.ABR, SortingAlgorithm.SelectionSort);
		//System.out.print(System.getProperty("user.dir"));
		File f = new File("esempio-formato-dati.txt");
		test.loadFromFile(f);
		//System.out.println(test.countMovies());
		//System.out.println(test.countPeople());
		/*Movie[] allMovies = test.getAllMovies();
		for(int i = 0; i<allMovies.length; i++) {
			System.out.println(allMovies[i].toString());
		}*/
		/*Person[] allPerson = test.getAllPeople();
		for(int i = 0; i<allPerson.length; i++) {
			System.out.println(allPerson[i].toString());
		}*/
		
		//Integer n = 100;
		/*Movie[] mostRecent = test.searchMostRecentMovies(n);
		
		for(int i = 0; i<mostRecent.length; i++) {
			System.out.println(mostRecent[i].toString());
		}
		
		/*Movie[] mostVoted = test.searchMostVotedMovies(n);
		
		for(int i = 0; i<mostVoted.length; i++) {
			System.out.println(mostVoted[i].toString());
		}*/
		
		//test.clear();
		//System.out.println(test.countMovies() + " " + test.countPeople());
		/*Person[] mostActive = test.searchMostActiveActors(n);
		for(int i = 0; i<mostActive.length; i++) {
			System.out.println(mostActive[i].toString());
		}*/
		
		/*Movie[] starredBy = test.searchMoviesStarredBy("harrison ford");
		for(int i = 0; i<starredBy.length; i++) {
			System.out.println(starredBy[i].toString() + "\n");
		}*/
		
		/*Movie[] starredBy = test.searchMoviesDirectedBy("christopher nolan");
		for(int i = 0; i<starredBy.length; i++) {
			System.out.println(starredBy[i].toString() + "\n");
		}*/
		
		/*Movie[] starredBy = test.searchMoviesInYear(2020);
		for(int i = 0; i<starredBy.length; i++) {
			System.out.println(starredBy[i].toString() + "\n");
		}*/
		
		/*Movie[] starredBy = test.searchMoviesByTitle("ve");
		for(int i = 0; i<starredBy.length; i++) {
			System.out.println(starredBy[i].toString() + "\n");
		}*/
		
		//System.out.println(test.getMovieByTitle("soul").toString());
		//System.out.println(test.getPersonByName("christopher nolan").toString());
		
		/*System.out.println(test.countMovies());
		System.out.println(test.countPeople());
		Person[] allPerson = test.getAllPeople();
		for(int i = 0; i<allPerson.length; i++) {
			System.out.println(allPerson[i].toString());
		}
		System.out.println(test.deleteMovieByTitle("taxi driver"));
		System.out.println(test.deleteMovieByTitle("Cape Fear"));
		System.out.println(test.deleteMovieByTitle("Pulp Fiction"));
		System.out.println(test.deleteMovieByTitle("Contact"));
		System.out.println(test.deleteMovieByTitle("Die Hard"));
		System.out.println(test.deleteMovieByTitle("The Sixth Sense"));
		System.out.println(test.deleteMovieByTitle("Scarface"));
		System.out.println(test.deleteMovieByTitle("What Lies Beneath"));
		System.out.println(test.deleteMovieByTitle("Air Force One"));
		//System.out.println(test.deleteMovieByTitle("The Fugitive"));
		allPerson = test.getAllPeople();
		for(int i = 0; i<allPerson.length; i++) {
			System.out.println(allPerson[i].toString());
		}
		System.out.println(test.countMovies());
		System.out.println(test.countPeople());*/
		//test.setMap(MapImplementation.ABR);
		//test.setSort(SortingAlgorithm.MergeSort);
		
		/*System.out.println(test.deleteMovieByTitle("Cape Fear"));
		System.out.println(test.deleteMovieByTitle("Pulp Fiction"));
		System.out.println(test.deleteMovieByTitle("Contact"));
		System.out.println(test.deleteMovieByTitle("Die Hard"));
		System.out.println(test.deleteMovieByTitle("The Sixth Sense"));
		System.out.println(test.deleteMovieByTitle("Scarface"));
		System.out.println(test.deleteMovieByTitle("What Lies Beneath"));
		System.out.println(test.deleteMovieByTitle("Air Force One"));
		
		File f2 = new File("FileSalvato.txt");
		test.saveToFile(f2);*/
		//System.out.println(test.deleteMovieByTitle("Air Force One"));
		//System.out.println(test.deleteMovieByTitle("What Lies Beneath"));
		//System.out.println(test.deleteMovieByTitle("The Fugitive"));
		/*Person[] collaboration;
		collaboration = test.getDirectCollaboratorsOf(test.getPersonByName("leonardo dicaprio"));
		for(int i = 0; i < collaboration.length; i++) {
			System.out.println(collaboration[i].toString());
		}
		
		Collaboration[]	c = test.getCollab(test.getPersonByName("tom hanks"));
		for(Collaboration c1 : c) {
			System.out.println(c1.toString());
		}*/
		
		/*Person[] team = test.getTeamOf(test.getPersonByName("harrison ford"));
		
		for(int i = 0; i < team.length; i++) {
			System.out.println(team[i]);
		}*/
		
		/*Collaboration[] collab = test.maximizeCollaborationsInTheTeamOf(test.getPersonByName("Harrison Ford"));
		
		for(int i = 0; i < collab.length; i++) {
			System.out.println(collab[i].toString());
		}*/


	}

}
