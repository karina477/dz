package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Витя", 4, 1, List.of(3, 3, 3, 4));
        Student student2 = new Student("Петя", 1, 1, List.of(1, 1, 1, 2));
        Student student3 = new Student("Маша", 2, 2, List.of(4, 4, 4, 4));

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        removeLowPerformingStudents(students);
        System.out.println(students);

        promoteStudent(students);
        System.out.println(students);

        printStudents(students, 3);

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("89578647897", "Смирнов");
        telephoneDirectory.add("89578647898", "Иванов");
        telephoneDirectory.add("89578647899", "Смирнов");

        telephoneDirectory.get("Смирнов");
    }

    public static void removeLowPerformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageScore() < 3.0);
    }

    public static void promoteStudent(Set<Student> students) {
        students.stream().filter(student -> student.getAverageScore() >= 3).forEach(Student::toNextCourse);
    }

    public static void printStudents(Set<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}