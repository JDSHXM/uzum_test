package two_pointers;

public class two_pointers {

   public static void result(){
        int[] array = {1, 1, 1, 2, 2, 3, 3, 3, 3};

        print(array,unikalNumber(array));
    }

    public static int unikalNumber(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int i = 1;

        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i - 1]) {
                array[i] = array[j];
                i++;
            }
        }

        return i;
    }

    public static void print(int[] array, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}