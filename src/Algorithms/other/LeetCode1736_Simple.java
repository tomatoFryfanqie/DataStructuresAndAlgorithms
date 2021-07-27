package Algorithms.other;

/**
 * @Description description
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 *
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 *
 * 输入：time = "1?:22"
 * 输出："19:22"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1736_Simple {

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if(chars[3] == '?'){
            chars[3] = '5';
        }
        if(chars[4] == '?'){
            chars[4] = '9';
        }
        if(chars[0] == '?'){
            chars[0] = chars[1] <= 4 && chars[1] <= 9 ? '1' : '2';
        }
        if(chars[1] == '?'){
            chars[1] = chars[0] == '2' ? '3' : '9';
        }
        return new String(chars);
    }
}
