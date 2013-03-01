import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Classe Bottoni che estende JPanel; contiene 
 */

public class Bottoni extends JPanel {

	/**
	 * Campo statico che determina se il gioco si deve bloccare (cioè evolvi pari a false)o è in esecuzione
	 * (cioè evolvi è pari a true).
	 */

	static boolean evolvi = false;
	
	/**
	 * Costruttore della classe Bottoni.
	 */
	
	public Bottoni() {

		/**
		 * Layout organizzato a griglia di una riga e 3 colonne.
		 * Ogni bottone occupa una cella.
		 */

		this.setLayout(new GridLayout(1, 3, 10, 10));

		/**
		 * Aggiunta a Bottoni dei tre bottoni. 
		 */

		this.add(new btnStopStart());
		this.add(new btnPulisci());
		this.add(new btnInfo());
	}


	/**
	 * Classe del bottone di Stop e Start che estende JButton.
	 */

	public class btnStopStart extends JButton {
		public btnStopStart() {
			super("Start");

			this.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {

					JButton btnTemp = (JButton)event.getSource();

					/**
					 * Se alla premuta del tasto evolvi è false allora diventa true
					 * e il bottone cambia testo in "Start" (precedentemente era "Stop", il gioco era in esecuzione).
					 * Altrimenti se evolsi è true allora diventa false e il bottone cambia testo in "Stop"
					 * (precedentemente era "Start", il gioco era fermo).
					 */

					if (evolvi == true) {
						evolvi = false;
						btnTemp.setText("Start");
					}
					else {
						evolvi = true;
						btnTemp.setText("Stop");
					}	
				}
			});	
		}
	}

	/**
	 * Classe del bottone Pulisci che estende JButton;
	 * Alla sua premuta il campo viene resettato e tutte le cellule
	 * (comprese quelle rosse, cioè quelle uccise dall'utente) vengono uccise,
	 * cioè diventa bianche.
	 */

	public class btnPulisci extends JButton {
		public btnPulisci() {
			super("Pulisci");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {

					/**
					 * Prima di pulire il campo interrompo il gioco.
					 * Con la variabile interrotto tengo conto se precedentemente alla premuta del tasto il gioco era un pausa o era in esecuzione 
					 */

					boolean interrotto = (evolvi == true) ? true : false;
					evolvi = false;

					/**
					 * Prima di pulire il campo aspetto 100ms così le varie thread finiscono di disegnare il campo.
					 * altrimenti si resetterebbe il campo ma le thread disegnerebbero le cellule rimanenti sulla base
					 * di previous che non è aggiornata.
					 */

					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					/**
					 * Pulisco il campo, tutte le cellule diventa bianche (cioè morte).
					 */

					for (Cellula[] rigaDiCellule: Gioco.next)
						for (Cellula cellula: rigaDiCellule)
							cellula.setWhite();

					/**
					 * Ripristino il valore di evolvi precedente alla premuta del tasto Pulisci
					 */

					evolvi = (interrotto == true) ? true : false;
				}
			});	
		}	
	}

	public class btnInfo extends JButton {
		public btnInfo() {
			super("Info");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {

					/**
					 * Prima di dare le informazioni interrompo il gioco.
					 * Con la variabile interrotto tengo conto se precedentemente alla premuta del tasto il gioco era un pausa o era in esecuzione 
					 */

					boolean interrotto = (evolvi == true) ? true : false;
					evolvi = false;

					JOptionPane.showMessageDialog(null, "The Game of Life è un automa cellulare sviluppato dal matematico inglese John Conway sul finire degli anni sessanta.\n " +
							" Il gioco della vita è l'esempio più famoso di automa cellulare: il suo scopo è quello di mostrare come comportamenti simili\n " +
							" alla vita possano emergere da regole semplici e interazioni a molti corpi, principio che è alla base dell'ecobiologia,\n " +
							" la quale si rifà anche alla teoria della complessità.\n\n " +
							" Per maggiori informazioni visitare la pagina: http://it.wikipedia.org/wiki/Gioco_della_vita\n\n" +
							" Autori: Luca Barile [VR359306] - Vincenzo Arceri [VR360465].", "Informazioni", JOptionPane.INFORMATION_MESSAGE);// ", "Informazioni", JOptionPane.INFORMATION_MESSAGE);// lancio il messaggio

					/**
					 * Ripristino il valore di evolvi precedente alla premuta del tasto Info
					 */

					evolvi = (interrotto == true) ? true : false;
				}
			});	
		}	
	}
}