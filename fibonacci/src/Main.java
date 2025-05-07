

public class Main {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        System.out.println("=== Fibonacci Tests ===");
        testFibonacci(fib, 5);
        testFibonacci(fib, 7);

        System.out.println("\n=== String Comparison Tests ===");
        testStringComparison(fib, "ABCDEF", "ABCD");
        testStringComparison(fib, "ABCD", "ABCDEF");
        testStringComparison(fib, "ABCD", "ABCD");

        System.out.println("\n=== indexOf Demonstration ===");
        fib.demonstrateIndexOf();
    }

    private static void testFibonacci(Fibonacci fib, int n) {
        System.out.println("\nTesting Fibonacci(" + n + "):");
        System.out.println("Non-recursive: " + fib.calcNerek(n));
        System.out.println("Recursive: " + fib.calcRek(n));
        fib.init(); // Reset table
        System.out.println("With memoization: " + fib.calcRekTable(n));
    }

    private static void testStringComparison(Fibonacci fib, String s1, String s2) {
        System.out.printf("Comparing '%s' and '%s': %d\n",
                s1, s2, fib.compareStrings(s1, s2));
    }
}