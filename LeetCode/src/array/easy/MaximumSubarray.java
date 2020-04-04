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
import java.io.Reader;

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
			System.out.println(" Enter The Size of Array");
			int arraySize = Integer.parseInt(br.readLine());
			int[] intArray = new int[arraySize];
			System.out.println(" Enter Elements of Given Array ");
			String[] stringIntegerArray = br.readLine().split("\\s");
			for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
				intArray[arrayIndex] = Integer.parseInt(stringIntegerArray[arrayIndex]);
			}
			// Using Brute Force Approach  To Solve 
			int largetSubarraySum = maxSubArray(intArray);
			System.out.println(" Larget Sum of contiguous Subarray is = " + largetSubarraySum);
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
		int largetSubarraySum;
		return largetSubarraySum;
	}
}
