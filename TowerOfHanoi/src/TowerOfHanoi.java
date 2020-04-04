/*
 * Created by: Ben Motz
 * Created on: April 4st 2020
 * Created for: ICS4U
 * Day #28 (Tower of Hanoi)
 * This program uses recursion to solve the tower of hanoi
 */
import java.util.Scanner;

public class TowerOfHanoi {

    public static void moveplate(int numbofplates, int toTower, int fromTower, int extraTower){
        //moves plate 1 & does not change any of the tower variables
        if (numbofplates==1){
            System.out.println("Plate 1 will move to tower " + toTower +" from " + fromTower);
            return;
        }
        //moves other plates
        else{
            //moves plate to the tower that wasn't filled last recursion from the same tower that was taken from last recursion
            moveplate(numbofplates-1, extraTower, fromTower, toTower);
            System.out.println ("Plate "+ numbofplates + " will move to tower " + toTower +" from " + fromTower);
            //moves the next smallest plate to the same tower that was added to last recursion from the tower that was not touched last recursion
            moveplate(numbofplates-1, toTower, extraTower, fromTower);
        }

    }
    public static void main(String[] args) {
        System.out.println("How many plates?");
        Scanner scanner = new Scanner(System.in);

        int numbofplates = Integer.parseInt(scanner.nextLine());

        moveplate(numbofplates, 3, 1, 2);

    }
}
