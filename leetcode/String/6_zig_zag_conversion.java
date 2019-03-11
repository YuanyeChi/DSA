/*6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/
//my solution 
//use list contaning stringbuilders whose amount is equal to rows
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        
        for(int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());//collection是add，string是append
        }
        
        int i = 0;
        while(i < s.length()) {
            for (int curRow = 0; curRow < numRows - 1 && i < s.length(); curRow++) 
                rows.get(curRow).append(s.toCharArray()[i++]);
            for (int curRow = numRows - 1; curRow > 0 && i < s.length(); curRow--)
                rows.get(curRow).append(s.toCharArray()[i++]);
        }
	//the part above can be replaced by follow one 	
	//int curRow = 0;
        //boolean goingDown = false;
	//
        //for (char c : s.toCharArray()) {
        //    rows.get(curRow).append(c);
        //    if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
        //    curRow += goingDown ? 1 : -1;
        //}

             
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : rows) {
            res.append(temp);
        }
        return res.toString();
    }
}
