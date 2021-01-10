package movida.cicconewanga;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

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
	
	Dictionary<String, Movie> film;
	Dictionary<String, Person> person;
	Sort<Entry[]> sort;
	
	MapImplementation tipoDizionario;
	SortingAlgorithm tipoOrdinamento;
	
	public MovidaCore(MapImplementation Dizionario, SortingAlgorithm Ordinamento)
			throws DizionarioSconosciutoEccezione, OrdinamentoSconosciutoEccezione{	
		Sort<Entry[]> sort = new Sort<Entry[]>();
		setMap(Dizionario);
		setSort(Ordinamento);
		
		switch (Dizionario) {
			case ListaNonOrdinata:
				film = new ListaNonOrdinata<String, Movie>();
				person = new ListaNonOrdinata<String, Person>();
				break;
			case ABR:
				//film = new ABR<String, Movie>();
				//person = new ABR<String, Person>();
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
		if(this.tipoOrdinamento == a || a != SortingAlgorithm.SelectionSort || a != SortingAlgorithm.MergeSort)
		return false;
		else {
			this.tipoOrdinamento = a;
			return true;
		}
	}

	@Override
	public boolean setMap(MapImplementation m) {
		if(this.tipoDizionario == m || m != MapImplementation.ListaNonOrdinata
				|| m != MapImplementation.ABR)
			return false;
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
			if(m.getTitle().contains(title)) movieMatch.add(m);
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
			if(m.getDirector().equals(name)) movieMatch.add(m);
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
				if (actor.getName().equals(name)) movieMatch.add(m);
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
		Movie[] BestMovies = new Movie[N];
		sort.selectedSort(allMovies, tipoOrdinamento, new Sort.sortMovieByVotes().reversed());
		for(int i = 0; i<N && i<allMovies.length && i<allMovies.length; i++) {
			BestMovies[i] = (Movie) allMovies[i].getElem();
		}
		return BestMovies;
	}

	@Override
	public Movie[] searchMostRecentMovies(Integer N) {
		Entry[] allMovies = (Entry[]) film.toArray();
		Movie[] mostRecentMovies = new Movie[N];
		sort.selectedSort(allMovies, tipoOrdinamento, new Sort.sortMovieByYear());
		for(int i = 0; i<N && i<allMovies.length && i<allMovies.length; i++) {
			mostRecentMovies[i] = (Movie) allMovies[i].getElem();
		}
		return mostRecentMovies;
	}

	@Override
	public Person[] searchMostActiveActors(Integer N) {
		return null;
		
	}

	@Override
	public void loadFromFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToFile(File f) {
		// TODO Auto-generated method stub
		
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
		try { this.film.delete(title); }
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
		return (Movie) this.film.search(title);
	}

	@Override
	public Person getPersonByName(String name) {
		return (Person) this.person.search(name);
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
		Person[] persone = new Person[film.getSize()];
		for(int i = 0; i<film.getSize(); i++) {
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
