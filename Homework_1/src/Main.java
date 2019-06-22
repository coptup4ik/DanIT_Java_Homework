import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Xarray array = new Xarray();

        int randomNumber = new Random().nextInt(6);
        System.out.println(randomNumber);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");

        String name = input.nextLine();
        System.out.println("Let the game begin!");


        while (true) {

            System.out.print("Enter number:");

            int enteredNum = 0;
            try {
                enteredNum = input.nextInt();
            } catch (Exception e) {
                System.out.println("You have to enter number only! Try again");
                input.next();
                continue;
            }

            array.push(enteredNum);

            if (enteredNum > randomNumber) {
                System.out.println("Your number is too big. Please, try again..");
            } else if (enteredNum < randomNumber) {
                System.out.println("Your number is too small. Please, try again..");
            } else {

                int[] sortedArrayToShow = BubbleSorter.sort(array.get());

                System.out.println("Congratulations," + name + "!");
                System.out.println("You have entered next numbers: "
                        + Arrays.toString(sortedArrayToShow));
                break;
            }
        }
    }
}
