package movida.cicconewanga;

public class Entry <K extends Comparable<K>, V extends Object> {
	/**
	 * La classe Entry rappresenta il formato dei record nel dizionario
	 * Ogni entry ha un K che sarebbe la chiave ed un V che rappresenta l'elemento
	 */
	
	private K key;
	private V value;
	
	public Entry (K key, V value) 
	{
		this.key = key;
		this.value = value;
	}
	
	public K getKey() 
	{
		return key;
	}
	
	public V getElem() 
	{
		return value;
	}
	
	@Override
	public String toString() 
	{
		return "Key: " + getKey() + " Value: " + getElem();
	}

}
