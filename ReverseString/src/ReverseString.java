/*
 * Created by: Ben Motz
 * Created on: April 2st 2020
 * Created for: ICS4U
 * Day #25 (Reverse String)
 * This program uses recursion to reverse a string
 */
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        //gets the user's entry
        String entered;
        System.out.println("Please enter a string");
        Scanner scanner = new Scanner(System.in);
        entered = scanner.nextLine();
        //calls the function and outputs the result
        System.out.println(Reverse(entered));
    }

    //function to reverse the string
    public static String Reverse(String enteredstring ){
        if (enteredstring.isEmpty()){
            //returns string when it is blank
            return enteredstring;
        }
        else{
            //slowly reverses the string
            return Reverse(enteredstring.substring(1)) + enteredstring.charAt(0);
        }
    }
}
