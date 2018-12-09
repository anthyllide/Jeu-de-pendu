package fr.alexandra.controler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.alexandra.model.Word;

public class Controler {
	
	private Word word;
	private static String hideWord;
	private List <String> lettersTable = new <String> ArrayList();
	private List <String> lettersNewWord = new <String> ArrayList();
	private JLabel gameWord;
	private int i = 1;
	private int nbError = 0;
	private ImageIcon urlImage;
	
	
	public Controler(Word w) {
		setHideWord(w);
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
	
	//vérifie que la lettre sélectionnée par le joueur est dans le mot ou pas
	//si la lettre fait partie du mot, elle ajoute la/les lettre(s) au mot
	public void letterInWord (String letter) {
		
		//si le tableau de lettres contient la lettre sélectionnée et le tableau du mot caché est vide
		if(lettersTable.contains(letter) && lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && lettersNewWord.isEmpty()) {
			
			for(int j=0; j < lettersTable.size(); j++) {
				
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
				
				this.hideWord = String.join(" ", lettersNewWord).toUpperCase();			
				System.out.println("nouveau mot1 :" + hideWord);		
			}
		
		//si le tableau de lettre contient la lettre choisie et le tableau du mot caché 
		//n'est pas vide (à partir de la deuxième lettre trouvée)	
		} else if (lettersTable.contains(letter) && !lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && !lettersNewWord.isEmpty()) {
					
			for(int j=0; j < lettersTable.size(); j++) {
				
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
					
				} else if(lettersTable.get(j).equals("ï") && letter == "I") {
					
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
					
				} else if (lettersTable.get(j).equals(letter)) {
						
					lettersNewWord.set(j, letter);	
				} 				
			}
			
			this.hideWord = String.join(" ",lettersNewWord).toUpperCase();
			System.out.println("nouveau mot2 :" + hideWord);
			
			//si le joueur sélectionne une lettre n'appartenant pas au tableau de lettres	
		} else {
			System.out.println("Et non cette lettre ne fait pas partie du mot !");
			if (nbError < 8) {
				setNbError();
				changeImage(nbError);
				System.out.println(" nombre d'erreurs :" + nbError);
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
			case 7 : this.urlImage = new ImageIcon("images/pendu8.jpg");
					break;
			default: urlImage = new ImageIcon("images/pendu9.jpg");
            		break;
		}
	}
		
}
