public class Week10 {
    public static void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    public static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }

    public static void run() {
        System.out.println("\n--- WEEK 10: Recursion ---");
        System.out.print("1 to 5: "); print1ToN(5);
        System.out.println("\n3 to the power 4: " + power(3, 4));
    }
}