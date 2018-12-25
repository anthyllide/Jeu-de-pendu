package fr.alexandra.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fr.alexandra.controler.Controler;
import fr.alexandra.model.Score;
import fr.alexandra.model.Word;
import observer.Observer;

public class GamePanel extends JPanel implements Observer<Integer> {
	
	private JLabel title;
	private JLabel wordLabel;
	private JLabel numberLetters;
	private JLabel hangManImage;
	private JLabel scoreLabel;
	private JLabel scoreCumulLabel;
	private JLabel stateLabel;
	private String wordGame = "";
	private Word word;
	private Controler controler;
	private Score scoreObject;
	private int score;
	private int cumulScore;
	private int nbError;
	
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
	
	public GamePanel(Word word) {
		
		//Instanciation de l'objet controleur	
		Controler controler = new Controler(word);
		
		this.controler = controler;
						
		this.wordGame = controler.getHideWord();
		this.score = controler.getScore();
		
		controler.addObserver(this);
		
		displayGamePanel(word);
				
	}
	
	 @Override
		public void update(Integer state) {
		 	
			String mot = controler.wordToFind();
			Font font5 = new Font("Arial", Font.BOLD, 16);
			
			if(state == 1) {
				clavierEnabled();
				numberLetters.setFont(font5);
				numberLetters.setForeground(new Color(237,0,0));
				numberLetters.setText("** GAGNÉ ** ");
				
			} else if (state == 2) {
				clavierEnabled();
				numberLetters.setFont(font5);
				numberLetters.setForeground(new Color(0,86,27));
				numberLetters.setText("Le mot à trouver était " + mot);			  
			}			
		}
	
	public void setWordGame() {
		this.wordGame = controler.getHideWord();
	}
	
	public String getWordGame() {
		return wordGame;
	}
	
	public void setWordLabel() {
			wordLabel.setText("perdu");
	}
		
	public JLabel getWordLabel() {
		return wordLabel;
	}
	
	public int getScore() {
		return score;
	}
	
	
	//gère les actions selon le type de boutons
	public class BoutonListener implements ActionListener {
			
			private JButton btn;
			private Word word;
			private JLabel wordLabel;
			private JLabel scoreLabel;
			private JLabel hangManImage;
			private int nbError;
			
			//Constructeur
			public BoutonListener (JButton btn, Word word, JLabel wordLabel, JLabel scoreLabel, JLabel hangManImage) {
			
				this.btn = btn;	
				this.word = word;
				this.wordLabel = wordLabel;
				this.scoreLabel = scoreLabel;
				this.hangManImage = hangManImage;
			}
			
			public String getBtn() {
				return btn.getText();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(controler.getGameState() == 0) {
				btn.setEnabled(false);
				btn.setBackground(Color.LIGHT_GRAY);
				controler.letterInWord(btn.getText());
				wordGame = controler.getHideWord();
				wordLabel.setText(wordGame);
				score = controler.getScore();
				
				if(score == 0) {
					scoreLabel.setText("Votre score actuel : " + Integer.toString(getScore()) + " point");
				} else {
					scoreLabel.setText("Votre score actuel : " + Integer.toString(getScore()) + " points");
				}
				
				ImageIcon image = controler.getUrlImage();
				
				System.out.println("nouveau score : " + getScore());
				System.out.println("wordGame :"+ getWordGame());
				
					if(image != null) {
					
						hangManImage.setIcon(new ImageIcon(image.getImage()));				
					}						
				}			
			}
	}
	
	//gère l'affichage du GamePanel
	private void displayGamePanel(Word word) {
		
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
		
		//insertion du layout BoxLayout dans le scorePanel
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
			
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
		this.wordPanel = wordPanel;
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
		Font font4 = new Font("Arial", Font.BOLD, 16);
		JLabel title = new JLabel(textTitle);
		JLabel scoreLabel = new JLabel("Votre score actuel : "+ this.getScore() + " points");
		JLabel scoreCumulLabel = new JLabel("Votre score cumulé :     points");
		JLabel wordLabel = new JLabel(wordGame);

		JLabel numberLetters = new JLabel("mot à "+ word.getNumberLetters()+ " lettres");
		this.numberLetters = numberLetters;//sauvegarde nouveau JLabel numberLetters
		
		JLabel hangManImage = new JLabel(new ImageIcon ("images/pendu1.jpg"));
		
		//Mise en forme du titre 
		title.setFont(font1);
		title.setForeground(new Color(93,84,109));
		title.setHorizontalAlignment(JLabel.LEFT);
		title.setVerticalAlignment(JLabel.CENTER);
		Border espace = BorderFactory.createEmptyBorder(10, 165, 40, 0);
		title.setBorder(espace);
		
		//Mise en forme du score actuel
		scoreLabel.setFont(font4);
		scoreLabel.setForeground(new Color(85,23,209));
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);
		scoreLabel.setVerticalAlignment(JLabel.CENTER);
		Border espace5 = BorderFactory.createEmptyBorder(25, 0, 0, 0);
		scoreLabel.setBorder(espace5);
		

		//Mise en forme du score cumulé
		scoreCumulLabel.setFont(font4);
		scoreCumulLabel.setForeground(new Color(85,23,209));
		scoreCumulLabel.setHorizontalAlignment(JLabel.LEFT);
		scoreCumulLabel.setVerticalAlignment(JLabel.CENTER);
		Border espace6 = BorderFactory.createEmptyBorder(10, 0, 0, 0);
		scoreCumulLabel.setBorder(espace6);
		
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
		
