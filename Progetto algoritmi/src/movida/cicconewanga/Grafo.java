package movida.cicconewanga;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import movida.cicconewanga.Sort.sortPersonByActivities;
import movida.commons.Collaboration;
import movida.commons.Movie;
import movida.commons.Person;

public class Grafo {
	
	private class Nodo extends Object{
		
		public Person vertice;
		public LinkedList<Collaboration> adiacenze;
		public boolean marked = false;
		public Nodo parent = null;
		public Double dist = 0.0;
		public Collaboration ActiveCollab;
		
		public Nodo(Person p) {
			this.vertice = p;
			this.adiacenze = new LinkedList<Collaboration>();
		}
		
		public void setTrue() {
			this.marked = true;
		}
		
		public void setParent(Nodo parent) {
			this.parent = parent;
		}
		
		public void setDist(Double d) {
			this.dist = d;
		}
		
		public Double getDist() {
			return this.dist;
		}
		
		public void setActiveCollab(Collaboration c) {
			this.ActiveCollab = c;
		}
		
		public Collaboration getActiveCollab() {
			return this.ActiveCollab;
		}
		
	}
	
	
	private LinkedList<Nodo> grafo = new LinkedList<Nodo>();
	int nodi = 0;
	int archi = 0;
	
	private void setAllFalse() {
		for(Nodo n : grafo) n.marked = false;
	}
	
	private void setToInfinity() {
		for(Nodo n : grafo) n.dist = Double.NEGATIVE_INFINITY;
	}
	
	
	public int getNodi() {
		return this.nodi;
	}
	
	public int getArchi() {
		return this.archi/2;
	}
	
