import java.util.Scanner;
public class SafeInput {

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Prompts the user to input any integer.
     *
     * @param pipe    Scanner object for input
     * @param prompt  Message to display as prompt for input
     * @return        The integer input by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        System.out.print(prompt + ": "); // Prompting user with the provided message
        while (!pipe.hasNextInt()) { // Loop until an integer is entered
            String trash = pipe.next(); // Read and discard non-integer input
            System.out.print("Invalid input. Please enter an integer: "); // Prompt user again
        }
        int userInput = pipe.nextInt(); // Read the integer input
        pipe.nextLine(); // Clear the newline character from the pipe
        return userInput; // Return the integer entered by the user
    }

    /**
     * Prompts the user to input any double value.
     *
     * @param inputScanner   Scanner object for input
     * @param userPrompt     Message to display as prompt for input
     * @return               The double value input by the user
     */
    public static double getDouble(Scanner inputScanner, String userPrompt) {
        System.out.print(userPrompt + ": "); // Prompting user with the provided message
        while (!inputScanner.hasNextDouble()) { // Loop until a double value is entered
            String trash = inputScanner.next(); // Read and discard non-double input
            System.out.print("Invalid input. Please enter a double value: "); // Prompt user again
        }
        double userInput = inputScanner.nextDouble(); // Read the double value input
        inputScanner.nextLine(); // Clear the newline character from the input stream
        return userInput; // Return the double value entered by the user
    }

    /**
     * Prompts the user to input an integer within a specified inclusive range.
     *
     * @param inputScanner   Scanner object for input
     * @param userPrompt     Message to display as prompt for input
     * @param minValue       The low value for the input range (inclusive)
     * @param maxValue       The high value for the input range (inclusive)
     * @return               The integer input by the user within the specified range
     */
    public static int getRangedInt(Scanner inputScanner, String userPrompt, int minValue, int maxValue) {
        String promptWithRange = userPrompt + " [" + minValue + " - " + maxValue + "]: ";
        System.out.print(promptWithRange); // Prompting user with the provided message and range
        int userInput;
        while (true) {
            while (!inputScanner.hasNextInt()) { // Loop until an integer is entered
                String trash = inputScanner.next(); // Read and discard non-integer input
                System.out.print("Invalid input. Please enter an integer: "); // Prompt user again
            }
            userInput = inputScanner.nextInt(); // Read the integer input
            inputScanner.nextLine();
            if (userInput >= minValue && userInput <= maxValue) { // Check if input is within the range
                break;
            } else {
                System.out.print("Input out of range. Please enter an integer within the specified range: "); // Prompt user again
            }
        }
        return userInput;
    }

    /**
     * Prompts the user to input a double within a specified inclusive range.
     *
     * @param inputScanner   Scanner object for input
     * @param userPrompt     Message to display as prompt for input
     * @param minValue       The low value for the input range (inclusive)
     * @param maxValue       The high value for the input range (inclusive)
     * @return               The double value input by the user within the specified range
     */
    public static double getRangedDouble(Scanner inputScanner, String userPrompt, double minValue, double maxValue) {
        String promptWithRange = userPrompt + " [" + minValue + " - " + maxValue + "]: ";
        System.out.print(promptWithRange);
        double userInput;
        while (true) {
            while (!inputScanner.hasNextDouble()) { // Loop until a double value is entered
                String trash = inputScanner.next(); // Read and discard non-double input
                System.out.print("Invalid input. Please enter a double value: "); // Prompt user again
            }
            userInput = inputScanner.nextDouble(); // Read the double value input
            inputScanner.nextLine();
            if (userInput >= minValue && userInput <= maxValue) { // Check if input is within the range
                break; // Exit loop if input is valid
            } else {
                System.out.print("Input out of range. Please enter a double within the specified range: "); // Prompt user again
            }
        }
        return userInput;
    }

    /**
     * This method prompts the user for a Yes or No response [Y/N],
     * returning true for Yes and false for No.
     *
     * @param inputScanner   Scanner object for input
     * @param userPrompt     Message to display as prompt for input
     * @return               true if user inputs 'Y' or 'y', false if user inputs 'N' or 'n'
     */
    public static boolean getYNConfirm(Scanner inputScanner, String userPrompt) {
        System.out.print(userPrompt + " [Y/N]: "); // Prompting user with the provided message
        while (true) { // Loop until valid input is entered
            String userInput = inputScanner.nextLine().trim().toUpperCase();
            if (userInput.equals("Y")) {
                return true; // Return true if user inputs 'Y'
            } else if (userInput.equals("N")) {
                return false; // Return false if user inputs 'N'
            } else {
                System.out.print("Invalid input. Please enter 'Y' for Yes or 'N' for No: "); // Prompt user again
            }
        }
    }

    /**
     * Prompts the user to input a String that matches a RegEx pattern.
     *
     * @param inputScanner   Scanner object for input
     * @param userPrompt     Message to display as prompt for input
     * @param regexPattern   The RegEx pattern in Java String format to use for matching
     * @return               The String input by the user matching the specified RegEx pattern
     */
    public static String getRegExString(Scanner inputScanner, String userPrompt, String regexPattern) {
        System.out.print(userPrompt + ": "); // Prompting user with the provided message
        while (true) {
            String userInput = inputScanner.nextLine().trim(); // Read user input and trim leading/trailing whitespace
            if (userInput.matches(regexPattern)) { // Check if input matches the specified RegEx pattern
                return userInput; // Return input if it matches the pattern
            } else {
                System.out.print("Invalid input. Please enter a string matching the pattern: " + regexPattern + ": "); // Prompt user again
            }
        }
    }

    /**
     * Creates a pretty header with a message centered in the middle.
     *
     * @param msg The message to be centered in the pretty header
     */
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();
        int paddingWidth = (totalWidth - msgWidth - 6) / 2;

        // Print the top line of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line

        // Print the second line with message centered between stars
        System.out.print("***");
        for (int i = 0; i < paddingWidth; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingWidth; i++) {
            System.out.print(" ");
        }
        if ((totalWidth - msgWidth - 6) % 2 == 1) {
            System.out.print(" ");
        }
        System.out.println("***"); // Move to the next line

        // Print the bottom line of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line
    }






}