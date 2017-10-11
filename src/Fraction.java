public class Fraction {

	private int numerator;
	private int denominator;
	private boolean improper;

	public Fraction() {
		this(0, 1);
	}

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

	/**
	 * creates a Fraction object for an integer
	 * 
	 * @param integer
	 */
	public Fraction(int integer) {
		this(integer, 1);
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
			if (smaller == 0) {
				return larger;
			}
			temp = larger;
			larger = smaller;
			smaller = temp % smaller;
		}
	}

	/**
	 * @return if the fraction is an improper fraction
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

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }
}
