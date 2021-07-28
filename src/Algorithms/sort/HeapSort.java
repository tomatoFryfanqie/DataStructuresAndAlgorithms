package Algorithms.sort;

/**
 * @author lzh
 */
public class HeapSort {

    public static void heapSort(int[] ints){

        for (int i =  ints.length - 1; i > 0; i--) {

            build_head(ints,i);
            swap(ints,0,i);
        }
    }

    public static void swap(int[] ints, int max, int i){

        int temp = ints[max];
        ints[max] = ints[i];
        ints[i] = temp;
    }

    public static void heapfiy(int[] ints, int i){

        if(i >= ints.length){
            return;
        }

        int child1 = 2*i+1;
        int child2 = 2*i+2;
        int max = i;

        if(child1 < ints.length && ints[child1] > ints[i]){

            max = child1;
        }
        if(child2 < ints.length && ints[child2] > ints[max]){

            max =child2;
        }
        if(max != i){

            swap(ints,max,i);
            heapfiy(ints,max);
        }
    }

    public static void build_head(int[] ints, int n){

        int last_node = n;
        int parent = (last_node-1)/2;
        for (int i = parent; i >= 0; i--) {

            heapfiy(ints,i);
        }
    }
}
