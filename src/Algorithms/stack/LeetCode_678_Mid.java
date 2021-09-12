package Algorithms.stack;

import java.util.LinkedList;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_678_Mid {
    public boolean checkValidString(String s) {
        //创建（栈和*栈
        LinkedList<Integer> leftStack = new LinkedList<>();
        LinkedList<Integer> rightStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '('){
                leftStack.push(i);
            }else if(chars[i] == '*'){
                rightStack.push(i);
            }else {
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if (!rightStack.isEmpty()){
                    rightStack.pop();
                }else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !rightStack.isEmpty()){
            int leftIndex = leftStack.pop();
            System.out.println(leftIndex);
            int rightIndex = rightStack.pop();
            System.out.println(rightIndex);
            if (leftIndex > rightIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode_678_Mid leetCode_678_mid = new LeetCode_678_Mid();
        leetCode_678_mid.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }
}
