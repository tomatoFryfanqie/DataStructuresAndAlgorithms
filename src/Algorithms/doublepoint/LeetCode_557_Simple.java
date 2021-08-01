package Algorithms.doublepoint;

/**
 * @Description
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_557_Simple {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(reverseString(split[i])+" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return new String(stringBuilder);
    }

    public String reverseString(String str){

        char[] s = str.toCharArray();
        int left = 0;
        int right = s.length-1;
        while (left < right){
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left++] ^ s[right--]);
        }

        return new String(s);
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(new LeetCode_557_Simple().reverseWords(str));
    }
}
