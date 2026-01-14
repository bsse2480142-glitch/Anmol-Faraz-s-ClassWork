import java.util.Arrays;

public class Week4 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void run() {
        System.out.println("\n--- WEEK 4: Sorting (Quick Sort) ---");
        int[] data = {64, 25, 12, 22, 11};
        System.out.println("Original: " + Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
}