package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AboutPanel extends JPanel {
	
	private JPanel contain;
	private JLabel title;
	private JLabel contain1;
	private JLabel contain11;
	private JLabel contain2;
	
	private String about1 = "<html><div style='text-align:center;'><span style='text-decoration:underline;'>VERSION 1.1</span> : mai 2019</div></html>";
	private String about11 = "<html><div style='text-align:center;'>Jeu créé par Alexandra Gonzalez</div></html>";
	private String about2 = "<html><div style='text-align:center;'>Pour jeter un oeil sur mon site : <a style='cursor:pointer;' href='https://www.alexandra-gonzalez.fr'>https://www.alexandra-gonzalez.fr</a></div></html>";
	
	public AboutPanel() {
		
		this.setBackground(Color.white);
		this.setSize(800,this.getHeight());
		this.setLayout(new BorderLayout());
		
		//on instancie tous les objets nécessaires
		this.contain = new JPanel();
				
		Font font1 = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial",Font.BOLD, 14);
		this.title = new JLabel("A PROPOS");
		this.contain1 = new JLabel(about1);
		this.contain11 = new JLabel(about11);
		
		this.contain2 = new JLabel(about2);
		
		//Instanciation du layout pour le JPanel contenant les JLabel du texte explicatif
		contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
		contain.setBackground(Color.white);
		
		//Instantiation des bordures
		Border espace = BorderFactory.createEmptyBorder(10, 0, 30, 0);
		Border espace1 = BorderFactory.createEmptyBorder(10, 0, 20, 0);
		Border espace2 = BorderFactory.createEmptyBorder(10, 0, 5, 0);
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setBorder(espace);
		
		//Mise en forme du contenu
		contain1.setFont(font2);
		contain1.setHorizontalAlignment(JLabel.CENTER);
		contain1.setVerticalAlignment(JLabel.CENTER);
		contain1.setBorder(espace2);
		
		contain11.setFont(font2);
		contain11.setHorizontalAlignment(JLabel.CENTER);
		contain11.setVerticalAlignment(JLabel.CENTER);
		contain11.setBorder(espace);
		
		contain2.setFont(font2);
		contain2.setHorizontalAlignment(JLabel.CENTER);
		contain2.setVerticalAlignment(JLabel.CENTER);
		
		contain.add(contain1);
		contain.add(contain11);
		contain.add(contain2);
		
		this.add(title, BorderLayout.NORTH);
		this.add(contain, BorderLayout.CENTER);
		
		this.setVisible(false);
	}

}
	