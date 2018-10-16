//unfortunately, my solution is time limited in 43/48
class Solution {
	public int candy(int[] ratings) {
		int[] candySum = new int[ratings.length];
		if (ratings.length == 1) return 1;
		int sum = 0;
		Arrays.fill(candySum, 1);
		for (int i = 0, position = 0; i < candySum.length; i++) {
			for (position = 0; position < candySum.length; position++) {
				if (position != 0 && position != candySum.length - 1 && ratings[position] > ratings[position - 1] && candySum[position] <= candySum[position - 1]) {
					candySum[position] = candySum[position - 1] + 1;
				}
				else if (position != 0 && position != candySum.length - 1 && ratings[position] > ratings[position + 1] && candySum[position] <= candySum[position + 1]) {
					candySum[position] = candySum[position + 1] + 1;
				}
				//avoid out of array index
				else if (position == 0  && ratings[0] > ratings[1] && candySum[0] <= candySum[1]) {
					candySum[0] = candySum[1] + 1;
				}
				else if (position == candySum.length - 1  && ratings[candySum.length - 1] > ratings[candySum.length - 2] && candySum[candySum.length - 1] <= candySum[candySum.length - 2]) {
					candySum[candySum.length - 1] = candySum[candySum.length - 2] + 1;
				
				}
				else if (position != 0 && position != candySum.length - 1 && ratings[position] == ratings[position - 1] && ratings[position] == ratings[position + 1]) {
					candySum[position] = 1;
				}
			}
		}

		for (int candy : candySum) {
			System.out.printf("%d\t", candy);
			sum += candy;
		}

		return sum;
	}
}

//here is an O(n) solution
public int candy(int[] ratings) {
	int candies[] = new int[ratings.length];        
	Arrays.fill(candies, 1);// Give each child 1 candy 

	for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
		if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
	}

	for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
		if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
	}

	int sum = 0;        
	for (int candy : candies)  
		sum += candy;        
	return sum;
}
