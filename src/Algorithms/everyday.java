package Algorithms;

import java.util.Arrays;

/**
 * @Description description
 * @Author lzh
 */
public class everyday {
    public int maxIceCream(int[] costs, int coins) {

        int sum =0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if(coins - costs[i] >= 0){
                coins -= costs[i];
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] a = {1,6,3,1,2,5};
        everyday everyday = new everyday();
        int i = everyday.maxIceCream(a, 20);
        System.out.println(i);
    }
}
