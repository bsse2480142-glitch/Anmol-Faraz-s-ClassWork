import java.util.Arrays;

public class Week12{
    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) return;
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    private static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int idx1 = si, idx2 = mid + 1, x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) merged[x++] = arr[idx1++];
            else merged[x++] = arr[idx2++];
        }
        while (idx1 <= mid) merged[x++] = arr[idx1++];
        while (idx2 <= ei) merged[x++] = arr[idx2++];
        for (int i = 0, j = si; i < merged.length; i++, j++) arr[j] = merged[i];
    }

    public static void run() {
        System.out.println("\n--- WEEK 12: Merge Sort ---");
        int[] data = {6, 3, 9, 5, 2, 8};
        System.out.println("Original: " + Arrays.toString(data));
        divide(data, 0, data.length - 1);
        System.out.println("After Merge Sort: " + Arrays.toString(data));
    }
}