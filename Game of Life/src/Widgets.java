import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Clase Widgets che estende JPanel; consiste in quindici bottoni utilizzati per inserire le varie forme
 * (il primo è un cannone, i successivi sette sono oscillatori, gli ultimi sette sono navicelle).
 */

public class Widgets extends JPanel {
	
	/**
	 * Array di quindici boolean inizializzato a false; diventa true nel momento in cui viene premuto il bottone corrispondente.
	 */

	static boolean[] buttons = {false, false, false, false , false, false, false, false, false, false, false, false, false, false, false};
	
	/**
	 * Costruttore della classe Widgets 
	 */

	public Widgets() {

		/**
		 * Il layout è organizzato a griglia di una riga e quindici colonne.
		 */

		this.setLayout(new GridLayout(1, 15, 50, 50));
		this.setBackground(Color.white);

		/**
		 * Aggiunta dei quindici bottoni del widget.
		 */
		
		this.add(new btnCannoneAlianteDiGosper());
		
		this.add(new btnBlinker());
		this.add(new btnFigureEight());
		this.add(new btnPulsar());
		this.add(new btnCaterer());
		this.add(new btnOneBeacon());
		this.add(new btnClock());
		this.add(new btnBentKeys());
		
		this.add(new btnGlider());
		this.add(new btnHwss());
		this.add(new btn30P5H2V0());
		this.add(new btnOrion());
		this.add(new btnNonmonotonicspaceship1());
		this.add(new btnHivenudger());
		this.add(new btnBarge2spaceship());
	}


	/**
	 * Ogni costruttore dei bottoni crea un bottone prendendo l'immagine corrispondente.
	 * Inoltre viene aggiunta una descrizione della forma (Nome forma, tipo forma, inventore, anno di scoperta) nel tooltip.
	 * Quando viene premuto un bottone viene messo a true la cella dell'array corrispondente a quel bottone.
	 */

	public class btnBlinker extends JButton {
		public btnBlinker()	{
			super(new ImageIcon("images/Blinker.png"));
			this.setToolTipText("Blinker, Oscillatore, John Conway, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[0] = true;
				}
			});	
		}
	}

	public class btnGlider extends JButton {
		public btnGlider()	{
			super(new ImageIcon("images/Glider.png"));
			this.setToolTipText("Glider, Navicella, Richard K. Guy, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[1] = true;
				}
			});	
		}
	}

	public class btnCannoneAlianteDiGosper extends JButton {
		public btnCannoneAlianteDiGosper()	{
			super(new ImageIcon("images/CannoneAlianteDiGosper.png"));
			this.setToolTipText("Cannone aliante di Gosper, Cannone, Bill Gosper, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[2] = true;
				}
			});	
		}
	}

	public class btnFigureEight extends JButton {
		public btnFigureEight()	{
			super(new ImageIcon("images/Figureeight.png"));
			this.setToolTipText("Figure Eight, Oscillatore, Simon Norton, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[3] = true;
				}
			});	
		}
	}

	public class btnPulsar extends JButton {
		public btnPulsar()	{
			super(new ImageIcon("images/Pulsar.png"));
			this.setToolTipText("Pulsar, Oscillatore, John Conway, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[4] = true;
				}
			});	
		}
	}

	public class btnCaterer extends JButton {
		public btnCaterer()	{
			super(new ImageIcon("images/Caterer.png"));
			this.setToolTipText("Caterer, Oscillatore, Dean Hickerson, 1989");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[5] = true;
				}
			});	
		}
	}

	public class btnOneBeacon extends JButton {
		public btnOneBeacon()	{
			super(new ImageIcon("images/OneBeacon.png"));
			this.setToolTipText("One Beacon, Oscillatore, Sconosciuto, Sconosciuto");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[6] = true;
				}
			});	
		}
	}

	public class btnClock extends JButton {
		public btnClock() {
			super(new ImageIcon("images/Clock.png"));
			this.setToolTipText("Clock, Oscillatore, Simon Norton, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[7] = true;
				}
			});	
		}
	}

	public class btnHwss extends JButton {
		public btnHwss() {
			super(new ImageIcon("images/HWSS.png"));
			this.setToolTipText("Heavyweight Spaceship, Navicella, John Conway, 1970");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[8] = true;
				}
			});	
		}
	}

	public class btnBentKeys extends JButton {
		public btnBentKeys() {
			super(new ImageIcon("images/BentKeys.png"));
			this.setToolTipText("Bent Keys, Oscillatore, Dean Hickerson, 1989");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[9] = true;
				}
			});	
		}
	}

	public class btn30P5H2V0 extends JButton {
		public btn30P5H2V0()	{
			super(new ImageIcon("images/30p5h2v0.png"));
			this.setToolTipText("30P5H2V0, Navicella, Paul Tooke, 2000");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[10] = true;
				}
			});	
		}
	}

	public class btnNonmonotonicspaceship1 extends JButton {
		public btnNonmonotonicspaceship1()	{
			super(new ImageIcon("images/Nonmonotonicspaceship1.png"));
			this.setToolTipText("Nonmonotonicspaceship1, Navicella, Hartmut Holzwart, 1992");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[11] = true;
				}
			});	
		}
	}



	public class btnOrion extends JButton {
		public btnOrion()	{
			super(new ImageIcon("images/Orion.png"));
			this.setToolTipText("Orion, Navicella, Hartmut Holzwart, 1993");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[12] = true;
				}
			});	
		}
	}


	public class btnHivenudger extends JButton {
		public btnHivenudger()	{
			super(new ImageIcon("images/Hivenudger.png"));
			this.setToolTipText("Hivenudger, Navicella, Hartmut Holzwart, 1992");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[13] = true;
				}
			});	
		}
	}


	public class btnBarge2spaceship extends JButton {
		public btnBarge2spaceship()	{
			super(new ImageIcon("images/Barge2spaceship.png"));
			this.setToolTipText("Barge To Space Ship, Navicella, Hartmut Holzwart, Sconosciuto");
			this.setBackground(Color.white);
			this.setBorderPainted(false);

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					buttons[14] = true;
				}
			});	
		}
	}
}