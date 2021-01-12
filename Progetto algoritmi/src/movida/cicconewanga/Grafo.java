package movida.cicconewanga;

import java.util.LinkedList;

import movida.commons.Collaboration;
import movida.commons.Person;

public class Grafo {
	
	private class Nodo {
		
		public Person vertice = null;
		public LinkedList<Collaboration> adiacenze = null;
		boolean marked = false;
		
		public Nodo(Person p) {
			this.vertice = p;
			this.adiacenze = new LinkedList<Collaboration>();
		}
		
	}
	
	private LinkedList<Nodo> grafo = new LinkedList<Nodo>();
	int nodi = 0;
	int archi = 0;
	
	public int getNodi() {
		return this.nodi;
	}
	
	public int getArchi() {
		return this.archi;
	}
	
	public void insert(Collaboration c) {
		Person A = c.getActorA();
		Person B = c.getActorB();
		if(!this.exist(A)) {
			Nodo A1 = new Nodo(A);
			A1.vertice = A;
			A1.adiacenze.add(c);
			this.grafo.add(A1);
			this.nodi++;
		}
		else {
			Nodo A1 = null;
			for(int i = 0; i < this.nodi; i++) {
				if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(A.getName()))
					A1 = this.grafo.get(i);
			}
			for(int i = 0; i < A1.adiacenze.size(); i++) {
				if(A1.adiacenze.get(i).getActorB().getName().equalsIgnoreCase(B.getName())
						|| A1.adiacenze.get(i).getActorA().getName().equalsIgnoreCase(B.getName()))
				{A1.adiacenze.remove(i); this.archi--;}
			}
			A1.adiacenze.add(c);
			this.archi++;
		}
		if(!this.exist(B)) {
			Nodo B1 = new Nodo(B);
			B1.vertice = B;
			B1.adiacenze.add(c);
			this.grafo.add(B1);
			this.nodi++;
		}
		else {
			Nodo B1 = null;
			for(int i = 0; i < this.nodi; i++) {
				if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(B.getName()))
					B1 = this.grafo.get(i);
			}
			for(int i = 0; i < B1.adiacenze.size(); i++) {
				if(B1.adiacenze.get(i).getActorA().getName().equalsIgnoreCase(A.getName())
						|| B1.adiacenze.get(i).getActorB().getName().equalsIgnoreCase(A.getName()))
				{B1.adiacenze.remove(i); this.archi--;}
			}
			B1.adiacenze.add(c);
			this.archi++;
		}
	}
	
	private boolean exist(Person A) {
		for(int i = 0; i < this.nodi; i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(A.getName())) return true;
		}
		return false;
	}
	
	public void delete(Person A) {
		Nodo toDelete = null;
		int toDeleteIndex = 0;
		//trova nodo da eliminare
		
		for(int i = 0; i < this.nodi; i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(A.getName()))
				{toDelete = this.grafo.get(i); toDeleteIndex = i; break;}
		}
		//trova lista persone collegate a questo nodo
		LinkedList<Person> collabToDelete = new LinkedList<Person>();
		for(int i = 0; i < toDelete.adiacenze.size(); i++) {
			if(toDelete.adiacenze.get(i).getActorA().getName().equalsIgnoreCase(A.getName()))
				collabToDelete.add(toDelete.adiacenze.get(i).getActorB());
			else if(toDelete.adiacenze.get(i).getActorB().getName().equalsIgnoreCase(A.getName()))
				collabToDelete.add(toDelete.adiacenze.get(i).getActorB());
		}
		System.out.println(collabToDelete.toString());
		//elimina le collaborazioni per ognuna di esse
		for(int i = 0; i < collabToDelete.size(); i++) {
			Nodo tmp = null;
			for(int j = 0; j < this.nodi; j++) {
				if(this.grafo.get(j).vertice.getName().equalsIgnoreCase(collabToDelete.get(i).getName()))
					{tmp = this.grafo.get(j);
					break;}
			}
			for(int k = 0; k < tmp.adiacenze.size(); k++) {
				if(tmp.adiacenze.get(k).getActorA().getName().equalsIgnoreCase(A.getName()))
					{tmp.adiacenze.remove(k); this.archi--;}
			}
		}
		//elimina gli archi relativi al nodo e lo elimina
		this.archi -= toDelete.adiacenze.size();
		toDelete.adiacenze = null;
		this.grafo.remove(toDeleteIndex);
		this.nodi--;
	}
	
	public Collaboration[] search(Person P) {
		for(int i = 0; i < this.nodi; i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(P.getName())) {
				Collaboration[] tmp = new Collaboration[this.grafo.get(i).adiacenze.size()];
				for(int j = 0; j < tmp.length; j++) {
					tmp[j] = this.grafo.get(i).adiacenze.get(j);
				}
				return tmp;
			}
		}
		return null;
	}
	
	
	
}
