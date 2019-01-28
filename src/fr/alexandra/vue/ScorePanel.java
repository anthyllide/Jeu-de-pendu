package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import fr.alexandra.model.ModelTableScore;
import fr.alexandra.model.ScoreSerializer;

public class ScorePanel extends JPanel {
	
	private JLabel title;
	private JTable table;	
	private ScoreSerializer scoreRecorded;
	
	public ScorePanel() {
		
		this.scoreRecorded = new ScoreSerializer();
		
		if(scoreRecorded.fileExists()) {
			scoreRecorded.readData();
		}
			
			
		this.setBackground(Color.white);
		this.setSize(800,this.getHeight());
		this.setLayout(new BorderLayout());	
		
		//on instancie les objets nécessaires
		JLabel title =  new JLabel("Récapitulatif des parties précédentes");
		Font font1 = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 12);
		
		//Instantiation des bordures
		Border espace = BorderFactory.createEmptyBorder(10, 0, 30, 0);
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setBorder(espace);
				
		//Construction du tableau
		//Les titres des colonnes
	   // String  titleTable[] = {"Pseudo", "Score", "Nombre de mots trouvés"};
	    
	    
	  //Les données du tableau
 
	   /* int sizeMax = scoreRecorded.getGamingList().size();
	    Object[][] dataTable = new Object[sizeMax][3];
	    
	    if(scoreRecorded.getGamingList()!= null) {
	    
	    	for(int i = 0; i < scoreRecorded.getGamingList().size(); i++) {
	    	   	
	    		Object[] items = scoreRecorded.getGamingList().get(i).toString().split(",");
	    		
	    		System.out.println("item1 :" + items[0].toString());
	    		System.out.println("item2 :" + items[1].toString());
	    		System.out.println("item3 size :" + scoreRecorded.getGamingList().size());
	    		
	    		dataTable[i][0] = items[0];
	    		dataTable[i][1] = items[1];
	    		dataTable[i][2] = items[2];			   	
	    			    		    	
	    	}
	    	
	    }*/
	     
	    //on instance un objet JTable en lui fournissant les données
	    JTable table = new JTable(new ModelTableScore((ArrayList <String>)scoreRecorded.getGamingList()));
	    
	    //mise en forme des titres du tableau
	    JTableHeader header = table.getTableHeader();
	    header.setFont(font2);
	    
	    //instance de CustomTableRenderer pour personnaliser le rendu du tableau
	    CustomTableCellRenderer renderer = new CustomTableCellRenderer();
	    
	    table.setDefaultRenderer(String.class, renderer);
	    
	    /*for(int i=0; i< table.getColumnModel().getColumnCount(); i++) {

	    	table.getColumnModel().getColumn(i).setCellRenderer(renderer); 
	    }*/
	  
	    
		this.add(title, BorderLayout.NORTH);
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		
		this.setVisible(false);
	}

}
