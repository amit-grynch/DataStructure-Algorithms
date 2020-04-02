
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
import java.util.List;

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

				// Brute Force Approach
				resultantIndices = twoSum(intArray, targetSum);
				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);
				
				// Optimizing the Solution
				resultantIndices = twoSumUsingBruteForce(intArray, targetSum);

				System.out.println("Indices Are : " + resultantIndices[0] + "  " + resultantIndices[1]);
				System.out.println(" Do you want to continue then Press Y ?");
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'Y' || userChoice == 'y');
		} catch (Exception e) {
			System.out.println("Doing SomeThing Wrong and Please check");
		}
	}

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

}
