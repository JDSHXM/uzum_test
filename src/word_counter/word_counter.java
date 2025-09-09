package word_counter;

import java.util.Scanner;

public class word_counter {

    public static void result() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("text: ");
        String text = scanner.nextLine();
        System.out.print("n: ");
        int n = scanner.nextInt();

        printResult(text, n);
    }


    public static String[] splitWords(String str) {
        return str.toLowerCase().split(" ");
    }

    public static boolean isWord(String[] wordArray, int count, String word) {
        for (int i = 0; i < count; i++) {
            if (wordArray[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static int countWord(String[] words, String word) {
        int count = 0;
        for (String s : words) {
            if (s.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void addWord(String[] wordArray, int index, String word) {
        wordArray[index] = word;
    }

    public static void printResult(String str, int n) {
        String[] words = splitWords(str);
        String[] wordArray = new String[words.length];
        int wordArrayCount = 0;

        for (String word : words) {
            if (!isWord(wordArray, wordArrayCount, word)) {
                int count = countWord(words, word);
                if (count == n) {
                    System.out.print(word + " ");
                }
                addWord(wordArray, wordArrayCount, word);
                wordArrayCount++;
            }
        }
    }
}