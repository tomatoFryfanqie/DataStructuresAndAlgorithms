package Algorithms.doublepoint;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_611_Mid {

    /*
    * 解法一：排序+双指针
    * 将数组进行排序，三角形的三条边分别对应 i ，j(作为左指针) ，k(作为右指针，最大边) 有nums[k] < nums[i] + nums[j]
    * 双循环遍历数组，先循环以 i 作为枚举量，再次循环时将 j 作为左指针。尝试移动右指针。
    * 使得上述条件满足。得到右指针距离左指针的长度。返回枚举值 i 循环得到的值。
    * */
    public int triangleNumber(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = i+1; j < length; ++j) {

                while (k+1 < length && nums[k+1] < nums[i] + nums[j]){
                    k++;
                }
                ans += Math.max(k-j,0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_611_Mid().triangleNumber(new int[]{2,2,3,4}));
    }
}
