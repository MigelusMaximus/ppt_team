#include "pch.h"
#include "Fce_Obdelnik.h"

void pocitej_obdelnik(Obdelnik& ob)
{
    ob.o = 2 * (ob.a + ob.b);
    ob.S = ob.a * ob.b;
}