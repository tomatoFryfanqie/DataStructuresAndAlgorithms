package Algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_345_Simple {

    public String reverseVowels(String s) {

        Set<Character> srcSet = new HashSet<>();
        srcSet.add('a');
        srcSet.add('e');
        srcSet.add('i');
        srcSet.add('o');
        srcSet.add('u');
        srcSet.add('A');
        srcSet.add('E');
        srcSet.add('I');
        srcSet.add('O');
        srcSet.add('U');
        char[] srcCharSet = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!srcSet.contains(s.charAt(left))) {
                left++;
                continue;
            }
            if (!srcSet.contains(s.charAt(right))) {
                right--;
                continue;
            }
            char tmpChar = srcCharSet[left];
            srcCharSet[left] = srcCharSet[right];
            srcCharSet[right] = tmpChar;
            left++;
            right--;
        }
        return new String(srcCharSet);
    }
}
