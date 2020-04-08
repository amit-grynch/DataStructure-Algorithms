/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and 
sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

package array.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char userChoice;
		int maxProfit;
		try {
			do {
				System.out.println(" Enter Size of Array : ");
				int arraySize = Integer.parseInt(br.readLine());
				int intArray[] = new int[arraySize];
				System.out.println("Enter the Elements of Array");
				String stringArray[] = br.readLine().split("\\s");
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					intArray[arrayIndex] = Integer.parseInt(stringArray[arrayIndex]);
				}
				// Solving using Brute Force Approach
				maxProfit = calculateMaxProfit(intArray);
				System.out.println(" Maximun Profit Made By Selling&Buying Share is = " + maxProfit);

				// Optimizing Brute Force by Reducing For Loop from Two to One
				maxProfit = calculateMaxProfitOptimised(intArray);
				System.out.println(" Maximun Profit Made By Selling&Buying Share is = " + maxProfit);
				System.out.println(" Do You Want to Continue if yes Then Press Y or y Other AnyKey ");
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'Y' || userChoice == 'y');
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * @param prices
	 * @return Runtime: 258 ms, faster than 11.87% of Java online submissions for
	 *         Best Time to Buy and Sell Stock. Memory Usage: 39.6 MB, less than
	 *         18.14% of Java online submissions for Best Time to Buy and Sell
	 *         Stock.
	 */
	public static int calculateMaxProfit(int[] prices) {
		int maxProfit = 0;
		int tempProfit = 0;
		if (prices == null || prices.length == 1) {
			throw new IllegalArgumentException();
		}
		for (int firstPriceIndex = 0; firstPriceIndex < prices.length; firstPriceIndex++) {
			for (int seconfPriceIndex = firstPriceIndex + 1; seconfPriceIndex < prices.length; seconfPriceIndex++) {
				if (prices[firstPriceIndex] < prices[seconfPriceIndex]) {
					tempProfit = prices[seconfPriceIndex] - prices[firstPriceIndex];
					maxProfit = Math.max(tempProfit, maxProfit);
				}
			}

		}
		return maxProfit;
	}

	public static int calculateMaxProfitOptimised(int[] prices) {
		int maxProfit = 0;
		int tempProfit = 0;
		int buyPrice=prices[0];
		if (prices == null || prices.length == 1) {
			throw new IllegalArgumentException();
		}
		
		for(int index=0;index<prices.length;index++) {
			 if(pric)
		}
		return maxProfit;
	}
}
