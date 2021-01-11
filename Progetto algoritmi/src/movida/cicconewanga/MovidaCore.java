package movida.cicconewanga;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import movida.cicconewanga.*;
import movida.commons.Collaboration;
import movida.commons.IMovidaCollaborations;
import movida.commons.IMovidaConfig;
import movida.commons.IMovidaDB;
import movida.commons.IMovidaSearch;
import movida.commons.MapImplementation;
import movida.commons.Movie;
import movida.commons.Person;
import movida.commons.SortingAlgorithm;
import movida.eccezioni.*;

public class MovidaCore implements IMovidaDB, IMovidaSearch, IMovidaConfig, IMovidaCollaborations {
	
	private Dictionary<String, Movie> film;
	private Dictionary<String, Person> person;
	private Sort<Entry[]> sort = new Sort<Entry[]>();
	
	private MapImplementation tipoDizionario;
	private SortingAlgorithm tipoOrdinamento;
	
	public MovidaCore(MapImplementation Dizionario, SortingAlgorithm Ordinamento)
			throws DizionarioSconosciutoEccezione, OrdinamentoSconosciutoEccezione{
		setMap(Dizionario);
		setSort(Ordinamento);

		switch (Dizionario) {
			case ListaNonOrdinata:
				film = new ListaNonOrdinata<String, Movie>(true);
				person = new ListaNonOrdinata<String, Person>();
				break;
			case ABR:
				film = new ABR<String, Movie>();
				person = new ABR<String, Person>();
				break;
	
			default:
				throw new DizionarioSconosciutoEccezione(Dizionario);
		}
		
		if (Ordinamento != SortingAlgorithm.SelectionSort && Ordinamento != SortingAlgorithm.MergeSort) 
		{
			throw new OrdinamentoSconosciutoEccezione(Ordinamento);
		}
		
	}
	
	

	@Override
	public boolean setSort(SortingAlgorithm a) {
		if(this.tipoOrdinamento == a || a != SortingAlgorithm.SelectionSort && a != SortingAlgorithm.MergeSort)
		return false;
		else {
			this.tipoOrdinamento = a;
			return true;
		}
	}

	@Override
	public boolean setMap(MapImplementation m) {
		if(this.tipoDizionario == m || m != MapImplementation.ListaNonOrdinata
				&& m != MapImplementation.ABR) {
			return false;
		}
		else {
			this.tipoDizionario = m;
			return true;
		}
	}

	@Override
	public Movie[] searchMoviesByTitle(String title) {
		List<Movie> movieMatch = new LinkedList<Movie>();
		Entry[] movieArray = (Entry[]) this.film.toArray();
		for(int i = 0; i<movieArray.length; i++) {
			Movie m = (Movie) movieArray[i].getElem();
			if(m.getTitle().toLowerCase().contains(title.toLowerCase())) movieMatch.add(m);
		}
		Movie[] arr = new Movie[movieMatch.size()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = movieMatch.get(i);
		}
		return arr;
	}

	@Override
	public Movie[] searchMoviesInYear(Integer year) {
		List<Movie> movieMatch = new LinkedList<Movie>();
		Entry[] movieArray = (Entry[]) this.film.toArray();
		for(int i = 0; i<movieArray.length; i++) {
			Movie m = (Movie) movieArray[i].getElem();
			if(m.getYear().equals(year)) movieMatch.add(m);
		}
		Movie[] arr = new Movie[movieMatch.size()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = movieMatch.get(i);
		}
		return arr;
	}

	@Override
	public Movie[] searchMoviesDirectedBy(String name) {
		List<Movie> movieMatch = new LinkedList<Movie>();
		Entry[] movieArray = (Entry[]) this.film.toArray();
		for(int i = 0; i<movieArray.length; i++) {
			Movie m = (Movie) movieArray[i].getElem();
			if(m.getDirector().getName().equalsIgnoreCase(name)) movieMatch.add(m);
		}
		Movie[] arr = new Movie[movieMatch.size()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = movieMatch.get(i);
		}
		return arr;
	}

	@Override
	public Movie[] searchMoviesStarredBy(String name) {
		List<Movie> movieMatch = new LinkedList<Movie>();
		Entry[] movieArray = (Entry[]) this.film.toArray();
		for(int i = 0; i<movieArray.length; i++) {
			Movie m = (Movie) movieArray[i].getElem();
			Person[] cast = m.getCast();
			for(Person actor : cast) {
				if (actor.getName().equalsIgnoreCase(name)) movieMatch.add(m);
			}
		}
		Movie[] arr = new Movie[movieMatch.size()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = movieMatch.get(i);
		}
		return arr;
	}

	@Override
	public Movie[] searchMostVotedMovies(Integer N) {
		Entry[] allMovies = (Entry[]) film.toArray();
		Movie[] BestMovies = new Movie[min(N, allMovies.length)];
		sort.selectedSort(allMovies, tipoOrdinamento, new Sort.sortMovieByVotes().reversed());
		for(int i = 0; i<N && i<allMovies.length && i<allMovies.length; i++) {
			BestMovies[i] = (Movie) allMovies[i].getElem();
		}
		return BestMovies;
	}

