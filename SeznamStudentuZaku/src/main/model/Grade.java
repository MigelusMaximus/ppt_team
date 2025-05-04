package main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Třída reprezentující známky studenta z jednotlivých předmětů.
 */
public class Grade {
    private final int studentId;
    private final Map<String, Integer> subjectGrades;

    /**
     * Konstruktor pro vytvoření objektu známek.
     *
     * @param studentId ID studenta, kterému patří známky
     */
    public Grade(int studentId) {
        this.studentId = studentId;
        this.subjectGrades = new HashMap<>();
    }

    /**
     * Konstruktor pro vytvoření objektu známek s předvyplněnými hodnotami.
     *
     * @param studentId ID studenta, kterému patří známky
     * @param subjectGrades mapa předmětů a jejich známek
     */
    public Grade(int studentId, Map<String, Integer> subjectGrades) {
        this.studentId = studentId;
        this.subjectGrades = new HashMap<>(subjectGrades);
    }

    /**
     * Přidá nebo aktualizuje známku z předmětu.
     *
     * @param subject kód předmětu
     * @param value hodnota známky
     * @return this pro řetězení metod
     */
    public Grade addGrade(String subject, int value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Známka musí být v rozsahu 1-5, zadáno: " + value);
        }
        subjectGrades.put(subject, value);
        return this;
    }

    /**
     * Vrací známku z daného předmětu.
     *
     * @param subject kód předmětu
     * @return hodnota známky nebo null, pokud předmět nemá známku
     */
    public Integer getGrade(String subject) {
        return subjectGrades.get(subject);
    }

    /**
     * Vrací ID studenta, kterému patří tyto známky.
     *
     * @return ID studenta
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Vrací kopii mapy všech známek.
     *
     * @return mapa předmětů a jejich známek
     */
    public Map<String, Integer> getSubjectGrades() {
        return new HashMap<>(subjectGrades);
    }

    /**
     * Vypočítá průměr známek.
     *
     * @return průměrná známka nebo 0.0, pokud student nemá žádné známky
     */
    public double calculateAverage() {
        if (subjectGrades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Integer grade : subjectGrades.values()) {
            sum += grade;
        }

        return (double) sum / subjectGrades.size();
    }

    /**
     * Převede známky do formátu pro uložení do souboru s pevným pořadím předmětů.
     *
     * @param subjects seznam předmětů v požadovaném pořadí
     * @return řetězec známek oddělených středníkem
     */
    public String toFixedOrderString(List<String> subjects) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subjects.size(); i++) {
            String subject = subjects.get(i);
            Integer grade = subjectGrades.getOrDefault(subject, 0);
            sb.append(grade);
            if (i < subjects.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /**
     * Převede známky do formátu "PŘEDMĚT:ZNÁMKA" odděleného středníky.
     *
     * @return řetězec známek ve formátu "MAT:1;FYZ:2;..."
     */
    public String toDynamicOrderString() {
        if (subjectGrades.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Integer> entry : subjectGrades.entrySet()) {
            if (!first) {
                sb.append(";");
            }
            sb.append(entry.getKey()).append(":").append(entry.getValue());
            first = false;
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return studentId == grade.studentId &&
                Objects.equals(subjectGrades, grade.subjectGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectGrades);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentId=" + studentId +
                ", subjectGrades=" + subjectGrades +
                '}';
    }

    /**
     * Builder pro snadnější vytváření objektů Grade.
     */
    public static class Builder {
        private final int studentId;
        private final Map<String, Integer> grades = new HashMap<>();

        public Builder(int studentId) {
            this.studentId = studentId;
        }

        public Builder withGrade(String subject, int value) {
            if (value < 1 || value > 5) {
                throw new IllegalArgumentException("Známka musí být v rozsahu 1-5, zadáno: " + value);
            }
            grades.put(subject, value);
            return this;
        }

        public Grade build() {
            return new Grade(studentId, grades);
        }
    }
}