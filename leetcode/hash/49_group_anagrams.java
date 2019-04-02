/*49. Group Anagrams
Medium

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strs) {  //str遍历strs
            char[] letters = str.toCharArray(); //转换成字符数组
            Arrays.sort(letters);  //排序
            String new_str = String.valueOf(letters);
            if(!map.containsKey(new_str)) {
                map.put(new_str, new ArrayList<>());
            }
                map.get(new_str).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

/*public List<List<String>> groupAnagrams(String[] strs) {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            Map<Integer, List<String>> map = new HashMap<>();
            for(String str:strs) {
                int k = 1;
                for(char ch:str.toCharArray()) {
                    k *= primes[ch-'a'];
                }
                if(!map.containsKey(k)) {
                    map.put(k, new ArrayList<>());
                }
                map.get(k).add(str);
            }
            return new ArrayList<List<String>>(map.values());
        }*/
