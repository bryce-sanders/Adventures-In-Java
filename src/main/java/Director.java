// Imports
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/* Directs the user in entering student information
 * and store it in a file
 */
public class Director {
  private static ObjectMapper om = new ObjectMapper();
  private static ArrayList <Student> students = new ArrayList<>();
  private static File studentsFile = new File("Students");

    public static void main(String[] args) throws IOException {
      if (studentsFile.exists()) {  // Check if there is already a "Students" file
        students = om.readValue(studentsFile, new TypeReference<ArrayList <Student>>() {});  //Reads contents of file to ArrayList 
      }
      mainMenu();  // Call the mainMenu class method 
    }

    public static void mainMenu() throws IOException {
      System.out.println("\n" + ANSI_YELLOW + "Welcome to Studentity."
      + "\nPlease enter the number of the option you would like"
      + "\nto select from the list bellow."
      + "\n"
      + "\n1. Enter New Student"
      + "\n2. Search Existing Student"
      + "\n3. Exit"
      + "\n" + ANSI_RESET);  // Display the main menu and options
      
      Scanner in = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Enter Selection: ");  // Ask for user input
      int selection = Integer.valueOf(in.nextLine());  // Read user input

      // Take the appropriate action that the user's selection requires
      if (selection == 1) {
        System.out.println("\n" + "Enter The Student's Name: ");  // Ask for user input
        String name = in.nextLine();  // Read user input
        System.out.println("\n" + "Enter The Student's ID Number: ");  // Ask for user input
        String id = in.nextLine();  // Read user input
        System.out.println("\n" + "Enter The Student's Age: ");  // Ask for user input
        int age = in.nextInt();  // Read user input

        Student newStudent = new Student(name, id, age);  // Create new instance of Student class
        
        students.add(newStudent);  // Add newStudent to "students" ListArray
        om.writeValue(studentsFile, students);  // Add newStudent to "students" file
        mainMenu();

      } else if (selection == 2) {
        System.out.println("\n" + "Enter The Student's ID Number To Find Them: ");  // Ask for user input
        String id = in.nextLine();  // Read user input

        for (Student student : students) {  // Search "students" ListArray for student with matching ID
          String checkedId = student.getId();  // Get the ID of the student currently being checked

          if (checkedId.equals(id)) {
            System.out.println("\n" + ANSI_GREEN + "Name: " + student.getName());  // Found! Print the student's info
            System.out.println("ID: " + id);
            System.out.println("Age: " + student.getAge() + ANSI_RESET);
            mainMenu();

          } else {
            System.out.println("\n" + ANSI_RED + "#== No ID Match Found ==#" + ANSI_RESET);
            mainMenu();
          }
        }

      } else if (selection == 3) {
        System.out.println("\n" + ANSI_YELLOW + "Have A Nice Day" + ANSI_RESET);  // Say goodbye
        System.exit(0);  // Close the program

      } else {
        System.out.println("\n" + ANSI_RED + "#== Invalid Selection ==#" + ANSI_RESET);
        mainMenu();
      };
      in.close();  // Close the Scanner
    }

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring color Yellow
    public static final String ANSI_YELLOW = "\u001B[33m";

    // Declaring the color Red
    public static final String ANSI_RED = "\u001B[31m";

    // Declaring the color Green
    public static final String ANSI_GREEN = "\u001B[32m";
  }
  