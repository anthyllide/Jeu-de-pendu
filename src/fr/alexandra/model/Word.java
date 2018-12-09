package fr.alexandra.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {

	private String word;
	private String oneLetter;
	private int line;
	private List <String> letters = new <String> ArrayList();
	private int numberLetters;
	
	public Word() {	
		//on génère une nouvelle ligne
		setLine();
		//lecture du mot correspondant à ligne
		selectOneWord(getLine());
		//split du mot
		splitWord(getWord());
		//comptage du nombre de lettres
		countLetters(getLetters());
		
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
	
	private void selectOneWord(int line) {
		
		  FileReader fr = null;
	      LineNumberReader lnr = null;
	      String str = "";
	      int i = 0;
					 
		try {
			
			fr = new FileReader("files/dictionnaire.txt");
			lnr = new LineNumberReader(fr);
			
			//on rentre le numéro de la ligne 
			lnr.setLineNumber(line);
			
			//tant que le numéro n'est pas atteint
			while(i < this.getLine()) {
				++i;
				str = lnr.readLine();				
			}
		
			this.word = str.toUpperCase();
			
		} catch (FileNotFoundException e) {

		    e.printStackTrace();

		  } catch (IOException e) { 

		    e.printStackTrace();     
	    }
	}
	
	//décompose le mot en lettres 
	private void splitWord(String str) {

		this.letters = Arrays.asList(str.split(""));	
			
	}
	
	private void countLetters(List letters) {
		
		int number = letters.size();
		this.numberLetters = number;
	}
		 
}
