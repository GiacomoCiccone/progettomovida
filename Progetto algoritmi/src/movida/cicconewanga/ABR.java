package movida.cicconewanga;

import java.util.Stack;

import movida.eccezioni.*;

public class ABR <K extends Comparable<K>, V extends Object> implements Dictionary<K,V> {
	
	private Nodo root = null;
	private int size = 0;
	
	private final class Nodo extends Entry{
		
		public Nodo left;
		
		public Nodo right;
		
		public Nodo(K key, V value) {
			super(key, value);
			this.left = null;
			this.right = null;	
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return(this.size == 0);
	}

	@Override
	public void clear() {
		this.root.left = this.root.right = this.root = null;
		this.size = 0;
		
	}

	@Override
	public Object search(K key) {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		else {
			Nodo p = this.root;
			while (p != null) {
				if (p.getKey().equals(key))
					return p.getElem();
				else if (p.getKey().compareTo(key) > 0)
					p = p.left;
				else
					p = p.right;
			}
			throw new ChiaveNonValidaEccezione();
		}
	}

	@Override
	public void insert(K key, V value) {
		Nodo p = root, prev = null;
		while (p != null) {
			prev = p;
			if (p.getKey().compareTo(key) < 0)
				p = p.right;
			else
				p = p.left;
		}
		if (root == null)
			root = new Nodo(key, value);
		else if (prev.getKey().compareTo(key) < 0)
			prev.right = new Nodo(key, value);
		else
			prev.left = new Nodo(key, value);
		size++;
		
	}

	@Override
	public void delete(K key) {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		else {
			Nodo predecessore, nodo, p = root, prev = null;
			// Cerca la chiave, se esiste
			while(p != null && !p.getKey().equals(key)) {
				prev = p;
				if(p.getKey().compareTo(key) < 0) p = p.right;
				else p = p.left;
			}
			nodo = p;
			// Se la chiave esiste vede se il nodo che la possiede ha figli oppure no
			if( p != null && p.getKey().equals(key)) {
				if(nodo.right == null) nodo = nodo.left;
				else if(nodo.left == null) nodo = nodo.right;
				// Se il nodo ha due figli cerca il predecessore
				else {
					predecessore = predecessore(nodo.left);
					predecessore.right = nodo.right;  //attacca il sottoalbero destro del nodo da eliminare al destro del predecessore
					nodo = nodo.left;
				}
				
				//elimina i puntatori al nodo da eliminare
				if(p == root) root = nodo;
				else if(prev.left == p) prev.left = nodo;
				else prev.right = nodo;
				this.size--;
			}
			else throw new ChiaveNonValidaEccezione();
		}
		
	}
	
	public Nodo predecessore(Nodo tmp) {
		if(tmp.right == null) return tmp;
		else return predecessore(tmp.right);
	}
	
	@Override
	public Entry[] toArray() {
		if(this.getSize() == 0) throw new DizionarioVuotoEccezione();
		Entry[] arr = new Entry[this.getSize()];
		
		Stack<Nodo> stack = new Stack();
		Nodo curr = this.root;
		int indice = 0;
		
		while(!stack.empty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			else {
				curr = stack.pop();
				arr[indice] = (Entry) curr;
				indice++;
				curr = curr.right;
			}
		}
		
		return arr;
	}


	@Override
	public Boolean Exist(K key) {
		if(this.getSize() == 0) return false;
		else {
			Nodo p = this.root;
			while (p != null) {
				if (p.getKey().equals(key))
					return true;
				else if (p.getKey().compareTo(key) > 0)
					p = p.left;
				else
					p = p.right;
			}
			return false;
		}
	}

}
