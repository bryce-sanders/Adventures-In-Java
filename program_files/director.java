import java.util.Scanner;  // Import the Scanner class for user input

public class director {
  final int tuition = 2200;

    public static void main(String[] args) {
      // Create the String variable to hold the text for the main menu
      String main_menu = "Welcome to Studentity."
      + "\nPlease enter the number of the option you would like"
      + "\nto select from the list bellow."
      + "\n"
      + "\n1. Enter New Student"
      + "\n2. Search Existing Student"
      + "\n3. Exit"
      + "\n";

      System.out.println(main_menu);  // Display the main menu
      
      Scanner in = new Scanner(System.in);  // Create a Scanner object
      System.out.print("Enter Selection: ");
      String selection = in.nextLine();  // Read user input
      in.close();  // Close the Scanner
    }
  }
  