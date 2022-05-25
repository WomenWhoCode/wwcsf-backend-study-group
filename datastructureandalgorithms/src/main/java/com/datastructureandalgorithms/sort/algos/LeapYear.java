package coding.problems;

public class LeapYear {

    public static void main(String[] args) {
        LeapYear leapYear = new LeapYear();
        int year2012 = 2012;
        int year2014 = 2014;
        int year2016 = 2016;
        System.out.println("Is " + year2012 + "a leap year? " + leapYear.isLeapYear(year2012));
        System.out.println("Is " + year2014 + "a leap year? " + leapYear.isLeapYear(year2014));
        System.out.println("Is " + year2016 + "a leap year? " + leapYear.isLeapYear(year2016));
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

}
