/* 
 * Copyright (C) 2020 - Angelo Di Iorio
 * 
 * Progetto Movida.
 * Corso di Algoritmi e Strutture Dati
 * Laurea in Informatica, UniBO, a.a. 2019/2020
 * 
*/
package movida.commons;

/**
 * Classe usata per rappresentare una persona, attore o regista,
 * nell'applicazione Movida.
 * 
 * Una persona � identificata in modo univoco dal nome 
 * case-insensitive, senza spazi iniziali e finali, senza spazi doppi. 
 * 
 * Semplificazione: <code>name</code> � usato per memorizzare il nome completo (nome e cognome)
 * 
 * La classe pu˜ essere modicata o estesa ma deve implementare il metodo getName().
 * 
 */
public class Person {

	private String name;
	private Integer numeroComparse = 0;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void increaseComparse() {
		this.numeroComparse+=1;
	}
	
	public Integer getComparse() {
		return this.numeroComparse;
	}
	
	public void dcreaseComparse() {
		if(this.numeroComparse>0) this.numeroComparse-=1;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public String toString() {
		return name;
		
	}
	
}
