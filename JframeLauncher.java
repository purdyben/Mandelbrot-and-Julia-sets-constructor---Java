package program;

import java.awt.Component;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 * 
 * @author Ben Purdy
 *
 */
public class JframeLauncher {
	public static JFrame frame;
	public static Display display;
	protected static Component mouseClick;
	public int extraInformation;

	/**
	 * JFrame constructor creates new JFrame() and creates Component mouseClick if
	 * dictated by extraInformation
	 * 
	 * @param width
	 * @param hight
	 * @param extraInformation
	 */
	public JframeLauncher(int width, int hight, int extraInformation) {
		this.extraInformation = extraInformation;
		frame = new JFrame();
		run(width, hight, extraInformation);
	}

	/**
	 * creates the JFrame() called by the constructor
	 * 
	 * @param width
	 * @param hight
	 * @param extraInformation
	 */
	private static void run(int width, int hight, int extraInformation) {

		if (extraInformation == 1) {
			frame = new JFrame("The MandelBrot Set");
			mouseClick = new MyComponent();
			frame.addMouseListener((MouseListener) mouseClick);
		} else if (extraInformation == 2) {
			frame = new JFrame("julia Set");
			mouseClick = new MyComponent();
			frame.addMouseListener((MouseListener) mouseClick);
		} else if (extraInformation == 3) {
			frame = new JFrame("julia Set");
		}

		frame.setSize(width, hight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Display());
		frame.setVisible(true);

	}
	public int getExtraInformation() {
		return extraInformation;
	}
}
