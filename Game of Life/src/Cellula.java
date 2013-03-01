import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Classe Cellula che estende JButton.
 */

public class Cellula extends JButton {

	/**
	 * Dimensione della cellula in pixel
	 */

	private final static int SIZE = 10;

	/**
	 * Posizione sull'ascissa in pixel 
	 */

	private int xPosition;

	/**
	 * Posizione sull'ordinata in pixel 
	 */

	private int yPosition;

	/**
	 * Colore della cellula: se è bianca signica che è morta, se è nera significa che è viva, 
	 * se è rossa significa che è stata uccisa definitivamente dall'utente.
	 */

	private Color color;

	/**
	 * Costruttore della classe Cellula.
	 * 
	 * @param x	Posizione sull'ascissa in pixel.
	 * @param y Posizione sull'ordinata in pixel.
	 */

	public Cellula(int x, int y) {

		/**
		 * Al momento della creazione della cellula quest'ultima è morta e quindi bianca.
		 */

		this.color = Color.white;
		this.setBackground(color);

		this.setBounds(x, y, SIZE, SIZE);
		this.setVisible(true);
		this.xPosition = x;
		this.yPosition = y;

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				/**
				 * btnCliccato vale true se è stato cliccato un bottone appartenente al Widgets
				 */

				boolean btnCliccato = false;

				/**
				 * Contiene l'indice di Widgets.buttons del bottone che è stato premuto
				 */

				int numWidget = 0;


				for (int i = 0; i < Widgets.buttons.length; i++) {

					/**
					 * Se Widgets.buttons[i] == true allora significa che l'utente vuole disegnare un widget
					 */

					if (Widgets.buttons[i] == true) {

						/**
						 * È stato cliccato un bottone del Widgets
						 */

						btnCliccato = true;

						/**
						 * Prendo l'indice del bottone che è stato premuto
						 */

						numWidget = i;

						/**
						 * Azzero tutti i bottoni cliccati 
						 */

						for(int k = 0; k < Widgets.buttons.length; k++)
							Widgets.buttons[k] = false;	

						break;
					}
				}

				/**
				 * Se non è stato premuto un bottone del widgets allora la cellula deve diventare rossa
				 * altrimenti controllo che widget è stato premuto, tramite uno switch.
				 */

				if (btnCliccato == false)
					setRed();

				/**
				 * In ogni case viene controllato se il disegno del widgets riesce a restare all'interno del campo;
				 * se sfora dal campo viene disegnano solamente quello che può essere disegnato riportando un 
				 * messaggio d'avviso.
				 */

				else {
					switch (numWidget) {

					/**
					 * Blinker
					 */

					case 0:

						try {
							creaBlinker();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Glider
						 */

					case 1:

						try {
							creaGlider();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Cannone aliante di Gosper
						 */

					case 2:

						try {
							creaCannoneAlianteDiGosper();
						}
						catch (Exception outOfBorde) {

							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Figure Eight
						 */

					case 3:

						try {
							creaFigureEight();
						}
						catch (Exception outOfBorde) {

							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Pulsar	
						 */

					case 4:

						try {
							creaPulsar();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Ceterer
						 */

					case 5:

						try {
							creaCaterer();
						}
						catch (Exception outOfBorde) {

							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * One Beacon
						 */

					case 6:

						try {
							creaOneBeacon();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Clock
						 */

					case 7:

						try {
							creaClock();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * HWSS
						 */

					case 8:
						try {
							creaHWSS();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Bent Keys
						 */

					case 9:

						try {
							creaBentKeys();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * 30P5H2V0
						 */

					case 10:			

						try {
							crea30P5H2V0();
						}
						catch (Exception outOfBorde) {

							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Nonmonotonic Spaceship
						 */

					case 11:			
						try {
							creaNonmonotonicSpaceship();	
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Orion
						 */

					case 12:

						try {
							creaOrion();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Hivenudger
						 */

					case 13:	
						try {
							creaHivenudger();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}

						break;

						/**
						 * Barge 2 Spaceship
						 */

					case 14:	
						try {
							creaBarge2Spaceship();
						}
						catch (Exception outOfBorde) {
							if (Bottoni.evolvi == true) {
								Bottoni.evolvi = false;
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
								Bottoni.evolvi = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Alcune cellule del Widget scelto non sono state disegnate poichè escono dai bordi del frame.", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);// lancio il messaggio di errore outOfborde
							}	
						}
						break;
					}


				}	
			}
		}
				);
	}


	/**
	 * Ritorna la coordinata X della cellula
	 * @return xPosition
	 */

	@Override
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Ritorna la coordinata Y della cellula
	 * @return yPosition
	 */

	@Override
	public int getY() {
		return this.yPosition;
	}
	/**
	 * Ritorna il colore attuale della cellula
	 * @return color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Cambia il colore della cellula in nero.
	 */

	public void setBlack() {
		this.color = Color.black;
		this.setBackground(color);
		setVisible(true);
	}

	/**
	 * Cambia il colore della cellula in rosso.
	 */

	public void setRed() {
		this.color = Color.red;
		this.setBackground(color);
		setVisible(true);
	}

	/**
	 * Cambia il colore della cellula in bianco.
	 */

	public void setWhite() {
		this.color = Color.white;
		this.setBackground(color);
		setVisible(true);
	}

	/**
	 * Ritorna l'indice X della cellula all'interno della matrice
	 */

	public int indiceX() {
		return (int) (this.getX() - 15) / 10;
	}

	/**
	 * Ritorna l'indice Y della cellula all'interno della matrice
	 */

	public int indiceY() {
		return (int) ((this.getY() -35) / 10);
	}

	/**
	 * Creazione di HWSS rispetto alla cellula this
	 */

	public void creaHWSS() {
		Gioco.next[indiceX()+3][indiceY()].setBlack();
		Gioco.next[indiceX()+4][indiceY()].setBlack();

		Gioco.next[indiceX()+1][indiceY()+1].setBlack();
		Gioco.next[indiceX()+6][indiceY()+1].setBlack();

		Gioco.next[indiceX()][indiceY()+2].setBlack();

		Gioco.next[indiceX()][indiceY()+3].setBlack();
		Gioco.next[indiceX()+6][indiceY()+3].setBlack();

		Gioco.next[indiceX()][indiceY()+4].setBlack();
		Gioco.next[indiceX()+1][indiceY()+4].setBlack();
		Gioco.next[indiceX()+2][indiceY()+4].setBlack();
		Gioco.next[indiceX()+3][indiceY()+4].setBlack();
		Gioco.next[indiceX()+4][indiceY()+4].setBlack();
		Gioco.next[indiceX()+5][indiceY()+4].setBlack();
	}

	/**
	 * Creazione di Bent Keys rispetto alla cellula this
	 */

	public void creaBentKeys() {
		Gioco.next[indiceX()+1][indiceY()].setBlack();
		Gioco.next[indiceX()+10][indiceY()].setBlack();

		Gioco.next[indiceX()+0][indiceY()+1].setBlack();
		Gioco.next[indiceX()+2][indiceY()+1].setBlack();
		Gioco.next[indiceX()+9][indiceY()+1].setBlack();
		Gioco.next[indiceX()+11][indiceY()+1].setBlack();

		Gioco.next[indiceX()+1][indiceY()+2].setBlack();
		Gioco.next[indiceX()+3][indiceY()+2].setBlack();
		Gioco.next[indiceX()+4][indiceY()+2].setBlack();
		Gioco.next[indiceX()+7][indiceY()+2].setBlack();
		Gioco.next[indiceX()+8][indiceY()+2].setBlack();
		Gioco.next[indiceX()+10][indiceY()+2].setBlack();

		Gioco.next[indiceX()+4][indiceY()+3].setBlack();
		Gioco.next[indiceX()+7][indiceY()+3].setBlack();

		Gioco.next[indiceX()+4][indiceY()+4].setBlack();
		Gioco.next[indiceX()+7][indiceY()+4].setBlack();
	}

	/**
	 * Creazione di Glider rispetto alla cellula this
	 */

	public void creaGlider() {
		Gioco.next[indiceX()][indiceY()].setBlack();
		Gioco.next[indiceX() + 1][indiceY() + 1].setBlack();
		Gioco.next[indiceX() + 1][indiceY() + 2].setBlack();
		Gioco.next[indiceX()][indiceY() + 2].setBlack();
		Gioco.next[indiceX() - 1][indiceY() + 2].setBlack();
	}

	/**
	 * Creazione di Cannone aliante di Gosper rispetto alla cellula this
	 */

	public void creaCannoneAlianteDiGosper() {
		Gioco.next[indiceX() + 1][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 2][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 1][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 2][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 11][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 11][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 11][indiceY() + 7].setBlack();
		Gioco.next[indiceX() + 12][indiceY() + 4].setBlack();
		Gioco.next[indiceX() + 12][indiceY() + 8].setBlack();
		Gioco.next[indiceX() + 13][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 13][indiceY() + 9].setBlack();
		Gioco.next[indiceX() + 14][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 14][indiceY() + 9].setBlack();
		Gioco.next[indiceX() + 15][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 16][indiceY() + 4].setBlack();
		Gioco.next[indiceX() + 16][indiceY() + 8].setBlack();
		Gioco.next[indiceX() + 17][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 17][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 17][indiceY() + 7].setBlack();
		Gioco.next[indiceX() + 18][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 21][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 21][indiceY() + 4].setBlack();
		Gioco.next[indiceX() + 21][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 22][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 22][indiceY() + 4].setBlack();
		Gioco.next[indiceX() + 22][indiceY() + 5].setBlack();
		Gioco.next[indiceX() + 23][indiceY() + 2].setBlack();
		Gioco.next[indiceX() + 23][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 25][indiceY() + 1].setBlack();
		Gioco.next[indiceX() + 25][indiceY() + 2].setBlack();
		Gioco.next[indiceX() + 25][indiceY() + 6].setBlack();
		Gioco.next[indiceX() + 25][indiceY() + 7].setBlack();
		Gioco.next[indiceX() + 35][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 35][indiceY() + 4].setBlack();
		Gioco.next[indiceX() + 36][indiceY() + 3].setBlack();
		Gioco.next[indiceX() + 36][indiceY() + 4].setBlack();
	}

	/**
	 * Creazione di Clock rispetto alla cellula this
	 */

	public void creaClock() {
		Gioco.next[indiceX()+2][indiceY()].setBlack();

		Gioco.next[indiceX()][indiceY()+1].setBlack();
		Gioco.next[indiceX()+2][indiceY()+1].setBlack();

		Gioco.next[indiceX()+1][indiceY()+2].setBlack();
		Gioco.next[indiceX()+3][indiceY()+2].setBlack();

		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
	}

	/**
	 * Creazione di One Beacon rispetto alla cellula this
	 */

	public void creaOneBeacon() {
		Gioco.next[indiceX()+2][indiceY()].setBlack();
		Gioco.next[indiceX()+3][indiceY()].setBlack();

		Gioco.next[indiceX()+1][indiceY()+1].setBlack();
		Gioco.next[indiceX()+3][indiceY()+1].setBlack();

		Gioco.next[indiceX()][indiceY()+2].setBlack();
		Gioco.next[indiceX()+3][indiceY()+2].setBlack();
		Gioco.next[indiceX()+5][indiceY()+2].setBlack();
		Gioco.next[indiceX()+6][indiceY()+2].setBlack();

		Gioco.next[indiceX()][indiceY()+3].setBlack();
		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+3][indiceY()+3].setBlack();
		Gioco.next[indiceX()+6][indiceY()+3].setBlack();

		Gioco.next[indiceX()+1][indiceY()+4].setBlack();
		Gioco.next[indiceX()+3][indiceY()+4].setBlack();

		Gioco.next[indiceX()+1][indiceY()+5].setBlack();
		Gioco.next[indiceX()+4][indiceY()+5].setBlack();

		Gioco.next[indiceX()+2][indiceY()+6].setBlack();
		Gioco.next[indiceX()+3][indiceY()+6].setBlack();
	}

	/**
	 * Creazione di Caterer rispetto alla cellula this
	 */

	public void creaCaterer() {
		Gioco.next[indiceX()][indiceY()].setBlack();

		Gioco.next[indiceX()-2][indiceY()+1].setBlack();
		Gioco.next[indiceX()-2][indiceY()+2].setBlack();
		Gioco.next[indiceX()-2][indiceY()+3].setBlack();

		Gioco.next[indiceX()+2][indiceY()+1].setBlack();
		Gioco.next[indiceX()+3][indiceY()+1].setBlack();
		Gioco.next[indiceX()+4][indiceY()+1].setBlack();
		Gioco.next[indiceX()+5][indiceY()+1].setBlack();

		Gioco.next[indiceX()+2][indiceY()+2].setBlack();

		Gioco.next[indiceX()+1][indiceY()+4].setBlack();

		Gioco.next[indiceX()][indiceY()+5].setBlack();
		Gioco.next[indiceX()-1][indiceY()+5].setBlack();
	}

	/**
	 * Creazione di Pulsar rispetto alla cellula this
	 */

	public void creaPulsar() {
		Gioco.next[indiceX()][indiceY()].setBlack();
		Gioco.next[indiceX()+1][indiceY()].setBlack();
		Gioco.next[indiceX()+3][indiceY()].setBlack();
		Gioco.next[indiceX()+4][indiceY()].setBlack();
		Gioco.next[indiceX()+5][indiceY()].setBlack();
		Gioco.next[indiceX()+6][indiceY()].setBlack();
		Gioco.next[indiceX()+7][indiceY()].setBlack();
		Gioco.next[indiceX()+8][indiceY()].setBlack();

		Gioco.next[indiceX()][indiceY()+1].setBlack();
		Gioco.next[indiceX()+1][indiceY()+1].setBlack();
		Gioco.next[indiceX()+3][indiceY()+1].setBlack();
		Gioco.next[indiceX()+4][indiceY()+1].setBlack();
		Gioco.next[indiceX()+5][indiceY()+1].setBlack();
		Gioco.next[indiceX()+6][indiceY()+1].setBlack();
		Gioco.next[indiceX()+7][indiceY()+1].setBlack();
		Gioco.next[indiceX()+8][indiceY()+1].setBlack();

		Gioco.next[indiceX()][indiceY()+2].setBlack();
		Gioco.next[indiceX()+1][indiceY()+2].setBlack();

		Gioco.next[indiceX()][indiceY()+3].setBlack();
		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+7][indiceY()+3].setBlack();
		Gioco.next[indiceX()+8][indiceY()+3].setBlack();

		Gioco.next[indiceX()][indiceY()+4].setBlack();
		Gioco.next[indiceX()+1][indiceY()+4].setBlack();
		Gioco.next[indiceX()+7][indiceY()+4].setBlack();
		Gioco.next[indiceX()+8][indiceY()+4].setBlack();

		Gioco.next[indiceX()][indiceY()+5].setBlack();
		Gioco.next[indiceX()+1][indiceY()+5].setBlack();
		Gioco.next[indiceX()+7][indiceY()+5].setBlack();
		Gioco.next[indiceX()+8][indiceY()+5].setBlack();

		Gioco.next[indiceX()+7][indiceY()+6].setBlack();
		Gioco.next[indiceX()+8][indiceY()+6].setBlack();

		Gioco.next[indiceX()][indiceY()+7].setBlack();
		Gioco.next[indiceX()+1][indiceY()+7].setBlack();
		Gioco.next[indiceX()+2][indiceY()+7].setBlack();
		Gioco.next[indiceX()+3][indiceY()+7].setBlack();
		Gioco.next[indiceX()+4][indiceY()+7].setBlack();
		Gioco.next[indiceX()+5][indiceY()+7].setBlack();
		Gioco.next[indiceX()+7][indiceY()+7].setBlack();
		Gioco.next[indiceX()+8][indiceY()+7].setBlack();

		Gioco.next[indiceX()][indiceY()+8].setBlack();
		Gioco.next[indiceX()+1][indiceY()+8].setBlack();
		Gioco.next[indiceX()+2][indiceY()+8].setBlack();
		Gioco.next[indiceX()+3][indiceY()+8].setBlack();
		Gioco.next[indiceX()+4][indiceY()+8].setBlack();
		Gioco.next[indiceX()+5][indiceY()+8].setBlack();
		Gioco.next[indiceX()+7][indiceY()+8].setBlack();
		Gioco.next[indiceX()+8][indiceY()+8].setBlack();
	}

	/**
	 * Creazione di Figure Eight rispetto alla cellula this
	 */

	public void creaFigureEight() {
		Gioco.next[indiceX()][indiceY()].setBlack();
		Gioco.next[indiceX()+1][indiceY()].setBlack();
		Gioco.next[indiceX()][indiceY()+1].setBlack();
		Gioco.next[indiceX()+1][indiceY()+1].setBlack();
		Gioco.next[indiceX()+3][indiceY()+1].setBlack();
		Gioco.next[indiceX()+4][indiceY()+2].setBlack();
		Gioco.next[indiceX()+2][indiceY()+4].setBlack();
		Gioco.next[indiceX()+4][indiceY()+4].setBlack();
		Gioco.next[indiceX()+4][indiceY()+5].setBlack();
		Gioco.next[indiceX()+5][indiceY()+5].setBlack();
		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+5][indiceY()+4].setBlack();
	}

	/**
	 * Creazione di Blinker rispetto alla cellula this
	 */

	public void creaBlinker() {
		Gioco.next[indiceX()][indiceY()].setBlack();
		Gioco.next[indiceX() + 1][indiceY()].setBlack();
		Gioco.next[indiceX() + 2][indiceY()].setBlack();
	}

	/**
	 * Creazione di Orion rispetto alla cellula this 
	 */

	public void creaOrion() {
		Gioco.next[indiceX()+3][indiceY()].setBlack();
		Gioco.next[indiceX()+4][indiceY()].setBlack();

		Gioco.next[indiceX()+3][indiceY()+1].setBlack();
		Gioco.next[indiceX()+5][indiceY()+1].setBlack();

		Gioco.next[indiceX()+3][indiceY()+2].setBlack();

		Gioco.next[indiceX()][indiceY()+3].setBlack();
		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+3][indiceY()+3].setBlack();

		Gioco.next[indiceX()][indiceY()+4].setBlack();
		Gioco.next[indiceX()+5][indiceY()+4].setBlack();

		Gioco.next[indiceX()][indiceY()+5].setBlack();
		Gioco.next[indiceX()+2][indiceY()+5].setBlack();
		Gioco.next[indiceX()+3][indiceY()+5].setBlack();
		Gioco.next[indiceX()+10][indiceY()+5].setBlack();
		Gioco.next[indiceX()+11][indiceY()+5].setBlack();
		Gioco.next[indiceX()+12][indiceY()+5].setBlack();

		Gioco.next[indiceX()+5][indiceY()+6].setBlack();
		Gioco.next[indiceX()+6][indiceY()+6].setBlack();
		Gioco.next[indiceX()+7][indiceY()+6].setBlack();
		Gioco.next[indiceX()+12][indiceY()+6].setBlack();
		Gioco.next[indiceX()+13][indiceY()+6].setBlack();


		Gioco.next[indiceX()+6][indiceY()+7].setBlack();
		Gioco.next[indiceX()+7][indiceY()+7].setBlack();
		Gioco.next[indiceX()+8][indiceY()+7].setBlack();
		Gioco.next[indiceX()+10][indiceY()+7].setBlack();
		Gioco.next[indiceX()+12][indiceY()+7].setBlack();

		Gioco.next[indiceX()+13][indiceY()+8].setBlack();

		Gioco.next[indiceX()+6][indiceY()+9].setBlack();
		Gioco.next[indiceX()+8][indiceY()+9].setBlack();

		Gioco.next[indiceX()+5][indiceY()+10].setBlack();
		Gioco.next[indiceX()+6][indiceY()+10].setBlack();
		Gioco.next[indiceX()+8][indiceY()+10].setBlack();

		Gioco.next[indiceX()+6][indiceY()+11].setBlack();

		Gioco.next[indiceX()+4][indiceY()+12].setBlack();
		Gioco.next[indiceX()+5][indiceY()+12].setBlack();
		Gioco.next[indiceX()+7][indiceY()+12].setBlack();

		Gioco.next[indiceX()+7][indiceY()+13].setBlack();

		Gioco.next[indiceX()+5][indiceY()+14].setBlack();
		Gioco.next[indiceX()+6][indiceY()+14].setBlack();

	}

	/**
	 * Creazione di Barge 2 Spaceship
	 */

	public void creaBarge2Spaceship() {
		Gioco.next[indiceX()+14][indiceY()].setBlack();
		Gioco.next[indiceX()+15][indiceY()].setBlack();
		Gioco.next[indiceX()+16][indiceY()].setBlack();
		Gioco.next[indiceX()+18][indiceY()].setBlack();
		Gioco.next[indiceX()+19][indiceY()].setBlack();
		Gioco.next[indiceX()+20][indiceY()].setBlack();

		Gioco.next[indiceX()+13][indiceY()+1].setBlack();
		Gioco.next[indiceX()+16][indiceY()+1].setBlack();
		Gioco.next[indiceX()+18][indiceY()+1].setBlack();
		Gioco.next[indiceX()+21][indiceY()+1].setBlack();

		Gioco.next[indiceX()+12][indiceY()+2].setBlack();
		Gioco.next[indiceX()+16][indiceY()+2].setBlack();
		Gioco.next[indiceX()+18][indiceY()+2].setBlack();
		Gioco.next[indiceX()+22][indiceY()+2].setBlack();

		Gioco.next[indiceX()+7][indiceY()+3].setBlack();
		Gioco.next[indiceX()+8][indiceY()+3].setBlack();
		Gioco.next[indiceX()+9][indiceY()+3].setBlack();
		Gioco.next[indiceX()+11][indiceY()+3].setBlack();
		Gioco.next[indiceX()+14][indiceY()+3].setBlack();
		Gioco.next[indiceX()+16][indiceY()+3].setBlack();
		Gioco.next[indiceX()+18][indiceY()+3].setBlack();
		Gioco.next[indiceX()+20][indiceY()+3].setBlack();
		Gioco.next[indiceX()+23][indiceY()+3].setBlack();
		Gioco.next[indiceX()+25][indiceY()+3].setBlack();
		Gioco.next[indiceX()+26][indiceY()+3].setBlack();
		Gioco.next[indiceX()+27][indiceY()+3].setBlack();


		Gioco.next[indiceX()+6][indiceY()+4].setBlack();
		Gioco.next[indiceX()+9][indiceY()+4].setBlack();
		Gioco.next[indiceX()+11][indiceY()+4].setBlack();
		Gioco.next[indiceX()+16][indiceY()+4].setBlack();
		Gioco.next[indiceX()+18][indiceY()+4].setBlack();
		Gioco.next[indiceX()+23][indiceY()+4].setBlack();
		Gioco.next[indiceX()+25][indiceY()+4].setBlack();
		Gioco.next[indiceX()+28][indiceY()+4].setBlack();

		Gioco.next[indiceX()+5][indiceY()+5].setBlack();
		Gioco.next[indiceX()+9][indiceY()+5].setBlack();
		Gioco.next[indiceX()+11][indiceY()+5].setBlack();
		Gioco.next[indiceX()+13][indiceY()+5].setBlack();
		Gioco.next[indiceX()+15][indiceY()+5].setBlack();
		Gioco.next[indiceX()+19][indiceY()+5].setBlack();
		Gioco.next[indiceX()+21][indiceY()+5].setBlack();
		Gioco.next[indiceX()+23][indiceY()+5].setBlack();
		Gioco.next[indiceX()+25][indiceY()+5].setBlack();
		Gioco.next[indiceX()+29][indiceY()+5].setBlack();

		Gioco.next[indiceX()+5][indiceY()+6].setBlack();
		Gioco.next[indiceX()+29][indiceY()+6].setBlack();

		Gioco.next[indiceX()+7][indiceY()+7].setBlack();
		Gioco.next[indiceX()+27][indiceY()+7].setBlack();

		Gioco.next[indiceX()+4][indiceY()+8].setBlack();
		Gioco.next[indiceX()+6][indiceY()+8].setBlack();
		Gioco.next[indiceX()+28][indiceY()+8].setBlack();
		Gioco.next[indiceX()+30][indiceY()+8].setBlack();

		Gioco.next[indiceX()+3][indiceY()+9].setBlack();
		Gioco.next[indiceX()+4][indiceY()+9].setBlack();
		Gioco.next[indiceX()+6][indiceY()+9].setBlack();
		Gioco.next[indiceX()+8][indiceY()+9].setBlack();
		Gioco.next[indiceX()+9][indiceY()+9].setBlack();
		Gioco.next[indiceX()+10][indiceY()+9].setBlack();
		Gioco.next[indiceX()+24][indiceY()+9].setBlack();
		Gioco.next[indiceX()+25][indiceY()+9].setBlack();
		Gioco.next[indiceX()+26][indiceY()+9].setBlack();
		Gioco.next[indiceX()+28][indiceY()+9].setBlack();
		Gioco.next[indiceX()+30][indiceY()+9].setBlack();
		Gioco.next[indiceX()+31][indiceY()+9].setBlack();

		Gioco.next[indiceX()+2][indiceY()+10].setBlack();
		Gioco.next[indiceX()+4][indiceY()+10].setBlack();
		Gioco.next[indiceX()+6][indiceY()+10].setBlack();
		Gioco.next[indiceX()+10][indiceY()+10].setBlack();
		Gioco.next[indiceX()+24][indiceY()+10].setBlack();
		Gioco.next[indiceX()+28][indiceY()+10].setBlack();
		Gioco.next[indiceX()+30][indiceY()+10].setBlack();
		Gioco.next[indiceX()+32][indiceY()+10].setBlack();

		Gioco.next[indiceX()+1][indiceY()+11].setBlack();
		Gioco.next[indiceX()+2][indiceY()+11].setBlack();
		Gioco.next[indiceX()+4][indiceY()+11].setBlack();
		Gioco.next[indiceX()+30][indiceY()+11].setBlack();
		Gioco.next[indiceX()+32][indiceY()+11].setBlack();
		Gioco.next[indiceX()+33][indiceY()+11].setBlack();

		Gioco.next[indiceX()][indiceY()+12].setBlack();
		Gioco.next[indiceX()+4][indiceY()+12].setBlack();
		Gioco.next[indiceX()+10][indiceY()+12].setBlack();
		Gioco.next[indiceX()+11][indiceY()+12].setBlack();
		Gioco.next[indiceX()+23][indiceY()+12].setBlack();
		Gioco.next[indiceX()+24][indiceY()+12].setBlack();
		Gioco.next[indiceX()+30][indiceY()+12].setBlack();
		Gioco.next[indiceX()+34][indiceY()+12].setBlack();

		Gioco.next[indiceX()][indiceY()+14].setBlack();
		Gioco.next[indiceX()+1][indiceY()+14].setBlack();
		Gioco.next[indiceX()+3][indiceY()+14].setBlack();
		Gioco.next[indiceX()+4][indiceY()+14].setBlack();
		Gioco.next[indiceX()+30][indiceY()+14].setBlack();
		Gioco.next[indiceX()+31][indiceY()+14].setBlack();
		Gioco.next[indiceX()+33][indiceY()+14].setBlack();
		Gioco.next[indiceX()+34][indiceY()+14].setBlack();
	}

	/**
	 * Creazione di Hivenudger rispetto alla cellula this
	 */
	public void creaHivenudger() {
		Gioco.next[indiceX()][indiceY()].setBlack();
		Gioco.next[indiceX()+1][indiceY()].setBlack();
		Gioco.next[indiceX()+2][indiceY()].setBlack();
		Gioco.next[indiceX()+3][indiceY()].setBlack();
		Gioco.next[indiceX()+9][indiceY()].setBlack();
		Gioco.next[indiceX()+13][indiceY()].setBlack();

		Gioco.next[indiceX()][indiceY()+1].setBlack();
		Gioco.next[indiceX()+4][indiceY()+1].setBlack();
		Gioco.next[indiceX()+8][indiceY()+1].setBlack();

		Gioco.next[indiceX()][indiceY()+2].setBlack();
		Gioco.next[indiceX()+8][indiceY()+2].setBlack();
		Gioco.next[indiceX()+13][indiceY()+2].setBlack();

		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+4][indiceY()+3].setBlack();
		Gioco.next[indiceX()+8][indiceY()+3].setBlack();
		Gioco.next[indiceX()+9][indiceY()+3].setBlack();
		Gioco.next[indiceX()+10][indiceY()+3].setBlack();
		Gioco.next[indiceX()+11][indiceY()+3].setBlack();
		Gioco.next[indiceX()+12][indiceY()+3].setBlack();

		Gioco.next[indiceX()+5][indiceY()+5].setBlack();
		Gioco.next[indiceX()+6][indiceY()+5].setBlack();

		Gioco.next[indiceX()+5][indiceY()+6].setBlack();
		Gioco.next[indiceX()+6][indiceY()+6].setBlack();

		Gioco.next[indiceX()+5][indiceY()+7].setBlack();
		Gioco.next[indiceX()+6][indiceY()+7].setBlack();

		Gioco.next[indiceX()+1][indiceY()+9].setBlack();
		Gioco.next[indiceX()+4][indiceY()+9].setBlack();
		Gioco.next[indiceX()+8][indiceY()+9].setBlack();
		Gioco.next[indiceX()+9][indiceY()+9].setBlack();
		Gioco.next[indiceX()+10][indiceY()+9].setBlack();
		Gioco.next[indiceX()+11][indiceY()+9].setBlack();
		Gioco.next[indiceX()+12][indiceY()+9].setBlack();

		Gioco.next[indiceX()][indiceY()+10].setBlack();
		Gioco.next[indiceX()+8][indiceY()+10].setBlack();
		Gioco.next[indiceX()+13][indiceY()+10].setBlack();

		Gioco.next[indiceX()][indiceY()+11].setBlack();
		Gioco.next[indiceX()+4][indiceY()+11].setBlack();
		Gioco.next[indiceX()+8][indiceY()+11].setBlack();

		Gioco.next[indiceX()][indiceY()+12].setBlack();
		Gioco.next[indiceX()+1][indiceY()+12].setBlack();
		Gioco.next[indiceX()+2][indiceY()+12].setBlack();
		Gioco.next[indiceX()+3][indiceY()+12].setBlack();
		Gioco.next[indiceX()+9][indiceY()+12].setBlack();
		Gioco.next[indiceX()+13][indiceY()+12].setBlack();
	}

	/**
	 * Creazione di NonmonotonicSpaceship rispetto alla cellula this
	 */

	public void creaNonmonotonicSpaceship() {
		Gioco.next[indiceX()+10][indiceY()].setBlack();
		Gioco.next[indiceX()+11][indiceY()].setBlack();
		Gioco.next[indiceX()+13][indiceY()].setBlack();

		Gioco.next[indiceX()+6][indiceY()+1].setBlack();
		Gioco.next[indiceX()+7][indiceY()+1].setBlack();
		Gioco.next[indiceX()+8][indiceY()+1].setBlack();
		Gioco.next[indiceX()+10][indiceY()+1].setBlack();
		Gioco.next[indiceX()+12][indiceY()+1].setBlack();
		Gioco.next[indiceX()+13][indiceY()+1].setBlack();
		Gioco.next[indiceX()+14][indiceY()+1].setBlack();

		Gioco.next[indiceX()+2][indiceY()+2].setBlack();
		Gioco.next[indiceX()+4][indiceY()+2].setBlack();
		Gioco.next[indiceX()+15][indiceY()+2].setBlack();
		Gioco.next[indiceX()+19][indiceY()+2].setBlack();
		Gioco.next[indiceX()+20][indiceY()+2].setBlack();

		Gioco.next[indiceX()][indiceY()+3].setBlack();
		Gioco.next[indiceX()+1][indiceY()+3].setBlack();
		Gioco.next[indiceX()+6][indiceY()+3].setBlack();
		Gioco.next[indiceX()+7][indiceY()+3].setBlack();
		Gioco.next[indiceX()+13][indiceY()+3].setBlack();
		Gioco.next[indiceX()+17][indiceY()+3].setBlack();
		Gioco.next[indiceX()+18][indiceY()+3].setBlack();
		Gioco.next[indiceX()+19][indiceY()+3].setBlack();
		Gioco.next[indiceX()+20][indiceY()+3].setBlack();

		Gioco.next[indiceX()+2][indiceY()+4].setBlack();
		Gioco.next[indiceX()+4][indiceY()+4].setBlack();
		Gioco.next[indiceX()+5][indiceY()+4].setBlack();
		Gioco.next[indiceX()+8][indiceY()+4].setBlack();
		Gioco.next[indiceX()+13][indiceY()+4].setBlack();
		Gioco.next[indiceX()+14][indiceY()+4].setBlack();
		Gioco.next[indiceX()+15][indiceY()+4].setBlack();
		Gioco.next[indiceX()+17][indiceY()+4].setBlack();

		Gioco.next[indiceX()+8][indiceY()+5].setBlack();
		Gioco.next[indiceX()+13][indiceY()+5].setBlack();

		Gioco.next[indiceX()+2][indiceY()+6].setBlack();
		Gioco.next[indiceX()+4][indiceY()+6].setBlack();
		Gioco.next[indiceX()+5][indiceY()+6].setBlack();
		Gioco.next[indiceX()+8][indiceY()+6].setBlack();
		Gioco.next[indiceX()+13][indiceY()+6].setBlack();
		Gioco.next[indiceX()+14][indiceY()+6].setBlack();
		Gioco.next[indiceX()+15][indiceY()+6].setBlack();
		Gioco.next[indiceX()+17][indiceY()+6].setBlack();

		Gioco.next[indiceX()][indiceY()+7].setBlack();
		Gioco.next[indiceX()+1][indiceY()+7].setBlack();
		Gioco.next[indiceX()+6][indiceY()+7].setBlack();
		Gioco.next[indiceX()+7][indiceY()+7].setBlack();
		Gioco.next[indiceX()+13][indiceY()+7].setBlack();
		Gioco.next[indiceX()+17][indiceY()+7].setBlack();
		Gioco.next[indiceX()+18][indiceY()+7].setBlack();
		Gioco.next[indiceX()+19][indiceY()+7].setBlack();
		Gioco.next[indiceX()+20][indiceY()+7].setBlack();

		Gioco.next[indiceX()+2][indiceY()+8].setBlack();
		Gioco.next[indiceX()+4][indiceY()+8].setBlack();
		Gioco.next[indiceX()+15][indiceY()+8].setBlack();
		Gioco.next[indiceX()+19][indiceY()+8].setBlack();
		Gioco.next[indiceX()+20][indiceY()+8].setBlack();

		Gioco.next[indiceX()+6][indiceY()+9].setBlack();
		Gioco.next[indiceX()+7][indiceY()+9].setBlack();
		Gioco.next[indiceX()+8][indiceY()+9].setBlack();
		Gioco.next[indiceX()+10][indiceY()+9].setBlack();
		Gioco.next[indiceX()+12][indiceY()+9].setBlack();
		Gioco.next[indiceX()+13][indiceY()+9].setBlack();
		Gioco.next[indiceX()+14][indiceY()+9].setBlack();

		Gioco.next[indiceX()+10][indiceY()+10].setBlack();
		Gioco.next[indiceX()+11][indiceY()+10].setBlack();
		Gioco.next[indiceX()+13][indiceY()+10].setBlack();

	}

	/**
	 * Creazione di 30P5H2V0 rispetto alla cellula this
	 */

	public void crea30P5H2V0() {
		Gioco.next[indiceX()+4][indiceY()].setBlack();

		Gioco.next[indiceX()+3][indiceY()+1].setBlack();
		Gioco.next[indiceX()+4][indiceY()+1].setBlack();
		Gioco.next[indiceX()+5][indiceY()+1].setBlack();

		Gioco.next[indiceX()+2][indiceY()+2].setBlack();
		Gioco.next[indiceX()+3][indiceY()+2].setBlack();
		Gioco.next[indiceX()+5][indiceY()+2].setBlack();
		Gioco.next[indiceX()+6][indiceY()+2].setBlack();

		Gioco.next[indiceX()+1][indiceY()+4].setBlack();
		Gioco.next[indiceX()+3][indiceY()+4].setBlack();
		Gioco.next[indiceX()+5][indiceY()+4].setBlack();
		Gioco.next[indiceX()+7][indiceY()+4].setBlack();
		Gioco.next[indiceX()+10][indiceY()+4].setBlack();

		Gioco.next[indiceX()][indiceY()+5].setBlack();
		Gioco.next[indiceX()+1][indiceY()+5].setBlack();
		Gioco.next[indiceX()+5][indiceY()+5].setBlack();
		Gioco.next[indiceX()+9][indiceY()+5].setBlack();
		Gioco.next[indiceX()+10][indiceY()+5].setBlack();
		Gioco.next[indiceX()+11][indiceY()+5].setBlack();

		Gioco.next[indiceX()][indiceY()+6].setBlack();
		Gioco.next[indiceX()+1][indiceY()+6].setBlack();
		Gioco.next[indiceX()+5][indiceY()+6].setBlack();
		Gioco.next[indiceX()+12][indiceY()+6].setBlack();



		Gioco.next[indiceX()+10][indiceY()+7].setBlack();
		Gioco.next[indiceX()+12][indiceY()+7].setBlack();

		Gioco.next[indiceX()+8][indiceY()+8].setBlack();
		Gioco.next[indiceX()+10][indiceY()+8].setBlack();



		Gioco.next[indiceX()+9][indiceY()+9].setBlack();
		Gioco.next[indiceX()+12][indiceY()+9].setBlack();

		Gioco.next[indiceX()+12][indiceY()+10].setBlack();
	}
}

