import java.util.Scanner;

public class Main {
    private static String[][] schedule = new String[7][2];
    private static Scanner in = new Scanner(System.in);
    private static int row = 0;
    private static int column = 0;

    public static void main(String[] args) {
        initScheduleArray();
        getUserInput();
    }

    private static void initScheduleArray() {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do something for Sunday";
        schedule[1][0] = "Monday";
        schedule[1][1] = "do something for Monday";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "do something for Tuesday";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "do something for Wednesday";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "do something for Thursday";
        schedule[5][0] = "Friday";
        schedule[5][1] = "do something for Friday";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do something for Saturday";
    }


    private static boolean checkIfDayExistInArray(String day) {
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                if (schedule[i][j].equalsIgnoreCase(day)) {
                    row = i;
                    column = j;
                    return true;
                }
            }
        }
        return false;
    }


    private static void changeSchedule(String input) {
        String[] tempArray = input.split(" ");
        String day = tempArray[tempArray.length - 1];
        if (checkIfDayExistInArray(day)) {
            System.out.printf("Please, input new tasks for %s :", schedule[row][column]);
            input = in.nextLine().trim();
            schedule[row][column + 1] = input;
            System.out.println("Successfully changed");
            showToDoItem();
            getUserInput();
        } else {
            System.out.println("Sorry, I don't understand you, please try again");
            getUserInput();
        }
    }

    private static void showToDoItem() {
        String arrayDay = schedule[row][column];
        String arrayTodo = schedule[row][column + 1];
        System.out.printf("Your tasks for %s: %s \n", arrayDay, arrayTodo);
    }

    private static void getUserInput() {
        System.out.print("Please, input the day of the week:");
        String input = in.nextLine().trim();

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("App exit");
            System.exit(0);
            return;
        }


        if (input.contains("change")) {
            changeSchedule(input);
        }

        if (checkIfDayExistInArray(input)) {
            showToDoItem();
            getUserInput();
        } else {
            System.out.println("Sorry, I don't understand you, please try again");
            getUserInput();
        }
    }
}
