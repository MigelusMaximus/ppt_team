using System;
using MyMathLibrary; // Import vlastní knihovny
using Math = System.Math; // Alias pro vestavěnou knihovnu Math

namespace MathApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Výpočet faktoriálu
           
            Console.Write("Zadejte číslo pro výpočet faktoriálu: ");
            if (int.TryParse(Console.ReadLine(), out int number))
            {
                try
                {
                    long factorial = MathFunctions.Factorial(number);
                    Console.WriteLine($"Faktoriál čísla {number} je {factorial}.");
                }
                catch (ArgumentException ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
            else
            {
                Console.WriteLine("Neplatný vstup. Zadejte celé číslo.");
            }

            // Výpočet sinu úhlu
           
            Console.Write("Zadejte úhel ve stupních: ");
            if (double.TryParse(Console.ReadLine(), out double angle))
            {
                double radians = angle * Math.PI / 180; // Převod na radiány
                double sineValue = Math.Sin(radians); // Výpočet sinu
                Console.WriteLine($"Sinus úhlu {angle}° je {sineValue:F4}.");
            }
            else
            {
                Console.WriteLine("Neplatný vstup. Zadejte číslo.");
            }

            Console.WriteLine("\nStiskněte libovolnou klávesu pro ukončení...");
            Console.ReadKey();
        }
    }
}