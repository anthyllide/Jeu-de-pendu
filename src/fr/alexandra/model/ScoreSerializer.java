package fr.alexandra.model;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ScoreSerializer<A> implements Serializable {
	
	private static final long serialVersionUID = 1L;  
	private String name; //nom du joueur
	private int finalScore; // score
	private int nbGaming; //nombre de parties
	private transient ArrayList<String> gamingList = new ArrayList<String> ();
	private transient Object[][] scoreList;
	private transient boolean isExist = true;
		
	
	public ScoreSerializer() {}
	
	public ScoreSerializer(String name, int finalScore, int nbGaming) {
		this.name = name;
		this.finalScore = finalScore;
		this.nbGaming = nbGaming;		
	}
	
	public Object[][] getScoreList(){
		return scoreList;
	}
	
	
	public String getName() {
		return name;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public int getNbGaming() {
		return nbGaming;
	}

	//retourne la arraylist d'objects désérialisés
	public ArrayList <String> getGamingList() {
		return gamingList;
	}
	
	public String toString() {
		return this.name +
				"," + this.finalScore +
				"," + this.nbGaming;
	}
	
	private void setScoreList() {	
		
		String[] items = gamingList.get(0).toString().split(",");
		List<String> itemList = new ArrayList<String>();
	      for (String item : items) {
	         itemList.add(item);
	      }
	
						
		//this.scoreList = (Object[][]) itemList;
		
		//System.out.println("scoreList :" + scoreList[0][0]);
	}
	
	public boolean fileExists() {
		if(new File("game.txt").exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	//enregistre les données d'une partie
	public void registerGame() {
		
		ObjectOutputStream oos;
		
		try {
			
			readData();
			
			File file = new File("game.txt");
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(							
									file)));	
			//le true indique qu'il faut écrire à la suite du fichier, même s'il n'est pas vide !
			System.out.print("size file ds register : " + file.length());
					
			//normalement gamingList n'est pas vide
			//check
			System.out.println("check gamingList ds registerGame : " + this.gamingList );
			
			String line = this.toString();
			System.out.println("line ds register : " + line) ;
			
			
			this.gamingList.add(line);
			System.out.println("nouveau tableau : " + gamingList);
			oos.writeObject(gamingList);
			//écriture de l'objet dans le fichier
			//oos.writeObject(new ScoreSerializer(this.name, this.finalScore, this.nbGaming));
				
			oos.close();
			//setScoreList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}		
	}
	
	public void readData() {
				
		try {
			File file = new File("game.txt");
			System.out.println("size file ds read : " + file.length());
			if(file.length() > 0){
				ObjectInputStream ois = new ObjectInputStream(
											new BufferedInputStream(
												new FileInputStream(
														file)));
				
				this.gamingList = (ArrayList<String>) ois.readObject();
				
				//limite le nombre de parties sauvegardées à 10
				if(gamingList.size() > 10) {
					gamingList.remove(0);
				}
				
				System.out.println("taille gamingList ds Serialize : " + gamingList.size());
				ois.close();
			}
								
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}	
			
	}
	
}
