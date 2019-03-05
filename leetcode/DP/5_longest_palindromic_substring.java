/**Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int left = 0, right = 0, len = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1] == true)) {
                    dp[j][i] = true;
                }
                if (dp[j][i] && len < i - j + 1) {
                    len = i - j + 1;
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
