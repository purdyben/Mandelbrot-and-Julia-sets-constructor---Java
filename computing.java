package program;

/**
 * 
 * @author Ben Purdy
 *
 */
public class computing extends launcher {
	public static double[][] pixelArray;
	private static double juliaReal = 0.285 +.03;
	private static double juliaImaginary = 0.01+.03;
	// −0.8 + 0.156
	// 0.285 + 0.01

	/**
	 * computing class constructor creates a double array[][] for each pixel on
	 * screen
	 */
	public computing() {
		pixelArray = new double[launcher.width][launcher.height];
	}

	/**
	 * sets the topLeft and bottomRight before calculating each point of the screen
	 * PickingEquation is used to pick between Julie set equation and MandelBrot set
	 * equation
	 * 
	 * @param PickingEquation
	 * @return double[][]
	 */
	public double[][] calculate(int PickingEquation) { // Calculates the graph to be drawn
		topLeft = new complexNum(center.getReal() - (1 / scale), center.getImag() - (1 / scale));
		bottomRight = new complexNum(center.getReal() + (1 / scale), center.getImag() + (1 / scale));

		System.out.println("center = :" + center.toString());
		System.out.println("topLeft = :" + topLeft + ", bottomRight = : " + bottomRight);
		return IteratingNum(topLeft, bottomRight, width, height, PickingEquation);

	}

	/**
	 * returns double[][] with number of iterations for each pixel PickingEquation
	 * picks the equation mandelBrotNumLimit or juliaNumLimit
	 * 
	 * @param topLeft
	 * @param bottomRight
	 * @param width
	 * @param height
	 * @param PickingEquation
	 * @return
	 */
	public static double[][] IteratingNum(complexNum topLeft, complexNum bottomRight, int width, int height,
			int PickingEquation) {

		long timeMill = System.currentTimeMillis();

		double[][] result = new double[width][height];

		for (int x = 0; x < width; x++) {

			double real = ((bottomRight.getReal() - topLeft.getReal()) / width) * x + topLeft.getReal();

			for (int y = 0; y < height; y++) {

				double imag = -(((bottomRight.getImag() - topLeft.getImag()) / height) * y + topLeft.getImag());

				if (PickingEquation == 1) {
					pixelArray[x][y] = mandelBrotNumLimit(new complexNum(real, imag));
				} else if (PickingEquation == 2) {
					pixelArray[x][y] = juliaNumLimit(new complexNum(real, imag));
				}
			}

		}
		System.out.println("Time to Iterate threw the array = :" + (System.currentTimeMillis() - timeMill)
				+ " limit = :" + launcher.limit + "\n \n");
		return result;
	}

	/**
	 * calculates the number of integrations to see if the point is bounded or
	 * unbounded based on MandelBrot set equations
	 * 
	 * @param c
	 * @return double
	 */
	public static double mandelBrotNumLimit(complexNum c) {
		complexNum z = new complexNum(0, 0);
		double result = 0;
		int iterations = 1;
		while (iterations <= launcher.limit) {
			complexSquared(z);
			complexAdd(z, c);
			double value = absoluteValue(z);
			if (value >= threshold) {
				result = iterations;
				break;
			}
			iterations++;
		}
		return result;
	}

	/**
	 * calculates the number of integrations to see if the point is bounded or
	 * unbounded based on julia set calculations
	 * 
	 * @param c
	 * @return double
	 */
	public static double juliaNumLimit(complexNum c) {
		int iterations = 1;
		while (iterations < launcher.limit && c.getReal() * c.getReal() + c.getImag() * c.getImag() < threshold) {

			double temp = (c.getReal() * c.getReal()) - (c.getImag() * c.getImag()) + juliaReal;
			c.setImag((2 * c.getImag() * c.getReal()) + juliaImaginary);
			c.setReal(temp);

			iterations++;
		}
		return iterations;

	}

	/**
	 * Squares a comlex number
	 * 
	 * @param number
	 */
	private static void complexSquared(complexNum number) {
		double tempi = number.getReal() * number.getImag();
		number.setReal((number.getReal() * number.getReal()) + (number.getImag() * number.getImag() * -1));
		number.setImag(tempi + tempi);
	}

	/**
	 * Adds complexNum added to complexNum addedTo
	 * 
	 * @param addedTo
	 * @param added
	 */
	private static void complexAdd(complexNum addedTo, complexNum added) {
		addedTo.setReal(addedTo.getReal() + added.getReal());
		addedTo.setImag(addedTo.getImag() + added.getImag());
	}

	/**
	 * Absolute value of complexNum num
	 * 
	 * @param num
	 * @return
	 */
	private static double absoluteValue(complexNum num) {
		double x = Math.abs(num.getReal());
		double y = Math.abs(num.getImag());
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * Multiples complexNum num1 and complexNum num2 using the foil method
	 * 
	 * @param num1
	 * @param num2
	 */
	public static void complexFOIL(complexNum num1, complexNum num2) {
		// (2+5i)*(3+8i) need to use the FOIL method
		num1.setReal(num1.getReal() * num2.getReal() + num1.getImag() * num2.getImag());
		num1.setImag(num1.getReal() * num2.getImag() + num1.getImag() * num2.getReal());
	}

	public double getjuliaReal() {
		return juliaReal;
	}

	public double getjuliaImaginary() {
		return juliaImaginary;
	}

	public void setjuliaReal(double num) {
		juliaReal = num;
	}

	public void setjuliaImaginary(double num) {
		juliaImaginary = num;
	}
}
