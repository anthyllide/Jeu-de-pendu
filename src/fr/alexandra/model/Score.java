package fr.alexandra.model;

import java.util.Observable;
import java.util.Observer;

import fr.alexandra.observer.Observateur;

//la classe score surveille la classe GamePanel
public class Score implements Observateur {
	
	private int nbError;
	private int score;
	
	
	 
	public int getNbError() {
		return nbError;
	}



	public void setNbError(int nbError) {
		this.nbError = nbError;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	@Override
	public void update(int nbError) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	

}
