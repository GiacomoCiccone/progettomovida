package movida.ciccone;


public class ListaNonOrdinata <K extends Comparable<K>, V extends Object> implements Dictionary<K, V> {
	
	private Record list = null;
	private int size = 0;
	
	private final class Record extends Entry{
    	
        
        public Record next;
        
        public Record prev;
        
        public Record(K key, V value) {
            super(key, value);
            next = prev = null;
        }
    }

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Entry<K, V> search(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(K key, V value) {
		Record tmp = new Record(key, value);
        if (list == null)
            list = tmp.prev = tmp.next = tmp;
        else {
            tmp.next = list.next;
            list.next.prev = tmp;
            list.next = tmp;
            tmp.prev = list;
        }
        size++;
	}

	@Override
	public void delete(K key) {
	}


}
