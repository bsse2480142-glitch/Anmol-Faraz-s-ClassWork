import java.util.*;

public class Week15 {
    public static void runHashMapBasics() {
        // --- 1. Creation and Putting Data ---
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Ali");
        studentMap.put(102, "Sara");
        studentMap.put(103, "Hamza");

        // --- 2. Retrieval & Checks ---
        System.out.println("Roll 101: " + studentMap.get(101));
        System.out.println("Contains Roll 102? " + studentMap.containsKey(102));

        // --- 3. Iteration Techniques ---
        System.out.println("\nIterating using EntrySet:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }

        // --- 4. Mini-Challenge: Frequency Counter ---
        System.out.println("\n--- Practice Challenge (Frequency Counter) ---");
        String sentence = "apple banana apple cherry banana apple";
        String[] words = sentence.split(" ");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            // If word exists, increment count; if not, set to 1
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequencies: " + freqMap);
    }

    public static void main(String[] args) {
        runHashMapBasics();
    }

    public static void run() {
    }
}