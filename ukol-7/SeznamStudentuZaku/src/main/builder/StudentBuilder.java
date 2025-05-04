package main.builder;

import main.model.Student;

/**
 * Builder pro vytváření studentů
 */
public class StudentBuilder {
    private String firstName;
    private String lastName;
    private int id; // Přidáno ID jako požadovaný parametr pro Student

    /**
     * Nastaví ID studenta.
     *
     * @param id ID studenta
     * @return this pro řetězení volání
     */
    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Nastaví jméno studenta.
     *
     * @param firstName Jméno studenta
     * @return this pro řetězení volání
     */
    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Nastaví příjmení studenta.
     *
     * @param lastName Příjmení studenta
     * @return this pro řetězení volání
     */
    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Vytvoří nový objekt Student s nastavenými parametry.
     *
     * @return Nový objekt Student
     * @throws IllegalStateException pokud nejsou nastaveny všechny povinné parametry
     */
    public Student build() {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalStateException("Jméno studenta nesmí být prázdné");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalStateException("Příjmení studenta nesmí být prázdné");
        }

        return new Student(id, firstName, lastName);
    }
}