// Tool_Obdelnik.cpp
#include "pch.h"
#include "Tool_Obdelnik.h"
#include "Obdelnik_IO.h"
#include "Fce_Obdelnik.h"
#include <iostream>  // kvuli printf

void obdelnik()
{
    double a, b, o, S;

    // Na?teme strany obdelníka
    nacti_strany_obdelnika(a, b);

    // Vypo?ítáme obvod a obsah
    pocitej_obdelnik(a, b, o, S);

    // Tiskneme výsledek
    tisk_UdajeObdelnika(a, b, o, S);
}

void obdelniky()
{
    obdelnik();

    // ---

    printf("\n\n");
    obdelnik();
}
