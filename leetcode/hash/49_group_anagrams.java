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

/*        public List<List<String>> groupAnagrams(String[] strs) {
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
        }
*/
