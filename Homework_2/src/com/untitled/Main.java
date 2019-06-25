package com.untitled;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int coordinateX = 0;
    private static int coordinateY = 0;
    private static final int[] target = new int[2];
    private static String[][] field = new String[6][6];
    private static final String missedHit = "*";
    private static final String hit = "x";

    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble!");
        startGame();
    }

    private static void startGame() {
        setTarget();
        inputCoordinates();
        shoot();
    }

    private static void continueGame() {
        generateField();
        inputCoordinates();
        shoot();
    }

    private static void gameFinished() {
        generateField();
        initializeField();
        startGame();
    }


    private static void setTarget() {
        initializeField();
        Random random = new Random();
        target[0] = random.nextInt(5) + 1;
        target[1] = random.nextInt(5) + 1;
        System.out.println(Arrays.toString(target));
    }


    private static void initializeField() {
        field = new String[][]{
                {"-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-"}
        };
    }

    private static void inputCoordinates() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter \"X\" coordinate from 1 to 5: ");
                coordinateX = in.nextInt();
                if (coordinateX < 1 || coordinateX > 5) {
                    System.out.println("You have to enter value from 1 to 5. Try again!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("You have to enter correct value. Try again!");
                in.next();
            }
        }

        while (true) {
            try {

                System.out.print("Enter \"Y\" coordinate from 1 to 5: ");

                coordinateY = in.nextInt();

                if (coordinateY < 1 || coordinateY > 5) {
                    System.out.println("You have to enter value from 1 to 5. Try again!");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println("You have to enter correct value. Try again!");
                in.next();
            }
        }
    }

    private static void shoot() {
        field[coordinateY][coordinateX] = missedHit;
        isTargetShot();
    }


    private static void isTargetShot() {
        if (coordinateX == target[0] && coordinateY == target[1]) {
            field[coordinateY][coordinateX] = hit;
            System.out.println(
                    ConsoleColors.BLUE_BACKGROUND
                            + ConsoleColors.BLACK_BOLD
                            + "   ------VICTORY------  "
                            + ConsoleColors.RESET);

            gameFinished();
        } else {
            continueGame();
        }
    }


    private static void generateField() {

        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                if (i == 0) {
                    System.out.print(
                            ConsoleColors.RED_BACKGROUND
                                    + ConsoleColors.BLACK_BOLD_BRIGHT
                                    + " " + j + " |"
                                    + ConsoleColors.RESET);

                } else if (j == 0) {
                    System.out.print(
                            ConsoleColors.RED_BACKGROUND
                                    + ConsoleColors.BLACK_BOLD_BRIGHT
                                    + " " + i + " |"
                                    + ConsoleColors.RESET);

                } else if (field[i][j].equals(missedHit)) {
                    System.out.print(
                            ConsoleColors.YELLOW_BACKGROUND
                                    + ConsoleColors.WHITE_BOLD_BRIGHT
                                    + " " + field[i][j] + " |"
                                    + ConsoleColors.RESET);
                } else if (field[i][j].equals(hit)) {
                    System.out.print(
                            ConsoleColors.BLUE_BACKGROUND
                                    + ConsoleColors.WHITE_BOLD_BRIGHT
                                    + " " + field[i][j] + " |"
                                    + ConsoleColors.RESET);
                } else {
                    System.out.print(
                            ConsoleColors.RED_BACKGROUND
                                    + ConsoleColors.BLACK_BOLD_BRIGHT
                                    + " " + field[i][j] + " |"
                                    + ConsoleColors.RESET);
                }
            }
            System.out.println();
        }
    }
}
