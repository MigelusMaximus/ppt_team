// Application_12.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
#include "pch.h"
#include <iostream>

#include "Tool_Obdelnik.h"
#include "Fce_Obdelnik.h"  // kvůli výpočtům
#include "Obdelnik_IO.h"   // pro vstupy a výstupy
#include "Zavislosti.h"


void my_task()
{
    double a1, b1, a2, b2;
    double o1, S1, o2, S2;

    // Načteme strany obdelníka
    nacti_strany_obdelnika(a1, b1);
    nacti_strany_obdelnika(a2, b2);

    // Vypočítáme obvod a obsah pro oba obdélníky
    pocitej_obdelnik(a1, b1, o1, S1);
    pocitej_obdelnik(a2, b2, o2, S2);

    // Tiskneme výsledky
    tisk_UdajeObdelnika(a1, b1, o1, S1);
    tisk_UdajeObdelnika(a2, b2, o2, S2);
}

int main()


{

    // Volání funkce pro zobrazení závislostí
    zobraz_zavislosti();

    obdelnik();  // Zavoláme funkci pro výpočet a tisk výsledků

    // Pokud chcete použít my_task pro více obdélníků, zavolejte jej
    //my_task();

    


    return 0;
}
