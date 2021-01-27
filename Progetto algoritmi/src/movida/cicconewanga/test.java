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
			
		/*MovidaCore test = new MovidaCore(MapImplementation.ABR, SortingAlgorithm.SelectionSort);
		//System.out.print(System.getProperty("user.dir"));
		File f = new File("esempio-formato-dati.txt");
		test.loadFromFile(f);
		test.setMap(MapImplementation.ListaNonOrdinata);*/
		/*System.out.println(test.countMovies());
		System.out.println(test.countPeople());*/
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
		}*/
		
		/*Movie[] mostVoted = test.searchMostVotedMovies(n);
		
		for(int i = 0; i<mostVoted.length; i++) {
			System.out.println(mostVoted[i].toString());
		}*/
		
		//test.clear();
		//System.out.println(test.countMovies() + " " + test.countPeople());
		//test.loadFromFile(f);
		//System.out.println(test.countMovies() + " " + test.countPeople());
		/*Person[] mostActive = test.searchMostActiveActors(n);
		for(int i = 0; i<mostActive.length; i++) {
			System.out.println(mostActive[i].toString());
		}*/
		/*Movie[] starredBy = test.searchMoviesStarredBy("leonardo dicaprio");
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
		System.out.println(test.deleteMovieByTitle("The Fugitive"));
		allPerson = test.getAllPeople();
		for(int i = 0; i<allPerson.length; i++) {
			System.out.println(allPerson[i].toString());
		}
		System.out.println(test.countMovies());
		System.out.println(test.countPeople());*/
		
		/*test.setMap(MapImplementation.ABR);
		test.setSort(SortingAlgorithm.MergeSort);
		System.out.println(test.deleteMovieByTitle("Cape Fear"));
		System.out.println(test.deleteMovieByTitle("Pulp Fiction"));
		System.out.println(test.deleteMovieByTitle("Contact"));
		System.out.println(test.deleteMovieByTitle("Die Hard"));
		System.out.println(test.deleteMovieByTitle("The Sixth Sense"));
		System.out.println(test.deleteMovieByTitle("Scarface"));
		System.out.println(test.deleteMovieByTitle("What Lies Beneath"));
		System.out.println(test.deleteMovieByTitle("Air Force One"));
		System.out.println(test.deleteMovieByTitle("The Fugitive"));
		File f2 = new File("FileSalvato.txt");
		test.saveToFile(f2);*/

		/*Person[] collaboration;
		collaboration = test.getDirectCollaboratorsOf(test.getPersonByName("harrison ford"));
		for(int i = 0; i < collaboration.length; i++) {
			System.out.println(collaboration[i].toString());
		}*/
		
		/*Collaboration[]	c = test.getCollab(test.getPersonByName("harrison ford"));
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
		
		/*test.clear();
		Person p = new Person("Harrison Ford");
		Collaboration[] collab = test.maximizeCollaborationsInTheTeamOf(p);
		for(int i = 0; i < collab.length; i++) {
			System.out.println(collab[i].toString());
		}*/
		

	}

}
