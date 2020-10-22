package Algorithms.Sort;

/**
 * @author lzh
 */
public class InsertSort {

    public static void insertSort(int[] ints){

        if(ints == null || ints.length==1){
            return;
        }

        for (int i = 1; i < ints.length; i++) {

            if(ints[i] < ints[i-1]){

                int j = i;
                int temp = ints[i];

                while (temp <= ints[j]) {

                    if (j==0){
                        break;
                    }

                    if(temp<ints[j-1]){

                        ints[j] = ints[j - 1];
                        ints[j-1] = temp;
                        j--;
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
