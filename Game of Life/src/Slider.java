import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * Classe Slider che determina la velocità di passaggio da una generazione all'altra; estende JSlider.
 */

public class Slider extends JSlider {

	/**
	 * Costruttore di Slider.
	 */
	
	public Slider() {

		/**
		 * Valore minimo di Slider = 0.
		 * Valore massimo di Slider = 1000.
		 * Valore iniziale di Slider = 960;
		 * Slider varia di 100 in 100.
		 */

		super(JSlider.VERTICAL, 0, 1000, 960);

		this.setMajorTickSpacing(100);// 
		Hashtable labelTable = new Hashtable();
		labelTable.put(0, new JLabel("Min"));
		labelTable.put(1000, new JLabel("Max"));

		this.setLabelTable(labelTable);
		this.setPaintLabels(true);
	}
}
