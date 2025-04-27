package main;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create an instance of Faktura with sample data
        Faktura faktura = new Faktura(
                "2024-001",
                LocalDate.of(2024, 4, 27),
                LocalDate.of(2024, 5, 27),
                "Jan", "Novák", "Ulice 1", "Praha", "10000",
                "123456789", "jan.novak@email.cz",
                1000.0, 1210.0, "standardní", 21.0
        );

        // Print the Faktura object using its toString method
        System.out.println(faktura.toString());
    }
}