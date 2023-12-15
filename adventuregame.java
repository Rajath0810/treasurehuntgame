package adventuregame;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreasureHuntGame {

    private static Map<String, String> roomConnections;
    private static String currentRoom;

    public static void main(String[] args) {
        initializeGame();

        System.out.println("Welcome to the Treasure Hunt Game!");
        System.out.println("You are currently in Room A.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your move (north, south, east, west, or exit): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            processUserInput(userInput);
        }

        scanner.close();
    }

    private static void initializeGame() {
        roomConnections = new HashMap<>();
        roomConnections.put("A", "B");
        roomConnections.put("B", "C");
        roomConnections.put("C", "D");
        roomConnections.put("D", "E");
        roomConnections.put("E", "F");
        roomConnections.put("F", "Treasure");

        currentRoom = "A";
    }

    private static void processUserInput(String userInput) {
        if (isValidDirection(userInput)) {
            String nextRoom = roomConnections.get(currentRoom);

            if (nextRoom.equals("Treasure")) {
                System.out.println("Congratulations! You found the hidden treasure.");
                System.exit(0);
            }

            System.out.println("You moved to Room " + nextRoom + ".");
            currentRoom = nextRoom;
        } else {
            System.out.println("Invalid direction. Please enter north, south, east, west, or exit.");
        }
    }

    private static boolean isValidDirection(String direction) {
        return direction.equalsIgnoreCase("north") ||
               direction.equalsIgnoreCase("south") ||
               direction.equalsIgnoreCase("east") ||
               direction.equalsIgnoreCase("west");
    }
}
