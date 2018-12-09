package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fr.alexandra.controler.Controler;
import fr.alexandra.model.Word;
import fr.alexandra.observer.Observable;
import fr.alexandra.observer.Observateur;

public class GamePanel extends JPanel {
	
	private JLabel title;
	private JLabel wordLabel;
	private JLabel numberLetters;
	private JLabel hangManImage;
	private JLabel scoreLabel;
	private String wordGame = "";
	private Word word;
	private Controler controler;
	private int score;
	
	private String textTitle = "A vous de jouer !";
	private String textWordGame;
	
	//Déclaration des boutons
	private JButton aLetter = new JButton("A");
	private JButton zLetter = new JButton("Z");
	private JButton eLetter = new JButton("E");
	private JButton rLetter = new JButton("R");
	private JButton tLetter = new JButton("T");
	private JButton yLetter = new JButton("Y");
	private JButton uLetter = new JButton("U");
	private JButton iLetter = new JButton("I");
	private JButton oLetter = new JButton("O");
	private JButton pLetter = new JButton("P");
	private JButton qLetter = new JButton("Q");
	private JButton sLetter = new JButton("S");
	private JButton dLetter = new JButton("D");
	private JButton fLetter = new JButton("F");
	private JButton gLetter = new JButton("G");
	private JButton hLetter = new JButton("H");
	private JButton jLetter = new JButton("J");
	private JButton kLetter = new JButton("K");
	private JButton lLetter = new JButton("L");
	private JButton mLetter = new JButton("M");
	private JButton wLetter = new JButton("W");
	private JButton xLetter = new JButton("X");
	private JButton cLetter = new JButton("C");
	private JButton vLetter = new JButton("V");
	private JButton bLetter = new JButton("B");
	private JButton nLetter = new JButton("N");
	private JButton tiret = new JButton("-");
	
	//Création d'un JPanel pour les boutons du clavier qui sera le conteneur d'une GridLayout
	private JPanel clavier = new JPanel();
	//création de la grille
	private GridLayout buttons = new GridLayout(3,10);
	
	//création du JPanel contenant le mot à trouver
	private JPanel wordPanel = new JPanel();
	
	//création du JPanel contenant le score
	private JPanel scorePanel = new JPanel();
	
	//creation du JPanel contenant le pendu
	private JPanel hangManPanel = new JPanel();
	
	//création du JPanel game contenant le mot à trouver et la clavier
	private JPanel gameArea = new JPanel();
	
	//Création du JPanel contenant le score, le gameArea et le pendu
	private JPanel central = new JPanel();
	
	public GamePanel(Word word, String str) {
		
		this.wordGame = str;
		displayGamePanel(word);
	}
	
	public GamePanel(Word word) {
		
		//Instanciation de l'objet controleur	
		Controler controler = new Controler(word);
		this.controler = controler;
				
		this.wordGame = controler.getHideWord();			
		displayGamePanel(word);
				
	}
	
	public void setWordGame() {
		this.wordGame = controler.getHideWord();
	}
	
	public String getWordGame() {
		return wordGame;
	}
	
	public void setWordLabel() {
			System.out.println("texte JLabel : " + wordLabel.getText());
	}
		
	public JLabel getWordLabel() {
		return wordLabel;
	}
	
	//gère les actions selon le type de boutons
	public class BoutonListener implements ActionListener {
			
			private JButton btn;
			private Word word;
			private JLabel wordLabel;
			private JLabel hangManImage;
			
			//Constructeur
			public BoutonListener (JButton btn, Word word, JLabel wordLabel, JLabel hangManImage) {
			
				this.btn = btn;	
				this.word = word;
				this.wordLabel = wordLabel;
				this.hangManImage = hangManImage;
			}
			
			public String getBtn() {
				return btn.getText();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn.setEnabled(false);
				//btn.setBackground(Color.Light_grey);
				controler.letterInWord(btn.getText());
				wordGame = controler.getHideWord();
				wordLabel.setText(wordGame);
				System.out.println("wordGame :"+ getWordGame());
				ImageIcon image = controler.getUrlImage();
				
				if(image != null) {
					
				hangManImage.setIcon(new ImageIcon(image.getImage()));
				
				}		
			}
	}
	
