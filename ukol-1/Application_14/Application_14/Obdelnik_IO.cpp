#include "pch.h"
#include "Obdelnik_IO.h"
#include <iostream>

void nacti_strany_obdelnika(Obdelnik& ob)
{
    printf("Zadej strany obdelnika:\n");
    scanf("%lf", &ob.a);
    scanf("%lf", &ob.b);
}

void tisk_UdajeObdelnika(const Obdelnik& ob)
{
    printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", ob.a, ob.b, ob.o, ob.S);
}