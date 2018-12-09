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
	
	//construit le mot cach� lors d'une nouvelle partie 
	public void setHideWord(Word word) {
		
		this.lettersTable = word.getLetters();
		String str = " --- ";
		
		while( i < lettersTable.size()) {
			
			i++;
			str += " --- ";
		}
		
		this.hideWord = str;			
	}
	
	//v�rifie que la lettre s�lectionn�e par le joueur est dans le mot ou pas
	//si la lettre fait partie du mot, elle ajoute la/les lettre(s) au mot
	public void letterInWord (String letter) {
		
		//si le tableau de lettres contient la lettre s�lectionn�e et le tableau du mot cach� est vide
		if(lettersTable.contains(letter) && lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && lettersNewWord.isEmpty()) {
			
			for(int j=0; j < lettersTable.size(); j++) {
				
				if(lettersTable.get(j).equals("�") && letter == "E") {
					
					lettersNewWord.add(j,"�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "E") {
					
					lettersNewWord.add(j,"�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "E"){						
					
					lettersNewWord.add(j,"�");
				
				} else if (lettersTable.get(j).equals("�") && letter == "E"){	
					
					lettersNewWord.add(j,"�");
				
				} else if(lettersTable.get(j).equals("�") && letter == "A") {
					lettersNewWord.add(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "A") {
					
					lettersNewWord.add(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "A") {	
					
					lettersNewWord.add(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "I") {
					
					lettersNewWord.add(j, "�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "I") {
					
					lettersNewWord.add(j, "�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "O") {
					
					lettersNewWord.add(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "O") {
					
					lettersNewWord.add(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "U") {
					
					lettersNewWord.add(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "U") {
					
					lettersNewWord.add(j, "�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "C"){
					
					lettersNewWord.add(j, "�");
					
				} else if (lettersTable.get(j).equals(letter)) {
						
					lettersNewWord.add(j, letter);												
				} else {
					
					lettersNewWord.add(j,"---");
				}	
				
				this.hideWord = String.join(" ", lettersNewWord).toUpperCase();			
				System.out.println("nouveau mot1 :" + hideWord);		
			}
		
		//si le tableau de lettre contient la lettre choisie et le tableau du mot cach� 
		//n'est pas vide (� partir de la deuxi�me lettre trouv�e)	
		} else if (lettersTable.contains(letter) && !lettersNewWord.isEmpty() || compareLetter(letter, lettersTable) && !lettersNewWord.isEmpty()) {
					
			for(int j=0; j < lettersTable.size(); j++) {
				
				if(lettersTable.get(j).equals("�") && letter == "E") {
					
					lettersNewWord.set(j,"�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "E") {
					
					lettersNewWord.set(j,"�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "E"){						
					
					lettersNewWord.set(j,"�");
				
				} else if (lettersTable.get(j).equals("�") && letter == "E"){	
					
					lettersNewWord.set(j,"�");
				
				} else if(lettersTable.get(j).equals("�") && letter == "A") {
					
					lettersNewWord.set(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "A") {
					
					lettersNewWord.set(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "A") {	
					
					lettersNewWord.set(j,"�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "I") {
					
					lettersNewWord.set(j, "�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "I") {
					
					lettersNewWord.set(j, "�");
					
				} else if(lettersTable.get(j).equals("�") && letter == "O") {
					
					lettersNewWord.set(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "O") {
					
					lettersNewWord.set(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "U") {
					
					lettersNewWord.set(j, "�");
					
				}  else if(lettersTable.get(j).equals("�") && letter == "U") {
					
					lettersNewWord.set(j, "�");
					
				} else if (lettersTable.get(j).equals("�") && letter == "C"){
					
					lettersNewWord.set(j, "�");
					
				} else if (lettersTable.get(j).equals(letter)) {
						
					lettersNewWord.set(j, letter);	
				} 				
			}
			
			this.hideWord = String.join(" ",lettersNewWord).toUpperCase();
			System.out.println("nouveau mot2 :" + hideWord);
			
			//si le joueur s�lectionne une lettre n'appartenant pas au tableau de lettres	
		} else {
			System.out.println("Et non cette lettre ne fait pas partie du mot !");
			if (nbError < 8) {
				setNbError();
				changeImage(nbError);
				System.out.println(" nombre d'erreurs :" + nbError);
			} 
		}		
	}

	//permet de d�tecter si le mot cach� poss�de une lettre accentu�e
	private boolean compareLetter(String letter, List<String> lettersTable2) {
		if(letter == "E") {
			if(lettersTable2.contains("�") || lettersTable2.contains("�") || 
					lettersTable2.contains("�") || lettersTable2.contains("�")) {
				return true;
			}
		} else if(letter == "A") {
			if(lettersTable2.contains("�") || lettersTable2.contains("�") || lettersTable2.contains("�")) {
				return true;
			}
		} else if (letter == "I") {
			if(lettersTable2.contains("�")|| lettersTable2.contains("�" )) {
				return true;
			}
		} else if(letter == "O") {
			if(lettersTable2.contains("�") || lettersTable2.contains("�")) {
				return true;
			}
		} else if(letter == "U") {
			if(lettersTable2.contains("�") || lettersTable2.contains("�")) {
				return true;
			}
		} else if (letter == "C") {
			if(lettersTable2.contains("�")) {
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
