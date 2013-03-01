import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Start extends JFrame {
	public Start() {

		/**
		 * Array contenente i possibili valori da scegliere nell'InputDialog
		 * per determinare il numero di thread da utilizzare nel gioco.
		 */

		Object[] possibiliValori = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		Object selectedValue = JOptionPane.showInputDialog(null, "Inserisci il numero di thread", "The Game of Life", JOptionPane.QUESTION_MESSAGE, null, possibiliValori, possibiliValori[1]);


		/**
		 * Se è stato premuto il tasto "Annulla" o è stata chiusa la finestra di dialogo allora il programma termina,
		 * altrimenti viene creata la classe Gioco.
		 */

		if (selectedValue != null)
			new Gioco((int)selectedValue);		
	}
}
