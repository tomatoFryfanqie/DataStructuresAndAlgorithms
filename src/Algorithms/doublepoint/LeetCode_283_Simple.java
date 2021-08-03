package Algorithms.doublepoint;

/**
 * @Description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_283_Simple {

    /*
    * 解法一：
    * 使用双指针解法，一个指针指向nums中的0序列尾部，一个指针指向nums中非0序列首部。
    * 易错：使用异或交换两值，相同数异或为0
    * */
    public void moveZeroes(int[] nums) {
        int left = -1;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                /*nums[left + 1] = nums[left + 1] ^ nums[right];
                nums[right] = nums[left + 1] ^ nums[right];
                nums[left + 1] = nums[left + 1] ^ nums[right];*/
                int temp = nums[left + 1];
                nums[left + 1] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,0};
        new LeetCode_283_Simple().moveZeroes(ints);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
