import java.util.Scanner;

public class Lift {
    public static void main(String[] args) {
        // Initialize current floor and maximum floor of the lift
        int currentFloor = 0;
        int maxFloor = 4;
        int targetFloor;
        Scanner scanner = new Scanner(System.in);

        // Start the lift system with a greeting message
        displayMessage("Good day!");

        // Infinite loop to keep the lift system running
        while (true) {
            // Display the current floor to the user
            displayMessage("You are currently on floor " + currentFloor);
            displayMessage("Enter the floor number you want to go to from 0 to 4 or press -1 to exit:");
            targetFloor = scanner.nextInt();  // Read user input for the target floor

            // Check if the user wants to exit the lift system
            if (targetFloor == -1) {
                displayMessage("Exiting the lift system.");
                break;  // Exit the loop and terminate the program
            }

            // Validate if the target floor is within the allowable range
            if (targetFloor < 0 || targetFloor > maxFloor) {
                displayMessage("Sorry, our floors are only limited between 0 and 4.");
                continue;  // Restart the loop if the input is invalid
            }

            // Move the lift to the target floor
            while (currentFloor != targetFloor) {
                if (currentFloor < targetFloor) {
                    currentFloor++;  // Lift moves up
                    displayMessage("Lift moving up to floor " + currentFloor);
                } else {
                    currentFloor--;  // Lift moves down
                    displayMessage("Lift moving down to floor " + currentFloor);
                }
            }

            // Notify the user that the lift has reached the desired floor
            displayMessage("Lift has arrived at floor " + currentFloor);
        }

        scanner.close();  // Close the scanner to prevent resource leaks
    }

    // Method to simulate a message panel by printing a message with a delay between characters
    public static void displayMessage(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));  // Print each character of the message
            try {
                Thread.sleep(50);  // Pause for 50 milliseconds between each character
            } catch (InterruptedException e) {
                e.printStackTrace();  // Print stack trace if there's an interruption
            }
        }
        System.out.println();  // Move to the next line after the message is printed
    }
}
