package main.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída reprezentující studenta.
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Map<Subject, Integer> grades;

    /**
     * Vytvoří nového studenta.
     *
     * @param id ID studenta
     * @param firstName Jméno studenta
     * @param lastName Příjmení studenta
     */
    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new HashMap<>();
    }

    /**
     * Nastaví ID studenta.
     *
     * @param id Nové ID studenta
     */
    public void setStudentNumber(int id) {
        this.id = id;
    }

    /**
     * Přidá známku z předmětu.
     *
     * @param subject Předmět
     * @param grade Známka (1-5)
     */
    public void addGrade(Subject subject, int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Známka musí být v rozsahu 1-5");
        }
        grades.put(subject, grade);
    }

    /**
     * Vrátí známku z předmětu.
     *
     * @param subject Předmět
     * @return Známka nebo null, pokud student nemá z předmětu známku
     */
    public Integer getGrade(Subject subject) {
        return grades.get(subject);
    }

    /**
     * Vrátí všechny známky studenta.
     *
     * @return Mapa předmětů a známek
     */
    public Map<Subject, Integer> getGrades() {
        return new HashMap<>(grades);
    }

    /**
     * Vypočítá průměr známek studenta.
     *
     * @return Průměrná známka nebo 0, pokud student nemá žádné známky
     */
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Integer grade : grades.values()) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    /**
     * Vrátí ID studenta.
     *
     * @return ID studenta
     */
    public int getId() {
        return id;
    }

    /**
     * Vrátí jméno studenta.
     *
     * @return Jméno studenta
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Vrátí příjmení studenta.
     *
     * @return Příjmení studenta
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Vrátí celé jméno studenta.
     *
     * @return Jméno a příjmení studenta
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", grades=" + grades + '}';
    }
}