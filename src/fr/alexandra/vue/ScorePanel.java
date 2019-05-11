package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		JLabel title =  new JLabel("Récapitulatif des dix dernières parties précédentes");
		Font font1 = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 14);
		
		//Instantiation des bordures
		Border espace = BorderFactory.createEmptyBorder(10, 0, 30, 0);
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setBorder(espace);
					     
	    //on instance un objet JTable en lui fournissant les données
	    JTable table = new JTable(new ModelTableScore((ArrayList <String>)scoreRecorded.getGamingList()));
	    
	    //mise en forme des titres du tableau
	    JTableHeader header = table.getTableHeader();
	    header.setFont(font2);
	    	    
	    //instance de CustomTableRenderer pour personnaliser le rendu du tableau
	    CustomTableCellRenderer renderer = new CustomTableCellRenderer();
	 
	    //on applique le renderer à toutes les cellules du tableau
	    for (int i=0 ; i < table.getColumnCount() ; i++) {
 	    	
	    	 table.getColumnModel().getColumn(i).setCellRenderer(renderer); 
	    }
	
	    JScrollPane tablePane = new JScrollPane(table);
	    tablePane.setPreferredSize(new Dimension(getWidth(), 324));
	    
		this.add(title, BorderLayout.NORTH);
		this.add(tablePane, BorderLayout.CENTER);
		
		this.setVisible(false);
	}

}
