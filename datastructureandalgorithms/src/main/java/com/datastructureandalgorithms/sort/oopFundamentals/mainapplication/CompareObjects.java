package com.mainapplication;

class CompareObjects {

	private double re, im;

	public CompareObjects(double re, double im) {
		this.re = re;
		this.im = im;
	}

	// Overriding equals() to compare two Complex objects
	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof CompareObjects)) {
			return false;
		}

		// type-cast o to Complex so that we can compare data members
		CompareObjects c = (CompareObjects) o;

		// Compare the data members and return accordingly
		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}
}