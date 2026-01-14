import java.util.Arrays;

public class Week11 {


    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;


        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearchRecursive(arr, low, mid - 1, target);
        }

        return binarySearchRecursive(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {
        System.out.println("--- WEEK 11: Recursive Binary Search ---");


        int[] sortedData = {3, 5, 7, 12, 25};
        int target = 7;

        int result = binarySearchRecursive(sortedData, 0, sortedData.length - 1, target);

        System.out.println("Searching for " + target + " in " + Arrays.toString(sortedData));

        // Output result 
        if (result == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found at index: " + result);
        }
    }

    public static void run() {
    }
}