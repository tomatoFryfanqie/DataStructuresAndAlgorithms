package Algorithms.binarySearch;

/**
* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class LeetCode_704_Simple {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int pivot = 0;
        while(left <= right){

            pivot =left+(right-left)/2;
            if(nums[pivot] == target){
                return pivot;
            }
            //中间值大于target，值在左区间
            if(nums[pivot] > target){
                right = pivot-1;
            }
            //中间值小于target，值在右区间
            if(nums[pivot] < target){
                left = pivot+1;
            }

        }
        return -1;
    }
}
