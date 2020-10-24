package Algorithms.Sort;

/**
 * @author lzh
 */
public class SelectSort {

    public static void selectSort(int[] ints){

        for (int i = 0; i < ints.length; i++) {

            int j = i;
            for (int k = j; k < ints.length; k++) {

                if (ints[k] > ints[j]){
                    j = k;
                }
            }
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
    }
}
