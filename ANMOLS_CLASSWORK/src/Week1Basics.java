import java.util.Scanner;

public class Week1Basics {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== WEEK 1: Variables & Data Types ===");
        runVariablesTask();
        System.out.println("\n=== Basic Input / Output ===");
        runInputOutputTask(sc);
        System.out.println("\n=== Conditional Statements (Largest of 3) ===");
        runConditionalsTask(sc);
        System.out.println("\n=== Loops (Multiplication Table) ===");
        runLoopsTask(sc);
        System.out.println("\n=== Arrays (Max and Reverse) ===");
        runArraysTask();
        System.out.println("\n=== Functions (Prime Check) ===");
        runPrimeTask();
        System.out.println("\n=== Final Mini Challenge (Grading System) ===");
        runGradingChallenge(sc);
    }

    public static void runVariablesTask() {
        String name = "Hamza";
        int rollNo = 12345;
        String department = "Computer Science";
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + department);
    }

    public static void runInputOutputTask(Scanner sc) {
        System.out.print("Enter your name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();
        System.out.println("Hello " + name + ", your marks are " + marks);
    }

    public static void runConditionalsTask(Scanner sc) {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a >= b && a >= c) System.out.println("Largest: " + a);
        else if (b >= a && b >= c) System.out.println("Largest: " + b);
        else System.out.println("Largest: " + c);
    }

    public static void runLoopsTask(Scanner sc) {
        System.out.print("Enter number for table: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void runArraysTask() {
        int[] arr = {15, 42, 7, 89, 23};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Maximum value: " + max);
        System.out.print("Reverse order: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void runPrimeTask() {
        int num = 29;
        System.out.println(num + (isPrime(num) ? " is Prime." : " is not Prime."));
    }

    public static void runGradingChallenge(Scanner sc) {
        int[] subjects = new int[5];
        int total = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subjects[i] = sc.nextInt();
            total += subjects[i];
        }
        double avg = total / 5.0;
        String grade = (avg >= 80) ? "A" : (avg >= 70) ? "B" : (avg >= 60) ? "C" : (avg >= 50) ? "D" : "F";
        System.out.println("\n--- Result ---");
        System.out.println("Total: " + total + " | Average: " + avg + " | Grade: " + grade);
    }
}