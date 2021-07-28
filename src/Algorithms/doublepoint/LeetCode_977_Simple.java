package Algorithms.doublepoint;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_977_Simple {
    public int[] sortedSquares(int[] nums) {
        /*
        * 双指针解法：
        * 找到首尾指针，对比平方后的值，依次将大值存入新数组。
        * 关键词：非递减数组
        * */
        int start = 0;
        int end = nums.length-1;
        int pivot = nums.length-1;
        int[] arrSquare = new int[nums.length];
        while (start < end){
            arrSquare[pivot--] = nums[start]*nums[start] < nums[end]*nums[end] ? nums[end]*nums[end--] : nums[start]*nums[start++];
        }
        arrSquare[pivot] = nums[start]*nums[start];
        Arrays.sort(arrSquare);
        return arrSquare;
    }

    public static void main(String[] args) {
        int[] squares = new LeetCode_977_Simple().sortedSquares(new int[]{-4,-1,0,3,10});
        for (int square : squares) {
            System.out.print(square+" ");
        }
    }
}