	public void displayGamePanel(Word word) {
		
		this.setBackground(Color.white);
		this.setSize(850,this.getHeight());
		this.setLayout(new BorderLayout());	
		
		
		//insertion du layout border dans le JPanel central
		central.setLayout(new BorderLayout());
		central.setBackground(Color.WHITE);
		
		scorePanel.setBackground(Color.WHITE);
		
		//insertion du layout border dans le gameArea
		gameArea.setLayout(new BorderLayout());
		gameArea.setBackground(Color.WHITE);
		gameArea.setPreferredSize(new Dimension(480, 150));
		
		//personnalisation JPanel de l'image du pendu
		hangManPanel.setBackground(Color.WHITE);
		hangManPanel.setPreferredSize(new Dimension(340,250));
		
		//Création d'espaces de 6px entre les boutons
		buttons.setHgap(6); //six pixels d'espace entre les colonnes (H comme Horizontal)
		buttons.setVgap(6); //six pixels d'espace entre les lignes (V comme Vertical)
		
		//Insertion du GridLayout buttons dans le JPanel clavier
		clavier.setBackground(Color.LIGHT_GRAY);
		clavier.setLayout(buttons);
		clavier.setPreferredSize(new Dimension(480,150));
		
		//le JPanel wordPanel prend le modèle BorderLayout
		wordPanel.setLayout(new BorderLayout());
		wordPanel.setPreferredSize(new Dimension(480, 100));
		
		//insertion des boutons-lettre dans le JPanel clavier
		clavier.add(aLetter);
		clavier.add(zLetter);
		clavier.add(eLetter);
		clavier.add(rLetter);
		clavier.add(tLetter);
		clavier.add(yLetter);
		clavier.add(uLetter);
		clavier.add(iLetter);
		clavier.add(oLetter);
		clavier.add(pLetter);
		clavier.add(qLetter);
		clavier.add(sLetter);
		clavier.add(dLetter);
		clavier.add(fLetter);
		clavier.add(gLetter);
		clavier.add(hLetter);
		clavier.add(jLetter);
		clavier.add(kLetter);
		clavier.add(lLetter);
		clavier.add(mLetter);
		clavier.add(wLetter);
		clavier.add(xLetter);
		clavier.add(cLetter);
		clavier.add(vLetter);
		clavier.add(bLetter);
		clavier.add(nLetter);
		clavier.add(tiret);
				
			
		
		//on instancie tous les objets nécessaires
		Font font1 = new Font("Arial", Font.BOLD, 22);
		Font font2 = new Font("Arial",Font.BOLD, 18);
		Font font3 = new Font("Arial", Font.PLAIN, 14);
		JLabel title = new JLabel(textTitle);
		JLabel wordLabel = new JLabel(wordGame);
		JLabel numberLetters = new JLabel("mot à "+ word.getNumberLetters()+ " lettres");
		JLabel hangManImage = new JLabel(new ImageIcon ("images/pendu1.jpg"));
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		Border espace = BorderFactory.createEmptyBorder(0, 0, 20, 0);
		title.setBorder(espace);
		
		//Mise du mot caché
		wordLabel.setFont(font2);
		wordLabel.setHorizontalAlignment(JLabel.CENTER);
		wordLabel.setVerticalAlignment(JLabel.CENTER);
		Border espace2 = BorderFactory.createEmptyBorder(30, 0, 10, 0);
		wordLabel.setBorder(espace2);
		
		//Mise en forme de l'indication nombre de lettres
		numberLetters.setFont(font3);
		numberLetters.setHorizontalAlignment(JLabel.CENTER);
		numberLetters.setVerticalAlignment(JLabel.CENTER);
		Border espace3 = BorderFactory.createEmptyBorder(8, 0, 30, 0);
		numberLetters.setBorder(espace3);
		
		//Mise en forme de l'image du pendu
		hangManImage.setHorizontalAlignment(JLabel.CENTER);
		hangManImage.setHorizontalAlignment(JLabel.CENTER);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY,2,true);
		//Border espace4 = BorderFactory.createEmptyBorder(0, 20, 0, 20);
		hangManImage.setBorder(border);
		//hangManImage.setBorder(espace4);
		
