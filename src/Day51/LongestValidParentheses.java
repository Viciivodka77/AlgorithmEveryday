package Day51;

/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串
找出最长的包含有效括号的子串的长度。

示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

https://leetcode-cn.com/problems/longest-valid-parentheses/

 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int res = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')'){//当前字符为')'才做dp维护
                //若是上一个字符可以和当前字符凑成一对,即"???()"，则还需要判断上上个字符是否有长度,即第三个'?'
                if (s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2 ;
                    //若情况为"???))"，则判断减去上一个字符成对长度后是否能配对当前字符的括号，且需判断是否存在
                    //若可以则 当前字符成对长度，即"???(???)" 至少为2，加上前一个字符成对长度，再加上第三个'?'的成对长度，且需判断是否存在
                }else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] -1) == '('){
                    dp[i] = dp[i-1] + ( (i - dp[i-1]) >= 2 ? dp[i-dp[i-1] -2] : 0) + 2 ;
                }
            }
            //判断最大值
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
