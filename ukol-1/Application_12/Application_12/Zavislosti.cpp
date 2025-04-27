#include "pch.h"  
#include "Zavislosti.h"
#include <iostream>


void zobraz_zavislosti()
{
    std::cout << "====================================================\n";
    std::cout << "          Vizualizace Zavislosti Mezi Moduly\n";
    std::cout << "====================================================\n";

    std::cout << "           +------------------------+\n";
    std::cout << "           |   Application_12.cpp    |\n";
    std::cout << "           | (Hlavni program)        |\n";
    std::cout << "           |                        |\n";
    std::cout << "           |  - vola Tool_Obdelnik   |\n";
    std::cout << "           |  - vola my_task()       |\n";
    std::cout << "           +------------------------+\n";
    std::cout << "                    |\n";
    std::cout << "                    v\n";
    std::cout << "           +------------------------+\n";
    std::cout << "           |   Tool_Obdelnik.cpp     |\n";
    std::cout << "           | (Obsluha obdelnika)     |\n";
    std::cout << "           |                        |\n";
    std::cout << "           |  - vola Fce_Obdelnik    |\n";
    std::cout << "           |  - vola Obdelnik_IO     |\n";
    std::cout << "           +------------------------+\n";
    std::cout << "                |\n";
    std::cout << "        +-------+-------+\n";
    std::cout << "        |               |\n";
    std::cout << "        v               v\n";
    std::cout << "   +------------------------+    +------------------------+\n";
    std::cout << "   |   Fce_Obdelnik.cpp      |    |   Obdelnik_IO.cpp       |\n";
    std::cout << "   | (Vypocty obdelniku)     |    | (Vstupy a vystupy)      |\n";
    std::cout << "   |                        |    |                        |\n";
    std::cout << "   |  - vola Obdelnik_IO     |    |                        |\n";
    std::cout << "   +------------------------+    +------------------------+\n";

    std::cout << "\n====================================================\n";
}
