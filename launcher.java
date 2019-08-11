package program;

import java.util.Scanner;

/**
 * 
 * @author Ben Purdy
 *Launcher for the program
 */
public class launcher {
/**
 * starting values used to create or change the program
 * width = : width of JFrame // keep square
 * height = : height of jFrame // keep square
 * threshold = : establishes a breaking point during computing
 * limit = : number of iterations before number is considered bounded
 * scale = : starting scale or magnification
 * center = : starting center point 
 * topLeft = : complex number equal to the top left corder of the graph
 * bottomRight = : complex number equal to the bottom right corder of the graph
 * frameLauncher = : JFrame launcher class
 * calculateArray = : computing class object
 */
	public String title = "The MandelBrot Set";
	static int width = 900;
	static int height = 900;
	static double[][] pixelArray;
	static double threshold = 2;
	static int limit = 400; 
	static double scale = .6;
	static complexNum center = new complexNum(0, 0);

	static complexNum topLeft;
	static complexNum bottomRight;

	static JframeLauncher frameLauncher;
	static computing calculateArray = new computing();
	
	
	public static void main(String[] args) {

		Scanner str = new Scanner(System.in);
		
		System.out.println("The MandelBrot Set enter 1 or julia set enter 2? ");

		 int selector = str.nextInt();
		
		if (selector == 1) {
			limit = 100;
			center = new complexNum(-0.79, 0.15);
			calculateArray.calculate(1);

			pixelArray = computing.pixelArray;

			frameLauncher = new JframeLauncher(width, height,selector);
			

		}

		else if (selector == 2 || selector == 3) {
			calculateArray.calculate(2);
			pixelArray = computing.pixelArray;

			frameLauncher = new JframeLauncher(width, height,selector);

			if (selector == 3) { //  Test Julie set animation
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = 0;

				while (i < 20) {
					calculateArray.setjuliaReal(calculateArray.getjuliaReal() + .01);
					calculateArray.setjuliaImaginary(calculateArray.getjuliaImaginary() + .01);
					calculateArray.calculate(2);
					Display.frameRedraw(JframeLauncher.frame.getGraphics());
					i++;

				}

			}
		}
		str.close();

	}
	public String getTitle() {
		return title;
	}

}
