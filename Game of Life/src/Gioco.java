import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;


/**
 * La classe Gioco è una classe che estende la classe JFrame e consiste
 * nella finistra contente il vero e proprio Game of Life.
 * Contiene i bottoni inseriti in un JPanel e posizionato a Nord, i widgets
 * posizionati a Sud e lo slider per regolare la velocità di passaggio da una generazione
 * all'altra.
 */

public class Gioco extends JFrame {

	/**
	 * Il numero di thread utilizzate.
	 */

	private int numeroDiThread;

	/**
	 * La matrice di cellule che consiste nella generazione successiva;
	 * questa è la matrice che effettivamente viene mostrata a video.
	 */

	static Cellula[][] next = new Cellula[100][50];

	/**
	 * La matrice di cellule che tiene conto delle informazioni relative alla generazione precedente,
	 * indispensabile per effettuare i calcoli da parte delle thread per far avanzare il gioco
	 * alla generazione successiva.
	 */

	static Cellula[][] previous = new Cellula[100][50];

	/**
	 * L'array di Worker che tiene traccia delle thread utilizzate dalla classe Gioco.
	 */

	private Worker[] lavoratori;

	/**
	 * JSlider utilizzato per regolare la velocità del passaggio da una generazione all'altra.
	 */

	JSlider slider = new Slider();

	/**
	 * Costruttore della classe Gioco
	 * 
	 * @param numeroDiThread	il numero di thread da utilizzare 
	 */

	public Gioco(int numeroDiThread) {
		super("The Game of Life ©");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Icona.png"));
		this.numeroDiThread = numeroDiThread;
		this.lavoratori = new Worker[numeroDiThread];
		this.setResizable(false);
		close();
		initGame();
	}

	/**
	 * Funzione che inizializza il gioco, crea il JFrame con il campo, lo slider e i vari bottoni. 
	 */

	private void initGame() {
		this.setBounds(0, 0, 1080, 665);

		/**
		 * La finestra viene centrata.  
		 */

		Dimension dimensione = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(new Point (((int)dimensione.getWidth() - this.getSize().width) /  2, (int)(dimensione.getHeight() - this.getSize().height)  / 2));

		/**
		 * Creazione e posizionamento della classe Widgets
		 */

		JScrollPane scroll = new JScrollPane(new Widgets());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scroll , BorderLayout.SOUTH);

		/**
		 * Creazione e posizionamento della classe Bottoni 
		 */

		this.add(new Bottoni(), BorderLayout.NORTH);

		/**
		 * Creazione e posizionamento della classe Slider 
		 */

		this.add(slider, BorderLayout.EAST);

		creaMondo();
		setVisible(true);
		evoluzione();
	}

	private void close() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creazione e posizionamento delle cellule 
	 */

	private void creaMondo() {
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 50; j++) {
				next[i][j] = new Cellula(i * 10 + 15, j * 10 + 35);
				this.getContentPane().add(next[i][j]);
			}

		Cellula temp = new Cellula(100 * 10, 50 * 10 + 35);
		this.getContentPane().add(temp);
		temp.setVisible(false);

	}

	/**
	 * Classe interna di Gioco che estende la classe Thread; 
	 * Un Worker è una thread che gestisce determinate righe della matrice di cellule.
	 */

	private class Worker extends Thread {

		/**
		 * Riga di inizio da cui parte la thread a lavorare.
		 */

		private int start;

		/**
		 * Riga di fine competenza della thread.
		 */

		private int end;

		/**
		 * Costruttore della classe Worker
		 * @param start
		 * @param end
		 */

		public Worker(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			
			/**
			 * Ogni thread controlla le cellulle posizionate tra la riga start e la riga end (start compresa, end esclusa).
			 */
			
			for (int i = 0; i < 100; i++)
				for(int j = start; j < end; j++) {
					if (previous[i][j].getColor() != Color.red) {

						int numVicini = 0;

						/**
						 * Controllo le otto cellule intorno alla cellula che la thread sta controllando
						 * e conto il numero di cellule vive intorno a questa.
						 */

						for (int dx = -1; dx <= 1; dx++)
							for (int dy = -1; dy <= 1; dy++) {
								try {
									if (previous[i + dx][j + dy].getColor() == Color.black)
										numVicini++;
								} catch (Exception outOfFrame) { }
							}

						/**
						 * Viene conteggiata come vicino anche la cellula che la thread sta esaminando
						 * quindi se quest'ultima è nera decremento il numero dei vicini vivi.
						 */

						if (previous[i][j].getColor() == Color.black)
							numVicini--;

						/**
						 * Se la cellula in esaminazione è morta e ha esattamente
						 * tre vicini vivi allora questa diventa viva alla generazione successiva.
						 */

						if (previous[i][j].getColor() == Color.white && numVicini == 3) 
							next[i][j].setBlack();

						/**
						 * Se la cellula in esaminazione è viva e ha 
						 * due o tre vicini vivi, allora questa sopravvive anche
						 * alla generazione successiva, altrimenti questa muore.
						 */

						if (previous[i][j].getColor() == Color.black) {
							if (numVicini == 2 || numVicini == 3)
								next[i][j].setBlack();
							else
								next[i][j].setWhite();
						}
					}
				}
		}
	}


	/**
	 * Funzione che assegna lo spazio di azione delle thread.
	 */

	private void evoluzione() {

		int space = Math.round(50 / numeroDiThread);

		while(true) {
			
			/**
			 * Necessito di tempo per vedere se l'utente vuole bloccare l'evoluzione o riprendere (creo una sorta di DoEvents)
			 */

			sleepFor(10);

			while (Bottoni.evolvi == true) {

				/**
				 * Copia della matrice next in previous, indispensabile per i calcoli che effettuano le thread
				 */

				for (int i = 0; i < 100; i++)
					for(int j = 0; j < 50; j++) {
						previous[i][j] = new Cellula(next[i][j].getX(), next[i][j].getY());

						if (next[i][j].getColor() == Color.white)
							previous[i][j].setWhite();
						else if (next[i][j].getColor() == Color.black)
							previous[i][j].setBlack();
						else
							previous[i][j].setRed();
					}
				
				/**
				 * Creazione ed esecuzione delle thread (l'ultima thread lanciata avrà uno spazio d'azione diverso dalle altre). 
				 */

				for (int i = 0; i < numeroDiThread; i++) {
					if (i == numeroDiThread - 1)
						lavoratori[i] = new Worker(i*space, 50);
					else
						lavoratori[i] = new Worker(i * space, i*space + space);

					lavoratori[i].start();
				}

				/**
				 * CurrentThread si mette in attesa di tutte le altre thread.
				 */

				for (Worker lavoratore: lavoratori) {
					try {
						lavoratore.join();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}

					setVisible(true);
					repaint();
				}
				
				/**
				 * CurrentThread attende un tempo pari a 1000 sottratto il valore di Slider 
				 */
				
				sleepFor(1000 - slider.getValue());
			}
		}
	}

	/**
	 * Funzione che addormenta la thread per un tempo pari a millisecondi
	 * @param millisecondi	
	 */

	private void sleepFor(int millisecondi) {
		try {
			Thread.currentThread().sleep(millisecondi);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
