package Algorithms.sort;

/**
 * @author lzh
 */
public class ShellSort {

    public static void shellSort(int[] arr){

        for (int step = arr.length/2; step > 0; step/=2) {

            for (int i = step; i < arr.length; i++) {

                for (int j = i; j >=step && arr[j] < arr[j-step] ; j-=step) {

                    int temp = arr[j];
                    arr[j] = arr[j-step];
                    arr[j-step] = temp;
                }
            }
        }
    }
}