	@Override
	public Movie[] searchMostRecentMovies(Integer N) {
		Entry[] allMovies = (Entry[]) film.toArray();
		Movie[] mostRecentMovies = new Movie[min(N, allMovies.length)];
		sort.selectedSort(allMovies, tipoOrdinamento, new Sort.sortMovieByYear().reversed());
		for(int i = 0; i<N && i<allMovies.length; i++) {
			mostRecentMovies[i] = (Movie) allMovies[i].getElem();
		}
		return mostRecentMovies;
	}

	private int min(int n, int m) {
		if(n<m) return n;
		else return m;
	}

	
	@Override
	public Person[] searchMostActiveActors(Integer N) {
		Entry[] allPerson = (Entry[]) person.toArray();
		this.sort.selectedSort(allPerson, tipoOrdinamento, new Sort.sortPersonByActivities().reversed());
		Person[] popularPerson = new Person[min(N, allPerson.length)];
		for(int i = 0; i<N && i<allPerson.length; i++) {
			popularPerson[i] = (Person) allPerson[i].getElem();
		}
		return popularPerson;
		
	}

	@Override
	public void loadFromFile(File f) {
		Scanner x = null;
		try {
			x = new Scanner(f);
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
				x.next();
				Integer vote = Integer.parseInt(x.nextLine().trim());
				Movie nuovoFilm = new Movie(title, year, vote, castArray, nuovoDirector);
				if(film.Exist(nuovoFilm.getTitle().toLowerCase())) this.deleteMovieByTitle(nuovoFilm.getTitle().toLowerCase());
				film.insert(nuovoFilm.getTitle().toLowerCase(), nuovoFilm);
				for(int i2 = 0; i2<castArray.length; i2++) {
					if(!person.Exist(castArray[i2].getName().toLowerCase())) {
						person.insert(castArray[i2].getName().toLowerCase(), castArray[i2]);
						castArray[i2].increaseComparse();
						}
					else {
						Person alreadyExist = (Person) person.search(castArray[i2].getName().toLowerCase());
						alreadyExist.increaseComparse();
					}
				}
				if(!person.Exist(nuovoDirector.getName().toLowerCase())) {
					person.insert(nuovoDirector.getName().toLowerCase(), nuovoDirector);
					nuovoDirector.dcreaseComparse();
					}
				else {
					Person alreadyExist = (Person) person.search(nuovoDirector.getName().toLowerCase());
					alreadyExist.dcreaseComparse();
				}
			}		
				
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveToFile(File f) {
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			Movie[] allMovies = this.getAllMovies();
			String text = "";
			
			for(int i = 0; i<allMovies.length; i++) {
				if(i == allMovies.length-1) text += allMovies[i].toString();
				else text += allMovies[i].toString() + "\n" + "\n";
			}
			
			pw.print(text);
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void clear() {
		this.film.clear();
		this.person.clear();
		
	}

	@Override
	public int countMovies() {
		return this.film.getSize();
	}

	@Override
	public int countPeople() {
		return this.person.getSize();
	}

	@Override
	public boolean deleteMovieByTitle(String title) {
		try {
			Movie toDelete = (Movie)this.film.search(title.toLowerCase());
			Person[] cast = toDelete.getCast();
			for(int i = 0; i<cast.length; i++) {
				Person p = (Person) this.person.search(cast[i].getName().toLowerCase());
				p.dcreaseComparse();
				if(p.getComparse().equals(0)) this.person.delete(p.getName().toLowerCase());
			}
			Person director = (Person) this.person.search(toDelete.getDirector().getName().toLowerCase());
			director.increaseComparse();
			if(director.getComparse().equals(0)) this.person.delete(director.getName().toLowerCase());
			this.film.delete(title.toLowerCase());
		}
		catch (ChiaveNonValidaEccezione e) {
			return false;
		}
		catch (DizionarioVuotoEccezione e2) {
			return false;
		}
		return true;
	}

	@Override
	public Movie getMovieByTitle(String title) {
		return (Movie) this.film.search(title.toLowerCase());
	}

	@Override
	public Person getPersonByName(String name) {
		return (Person) this.person.search(name.toLowerCase());
	}

	@Override
	public Movie[] getAllMovies() {
		Entry[] all = (Entry[]) film.toArray();
		Movie[] movies = new Movie[film.getSize()];
		for(int i = 0; i<film.getSize(); i++) {
			movies[i] = (Movie) all[i].getElem();
		}
		return movies;
	}

	@Override
	public Person[] getAllPeople() {
		Entry[] all = (Entry[]) person.toArray();
		Person[] persone = new Person[person.getSize()];
		for(int i = 0; i<person.getSize(); i++) {
			persone[i] = (Person) all[i].getElem();
		}
		return persone;
	}

	@Override
	public Person[] getDirectCollaboratorsOf(Person actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person[] getTeamOf(Person actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collaboration[] maximizeCollaborationsInTheTeamOf(Person actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
