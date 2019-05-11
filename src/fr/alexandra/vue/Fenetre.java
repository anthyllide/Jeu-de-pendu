package fr.alexandra.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import fr.alexandra.model.Word;


public class Fenetre extends JFrame {
	//création Jpanel principal
	private JPanel container = new JPanel();
	
	private AccueilPanel accueil = new AccueilPanel();
	private RulesPanel rulesPage = new RulesPanel();
	private GamePanel gamePage = new GamePanel(new Word());
	private ScorePanel scorePage  = new ScorePanel();
	private AboutPanel aProposPage = new AboutPanel();
	
	//création du menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier");
   // private JMenu aPropos = new JMenu ("A Propos");
    
    //création des sous-menus
    private JMenuItem nouveau = new JMenuItem("Nouveau");
    private JMenuItem scores = new JMenuItem("Scores");
    private JMenuItem regles = new JMenuItem("Règles");
    private JMenuItem aPropos = new JMenuItem("A propos");
	
	public Fenetre() {
	
	
    this.setTitle("P'tit Pendu !!");     
    this.setSize(850, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    initMenu();
    
    //Ajout de la barre de menus sur la fenêtre
    this.setJMenuBar(menuBar);
    
    container.setBackground(Color.WHITE);
    
    //Ajout accueil
    container.add(accueil);
    container.add(gamePage);
    container.add(scorePage);
    container.add(rulesPage);
    container.add(aProposPage);
      
    //Ajout du JPanel principal à la fenêtre
    this.setContentPane(container);
    
    this.setVisible(true);
     
	}
			
	private void initMenu() {
		
		//ajout des sous-menu au menu Fichiers
		//ajout d'accélérateurs
		this.nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		this.fichier.add(nouveau);
		
		this.scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		this.fichier.add(scores);
		
		this.regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		this.fichier.add(regles);
		
		//this.aPropos.add(aides);
		
		//ajout des menus à la barre de menu
		this.menuBar.add(fichier);
		this.menuBar.add(aPropos);
		
		//Listeners 
		this.nouveau.addActionListener(new DisplayNewGameListener());
		this.scores.addActionListener(new DisplayScoreListener());
		this.regles.addActionListener(new DisplayRulesListener());
		this.aPropos.addActionListener(new DisplayAboutListener());
	}
	
	//écoute si le bouton "nouveau" est cliqué
	public class DisplayNewGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			//on lance un nouveau mot
			gamePage = new GamePanel(new Word());
			
			//on retire tous les panels du container
			container.removeAll();
			container.add(accueil);
		    container.add(gamePage);
		    container.add(scorePage);
		    container.add(rulesPage);
		    container.add(aProposPage);
		    //puis on réaffiche le container
			container.revalidate();
			accueil.setVisible(false);
			scorePage.setVisible(false);
			rulesPage.setVisible(false);
			gamePage.setVisible(true);
			aProposPage.setVisible(false);
			
		}
		
	}
	
	//écoute si le bouton "score" est cliqué
	public class DisplayScoreListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			accueil.setVisible(false); 
			scorePage.setVisible(true);	//on rend visible la page score
			rulesPage.setVisible(false);
			gamePage.setVisible(false);
			aProposPage.setVisible(false);
		}
		
	}
	
	//écoute si le bouton "règles" est cliqué
	public class DisplayRulesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			accueil.setVisible(false);
			scorePage.setVisible(false);	
			rulesPage.setVisible(true);	//on rend visible la page "règle"
			gamePage.setVisible(false); 
			aProposPage.setVisible(false);
		}
		
	}
	
	//écoute si le bouton "à propos" est cliqué
	public class DisplayAboutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			accueil.setVisible(false);
			scorePage.setVisible(false);	
			rulesPage.setVisible(false);	
			gamePage.setVisible(false); 
			aProposPage.setVisible(true);//on rend visible la page "à propos"
		}
		
	}
	

}
