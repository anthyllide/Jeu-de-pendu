package fr.alexandra.model.copy;

import fr.alexandra.controler.Controler;

public class Score {
	
	private int nbError;
	private int score;
	private Controler controler;
	
	public Score() {
		
		this.score = 100;
		this.controler = new Controler();		
	}
	 
	public int getNbError() {
		return nbError;
	}

	public void setNbError(int nbError) {
		this.nbError = nbError;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int nbError) {
		this.score = rules(nbError);
	}
	
	//calcul le score en fonction du nombre d'erreurs
	private int rules(int nbError) {
		int points;
		switch(nbError) {
			case 0 : points = 100;
					break;
			case 1 : points = 60;
					break;
			case 2 : points = 40;
					break;
			case 3 : points = 30;
					break;
			case 4 : points = 20;
					break;
			case 5 : points = 10;
					break;
			case 6 : points = 5;
					break;
			default : points = 0;
					break;
		}
		
		return points;
		
	}

}
