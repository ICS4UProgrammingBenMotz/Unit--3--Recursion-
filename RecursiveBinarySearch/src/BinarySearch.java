/*
 * Created by: Ben Motz
 * Created on: April 2st 2020
 * Created for: ICS4U
 * Day #27 (Binary Search)
 * This program uses recursion in binary search
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randnumb;

        //creates array
        int[] vals = new int[100];

        //creates all the values
        for (int counter=0; counter<99; counter++ ){
            randnumb=new Random().nextInt(1000)+1;
            vals[counter]= randnumb;
            System.out.print(randnumb + " ");
        }
        //sorts the values
        Arrays.sort(vals);

        System.out.println("\nWhat number would you like to find?");

        int desval = Integer.parseInt(scanner.next());

        //finds the value
        String index = String.valueOf(binarysearch(vals, 0, vals.length-1, desval ));

        //outputs information based on if the value is found or not
        if (index.equals("0"))
        {
            System.out.println("This value does not exist");
        }
        else {
            System.out.println("The index is " + index);
        }
    }

    public static int binarysearch(int[] array, int low, int max, int desiredval){

        //determines the value
        if (max >= low) {
            //finds the midpoint
            int mid= (low+max)/2;

            if (array[mid] == desiredval){
                //if the value is the midpoint
                return mid;
            }
            else if (array[mid] > desiredval) {
                //sets the max to the mid value-1 then reruns the func
                return binarysearch(array, low, mid - 1, desiredval);
            }
            else if (array[mid] < desiredval) {
                //sets the min to the mid value+1 then reruns the func
                return binarysearch(array, mid + 1, max, desiredval);
            }
        }
        //returns if the value does not exist
        return 0;
    }

}

