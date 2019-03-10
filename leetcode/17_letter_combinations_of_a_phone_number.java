//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


//Runtime: 2 ms, faster than 71.29% of Java online submissions for Letter Combinations of a Phone Number.
//Memory Usage: 37.4 MB, less than 15.13% of Java online submissions for Letter Combinations of a Phone Number.
class Solution {
	HashMap<Integer, String> map = new HashMap<Integer, String>(){{
		put(2, "abc");
		put(3, "def");
		put(4, "ghi");
		put(5, "jkl");
		put(6, "mno");
		put(7, "pqrs");
		put(8, "tuv");
		put(9, "wxyz");
	}};
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() < 1) return res;
		StringBuffer temp = new StringBuffer();
		comb(digits, temp, res, map, 0);     
		return res;
	}

	public void comb(String digits, StringBuffer temp, List<String> res, HashMap<Integer, String> map, int index) {
		if(index == digits.length()){
			res.add(temp.toString());
		}else{    
			int num = digits.charAt(index) - '0';
			for(int i = 0; i < map.get(num).length(); i++){
				temp.append(map.get(num).charAt(i));
				comb(digits, temp, res, map, index + 1);
				temp.delete(temp.length()-1, temp.length());
			}
		}
	}
}


