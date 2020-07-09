package Day54;

/*
面试题 17.13. 恢复空格

哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，
并且大写也弄成了小写。
像句子"I reset the computer. It still didn’t boot!"
已经变成了"iresetthecomputeritstilldidntboot"。
在处理标点符号和大小写之前，你得先把它断成词语。
当然了，你有一本厚厚的词典dictionary，
不过，有些词没在词典里。假设文章用sentence表示，
设计一个算法，把文章断开，
要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数

示例：
输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。

提示：
0 <= len(sentence) <= 1000
dictionary中总字符数不超过 150000。
你可以认为dictionary和sentence中只包含小写字母。

https://leetcode-cn.com/problems/re-space-lcci/

 */

import java.util.Arrays;
import java.util.HashSet;

public class Respace {
    //dp
    public int respace1(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len+1];
        HashSet<String> words = new HashSet<>(Arrays.asList(dictionary));
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-1; j >=0 ; j--) {
                String word = sentence.substring(j,i);
                if (words.contains(word)){
                    dp[i] = Math.min(dp[i],dp[j]);
                }else {
                    dp[i] = Math.min(dp[i],dp[j] + i - j);
                }
            }
        }
        return dp[len];
    }
    //dp2
    public int respace2(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len+1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1] + 1;
            for (String word : dictionary) {
                if (i - word.length() >= 0 &&sentence.substring(i - word.length(), i).equals(word)){
                    dp[i] = Math.min(dp[i],dp[i-word.length()]);
                }
            }
        }
        return dp[len];
    }


}
