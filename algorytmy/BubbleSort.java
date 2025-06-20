import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {34, 56, 1, 9};
        sort(array);
    }

    public static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
