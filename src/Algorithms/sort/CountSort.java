package Algorithms.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description description
 * @Author lzh
 */
public class CountSort {

    public static int[] countSort(int[] ints){
        /*
        找到最大值max与最小值min
        */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int anInt : ints) {
            min = Math.min(min,anInt);
            max = Math.max(max,anInt);
        }
        /*
        定义计数数组,数组范围由max与min决定
        据元素的大小分配数组的索引,元素的数量为数组索引的值
        */
        int[] count = new int[max-min+1];
        for (int anInt : ints) {
            count[anInt-min]++;
        }
        /*
        定义结果数组,用来接收计数数组.
        */
        int[] result = new int[ints.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                result[index++] = i+min;
                count[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {


        ThreadLocalRandom current = ThreadLocalRandom.current();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = current.nextInt(100000000,100001000);
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
        int[] ints = countSort(a);
        System.out.println();
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }
}
