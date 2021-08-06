package movida.cicconewanga;

public interface Dictionary< K extends Comparable<K>,V extends Object> {
	/**
	 * 
	 * Funzione che ritorna il numero di elementi presenti nel dizionario
	 */
	 public int getSize();
	 /**
	  * 
	  * Controlla se il dizionario e' vuoto
	  */
	 public boolean isEmpty();
	 /**
	  * Elimina tutti i record presenti nel dizionario
	  */
	 public void clear();
	 /**
	  * 
	  * Ricerca se e' presente un elemento con chiave K
	  * Se esiste lo restituisce, altreimenti lancia un'eccezione
	  */
	 public Object search(K key);
	 /**
	  * Inserisce l'elemento con valore V e chiave K
	  */
	 public void insert(K key, V value);
	 /**
	  * Elimina l'elemento con chiave K
	  * Se non e' presente lancia un eccezione
	  */
	 public void delete(K key);
	 /**
	  * Trasforma il dizionario in un array e lo restituisce
	  */
	 public Entry[] toArray();
	 /**
	  * Controlla se esiste un elemento con chiave K
	  * Se esiste restituisce true, altrimenti false
	  */
	 public Boolean Exist(K key);

	 
	}

