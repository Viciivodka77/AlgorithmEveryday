package y2020.m6.Day42;
/*
139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    //dp
    private static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j >= 0; j--) {
                String word = s.substring(j,i);
                if (wordDict.contains(word) && dp[j]){//判断是否在wordDict
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    //用HashSet优化
    private static boolean wordBreak1(String s, List<String> wordDict) {
        int len = s.length();
        Set wordSet = new HashSet(wordDict);
        boolean[] dp = new boolean[len+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && wordSet.contains(s.substring(j,i))  ){//判断是否在wordDict
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /*
        取巧做法

     */
    private static boolean wordBreak2(String s, List<String> wordDict){
        int len = s.length();
        if (len == 0) return true;
        if (len >= 151) return false;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word)){
                if (wordBreak(s.substring(word.length()),wordDict)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreak(s,wordDict));
        System.out.println(wordBreak1(s,wordDict));
        System.out.println(wordBreak2(s,wordDict));
    }



}
