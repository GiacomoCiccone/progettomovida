package movida.ciccone;


public interface Dictionary< K extends Comparable<K>,V extends Object> {
	
	 public int size();
	 
	 public boolean isEmpty();
	 
	 public Entry<K,V> search(K key);
	 
	 public void insert(K key, V value);
	 
	 public void delete(K key);

	 
	}
