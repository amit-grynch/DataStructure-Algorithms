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

				// Optimizing by Reducing For Loop from Two to One
				maxProfit = calculateMaxProfitOptimised(intArray);
				System.out.println(" Maximun Profit Made By Selling&Buying Share is = " + maxProfit);

				// Optimizing the Solution
				maxProfit = findMaxProfit(intArray);
				System.out.println(" Maximun Profit Made By Selling&Buying Share is = " + maxProfit);

				// Optimized Solution
				maxProfit = findingMaxProfit(intArray);
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
	 * @return 
	 * Runtime: 258 ms, faster than 11.87% of Java online submissions for Best Time to Buy and Sell Stock. 
	 * Memory Usage: 39.6 MB, less than 18.14% of Java online submissions for Best Time to Buy and Sell  Stock.
	 * Time Complexity =O(n^2) Space Complexity=O(1)
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

	/**
	 * @param prices
	 * @return 
	 * Runtime: 1 ms, faster than 99.12% of Java online submissions for Best Time to Buy and Sell Stock. 
	 * Memory Usage: 39.4 MB, less than 22.56% of Java online submissions for Best Time to Buy and Sell Stock. 
	 *     Time Complexity =O(n) Space Complexity=O(1)
	 */
	public static int calculateMaxProfitOptimised(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

	/**
	 * @param prices
	 * @return 
	 * Runtime: 1 ms, faster than 99.13% of Java online submissions for Best Time to Buy and Sell Stock. 
	 * Memory Usage: 39.2 MB, less than 24.33% of Java online submissions for Best Time to Buy and Sell Stock.
	 *       Time  Complexity =O(n) Space Complexity=O(1)
	 */
	public static int findMaxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int priceIndex = 0; priceIndex < prices.length; priceIndex++) {
			if (minPrice > prices[priceIndex]) {
				minPrice = prices[priceIndex];
			} else if (prices[priceIndex] - minPrice > maxProfit) {
				maxProfit = prices[priceIndex] - minPrice;
			}
		}
		return maxProfit;
	}

	/**
	 * @param prices
	 * @return 
	 * Runtime: 1 ms, faster than 99.13% of Java online submissions for Best Time to Buy and Sell Stock. 
	 * Memory Usage: 39.8 MB, less than 11.94% of Java online submissions for Best Time to Buy and Sell Stock. 
	 * Time Complexity =O(n) Space Complexity=O(1)
	 */
	public static int findingMaxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int priceIndex = 1; priceIndex < prices.length; priceIndex++) {
			if (minPrice > prices[priceIndex])
				minPrice = prices[priceIndex];
			else
				maxProfit = Math.max(maxProfit, prices[priceIndex] - minPrice);

		}

		return maxProfit;
	}

}
