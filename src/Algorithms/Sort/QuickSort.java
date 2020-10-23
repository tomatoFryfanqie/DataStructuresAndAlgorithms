package Algorithms.Sort;

/**
 * @author lzh
 */
public class QuickSort {

    public static void quickSort(int[] ints, int left, int right){

        if(left>=right){
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
        int key = ints[left];

        while (leftIndex < rightIndex){

            while (leftIndex < rightIndex &&ints[rightIndex] >= key){
                rightIndex--;
            }
            ints[leftIndex] = ints[rightIndex];

            while (leftIndex < rightIndex && ints[leftIndex] <= key){
                leftIndex++;
            }
            ints[rightIndex] = ints[leftIndex];
        }
        ints[leftIndex] = key;
        quickSort(ints,left,leftIndex-1);
        quickSort(ints,rightIndex+1,right);
    }
}
