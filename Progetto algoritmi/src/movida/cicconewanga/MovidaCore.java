package movida.cicconewanga;

import java.io.File;

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
	Dictionary<String, Person> persone;
	Sort<Entry> sort;
	
	MapImplementation tipoDizionario;
	SortingAlgorithm tipoOrdinamento;
	
	public MovidaCore(MapImplementation Dizionario, SortingAlgorithm Ordinamento)
			throws DizionarioSconosciutoEccezione, OrdinamentoSconosciutoEccezione{
		
		sort = new Sort<Entry>();	
		
		setMap(Dizionario);
		setSort(Ordinamento);
		
		switch (Dizionario) {
			case ListaNonOrdinata:
				film = new ListaNonOrdinata<String, Movie>();
				persone = new ListaNonOrdinata<String, Person>();
				break;
			case ABR:
				//film = new ABR<String, Movie>();
				//persone = new ABR<String, Person>();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchMoviesInYear(Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchMoviesDirectedBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchMoviesStarredBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchMostVotedMovies(Integer N) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] searchMostRecentMovies(Integer N) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person[] searchMostActiveActors(Integer N) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countMovies() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countPeople() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Movie getMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPersonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person[] getAllPeople() {
		// TODO Auto-generated method stub
		return null;
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
