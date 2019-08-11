package program;
public class complexNum {
	double real;
	double imag;

	complexNum(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}

	public void setReal(double value) {
		real = value;
	}

	public void setImag(double value) {
		imag = value;
	}
	@Override
	public String toString() {
		return real + "," +imag;
		
	}
}
