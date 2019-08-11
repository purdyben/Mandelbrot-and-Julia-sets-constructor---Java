package program;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * 
 * @author Ben Purdy
 *
 */
public class MyComponent extends JComponent implements MouseListener {

	private launcher launcher;

	/**
	 * Mouse click event zooms in and displays the new image
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("here was a click ! ");

		PointerInfo mousePointer = MouseInfo.getPointerInfo();
		program.launcher.center = setCenter(arg0.getX(), arg0.getY());//(mousePointer.getLocation().getX(), mousePointer.getLocation().getY());
		program.launcher.scale = launcher.scale * 2;
		program.launcher.limit += 20;

		if (program.launcher.frameLauncher.getExtraInformation() == 1) {
			program.launcher.calculateArray.calculate(1);
		} else {
			program.launcher.calculateArray.calculate(2);
		}
		Display.frameRedraw(JframeLauncher.frame.getGraphics());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * creates a new center bases on where you click
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private complexNum setCenter(double x, double y) {
		complexNum complexNum = new complexNum(
				((launcher.bottomRight.getReal() - launcher.topLeft.getReal()) / launcher.width) * x
						+ launcher.topLeft.getReal(),
				(((launcher.bottomRight.getImag() - launcher.topLeft.getImag()) / launcher.height) * y
						+ launcher.topLeft.getImag()));
		return complexNum;
	}

}
