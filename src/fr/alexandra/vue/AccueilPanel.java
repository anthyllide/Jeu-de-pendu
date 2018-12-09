package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class AccueilPanel extends JPanel	 {
	
	private String text1 = "<html><div style='text-align: center;'>Vous avez 7 coups pour trouver le mot caché"
			+ " et si vous gagnez ... et bien on recommence !</div></html>";
	private String text2 = "<html><div style='text-align: center;'>Plus vous trouvez de mots, plus votre score augmente !"
			+ " Alors à vous jouer !</div></html>";
	private String text3 = "<html><div style='text-align: center;'>Pas vu, pas pris ; pas pris, pas pendu. (proverbe franc-comtois)</div></html>";	
	private JLabel title;
	private JLabel image;
	private JLabel speech1;
	private JLabel speech2;
	private JLabel speech3;
	private JPanel speech;
	
	public AccueilPanel() {
		
		this.setBackground(Color.white);
		this.setSize(800,this.getHeight());
		this.setLayout(new BorderLayout());	
		
		//on instancie tous les objets nécessaires
		Font font1 = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial",Font.CENTER_BASELINE, 12);
		this.title = new JLabel("Bienvenue !");
		this.image = new JLabel(new ImageIcon("images/accueil.jpg"));		
		this.speech1 = new JLabel(text1);
		this.speech2 = new JLabel(text2);
		this.speech3 = new JLabel(text3);
		this.speech = new JPanel();
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		Border espace = BorderFactory.createEmptyBorder(10, 0, 10, 0);
		title.setBorder(espace);
		
		//Instanciation du layout pour le JPanel contenant les JLabel du texte explicatif
		speech.setLayout(new BoxLayout(speech, BoxLayout.PAGE_AXIS));
		speech.setBackground(Color.white);
		
		//Mise en forme des JLabel du texte explicatif
		speech1.setFont(font2);
		speech1.setHorizontalAlignment(JLabel.CENTER);
		speech1.setVerticalAlignment(JLabel.CENTER);
		Border espace2 = BorderFactory.createEmptyBorder(10, 0, 0, 0); 
		speech1.setBorder(espace2);
		
		speech2.setFont(font2);
		speech2.setHorizontalAlignment(JLabel.CENTER);
		speech2.setVerticalAlignment(JLabel.CENTER);
		
		speech3.setFont(font2);
		speech3.setHorizontalAlignment(JLabel.CENTER);
		speech3.setVerticalAlignment(JLabel.CENTER);
		
		//on ajoute les 3 JLabel au JPanel speech		
		speech.add(speech1);
		speech.add(speech2);
		speech.add(speech3);
		
		//on ajoute le titre, l'image centrale et le texte explicatif au JPanel AccueilPanel
		this.add(title, BorderLayout.NORTH);
		this.add(image, BorderLayout.CENTER);
		this.add(speech, BorderLayout.SOUTH);
		
		//on rend visible le panel AccueilPanel
		this.setVisible(true);				
	}
}
