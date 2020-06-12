
/*
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

package array.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author amitg
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			char userChoice;
			do {
				System.out.print("Enter The Size of Array :");
				int ArraySize = Integer.parseInt(br.readLine());
				int intArray[] = new int[ArraySize];
				System.out.println("Enter the Elements Of Arrays :");
				String stringArray[] = br.readLine().split("\\s");
				for (int intputArrayIndex = 0; intputArrayIndex < stringArray.length; intputArrayIndex++) {
					intArray[intputArrayIndex] = Integer.parseInt(stringArray[intputArrayIndex]);
				}
				System.out.println("Enter The Target Sum:");
				int targetSum = Integer.parseInt(br.readLine());
				int resultantIndices[];

				// Solving Using Brute Force Approach 1

				resultantIndices = twoSum(intArray, targetSum);
				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);

				// Solving Using Brute Force Approach 2

				resultantIndices = twoSumUsingBruteForce(intArray, targetSum);
				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);

				// Solving using Map
				resultantIndices = findingTwoSumUsingMap(intArray, targetSum);
				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);
				
			/*	Solving Using Two Pointer Approach 
				Time Complexity=O(n) Space Complexity=O(n)
          */				
				resultantIndices = findingTwoSumUsingTwoPointer(intArray, targetSum);
				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);
				System.out.println(" Do you want to continue then Press Y ?");
				userChoice = br.readLine().charAt(0);
				
				
			} while (userChoice == 'Y' || userChoice == 'y');
		} catch (Exception e) {
			System.out.println("Doing SomeThing Wrong and Please check");
		}
	}

	// Runtime: 49 ms, faster than 36.96% of Java online submissions for Two Sum.
	// Memory Usage: 40 MB, less than 5.65% of Java online submissions for Two Sum.
	public static int[] twoSum(int nums[], int target) {
		int targetIndices[] = new int[2];
		int firstNum;
		int secondNum;
		for (int startIndex = 0; startIndex < nums.length; startIndex++) {
			firstNum = nums[startIndex];
			for (int iterativeIndex = startIndex + 1; iterativeIndex < nums.length; iterativeIndex++) {
				secondNum = nums[iterativeIndex];
				if (firstNum + secondNum == target) {
					targetIndices[0] = startIndex;
					targetIndices[1] = iterativeIndex;
				}
			}
		}
		return targetIndices;
	}

	// Runtime: 1000 ms, faster than 5.09% of Java online submissions for Two Sum.
	// Memory Usage: 40.1 MB, less than 5.65% of Java online submissions for Two
	// Sum.
	public static int[] twoSumUsingBruteForce(int numArray[], int target) {
		int targetIndices[] = new int[2];
		List<Integer> numList = new ArrayList<Integer>(numArray.length);
		for (int element : numArray) {
			numList.add(element);
		}
		int firstNum, secondNum;
		for (int startIndex = 0; startIndex < numArray.length; startIndex++) {
			firstNum = numArray[startIndex];
			secondNum = target - firstNum;
			if ((numList.contains(secondNum)) && (firstNum == secondNum)
					&& (startIndex != numList.indexOf(secondNum))) {
				targetIndices[0] = startIndex;
				targetIndices[1] = numList.indexOf(secondNum);
				return targetIndices;
			} else if (numList.contains(secondNum) && firstNum != secondNum) {
				targetIndices[0] = startIndex;
				targetIndices[1] = numList.indexOf(secondNum);
				return targetIndices;
			}

		}
		return targetIndices;
	}

	// Runtime: 1 ms, faster than 99.88% of Java online submissions for Two Sum.
	// Memory Usage: 39.9 MB, less than 5.65% of Java online submissions for Two Sum
	public static int[] findingTwoSumUsingMap(int nums[], int target) {
		int targetIndices[] = new int[2];
		Map<Integer, Integer> storeMap = new HashMap<Integer, Integer>();
		for (int startIndex = 0; startIndex < nums.length; startIndex++) {
			if (storeMap.containsKey(target - nums[startIndex])) {
				targetIndices[0] = startIndex;
				targetIndices[1] = storeMap.get(target - nums[startIndex]);
				return targetIndices;
			} else {
				storeMap.put(nums[startIndex], startIndex);
			}

		}
		return targetIndices;
	}
	
	
	//Runtime: 1 ms, faster than 99.93% of Java online submissions for Two Sum.
	//Memory Usage: 39.5 MB, less than 67.81% of Java online submissions for Two Sum.
	 public static int[] findingTwoSumUsingTwoPointer(int[] nums, int target) {
		   if(nums == null)
			    		return null;
			    	int[] nums2 = Arrays.copyOf(nums, nums.length);
			    	Arrays.sort(nums2);
			    	int a = 0, b = 0;
			    	int start = 0, end = nums2.length-1;
			    	//find two nums
			    	while(start<end){
			    		int sum = nums2[start] + nums2[end];
			    		if(sum < target)
			    			start++;
			    		else if(sum > target)
			    			end--;
			    		else{
			    			a = nums2[start]; b = nums2[end];
			    			break;
			    		}
			    	}
			    	//find the index of two numbers
			    	int[] res = new int[2];
			    	for(int i = 0; i < nums.length; i++){
			    		if(nums[i] == a){
			    			res[0] = i;
			    			break;
			    		}
			    	}
			    	if(a != b){
			    		for(int i = 0; i < nums.length; i++){
				    		if(nums[i] == b){
				    			res[1] = i;
				    			break;
				    		}
				    	}
			    	} else{
			    		for(int i = 0; i < nums.length; i++){
				    		if(nums[i] == b && i != res[0]){
				    			res[1] = i;
				    			break;
				    		}
				    	}
			    	}
			    	
			    	return res;
		}
}
