package Algorithms.Sort;

/**
 * @author lzh
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int low, int high){

        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high){

        int[] tmp = new int[arr.length];
        int i = 0;
        int j = low,k = mid+1;

        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }

        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t = 0; t < i; t++){
            arr[low+t] = tmp[t];
        }
    }
}
