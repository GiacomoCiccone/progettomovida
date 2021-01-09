package movida.ciccone;

public class Entry <K extends Comparable<K>, V extends Object> {
	
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
		return getKey() + " : " + getElem();
	}

}
