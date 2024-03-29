package Algorithms.doublepoint;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_189_Mid {
    /*
    * 解法1：借用数组
    * 依次将需要旋转的元素加入新数组
    * arrays.copyof()方法有问题，不知道什么原因-.-
    * */
    public void rotate(int[] nums, int k) {

        int length = nums.length;
        int[] arrRotate = new int[nums.length];
        for (int i = 0; i < length; i++) {
            arrRotate[(i + k)%length] = nums[i];
        }
        //Arrays.copyOf(arrRotate, length);
        System.arraycopy(arrRotate,0,nums,0,length);
    }
    /*
    * 解法2：翻转数组
    * 将数组全面翻转。找到需要旋转的点，继而翻转点之前的部分数组翻转，再翻转之后的翻转。
    * */
    public void rotate2(int[] nums, int k) {

        k %= nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int x, int y){
        while (x < y){
            nums[x] = nums[x]^nums[y];
            nums[y] = nums[x]^nums[y];
            nums[x] = nums[x++]^nums[y--];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7};
        new LeetCode_189_Mid().rotate2(arr,3);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
