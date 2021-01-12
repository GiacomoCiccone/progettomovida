package movida.commons;

import java.util.ArrayList;

public class Collaboration {

	Person actorA;
	Person actorB;
	ArrayList<Movie> movies;
	
	public Collaboration(Person actorA, Person actorB) {
		this.actorA = actorA;
		this.actorB = actorB;
		this.movies = new ArrayList<Movie>();
	}

	public Person getActorA() {
		return actorA;
	}

	public Person getActorB() {
		return actorB;
	}

	public Double getScore(){
		
		Double score = 0.0;
		
		for (Movie m : movies)
			score += m.getVotes();
		
		return score / movies.size();
	}
	
	public void addCollab(Movie m) {
		for(int i = 0; i < this.movies.size(); i++) {
			if(this.movies.get(i).getTitle().equalsIgnoreCase(m.getTitle())) return;
		}
		this.movies.add(m);
	}
	
	public void removeCollab(Movie m) {
		for(int i = 0; i < this.movies.size(); i++) {
			if(this.movies.get(i).getTitle().equalsIgnoreCase(m.getTitle()))
				{this.movies.remove(i); return;}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Le collaborazioni tra " + this.actorA.getName() + " e " + this.actorB.getName() + " includono i film:\n";
		for(Movie m : movies)
			s += m.getTitle() + "\n";
		s += "Con uno score pari a: " + this.getScore();
		return s;
	}
}
