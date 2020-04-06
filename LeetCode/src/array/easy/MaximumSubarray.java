/*Given an integer array nums, find the contiguous subarray (containing at least one number)
 
  which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],

Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.
*/

package array.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javafx.animation.StrokeTransition;

/**
 * @author amitg
 *
 */
/**
 * @author amitg
 *
 */
public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int largetSubarraySum;
		try {
			char userChoice;
			do {
				System.out.println(" Enter The Size of Array");
				int arraySize = Integer.parseInt(br.readLine());
				int[] intArray = new int[arraySize];
				System.out.println(" Enter Elements of Given Array ");
				String[] stringIntegerArray = br.readLine().split("\\s");
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					intArray[arrayIndex] = Integer.parseInt(stringIntegerArray[arrayIndex]);
				}

				// Using Brute Force Approach To Solve
				 largetSubarraySum = maxSubArray(intArray);
				 System.out.println(" Larget Sum of contiguous Subarray is = " +
				 largetSubarraySum);

				// Optimizing The Solution Using DP with Time-Complexity O(n) and Space Complexity O(n)
				int largestSumUsingDP = maxSubArrayUsingDP(intArray);
				System.out.println(" Larget Sum of contiguous Subarray is = " + largestSumUsingDP);

				//Optimizing The Solution Using DP  by Reducing Space Complexity from O(n) to (O1) and Still Has Time Complexity O(n)
				int largestSumUsingDPOptimizedSpace = maxSubArrayUsingDPOptimizedSpace(intArray);
				System.out.println(" Larget Sum of contiguous Subarray is = " + largestSumUsingDPOptimizedSpace);
				
				// Optimizing The Solution In O(n) Time complexity and O(1) Space Complexity
				 int largestSumInArray = maxSubArrayCalculation(intArray);
				 System.out.println(" Larget Sum of contiguous Subarray is = " + largestSumInArray);

				System.out.println(" Do you want to continue then Press Y ?");
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'Y' || userChoice == 'y');
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	/**
	 * @param nums
	 * @return
	 * 202 / 202 test cases passed, but took too long. Exceeded Time Limit
	 */
	public static int maxSubArray(int[] nums) {
		int largestSubarraySum;
		int tempSum;
		Set<Integer> tempSumStore = new HashSet<Integer>();
		for (int firstPointerIndex = 0; firstPointerIndex < nums.length; firstPointerIndex++) {
			tempSum = nums[firstPointerIndex];
			tempSumStore.add(tempSum);
			for (int secondPointerIndex = firstPointerIndex
					+ 1; secondPointerIndex < nums.length; secondPointerIndex++) {
				tempSum = tempSum + nums[secondPointerIndex];
				tempSumStore.add(tempSum);
			}

		}
		TreeSet<Integer> sortedSumStore = new TreeSet<Integer>(tempSumStore);
		if (nums.length == 0) {
			return 0;
		} else
			largestSubarraySum = sortedSumStore.last();
		return largestSubarraySum;
	}

	
	/**
	 * @param nums
	 * @return
	 * Runtime: 2 ms, faster than 12.45% of Java online submissions for Maximum Subarray
	 * Memory Usage: 41.3 MB, less than 5.16% of Java online submissions for Maximum Subarray.
	 */
	public static int maxSubArrayUsingDP(int nums[]) {
		if (nums.length == 0 || nums == null)
			throw new IllegalArgumentException();
		int[] dp = new int[nums.length];
		int maxSum = nums[0];
		dp[0] = nums[0];
		for (int index = 1; index < nums.length; index++) {
			dp[index] = Math.max(nums[index], dp[index - 1] + nums[index]);
			maxSum = Math.max(dp[index], maxSum);
		}
		return maxSum;

	}
	
	
	/**
	 * @param nums
	 * @return
	 * Runtime: 1 ms, faster than 70.91% of Java online submissions for Maximum Subarray.
	 * Memory Usage: 39.4 MB, less than 8.45% of Java online submissions for Maximum Subarray.
	 */
	public static int maxSubArrayUsingDPOptimizedSpace(int nums[]) {
		if(nums.length==0||nums==null) {
			throw new IllegalArgumentException();
		}
		int maxSum=nums[0];
		int tempMaxSum=nums[0];
		for(int index=1;index<nums.length;index++) {
			tempMaxSum=Math.max(nums[index],tempMaxSum+nums[index]);
			maxSum=Math.max(tempMaxSum, maxSum);
		}
		return maxSum;
	}

	
	/**
	 * @param nums
	 * @return
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray
	 * Memory Usage: 39.6 MB, less than 7.98% of Java online submissions for Maximum Subarray
	 */
	public static int maxSubArrayCalculation(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int startIndex = 0; startIndex < nums.length; startIndex++) {
			if (sum < 0)
				sum = nums[startIndex];
			else
				sum += nums[startIndex];
			if (max < sum)
				max = sum;
		}
		return max;
	}
}
