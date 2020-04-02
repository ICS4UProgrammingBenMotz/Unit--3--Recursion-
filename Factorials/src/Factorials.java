/*
 * Created by: Ben Motz
 * Created on: April 2st 2020
 * Created for: ICS4U
 * Day #26 (Factorials)
 * This program uses recursion to determine the factorials of a numb
 */
import java.util.Scanner;

public class Factorials {
    public static void main(String[] args) {

        //gets user inputted information
        System.out.println("Enter an int");

        Scanner scanner = new Scanner(System.in);

        //scans the nextx line
        int enteredval = Integer.parseInt(scanner.nextLine());

        System.out.println(factorial(enteredval));

    }
    public static int factorial(int enterednumb){
        if (enterednumb<=1){
            //returns the final answer
            return enterednumb;
        }
        else{
            //gets the factorials of all numbers
            return enterednumb*factorial(enterednumb-1);
        }
    }
}
