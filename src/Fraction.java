
public class Fraction {

	private int numerator;
	private int denominator;
	private boolean improper;

	/**
	 * creates a Fraction object when the numerator and denominator is provided
	 * 
	 * @param numerator
	 *            the numerator of the fraction
	 * @param denominator
	 *            the denominator of the fraction
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.improper = numerator > denominator ? true : false;
		reduce();
	}

	public Fraction(int integer) {
		this(integer, 1);
	}

	public Fraction(double decimal) {
		String decString = Double.toString(decimal);
		int frontNum = Integer.parseInt(decString.substring(0, decString.indexOf('.')));
		int endNum = Integer.parseInt(decString.substring(decString.indexOf('.') + 1));
		int numDec = decString.length() - decString.indexOf('.') - 1;
	}

	/**
	 * reduces the fraction to lowest terms
	 * 
	 * @return if the fraction was reduced
	 */
	public boolean reduce() {
		int GCF = getGCF(numerator, denominator);
		if (GCF == 1) {
			return false;
		}
		numerator /= GCF;
		denominator /= GCF;
		return true;
	}

	@Override
	public String toString() {
		return (numerator + "/" + denominator);
	}

	/**
	 * returns the GCF for two integers
	 * 
	 * @param a
	 *            the first integer
	 * @param b
	 *            the second integer
	 * @return the GCF of a and b
	 */
	private int getGCF(int a, int b) {
		int larger = a > b ? a : b;
		int smaller = a > b ? b : a;
		int temp;

		while (true) {
			if (b == 0) {
				return b;
			}
			temp = larger;
			larger = smaller;
			smaller = temp % smaller;
		}
	}

	/**
	 * @return f the fraction is an improper fraction
	 */
	public boolean isImproper() {
		return improper;
	}

	/**
	 * adds two Fraction objects together
	 * 
	 * @param fraction
	 *            the Fraction object to add
	 * @return a Fraction object of the sum
	 */
	public Fraction add(Fraction fraction) {
		return new Fraction(fraction.numerator + numerator, fraction.denominator + denominator);
	}

	/**
	 * adds an integer to a Fraction object
	 * 
	 * @param num
	 *            the integer to add
	 * @return a Fraction object of the sun
	 */
	public Fraction add(int num) {
		return this.add(new Fraction(num));
	}
}
