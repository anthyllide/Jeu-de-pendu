package fr.alexandra.controler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.alexandra.model.Score;
import fr.alexandra.model.Word;
import observer.Observable;
import observer.Observer;


public class Controler implements Observable<Integer> {
	
	private Word word;
	private Score scoreObject;
	private static String hideWord;
	private List <String> lettersTable = new <String> ArrayList();
	private List <String> lettersNewWord = new <String> ArrayList();
	private JLabel gameWord;
	private int i = 1;
	private int nbError = 0;
	private ImageIcon urlImage;
	private int score;
	private int gameState = 0; //1 si gagné, 2 si perdu
	private boolean gagne = false;
	private List<Observer<Integer>> observers = new ArrayList<>();
	public Controler() {}
	
	public Controler(Word w) {
		setHideWord(w);
		this.scoreObject = new Score();
		this.score = scoreObject.getScore();
	}
	
	public JLabel getGameWord() {
		return gameWord;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getNbError() {
		return nbError;
	}
		
	public ImageIcon getUrlImage() {
		return urlImage;
	}
		
	public void setNbError() {
		this.nbError = this.nbError + 1;
	}
	
	public static String getHideWord() {
		return hideWord;
	}
	
	//construit le mot caché lors d'une nouvelle partie 
	public void setHideWord(Word word) {
		
		this.lettersTable = word.getLetters();
		String str = " --- ";
		
		while( i < lettersTable.size()) {
			
			i++;
			str += " --- ";
		}
		
		this.hideWord = str;			
	}
	
	public int getGameState () {
		return gameState;
	}
		
	public void setGameState(int value) {
		
		this.gameState = value;		
			
	    notifyObservers(gameState);
	}
	
	//vérifie que la lettre sélectionnée par le joueur est dans le mot ou pas
	//si la lettre fait partie du mot, elle ajoute la/les lettre(s) au mot
	public void letterInWord (String letter) {
			
	if(nbError <= 7) {
		
		//si le tableau de lettres contient la lettre sélectionnée et le tableau du mot caché est vide
		if(lettersTable.contains(letter) && lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && lettersNewWord.isEmpty()) {
			
			for(int j=0; j < lettersTable.size(); j++) {
				
				addLetters(j, letter);
				this.hideWord = String.join(" ", lettersNewWord).toUpperCase();			
				System.out.println("nouveau mot1 :" + hideWord);		
			}
		
		//si le tableau de lettre contient la lettre choisie et le tableau du mot caché 
		//n'est pas vide (à partir de la deuxième lettre trouvée)	
		} else if (lettersTable.contains(letter) && !lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && !lettersNewWord.isEmpty()) {
					
			for(int j=0; j < lettersTable.size(); j++) {
				setLetters(j,letter);								
			}
			
			this.hideWord = String.join(" ",lettersNewWord).toUpperCase();
			String str = String.join(" ",lettersTable).toUpperCase();
			
			//si le joueur trouve le mot
			if(lettersNewWord.equals(lettersTable)){
				setGameState(1);
			}
			
			System.out.println("nouveau mot2 :" + hideWord);
			System.out.println("compare " + String.join(" ",lettersTable).toUpperCase());
			
			//si le joueur sélectionne une lettre n'appartenant pas au tableau de lettres	
		} else {
			//on modifie le nb d'erreur, on change l'image du pendu et on modifie le score	
			setNbError();
			changeImage(nbError);			
			scoreObject.setScore(nbError);
			this.score = scoreObject.getScore();
			System.out.println("nombre d'erreurs :" + nbError);
			System.out.println("nouveau score :" + score);
			
			if(getNbError() == 7) {
				setGameState(2);
				System.out.println("perdu : " + getGameState());
			}
				
		}
	}
		
	}

	//permet de détecter si le mot caché posséde une lettre accentuée
	private boolean compareLetter(String letter, List<String> lettersTable2) {
		if(letter == "E") {
			if(lettersTable2.contains("É") || lettersTable2.contains("È") || 
					lettersTable2.contains("Ê") || lettersTable2.contains("Ë")) {
				return true;
			}
		} else if(letter == "A") {
			if(lettersTable2.contains("Â") || lettersTable2.contains("Ä") || lettersTable2.contains("À")) {
				return true;
			}
		} else if (letter == "I") {
			if(lettersTable2.contains("ï")|| lettersTable2.contains("Î" )) {
				return true;
			}
		} else if(letter == "O") {
			if(lettersTable2.contains("Ô") || lettersTable2.contains("Ö")) {
				return true;
			}
		} else if(letter == "U") {
			if(lettersTable2.contains("Û") || lettersTable2.contains("Ü")) {
				return true;
			}
		} else if (letter == "C") {
			if(lettersTable2.contains("Ç")) {
				return true;
			}
		}
		
		return false;
	}
	
	//Ajoute une/ou plusieurs lettre(s) à la première bonne tentative
	private void addLetters(int j, String letter) {
		
		if(lettersTable.get(j).equals("É") && letter == "E") {
			
			lettersNewWord.add(j,"É");
			
		} else if (lettersTable.get(j).equals("È") && letter == "E") {
			
			lettersNewWord.add(j,"È");
			
		} else if (lettersTable.get(j).equals("Ê") && letter == "E"){						
			
			lettersNewWord.add(j,"Ê");
		
		} else if (lettersTable.get(j).equals("Ê") && letter == "E"){	
			
			lettersNewWord.add(j,"Ë");
		
		} else if(lettersTable.get(j).equals("Ä") && letter == "A") {
			lettersNewWord.add(j,"Ä");
			
		} else if(lettersTable.get(j).equals("Â") && letter == "A") {
			
			lettersNewWord.add(j,"Â");
			
		} else if(lettersTable.get(j).equals("À") && letter == "A") {	
			
			lettersNewWord.add(j,"À");
			
		} else if(lettersTable.get(j).equals("ï") && letter == "I") {
			
			lettersNewWord.add(j, "ï");
			
		} else if(lettersTable.get(j).equals("Î") && letter == "I") {
			
			lettersNewWord.add(j, "Î");
			
		} else if(lettersTable.get(j).equals("Ô") && letter == "O") {
			
			lettersNewWord.add(j, "Ô");
			
		}  else if(lettersTable.get(j).equals("Ö") && letter == "O") {
			
			lettersNewWord.add(j, "Ö");
			
		}  else if(lettersTable.get(j).equals("Û") && letter == "U") {
			
			lettersNewWord.add(j, "Û");
			
		}  else if(lettersTable.get(j).equals("Ü") && letter == "U") {
			
			lettersNewWord.add(j, "Ü");
			
		} else if (lettersTable.get(j).equals("Ç") && letter == "C"){
			
			lettersNewWord.add(j, "Ç");
			
		} else if (lettersTable.get(j).equals(letter)) {
				
			lettersNewWord.add(j, letter);												
		} else {
			
			lettersNewWord.add(j,"---");
		}	
		
	}
	
	//modifie le mot caché si une lettre dans le mot après la première tentative
	private void setLetters(int j, String letter) {
		if(lettersTable.get(j).equals("É") && letter == "E") {
			
			lettersNewWord.set(j,"É");
			
		} else if (lettersTable.get(j).equals("È") && letter == "E") {
			
			lettersNewWord.set(j,"È");
			
		} else if (lettersTable.get(j).equals("Ê") && letter == "E"){						
			
			lettersNewWord.set(j,"Ê");
		
		} else if (lettersTable.get(j).equals("Ê") && letter == "E"){	
			
			lettersNewWord.set(j,"Ë");
		
		} else if(lettersTable.get(j).equals("Ä") && letter == "A") {
			
			lettersNewWord.set(j,"Ä");
			
		} else if(lettersTable.get(j).equals("Â") && letter == "A") {
			
			lettersNewWord.set(j,"Â");
			
		} else if(lettersTable.get(j).equals("À") && letter == "A") {	
			
			lettersNewWord.set(j,"À");
			
		} else if(lettersTable.get(j).equals("Ï") && letter == "I") {
			
			lettersNewWord.set(j, "ï");
			
		} else if(lettersTable.get(j).equals("Î") && letter == "I") {
			
			lettersNewWord.set(j, "Î");
			
		} else if(lettersTable.get(j).equals("Ô") && letter == "O") {
			
			lettersNewWord.set(j, "Ô");
			
		}  else if(lettersTable.get(j).equals("Ö") && letter == "O") {
			
			lettersNewWord.set(j, "Ö");
			
		}  else if(lettersTable.get(j).equals("Û") && letter == "U") {
			
			lettersNewWord.set(j, "Û");
			
		}  else if(lettersTable.get(j).equals("Ü") && letter == "U") {
			
			lettersNewWord.set(j, "Ü");
			
		} else if (lettersTable.get(j).equals("Ç") && letter == "C"){
			
			lettersNewWord.set(j, "Ç");
		}else if (lettersTable.get(j).equals(letter)) {
			
		lettersNewWord.set(j, letter);	
		} 
	}
	//change l'image du pendu quand le joueur ne saisit pas les bonnes lettres
	private void changeImage(int nbError) {
		
		switch (nbError) {
			case 1 : this.urlImage = new ImageIcon("images/pendu2.jpg");
					break;
			case 2 : this.urlImage = new ImageIcon("images/pendu3.jpg");
					break;
			case 3 : this.urlImage = new ImageIcon("images/pendu4.jpg");
					break;
			case 4 : this.urlImage = new ImageIcon("images/pendu5.jpg");
					break;
			case 5:	this.urlImage = new ImageIcon("images/pendu6.jpg");
					break;
			case 6 : this.urlImage = new ImageIcon("images/pendu7.jpg");
					break;
			case 7 : this.urlImage = new ImageIcon("images/pendu9.jpg");
					break;
			default: urlImage = new ImageIcon("images/pendu9.jpg");
            		break;
		}
	}
	
	//permet de comparer les valeurs de deux tableaux
	public boolean compareTable(List <String> a, List <String> b) {
		boolean test = false;
		for(String strA : a) {
			for(String strB : b) {
				if(strA == strB) {
					test = true;
				} else {
					test = false;
					return test;
				}
			}
		}
		return test;
	}
	
	public String wordToFind() {
		String word = String.join(" ", lettersTable);
		return word;
	}

	@Override
	public void addObserver(Observer <Integer> observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers(Integer data) {
		 for (Observer<Integer> observer : observers) {
	            observer.update(data);
	        }		
	}
	
			
}
