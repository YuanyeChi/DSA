/*22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }
    
     public void backTrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max * 2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backTrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backTrack(list, str + ")", open, close + 1, max);
    }
}
