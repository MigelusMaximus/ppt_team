

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Map<Integer, Integer> fibTable;

    public Fibonacci() {
        init();
    }

    // Non-recursive Fibonacci
    public int calcNerek(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Recursive Fibonacci
    public int calcRek(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calcRek(n-1) + calcRek(n-2);
    }

    // Initialize memoization table
    public void init() {
        fibTable = new HashMap<>();
        fibTable.put(0, 0);
        fibTable.put(1, 1);
    }

    // Recursive with memoization
    public int calcRekTable(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");

        if (!fibTable.containsKey(n)) {
            System.out.println("Calculating fib(" + n + ")...");
            int result = calcRekTable(n-1) + calcRekTable(n-2);
            fibTable.put(n, result);
            System.out.println("Table state: " + fibTable);
        }
        return fibTable.get(n);
    }

    // String comparison
    public int compareStrings(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }

        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }

    // indexOf demonstration
    public void demonstrateIndexOf() {
        System.out.println("\nEducational Test for indexOf:");

        String[] fruits = {"apple", "banana", "orange", "grape"};

        System.out.println("Array: [apple, banana, orange, grape]");
        System.out.println("1. indexOf('banana'): " + indexOf(fruits, "banana"));
        System.out.println("2. indexOf('pear'): " + indexOf(fruits, "pear"));
        System.out.println("3. indexOf('apple'): " + indexOf(fruits, "apple"));
    }

    private int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        // Test Fibonacci
        System.out.println("Fibonacci(5):");
        System.out.println("Non-recursive: " + fib.calcNerek(5));
        System.out.println("Recursive: " + fib.calcRek(5));
        System.out.println("With memoization:");
        fib.init(); // Reset table
        System.out.println("Result: " + fib.calcRekTable(5));

        // Test string comparison
        System.out.println("\nString comparison:");
        System.out.println("'ABCDEF' vs 'ABCD': " + fib.compareStrings("ABCDEF", "ABCD"));

        // Run educational test
        fib.demonstrateIndexOf();
    }
}