	public void insert(Collaboration c, Movie m) {
		Person A = c.getActorA();
		Person B = c.getActorB();
		if(!this.exist(A)) {
			Nodo A1 = new Nodo(A);
			A1.vertice = A;
			A1.adiacenze.add(c);
			this.archi++;
			c.addCollab(m);
			this.grafo.add(A1);
			this.nodi++;
		}
		else {
			Nodo A1 = null;
			for(int i = 0; i < this.nodi; i++) {
				if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(A.getName()))
					A1 = this.grafo.get(i);
			}
			Boolean flag = false;
			for(int i = 0; i < A1.adiacenze.size(); i++) {
				if(A1.adiacenze.get(i).getActorB().getName().equalsIgnoreCase(B.getName())
						|| A1.adiacenze.get(i).getActorA().getName().equalsIgnoreCase(B.getName()))
				{A1.adiacenze.get(i).addCollab(m); flag = true;}
			}
			if(!flag) {
				A1.adiacenze.add(c);
				c.addCollab(m);
				this.archi++;
			}
		}
		if(!this.exist(B)) {
			Nodo B1 = new Nodo(B);
			B1.vertice = B;
			B1.adiacenze.add(c);
			c.addCollab(m);
			this.archi++;
			this.grafo.add(B1);
			this.nodi++;
		}
		else {
			Nodo B1 = null;
			for(int i = 0; i < this.nodi; i++) {
				if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(B.getName()))
					B1 = this.grafo.get(i);
			}
			Boolean flag2 = false;
			for(int i = 0; i < B1.adiacenze.size(); i++) {
				if(B1.adiacenze.get(i).getActorA().getName().equalsIgnoreCase(A.getName())
						|| B1.adiacenze.get(i).getActorB().getName().equalsIgnoreCase(A.getName()))
				{B1.adiacenze.get(i).addCollab(m); flag2 = true;}
			}
			if(!flag2) {
				B1.adiacenze.add(c);
				this.archi++;
			}
		}
	}
	
	//vede se un nodo e' gia' presente nel grafo
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
				collabToDelete.add(toDelete.adiacenze.get(i).getActorA());
		}
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
				else if(tmp.adiacenze.get(k).getActorB().getName().equalsIgnoreCase(A.getName()))
						{tmp.adiacenze.remove(k); this.archi--;}
			}
		}
		//elimina gli archi relativi al nodo e lo elimina
		this.archi -= toDelete.adiacenze.size();
		toDelete.adiacenze = null;
		this.grafo.remove(toDeleteIndex);
		this.nodi--;
	}
	
	
	//ritorna le collaborazioni dirette di P
	public Person[] search(Person P) {
		Nodo toSearch = null;
		Person[] tmp = null;
		for(int i = 0; i < this.nodi; i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(P.getName())) {
				tmp = new Person[this.grafo.get(i).adiacenze.size()];
				toSearch = this.grafo.get(i);
				break;
			}
		}
		for(int j = 0; j < tmp.length; j++) {
			if(toSearch.adiacenze.get(j).getActorA().getName().equalsIgnoreCase(P.getName()))
				tmp[j] = toSearch.adiacenze.get(j).getActorB();
			else
				tmp[j] = toSearch.adiacenze.get(j).getActorA();
		}

		return tmp;
	
	}
	
	public Collaboration[] getCollab(Person P) {
		LinkedList<Collaboration> collab = null;
		for(int i = 0; i < this.nodi; i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(P.getName()))
				{collab = this.grafo.get(i).adiacenze; break;}
		}
		Collaboration[] collabArray = new Collaboration[collab.size()];
		for(int i = 0; i < collab.size(); i++) {
			collabArray[i] = collab.get(i);
		}
		return collabArray;
	}

	public Person[] BFS(Person P) {
		Nodo source = null;
		for(int i = 0; i < this.grafo.size(); i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(P.getName()))
				{source = this.grafo.get(i); break;}
		}
		this.setAllFalse();
		LinkedList<Person> teamList = new LinkedList<Person>();
		Queue<Nodo> queue = new LinkedList<Nodo>();
		queue.add(source);
		source.setTrue();
		while(queue.size() > 0) {
			Nodo tmp = queue.remove();
			teamList.add(tmp.vertice);
			for(Collaboration c : tmp.adiacenze) {
				Nodo toAdd;
				if(c.getActorA().getName().equalsIgnoreCase(tmp.vertice.getName())) {
					Person toAddP = c.getActorB();
					for(int i = 0; i < this.grafo.size(); i++) {
						if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(toAddP.getName())) {
							toAdd = this.grafo.get(i);
							if(!toAdd.marked) {
								queue.add(toAdd);
								toAdd.setTrue();
							}
							
						}
					}
				}
				else {
					Person toAddP = c.getActorA();
					for(int i = 0; i < this.grafo.size(); i++) {
						if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(toAddP.getName())) {
							toAdd = this.grafo.get(i);
							if(!toAdd.marked) {
								queue.add(toAdd);
								toAdd.setTrue();
							}
							
						}
					}
				}
			}
		}
		Person[] team = new Person[teamList.size()];
		for(int i = 0; i < team.length; i++) {
			team[i] = teamList.get(i);
		}
		return team;
		
	}
	
	public Collaboration[] MST(Person p) {
		LinkedList<Collaboration> collab = new LinkedList<Collaboration>();
		Nodo source = this.cercaNodo(p);
		this.setAllFalse();
		this.setToInfinity();
		Queue<Nodo> maxQueue = new PriorityQueue<Nodo>(new Grafo.sortByVotes().reversed());
		source.setDist(0.0);
		maxQueue.add(source);
		source.setTrue();
		while(maxQueue.size() > 0) {
			Nodo u = maxQueue.remove();
			if(!collab.contains(u.getActiveCollab()) && u.ActiveCollab != null)
				collab.add(u.getActiveCollab());
			for(Collaboration c : u.adiacenze) {
				Nodo toAdd;
				if(c.getActorA().getName().equalsIgnoreCase(u.vertice.getName())) {
					Person toAddP = c.getActorB();
					toAdd = this.cercaNodo(toAddP);
					if(!toAdd.marked) {
						toAdd.setDist(c.getScore());
						toAdd.setActiveCollab(c);
						toAdd.parent = u;
						maxQueue.add(toAdd);
						toAdd.setTrue();
					}
					else if(toAdd.dist < c.getScore()) {
						maxQueue.remove(toAdd);
						toAdd.setDist(c.getScore());
						toAdd.setActiveCollab(c);
						toAdd.parent = u;
						maxQueue.add(toAdd);
					}
				}
				else {
					Person toAddP = c.getActorA();
					toAdd = this.cercaNodo(toAddP);
					if(!toAdd.marked) {
						toAdd.setDist(c.getScore());
						toAdd.setActiveCollab(c);
						toAdd.parent = u;
						maxQueue.add(toAdd);
						toAdd.setTrue();
					}
					else if(toAdd.dist < c.getScore()) {
						maxQueue.remove(toAdd);
						toAdd.setDist(c.getScore());
						toAdd.setActiveCollab(c);
						toAdd.parent = u;
						maxQueue.add(toAdd);
					}
				}
			}
			
		}
		Collaboration[] collabArray = new Collaboration[collab.size()];
		for(int i = 0; i < collabArray.length; i++) {
			collabArray[i] = collab.get(i);
		}
		return collabArray;
	}
	
	private Nodo cercaNodo(Person p) {
		for(int i = 0; i < this.grafo.size(); i++) {
			if(this.grafo.get(i).vertice.getName().equalsIgnoreCase(p.getName()))
				return this.grafo.get(i);
		}
		
		return null;
	}
	
	
	public static class sortByVotes implements Comparator<Nodo>{
		
		@Override
		public int compare(Nodo n1, Nodo n2) {
				return (n1.getDist()).compareTo(n2.getDist());
		}
		
	}
	
	
}
