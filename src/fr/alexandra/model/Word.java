package fr.alexandra.model;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {

	private String word;
	private int line;
	private List <String> letters = new <String> ArrayList();
	private int numberLetters;
	
	public Word() {	
			
			//on génère une nouvelle ligne
			setLine();
			//lecture du mot correspondant à ligne
			selectOneWord(getLine());
	}
	
	public String getWord() {
		return word;
	}
	
	public int getNumberLetters() {
		return numberLetters;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setNumberLetters(int numberLetters) {
		this.numberLetters = numberLetters;
	}
	
	public int getLine() {
		return line;
	}
	
	public void setLine() {
		int number = (int)(Math.random()*336530);
		this.line = number;
	}
	
	public List<String> getLetters() {
		return letters;
	}
	
	public void setLetters(String letter) {
		this.letters.add(letter);
	}
	
	//choisit un mot au hasard
	private void selectOneWord(int line) {
		
		  FileReader fr = null;
	      LineNumberReader lnr = null;
	      String str = "";
	      int i = 0;
					 
		try {
			
			/*String url = this.getClass().getResource("files/dictionnaire.txt").toString();*/
			
			fr = new FileReader("files/dictionnaire.txt");
			
			lnr = new LineNumberReader(fr);
			
			//on rentre le numéro de la ligne 
			lnr.setLineNumber(line);
			
			//tant que le numéro n'est pas atteint
			while(i < this.getLine()) {
				++i;
				str = lnr.readLine();				
			}
		
			String wordChoice = str.toUpperCase();
			List letters = splitWord(wordChoice);
			int nbLetters = countLetters(letters);
		//on limite le nombre de lettres du mot à 15 lettres et à 3 lettres minimuùm
		if ((nbLetters > 15) || (nbLetters < 3)) {
			new Word();
		} else {
			this.letters = letters;
			this.numberLetters = nbLetters;
		}
			
		} catch (FileNotFoundException e) {

		    e.printStackTrace();

		  } catch (IOException e) { 

		    e.printStackTrace();     
	    }
	}
	
	//décompose le mot en lettres 
	private List splitWord(String str) {

			return  Arrays.asList(str.split(""));	
			
	}
	
	//compte le nombre de lettres du mot
	private int countLetters(List letters) {
		
		return letters.size();
	
	}
	
	//ouvre une page du navigation pour rechercher le sens du mot
	public void wikitionary(String word) {
		
		 if (Desktop.isDesktopSupported()) {
	           Desktop desktop = Desktop.getDesktop();
	           
	    //Tranformation du mot en minuscules et on enlève les espaces      				
		String lowerWord = word.toLowerCase().replaceAll(" ", "");
	
		//url wiktionary
		String url = "https://fr.wiktionary.org/wiki/"+lowerWord;
		try {
			URI uri = new URI(url);
			try {
				desktop.browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
		 
}
