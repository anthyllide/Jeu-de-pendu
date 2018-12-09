package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RulesPanel extends JPanel{
	
	private JPanel explains;
	private JPanel conclusion;
	
	private JLabel title;
	private JLabel intro1;
	private JLabel intro2;
	private JLabel sstitle;
	private JLabel point0;
	private JLabel point1;
	private JLabel point2;
	private JLabel point3;
	private JLabel point4;
	private JLabel point5;
	private JLabel point6;
	private JLabel conclusion1;
	private JLabel conclusion2;
	private JLabel conclusion3;
	
	private String textIntro1 = "Vous avez 7 coups pour trouver le mot caché !"
			+ " Et si vous gagnez, on recommence !";
	private String textIntro2 = "Plus vous avez trouvé de mot, plus votre score augmentera.";
	private String textPoint0 = "Mot trouvé sans erreur : ----- 100pts";
	private String textPoint1 = "Mot trouvé avec 1 erreur : ---- 60pts";
	private String textPoint2 = "Mot trouvé avec 2 erreurs : --- 40pts";
	private String textPoint3 = "Mot trouvé avec 3 erreurs : --- 30pts";
	private String textPoint4 = "Mot trouvé avec 4 erreurs : --- 20pts";
	private String textPoint5 = "Mot trouvé avec 5 erreurs : --- 10pts";
	private String textPoint6 = "Mot trouvé avec 6 erreurs : ---- 5pts";
	private String textConclusion1 ="Je vous souhaite bien du plaisir...";
	private String textConclusion2 = "Si vous pensez pouvoir trouver un mot en un seul coup,"
			+ " Détrompez-vous !";
	private String textConclusion3 = "Ce jeu contient plus de 335 000 mots ! Donc bonne chance !";
	
	public RulesPanel() {
		
		this.setBackground(Color.white);
		this.setSize(800,this.getHeight());
		this.setLayout(new BorderLayout());	
		
		//on instancie tous les objets nécessaires
		this.explains = new JPanel();
		this.conclusion = new JPanel();
		Font font1 = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial",Font.CENTER_BASELINE, 12);
		Font font3 = new Font("Arial",Font.CENTER_BASELINE, 16);
		this.title = new JLabel("JEU DE PENDU");
		this.intro1 = new JLabel(textIntro1);
		this.intro2 = new JLabel(textIntro2);
		this.sstitle = new JLabel("Attribution des points :");
		this.point0 = new JLabel(textPoint0);
		this.point1 = new JLabel(textPoint1);
		this.point2 = new JLabel(textPoint2);
		this.point3 = new JLabel(textPoint3);
		this.point4 = new JLabel(textPoint4);
		this.point5 = new JLabel(textPoint5);
		this.point6 = new JLabel(textPoint6);
		this.conclusion1 = new JLabel(textConclusion1);
		this.conclusion2 = new JLabel(textConclusion2);
		this.conclusion3 = new JLabel(textConclusion3);
		
		//Instantiation des bordures
		Border espace = BorderFactory.createEmptyBorder(10, 0, 30, 0);
		Border espace1 = BorderFactory.createEmptyBorder(10, 0, 0, 0); 
		Border espace2 = BorderFactory.createEmptyBorder(10, 0, 0, 0); 
		Border espace3 = BorderFactory.createEmptyBorder(30, 0, 30, 0);
		Border espace4 = BorderFactory.createEmptyBorder(5, 0, 0, 0);
		Border espace5 = BorderFactory.createEmptyBorder(30, 0, 0, 0);
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setBorder(espace);
		
		//Instanciation du layout pour le JPanel contenant les JLabel du texte explicatif
		explains.setLayout(new BoxLayout(explains, BoxLayout.PAGE_AXIS));
		explains.setBackground(Color.white);
		
		//Mise en forme des JLabel de l'intro
		intro1.setFont(font2);
		intro1.setHorizontalAlignment(JLabel.CENTER);
		intro1.setVerticalAlignment(JLabel.CENTER);
		intro1.setBorder(espace1);
		
		intro2.setFont(font2);
		intro2.setHorizontalAlignment(JLabel.CENTER);
		intro2.setVerticalAlignment(JLabel.CENTER);
		intro2.setBorder(espace2);
		
		//mise en forme du sous titre
		sstitle.setFont(font3);
		sstitle.setBorder(espace3);
		
		//mise en forme des points	
		point0.setFont(font2);
		point0.setHorizontalAlignment(JLabel.CENTER);
		point0.setVerticalAlignment(JLabel.CENTER);
		
		point1.setFont(font2);
		point1.setHorizontalAlignment(JLabel.CENTER);
		point1.setVerticalAlignment(JLabel.CENTER);
		point1.setBorder(espace4);
		
		point2.setFont(font2);
		point2.setHorizontalAlignment(JLabel.CENTER);
		point2.setVerticalAlignment(JLabel.CENTER);
		point2.setBorder(espace4);
		
		point3.setFont(font2);
		point3.setHorizontalAlignment(JLabel.CENTER);
		point3.setVerticalAlignment(JLabel.CENTER);
		point3.setBorder(espace4);
		
		point4.setFont(font2);
		point4.setHorizontalAlignment(JLabel.CENTER);
		point4.setVerticalAlignment(JLabel.CENTER);
		point4.setBorder(espace4);
		
		point5.setFont(font2);
		point5.setHorizontalAlignment(JLabel.CENTER);
		point5.setVerticalAlignment(JLabel.CENTER);
		point5.setBorder(espace4);
		
		point6.setFont(font2);
		point6.setHorizontalAlignment(JLabel.CENTER);
		point6.setVerticalAlignment(JLabel.CENTER);
		point6.setBorder(espace4);
		
		//mise en forme de la conclusion
		conclusion1.setFont(font2);
		conclusion1.setHorizontalAlignment(JLabel.CENTER);
		conclusion1.setVerticalAlignment(JLabel.CENTER);
		conclusion1.setBorder(espace5);
		
		conclusion2.setFont(font2);
		conclusion2.setHorizontalAlignment(JLabel.CENTER);
		conclusion2.setVerticalAlignment(JLabel.CENTER);
		conclusion2.setBorder(espace4);
		
		conclusion3.setFont(font2);
		conclusion3.setHorizontalAlignment(JLabel.CENTER);
		conclusion3.setVerticalAlignment(JLabel.CENTER);
		conclusion3.setBorder(espace4);
		
		//on ajoute les composants
		explains.add(intro1);
		explains.add(intro2);
		explains.add(sstitle);
		explains.add(point0);
		explains.add(point1);
		explains.add(point2);
		explains.add(point3);
		explains.add(point4);
		explains.add(point5);
		explains.add(point6);
		explains.add(conclusion1);
		explains.add(conclusion2);
		explains.add(conclusion3);
		
		this.add(title, BorderLayout.NORTH);
		this.add(explains, BorderLayout.CENTER);
		
		this.setVisible(false);
		
	}
	
	

}
