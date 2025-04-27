// Obdelnik_IO.cpp
#include "pch.h"
#include "Obdelnik_IO.h"
#include <iostream>

void nacti_strany_obdelnika(double& a, double& b)
{
    printf("Zadej strany obdelnika:\n");
    scanf("%lf", &a);
    scanf("%lf", &b);
}

void tisk_UdajeObdelnika(double a, double b, double o, double S)
{
    printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", a, b, o, S);
}
