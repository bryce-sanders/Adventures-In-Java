public class Student {
    private String name;
    private String id;
    private int age;

    // Construct the student with provided arguments
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

}
