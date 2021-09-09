package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_68_Hard {

    public StringBuilder join(String[] words, int index, int right, String sep){
        StringBuilder stringBuilder = new StringBuilder(words[index]);
        for (int i = index+1; i < right; ++i) {
            stringBuilder.append(sep);
            stringBuilder.append(words[i]);
        }
        return stringBuilder;
    }

    public String black(int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> answer = new ArrayList<>();
        int n = words.length;
        int right = 0;

        while (true){
            int index = right; //当前行的第一个单词在words的位置
            int sumlen = 0; //统计这一行单词长度之和
            //循环确定当前行可以放多少个单词，单词之间至少有一个空格
            while (right < n && sumlen+words[right].length() + right-index <= maxWidth){
                sumlen += words[right++].length();
            }
            //当前行是最后一行：单词左对齐，且单词之间只有一个空格。并在行尾填充空格至maxWidth
            if (right == n){
                StringBuilder stringBuilder = join(words, index, n, " ");
                stringBuilder.append(black(maxWidth - stringBuilder.length()));
                answer.add(stringBuilder.toString());
                return answer;
            }

            int numWords = right - index;
            int numSpaces = maxWidth - sumlen;
            //当前行只有一个单词，左对齐，在行未填充空格
            if (numWords == 1){
                StringBuilder stringBuilder = new StringBuilder(words[index]);
                stringBuilder.append(black(numSpaces));
                answer.add(stringBuilder.toString());
                continue;
            }
            //当前行不知一个单词。
            int avgSpace = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuilder stringBuilder = new StringBuilder();
            //拼接额外加一个空格的单词
            stringBuilder.append(join(words, index, index+extraSpaces+1, black(avgSpace+1)));
            stringBuilder.append(black(avgSpace));
            //拼接其他单词
            stringBuilder.append(join(words, index+extraSpaces+1, right, black(avgSpace)));
            answer.add(stringBuilder.toString());
        }
    }
    public static void main(String[] args) {
        LeetCode_68_Hard leetCode_68_hard = new LeetCode_68_Hard();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> list = leetCode_68_hard.fullJustify(words, 16);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
