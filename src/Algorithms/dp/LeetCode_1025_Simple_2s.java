package Algorithms.dp;

/**
 * @Description description
 * @Author lzh
 */
public class LeetCode_1025_Simple_2s {

    /*
    * 解法一:dp
    * */
    public boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    /*
    * 解法二:math
    * */
    public boolean divisorGame2(int n) {
        return n % 2 == 0;
    }
}
