package coding.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Bookings {

    // TODO DOESNT WORK
    public static void main(String[] args) {
        System.out.println("Hello Java");
        System.out.println(findBookingStartDate("0:2 5:6 7:14", 1, 3));
    }

    /*
    Sonder determines availability based on existing bookings,
    serialized as colon-separated pairs of integers.
    The first integer is a check-in date, and the second is a check-out date.
    Each integer represents an offset since Jan 1, 2019. 
    E.g. '0:1' represents a booking where the check-in date is Jan 1st 2019,
    and the check-out date is Jan 2nd 2019.

    Directions
    Implement a method, booking_start_date(string bookings, int stay_length, int current_date)
    that will return the first day that can accommodate a booking of length stay_length.

    Examples:
    Input: bookings: '0:2 3:5 7:14', stay_length: 1, current_date: 4
    Output: 5
    Input: bookings: '0:3 3:6 7:14', stay_length: 2, current_date: 4
    Output: 14
    Input: bookings: '0:2 5:6 7:14', stay_length: 1, current_date: 3
    Output: 3

    Rules:
    Input is well-formed
    Bookings will not overlap
    Bookings are sorted in order of check-in date
    Only dates later than or equal to current date should be returned
    */
    private static int findBookingStartDate(String bookings, int stayLength, int currentDate) {
//        String[] date = bookings.split(" ");
//        ArrayList<String> dates = new ArrayList<>();
//        for (int i = 0; i < date.length * 2; i++) {
//            //dates.addAll(date[i].split(":"));
//        }
//        String[] dates = Arrays.toString(date).split(":"); // {'0', '2', '3', ...}


        String[] dates = bookings.split("[ :]");

        int startDate = 0;

        int[] bookingsDates = new int[dates.length];
        for (int i = 0; i < dates.length; i++) {
            bookingsDates[i] = parseInt(dates[i]);
        }

        // bookingDates = {0, 2, 3, 5, 7, 14}
        for (int i = 0; i < bookingsDates.length && i + 1 < bookingsDates.length; i++) {
            if (bookingsDates[i] >= currentDate && bookingsDates[i + 1] >= currentDate + stayLength) {
                if (bookingsDates[i] >= bookingsDates[i - 1] + currentDate && stayLength <= bookingsDates[i] -
                        bookingsDates[i - 1]) {
                    startDate = currentDate;
                } else {
                    startDate = bookingsDates[i];
                }
            }
        }
        return startDate;
    }

    // bookings.split(" ")
    // String number = "10";
    //int result = Integer.parseInt(number);

    static private int parseInt(String number) {
        return Integer.parseInt(number);
    }

}
