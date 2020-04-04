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
				int largetSubarraySum = maxSubArray(intArray);
				System.out.println(" Larget Sum of contiguous Subarray is = " + largetSubarraySum);
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
}
