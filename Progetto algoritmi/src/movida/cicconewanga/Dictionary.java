package movida.cicconewanga;

public interface Dictionary< K extends Comparable<K>,V extends Object> {
	
	 public int getSize();
	 
	 public boolean isEmpty();
	 
	 public void clear();
	 
	 public Object search(K key);
	 
	 public void insert(K key, V value);
	 
	 public void delete(K key);

	 public Entry[] toArray();
	 
	 public Object[] valuesToArray();

	 
	}

