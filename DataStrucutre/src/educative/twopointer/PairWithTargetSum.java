package educative.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PairWithTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			char userChoice;
			do {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter The Size Of Array : ");
				int arraySize = Integer.parseInt(br.readLine());
				int intArray[] = new int[arraySize];
				System.out.println("Enter The Elements Of Array : ");
				String[] stringArray = br.readLine().split("\\s");
				for (int arrayIndex = 0; arrayIndex < stringArray.length; arrayIndex++) {
					intArray[arrayIndex] = Integer.parseInt(stringArray[arrayIndex]);
				}
				System.out.println("Enter The Target Sum : ");
				int targetSum = Integer.parseInt(br.readLine());
				int resultIndices[];
				resultIndices = findPairOfTwoSum(intArray, targetSum);
				System.out.println("Index Of Required Pair : " + resultIndices[0] + " " + resultIndices[1]);
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'y' || userChoice == 'Y');
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int[] findPairOfTwoSum(int[] intputArray, int targetsum) {
		int[] targetIndices = new int[2];
		int leftpointer = 0;
		int rightpointer = intputArray.length - 1;
		int tempSum = 0;
		while (leftpointer < rightpointer) {
			tempSum = intputArray[leftpointer] + intputArray[rightpointer];
			if (tempSum == targetsum) {
				targetIndices[0] = leftpointer;
				targetIndices[1] = rightpointer;
				break;
			} else if (tempSum > targetsum) {
				rightpointer--;
			} else {
				leftpointer++;

			}
		}
		return targetIndices;

	}

}
