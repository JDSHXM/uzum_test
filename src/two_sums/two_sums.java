package two_sums;

public class two_sums {

    public static void result() {
        int[] array = {1, 2, 5, 6, 7, 8};
        int Summa = 11;

        searchResult(array, Summa);
    }

    public static void searchResult(int[] array, int summa) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int currentSum = array[start] + array[end];

            if (currentSum == summa) {
                System.out.println(array[start] + " + " + array[end] + " = " + summa);
                return;
            }

            if (currentSum < summa) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println("Пара с суммой " + summa + " не найдена.");
    }
}