		scorePanel.add(scoreLabel);
		scoreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		scorePanel.add(scoreCumulLabel);
		scoreCumulLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		wordPanel.setBackground(Color.white);
		wordPanel.add(wordLabel, BorderLayout.CENTER);
		wordPanel.add(numberLetters, BorderLayout.SOUTH);
		
		gameArea.add(wordPanel, BorderLayout.NORTH);
		gameArea.add(clavier, BorderLayout.CENTER);
		
		central.add(scorePanel, BorderLayout.SOUTH);
		central.add(hangManPanel, BorderLayout.EAST);
		central.add(gameArea, BorderLayout.WEST);
		
		this.add(title,BorderLayout.NORTH);
		this.add(central,BorderLayout.CENTER);
		
		//ecoute les boutons du clavier   
	    aLetter.addActionListener(new BoutonListener(aLetter, word, wordLabel, scoreLabel, hangManImage));
	    zLetter.addActionListener(new BoutonListener(zLetter, word, wordLabel, scoreLabel, hangManImage));
	    eLetter.addActionListener(new BoutonListener(eLetter, word, wordLabel, scoreLabel, hangManImage));
	    rLetter.addActionListener(new BoutonListener(rLetter, word, wordLabel, scoreLabel, hangManImage));
	    tLetter.addActionListener(new BoutonListener(tLetter, word, wordLabel, scoreLabel, hangManImage));
	    yLetter.addActionListener(new BoutonListener(yLetter, word, wordLabel, scoreLabel, hangManImage));
	    uLetter.addActionListener(new BoutonListener(uLetter, word, wordLabel, scoreLabel, hangManImage));
	    iLetter.addActionListener(new BoutonListener(iLetter, word, wordLabel, scoreLabel, hangManImage));
	    oLetter.addActionListener(new BoutonListener(oLetter, word, wordLabel, scoreLabel, hangManImage));
	    pLetter.addActionListener(new BoutonListener(pLetter, word, wordLabel, scoreLabel, hangManImage));
	    qLetter.addActionListener(new BoutonListener(qLetter, word, wordLabel, scoreLabel, hangManImage));
	    sLetter.addActionListener(new BoutonListener(sLetter, word, wordLabel, scoreLabel, hangManImage));
	    dLetter.addActionListener(new BoutonListener(dLetter, word, wordLabel, scoreLabel, hangManImage));
	    fLetter.addActionListener(new BoutonListener(fLetter, word, wordLabel, scoreLabel, hangManImage));
	    gLetter.addActionListener(new BoutonListener(gLetter, word, wordLabel, scoreLabel,hangManImage));
	    hLetter.addActionListener(new BoutonListener(hLetter, word, wordLabel, scoreLabel,hangManImage));
	    jLetter.addActionListener(new BoutonListener(jLetter, word,wordLabel, scoreLabel, hangManImage));
	    kLetter.addActionListener(new BoutonListener(kLetter, word, wordLabel, scoreLabel, hangManImage));
	    lLetter.addActionListener(new BoutonListener(lLetter, word, wordLabel, scoreLabel, hangManImage));
	    mLetter.addActionListener(new BoutonListener(mLetter, word, wordLabel, scoreLabel, hangManImage));
	    wLetter.addActionListener(new BoutonListener(wLetter, word, wordLabel, scoreLabel, hangManImage));
	    xLetter.addActionListener(new BoutonListener(xLetter, word, wordLabel, scoreLabel, hangManImage));
	    cLetter.addActionListener(new BoutonListener(cLetter, word, wordLabel, scoreLabel, hangManImage));
	    vLetter.addActionListener(new BoutonListener(vLetter, word, wordLabel, scoreLabel, hangManImage));
	    bLetter.addActionListener(new BoutonListener(bLetter, word, wordLabel, scoreLabel, hangManImage));
	    nLetter.addActionListener(new BoutonListener(nLetter, word, wordLabel, scoreLabel, hangManImage));
	    tiret.addActionListener(new BoutonListener(tiret, word, wordLabel, scoreLabel, hangManImage));
	    
	    this.setVisible(false);
	}
	
	private void clavierEnabled() {
		 	aLetter.setEnabled(false);
		 	zLetter.setEnabled(false);
			eLetter.setEnabled(false);
			rLetter.setEnabled(false);
			tLetter.setEnabled(false);
			yLetter.setEnabled(false);
			uLetter.setEnabled(false);
			iLetter.setEnabled(false);
			oLetter.setEnabled(false);
			pLetter.setEnabled(false);
			qLetter.setEnabled(false);
			sLetter.setEnabled(false);
			dLetter.setEnabled(false);
			fLetter.setEnabled(false);
			gLetter.setEnabled(false);
			hLetter.setEnabled(false);
			jLetter.setEnabled(false);
			kLetter.setEnabled(false);
			lLetter.setEnabled(false);
			mLetter.setEnabled(false);
			wLetter.setEnabled(false);
			xLetter.setEnabled(false);
			cLetter.setEnabled(false);
			vLetter.setEnabled(false);
			bLetter.setEnabled(false);
			nLetter.setEnabled(false);
			tiret.setEnabled(false);
	}
	
}
