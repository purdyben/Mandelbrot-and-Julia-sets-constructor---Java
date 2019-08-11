package program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * @author Ben Purdy
 *
 */
@SuppressWarnings("serial")
public class Display extends JPanel {
	/**
	 * Display constructor
	 */
	Display() {
		setLayout(null);
	}

	/**
	 *  creates BufferedImage to be displayed
	 * @param g
	 */
	public void paint(Graphics g) {
		render(g);
	}

	/**
	 * Takes the result array from computing.calculate() and colors each pixel based on the result
	 * Displays the image using BufferedImage
	 * @param g
	 */
	private static void render(Graphics g) { 
		BufferedImage buff = new BufferedImage(launcher.width, launcher.height, 2);
		Graphics buffG = buff.getGraphics();
		
		for (int x = 0; x < launcher.width; x++) {
			for (int y = 0; y < launcher.height; y++) {
				double result = launcher.pixelArray[x][y];
				if (result == 0) { // is in set
					buffG.setColor(Color.black);
				} else {
					// if(result < 300 && result > 100 ) { // testing different color ideas
					// float[] hsbvals = new float[3];
					// float[] color = Color.RGBtoHSB(255,255,255, hsbvals);
					// g.setColor(Color.getHSBColor(color[0], color[1], color[2]));
					//
					// }
					if (result < launcher.limit / 2) {
						buffG.setColor(Color.getHSBColor((float) (Math.abs(2.7 - (result) / 255)), .6f, 1f)); // set the
																											// color
					} 
					else {
						buffG.setColor(Color.getHSBColor((float) (Math.abs(1 - (result) / 255)), .9f, 1f)); // set the color
					}
				}

				buffG.drawRect(x, y, 1, 1);
			}

		}
		g.drawImage(buff, 0, 0, null);

	}

	/**
	 * Method to redraw the frame
	 * @param g
	 */
	
	public static void frameRedraw(Graphics g) {
		render(g);
	}
}
