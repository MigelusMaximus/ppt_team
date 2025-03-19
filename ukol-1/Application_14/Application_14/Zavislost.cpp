#include "pch.h"
#include "Zavislost.h"
#include <iostream>
#include <map>
#include <vector>
#include <string>

void zobrazZavislosti() {
    // Definice závislostí mezi moduly
    std::map<std::string, std::vector<std::string>> zavislosti = {
        {"Application_14.cpp", {"Tool_Obdelnik.cpp"}},
        {"Tool_Obdelnik.cpp", {"Fce_Obdelnik.cpp", "Obdelnik_IO.cpp"}},
        {"Obdelnik_IO.cpp", {"Fce_Obdelnik.cpp"}},
        {"Fce_Obdelnik.cpp", {}}
    };

    // Zobrazení závislostí
    std::cout << "Vizualizace zavislosti mezi moduly:\n";
    std::cout << "-----------------------------------\n";

    for (const auto& modul : zavislosti) {
        std::cout << modul.first << " zavisi na:\n";
        if (modul.second.empty()) {
            std::cout << "  - Zadny modul\n";
        }
        else {
            for (const auto& zavislost : modul.second) {
                std::cout << "  - " << zavislost << "\n";
            }
        }
        std::cout << "\n";
    }

    std::cout << "-----------------------------------\n";
    std::cout << "Legenda:\n";
    std::cout << "  - Application_14.cpp: Hlavni program\n";
    std::cout << "  - Tool_Obdelnik.cpp: Nastroj pro praci s obdalnikem\n";
    std::cout << "  - Obdelnik_IO.cpp: Vstup/vystup pro obdelnik\n";
    std::cout << "  - Fce_Obdelnik.cpp: Logika pro vypocet obvodu a obsahu\n";
}