		//DEBUT TEST DEV
		System.out.println("line : "+ word.getLine());
		System.out.println("word : " +word.getWord());
		System.out.println("nb de lettres : " +word.getNumberLetters());
		
		
		for(String str : word.getLetters()) {
			System.out.println("lettre : "+ str);
		}
		//FIN TEST DEV  
		
		
		hangManPanel.add(hangManImage);
		
		wordPanel.setBackground(Color.white);
		wordPanel.add(wordLabel, BorderLayout.CENTER);
		wordPanel.add(numberLetters, BorderLayout.SOUTH);
		
		gameArea.add(wordPanel, BorderLayout.NORTH);
		gameArea.add(clavier, BorderLayout.CENTER);
		
		central.add(scorePanel, BorderLayout.NORTH);
		central.add(hangManPanel, BorderLayout.EAST);
		central.add(gameArea, BorderLayout.WEST);
		
		this.add(title,BorderLayout.NORTH);
		this.add(central,BorderLayout.CENTER);
		
		//ecoute les boutons du clavier   
	    aLetter.addActionListener(new BoutonListener(aLetter, word, wordLabel, hangManImage));
	    zLetter.addActionListener(new BoutonListener(zLetter, word, wordLabel, hangManImage));
	    eLetter.addActionListener(new BoutonListener(eLetter, word, wordLabel, hangManImage));
	    rLetter.addActionListener(new BoutonListener(rLetter, word, wordLabel, hangManImage));
	    tLetter.addActionListener(new BoutonListener(tLetter, word, wordLabel, hangManImage));
	    yLetter.addActionListener(new BoutonListener(yLetter, word, wordLabel, hangManImage));
	    uLetter.addActionListener(new BoutonListener(uLetter, word, wordLabel, hangManImage));
	    iLetter.addActionListener(new BoutonListener(iLetter, word, wordLabel, hangManImage));
	    oLetter.addActionListener(new BoutonListener(oLetter, word, wordLabel, hangManImage));
	    pLetter.addActionListener(new BoutonListener(pLetter, word, wordLabel, hangManImage));
	    qLetter.addActionListener(new BoutonListener(qLetter, word, wordLabel, hangManImage));
	    sLetter.addActionListener(new BoutonListener(sLetter, word, wordLabel, hangManImage));
	    dLetter.addActionListener(new BoutonListener(dLetter, word, wordLabel, hangManImage));
	    fLetter.addActionListener(new BoutonListener(fLetter, word, wordLabel, hangManImage));
	    gLetter.addActionListener(new BoutonListener(gLetter, word, wordLabel, hangManImage));
	    hLetter.addActionListener(new BoutonListener(hLetter, word, wordLabel, hangManImage));
	    jLetter.addActionListener(new BoutonListener(jLetter, word,wordLabel, hangManImage));
	    kLetter.addActionListener(new BoutonListener(kLetter, word, wordLabel, hangManImage));
	    lLetter.addActionListener(new BoutonListener(lLetter, word, wordLabel, hangManImage));
	    mLetter.addActionListener(new BoutonListener(mLetter, word, wordLabel, hangManImage));
	    wLetter.addActionListener(new BoutonListener(wLetter, word, wordLabel, hangManImage));
	    xLetter.addActionListener(new BoutonListener(xLetter, word, wordLabel, hangManImage));
	    cLetter.addActionListener(new BoutonListener(cLetter, word, wordLabel, hangManImage));
	    vLetter.addActionListener(new BoutonListener(vLetter, word, wordLabel, hangManImage));
	    bLetter.addActionListener(new BoutonListener(bLetter, word, wordLabel, hangManImage));
	    nLetter.addActionListener(new BoutonListener(nLetter, word, wordLabel, hangManImage));
	    tiret.addActionListener(new BoutonListener(tiret, word, wordLabel, hangManImage));
		
	    this.setVisible(false);
	}	
}
