package coding.problems;

/* PagerDuty onsite interview question 2019
 * Find a pair that adds up to a 100 - with an added requirement not to remove any duplicate pair.  Given no.s between 1
 * & 99 find all pairs that add to 100
 *
 * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */
public class IntegerPair {

    private int firstNumber;
    private int secondNumber;

    public IntegerPair(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public int hashCode() {
        return (32 + 7) * (this.firstNumber + this.secondNumber);
    }

    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null) { return false; }
        if (!(obj instanceof IntegerPair)) { return false; }
        return (this.firstNumber == ((IntegerPair) obj).getFirstNumber() && this.secondNumber == ((IntegerPair) obj).getSecondNumber());
    }

}