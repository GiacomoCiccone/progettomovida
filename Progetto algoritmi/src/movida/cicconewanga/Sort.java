package movida.cicconewanga;

import java.util.Arrays;
import movida.commons.*;

import java.util.Comparator;



public class Sort <T> {
	/**
	 * Classe che implementa gli algoritmi di ordinamento
	 * e gestisce il modo in cui vogliamo ordinare gli elementi
	 */
	
	/**
	 * Questa funzione si usa per decidere quale algoritmo di ordinamento utilizzare
	 * In base al valore che passiamo chiama selectionSort oppure mergeSort
	 */
	public <T> void selectedSort(T V[], SortingAlgorithm algo, Comparator<T> comparator) {
		if(algo.equals(SortingAlgorithm.SelectionSort)) selectionSort(V, comparator);
		else mergeSort(V, comparator);
	}
	
	/**
	 * Ordina gli elementi di un vettore in O(N^2)
	 * Fa uso di un comparator per decidere in base a cosa ordinare
	 */
	private static <T> void selectionSort(T V[], Comparator<T> comparator) {
		for (int i = 0; i < V.length - 1; i++) {
			int m = i;
			for (int j = i + 1; j < V.length; j++) {
				if (comparator.compare(V[j], V[m]) < 0) m = j;
				}
			if (m != i) {
				T temp = V[m];
				V[m] = V[i];
				V[i] = temp;
			}
		}
	}
	
	/**
	 * Ordina gli elementi ricorsivamente in tempo O(NlogN) e spazio O(N)
	 * Fa uso di un comparator per decidere in base a cosa ordinare
	 */
	private static <T> void mergeSort(T V[], Comparator<T> comparator) {
		mergeRec(V, comparator, 0, V.length -1);
		
	}
	
	private static <T> void mergeRec(T V[], Comparator<T> comparator, int i, int f) {
		if (i < f) {
			int m = (i + f) / 2;
			mergeRec(V, comparator, i, m);
			mergeRec(V, comparator, m + 1, f);
			merge(V, comparator, i, m, f);
		}
	}
	
	private static <T> void merge(T V[], Comparator<T> comparator, int i1, int f1, int f2) {
		T[] X = (T[]) new Object[f2 - i1 + 1];
		int i = 0, 
		i2 = f1 + 1, 
		k = i1;
		while (i1 <= f1 && i2 <= f2) {
			if (comparator.compare(V[i1], V[i2]) < 0) X[i++] = V[i1++];
			else X[i++] = V[i2++];
		}
		if (i1 <= f1)
			for (int j = i1; j <= f1; j++, i++) X[i] = V[j];
		else for (int j = i2; j <= f2; j++, i++) X[i] = V[j];
		for (int t = 0; k <= f2; k++, t++) V[k] = X[t];
	}
	
	
	
	
	
	public static class sortMovieByTitle implements Comparator<Entry>{
		/**
		 * Classe che estende comparator per ordinare film in base al titolo
		 */
		@Override
		public int compare(Entry o1, Entry o2) {
			Movie a, b;
			a = (Movie) o1.getElem();
			b = (Movie) o2.getElem();
			return(a.getTitle().compareToIgnoreCase(b.getTitle()));
		}
		
	}
		
	public static class sortMovieByYear implements Comparator<Entry>{
		/**
		 * Classe che estende comparator per ordinare film in base all'anno di uscita
		 */	
		@Override
		public int compare(Entry o1, Entry o2) {
			Movie a, b;
			a = (Movie) o1.getElem();
			b = (Movie) o2.getElem();
			return(a.getYear().compareTo(b.getYear()));
		}
		
	}
	
	public static class sortMovieByVotes implements Comparator<Entry>{
		/**
		 * Classe che estende comparator per ordinare film in base ai voti
		 */
		@Override
		public int compare(Entry o1, Entry o2) {
			Movie a, b;
			a = (Movie) o1.getElem();
			b = (Movie) o2.getElem();
			return(a.getVotes().compareTo(b.getVotes()));
		}
	
	}
	
	public static class sortByKey implements Comparator<Entry>{
		/**
		 * Classe che estende comparator per un oggetto Entry in base alla sua chiave
		 */
		@Override
		public int compare(Entry x1, Entry x2) {
				return ( x1.getKey()).compareTo(x2.getKey() );
		}
		
	}
	
	public static class sortPersonByActivities implements Comparator<Entry>{
		/**
		 * Classe che estende comparator per persone in base al numero di comparse
		 */
		@Override
		public int compare(Entry o1, Entry o2) {
			Person a, b;
			a = (Person) o1.getElem();
			b = (Person) o2.getElem();
			return(a.getComparse().compareTo(b.getComparse()));
		}
	
	}

	
}
