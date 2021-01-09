package movida.ciccone;

import java.util.Arrays;
import movida.commons.*;
import java.util.Comparator;



public class Sort <T> {
	
	
	public static <T> void selectionSort(T V[], Comparator<T> comparator) {
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
		
	public static <T> void mergeSort(T V[], Comparator<T> comparator) {
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
		
	public static class sortMovieByTitle implements Comparator<Movie>{
		
		@Override
		public int compare(Movie o1, Movie o2) {
			String a, b;
			a = o1.getTitle();
			b = o2.getTitle();
			return(a.compareToIgnoreCase(b));
		}
		
	}
		
	public static class sortMovieByYear implements Comparator<Movie>{
			
		@Override
		public int compare(Movie o1, Movie o2) {
			Integer a, b;
			a = o1.getYear();
			b = o2.getYear();
			return(a.compareTo(b));
		}
		
	}
	
	public static class sortMovieByVotes implements Comparator<Movie>{
		
		@Override
		public int compare(Movie o1, Movie o2) {
			Integer a, b;
			a = o1.getVotes();
			b = o2.getVotes();
			return(a.compareTo(b));
		}
	
	}

	
}
