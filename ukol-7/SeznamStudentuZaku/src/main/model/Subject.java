package main.model;

/**
 * Předměty, které student může mít
 */
public enum Subject {
    MAT("Matematika"),
    FYZ("Fyzika"),
    IT("Informatika"),
    TV("Tělesná výchova"),
    CJ("Český jazyk");

    private final String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Získá předmět podle jeho zkratky
     */
    public static Subject fromCode(String code) {
        for (Subject subject : values()) {
            if (subject.name().equals(code)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Neznámý předmět: " + code);
    }
}