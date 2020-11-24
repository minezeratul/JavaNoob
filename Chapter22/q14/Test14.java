package Chapter22.q14;

import java.util.List;

public class Test14 {
    public static void main(String[] args) {
        long[] executionTime = new long[6];
        for (int i = 0; i < 6; i++) {
            long startTime = System.currentTimeMillis();
            findPrimeNumbers1(8000000 + i * 2000000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }
        System.out.printf("%20d %7d %7d %7d %7d %7d ", 8000000, 10000000, 12000000, 14000000 ,16000000, 18000000);
        System.out.println("\n-----------------------------------------------------------------");
        System.out.print("Listing 22.5");

        for (int i = 0; i < 6; i++) {
            System.out.printf("%7d" , executionTime[i]);
        }

        System.out.print("\nListing 22.6");
        for (int i = 0; i < 6; i++) {
            long startTime = System.currentTimeMillis();
            findPrimeNumbers2(8000000 + i * 2000000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("%7d" , executionTime[i]);
        }

        System.out.print("\nListing 22.7");
        for (int i = 0; i < 6; i++) {
            long startTime = System.currentTimeMillis();
            findPrimeNumbers3(8000000 + i * 2000000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("%7d" , executionTime[i]);
        }
    }
    
    public static void findPrimeNumbers1(long num){
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness


        // Repeatedly find prime numbers
        while (number <= num) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // ClosestPair if number is prime
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number));
                 divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count
            }

            // Check if the next number is prime
            number++;
        }

    }

    public static void findPrimeNumbers2(long num){

        List<Integer> list = new java.util.ArrayList<>();

        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot


        // Repeatedly find prime numbers
        while (number <= num) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) squareRoot++;

            // ClosestPair if number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count
              //  list.add(number); // Add a new prime to the list
            }

            number++;
        }
    }

    public static void findPrimeNumbers3(long n){
        boolean[] primes = new boolean[(int) (n + 1)]; // Prime number sieve

        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers found so far
        // Print prime numbers
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }

    }
    
}

