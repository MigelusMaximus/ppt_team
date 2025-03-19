namespace MyMathLibrary
{
    public class MathFunctions
    {
        /// <summary>
        /// Vypočítá faktoriál zadaného čísla.
        /// </summary>
        /// <param name="n">Číslo, pro které se počítá faktoriál.</param>
        /// <returns>Faktoriál zadaného čísla.</returns>
        /// <exception cref="ArgumentException">Vyvolá výjimku, pokud je vstupní číslo záporné.</exception>
        public static long Factorial(int n)
        {
            if (n < 0)
            {
                throw new ArgumentException("Faktoriál je definován pouze pro nezáporná čísla.");
            }

            long result = 1;
            for (int i = 2; i <= n; i++)
            {
                result *= i;
            }
            return result;
        }
    }
}

