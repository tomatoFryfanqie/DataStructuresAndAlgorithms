package Algorithms;

public class LeetCode_1894_Mid {

    public int chalkReplacer(int[] chalk, int k){
        int n = chalk.length;
        int onceAll = 0;
        for (int i = 0; i < n; i++) {
            onceAll += chalk[i];
        }
        long last = k % onceAll;
        for (int i = 0; i < n; i++) {
            if (last < chalk[i]){
                return i;
            }
            last -= chalk[i];
        }
        return 0;
    }
}
