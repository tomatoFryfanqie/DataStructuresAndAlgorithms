package Algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_581_Mid {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
        /*int start = 0,end = 0;
        int length = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], 0);
        }
        insertSort(nums,hashMap);

        for (int i = 0; i < length; i++) {
            if(hashMap.get(nums[i]) == 1){
                start = i-1;
                break;
            }
        }
        for (int i = length-1; i >0; i--) {
            if(hashMap.get(nums[i]) == 1){
                end = i;
                break;
            }
        }

        return end-start;
    }*/

    /*public void insertSort(int[] nums, HashMap hashMap){
        if (nums == null || nums.length == 1){
            return;
        }
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] < nums[i-1]){
                int j = i;
                int temp = nums[j];
                while (temp <= nums[j]){

                    if (j == 0){
                        break;
                    }else if(temp < nums[j-1]){
                        hashMap.put(nums[j],1);
                        hashMap.put(nums[j-1],1);
                        nums[j] = nums[j-1];
                        nums[j-1] = temp;
                        j--;
                    }else {
                        break;
                    }
                }
            }
        }
    }*/

    public static void main(String[] args) {

        System.out.println(new LeetCode_581_Mid().findUnsortedSubarray(new int[]{1,3,2,3,3}));
    }
}
