package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Human implements Comparable<Human> {
    int id;
    String lastName;
    String firstName;
    String patronymic;
    int age;

    Human() {
        id = -1;
        lastName = "";
        firstName = "";
        patronymic = "";
        age = -1;
    }

    Human(int id, String lastName, String firstName, String patronymic, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    @Override
    public int compareTo(Human human) {
        if (age == human.age) {
            return 0;
        } else if (age < human.age) {
            return -1;
        } else {
            return 1;
        }
    }

    public String printFull() {
        return id + " " + lastName + " " + firstName + " " + patronymic + " " + age;
    }
}

class Student extends Human {
    String numGroup;

    Student() {
        super();
        numGroup = "";
    }

    Student(int id, String lastName, String firstName, String patronymic, int age, String numGroup) {
        super(id, lastName, firstName, patronymic, age);
        this.numGroup = numGroup;
    }

    @Override
    public String toString() {
        return super.toString() + " - student(group: " + numGroup + ")";
    }

    @Override
    public String printFull() {
        return super.printFull() + " " + numGroup;
    }
}

class Teacher extends Human {
    String department;

    Teacher() {
        super();
        department = "";
    }

    Teacher(int id, String lastName, String firstName, String patronymic, int age, String department) {
        super(id, lastName, firstName, patronymic, age);
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + " - teacher (department: " + department + ")";
    }

    @Override
    public String printFull() {
        return super.printFull() + " " + department;
    }
}

class SortByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.toString().compareTo(o2.toString());
    }
}

public class StudentsAndTeachers {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        Teacher[] teachers = new Teacher[3];
        students[0] = new Student(1, "Berlizov", "Evgeny", "Sergeevich", 20, "09-011");
        students[1] = new Student(12, "Ivanova", "Darya", "Vladimirovna", 20, "09-011");
        students[2] = new Student(18, "Habibullina", "Karina", "Lenarovna", 21, "09-011");
        students[3] = new Student(22, "Lenchenko", "Darya", "Romanovna", 19, "09-012");
        students[4] = new Student(24, "Idiyatov", "Vadim", "Ildarovich", 20, "09-011");

        teachers[0] = new Teacher(30, "Bayrasheva", "Venera", "Rustamovna", 60, "department of theoretical cybernetics");
        teachers[1] = new Teacher(40, "Simushkin", "Sergey", "Vladimirovich", 66, "department of mathematical statistics");
        teachers[2] = new Teacher(35, "Buharaev", "Nail", "Raisovich", 67, "department of theoretical cybernetics");

        ArrayList<Human> humanArrayList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            humanArrayList.add(students[i]);
        }
        for (int i = 0; i < teachers.length; i++) {
            humanArrayList.add(teachers[i]);
        }

        for (Human human : humanArrayList) {
            System.out.println(human);
        }
        System.out.println();
        SortByName fc = new SortByName();
        humanArrayList.sort(fc);
        System.out.println("Sort by name: ");
        for (Human human : humanArrayList) {
            System.out.println(human);
        }

        humanArrayList.sort(Human::compareTo);
        System.out.println("Youngest and oldest: ");
        System.out.println(humanArrayList.get(0).printFull());
        System.out.println(humanArrayList.get(humanArrayList.size() - 1).printFull());

    }
}
