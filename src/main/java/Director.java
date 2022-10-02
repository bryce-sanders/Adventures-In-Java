import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class for user input

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Director {
  final static int tuition = 2200;
  private static ObjectMapper om = new ObjectMapper();
  private static ArrayList <Student> students = new ArrayList<>();
  private static File studentsFile = new File("Students");

    public static void main(String[] args) throws IOException {
      if (studentsFile.exists()) {
        students = om.readValue(studentsFile, new TypeReference<ArrayList <Student>>() {});
      }
      main_menu();
    }

    public static void main_menu() throws IOException {
      System.out.println("Welcome to Studentity."
      + "\nPlease enter the number of the option you would like"
      + "\nto select from the list bellow."
      + "\n"
      + "\n1. Enter New Student"
      + "\n2. Enter New Semester"
      + "\n3. Search Existing Student"
      + "\n4. Exit"
      + "\n");  // Display the main menu
      
      Scanner in = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Enter Selection: ");  // Ask for user input
      int selection = Integer.valueOf(in.nextLine());  // Read user input

      // Take the appropriate action that the user's selection requires
      
      if (selection == 1) {
        System.out.println("Enter The Student's Name: ");
        String name = in.nextLine();
        System.out.println("Enter The Student's ID Number: ");
        String id = in.nextLine();
        System.out.println("Enter The Student's Age: ");
        int age = in.nextInt();
        Student newStudent = new Student(name, id, age);
        
        students.add(newStudent);
        om.writeValue(studentsFile, students);
        main_menu();

      } else if (selection == 2) {


      } else if (selection == 3) {
        System.out.println("Enter The Student's ID Number To Find Them: ");
        String id = in.nextLine();

        for (Student student : students) {
          String checkedId = student.getId();
          if (checkedId.equals(id)) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + id);
            System.out.println("Age: " + student.getAge());
          }
        }

      } else if (selection == 4) {


      } else {
        System.out.println("#== Invalid Selection ==#");
        main_menu();
      };
    }
  }
  