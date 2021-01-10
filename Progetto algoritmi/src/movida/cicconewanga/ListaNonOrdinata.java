package movida.cicconewanga;

import java.lang.reflect.Array;

import movida.eccezioni.*;

public class ListaNonOrdinata <K extends Comparable<K>, V extends Object> implements Dictionary<K, V> {
	
	private Record list = null;
	private int size = 0;
	private Boolean insertTail = false;
	
	private final class Record extends Entry{
    	 
        public Record next;
        
        public Record prev;
        
        public Record(K key, V value) {
            super(key, value);
            next = prev = null;
        }
    }

	
	public ListaNonOrdinata() {
		this.insertTail = insertTail;
	}
	
	public ListaNonOrdinata(Boolean insertTail) {
		this.insertTail = insertTail;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Object search(K key) {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		else {
			Record tmp = this.list;
			while(true) {
				if(tmp.getKey().equals(key)) return (tmp.getElem());
				else {
					tmp = tmp.next;
					if(tmp == this.list) throw new ChiaveNonValidaEccezione();
				}
			}
		}
	}

	@Override
	public void insert(K key, V value) {
		if (this.insertTail) { this.tailInsert(key, value); return;}
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
	
	public void tailInsert(K key, V value) {
		Record tmp = new Record(key, value);
		if (list == null) list = tmp.prev = tmp.next = tmp;
		else {
			tmp.next = list;
			tmp.prev = list.prev;
			list.prev.next = tmp;
			list.prev = tmp;
		}
		size++;
	}

	@Override
	public void delete(K key) {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		else if(this.list.getKey().equals(key)) {
			if(this.list == this.list.next && this.list == this.list.prev)
				this.list = this.list.prev = this.list.next = null;
			else {
				this.list.prev.next = this.list.next;
				this.list.next.prev = this.list.prev;
				this.list = this.list.next;
			}
			this.size--;
		}
		else {
			Record tmp = this.list.next;
			while(true) {
				if(tmp.getKey().equals(key)) {
					tmp.next.prev = tmp.prev;
					tmp.prev.next = tmp.next;
					this.size--;
					break;
				}
				tmp = tmp.next;
				if(tmp == this.list) throw new ChiaveNonValidaEccezione();
			}
		}
	}
	
	@Override
	public void clear() {
		this.list = this.list.prev = this.list.next = null;
		this.size = 0;
	}
	
	@Override
	public String toString() {
		String S = "";
		Record tmp = this.list;
		if(this.getSize() != 0) {
			while(true) {
				S = S + ("[Key: " + tmp.getKey() + ", Value: " + tmp.getElem() + "] \n");
				tmp = tmp.next;
				if(tmp == this.list) break;
			}
		}
		return S;
		
	}
	

	@Override
	public Entry[] toArray() {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		Entry[] arr = new Entry[this.getSize()];
		Record tmp = this.list; 		
		int i = 0;
		while (true) {
			arr[i] = (Entry)tmp;
			i++;
			tmp = tmp.next;
			if(tmp == this.list) break;
		}

		return arr;
	}
	
	@Override
	public Object[] valuesToArray() {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		Object[] arr = new Object[this.getSize()];
		Record tmp = this.list;
		int i = 0;
		while(true) {
			arr[i] = tmp.getElem();
			i++;
			tmp = tmp.next;
			if(tmp == this.list) break;
		}
		
		return arr;
	}

}
