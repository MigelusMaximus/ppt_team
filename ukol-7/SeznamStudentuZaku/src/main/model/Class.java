package main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující školní třídu
 */
public class Class {
    private String name;
    private List<Student> students;

    public Class(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        // Upraveno, jelikož třída Student nemá metodu setStudentNumber
        // Předpokládáme, že ID studenta může být nastaveno při konstrukci
        if (student.getId() == 0) {
            // Pokud ID není nastaveno, nastavíme ho podle pořadí v seznamu
            // Toto je potřeba upravit podle skutečné implementace třídy Student
            student = new Student(students.size() + 1, student.getFirstName(), student.getLastName());
        }
        students.add(student);
    }

    public int getStudentCount() {
        return students.size();
    }

    public Map<Subject, Double> calculateSubjectAverages() {
        Map<Subject, Double> averages = new HashMap<>();
        Map<Subject, Integer> totals = new HashMap<>();
        Map<Subject, Integer> counts = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<Subject, Integer> entry : student.getGrades().entrySet()) {
                Subject subject = entry.getKey();
                int grade = entry.getValue();

                totals.put(subject, totals.getOrDefault(subject, 0) + grade);
                counts.put(subject, counts.getOrDefault(subject, 0) + 1);
            }
        }

        for (Subject subject : totals.keySet()) {
            int total = totals.get(subject);
            int count = counts.get(subject);
            averages.put(subject, (double) total / count);
        }

        return averages;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        // Upraveno, jelikož Student nemá metodu calculateAverage
        // Místo toho vypočítáme průměr ručně
        for (Student student : students) {
            Map<Subject, Integer> grades = student.getGrades();
            if (!grades.isEmpty()) {
                int studentSum = 0;
                for (Integer grade : grades.values()) {
                    studentSum += grade;
                }
                sum += (double) studentSum / grades.size();
                count++;
            }
        }

        return count > 0 ? sum / count : 0;
    }
}