import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private int age;
    private ArrayList <Semester> semesters = new ArrayList<>();

    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

}
