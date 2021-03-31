package educative.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class PairWithTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			char userChoice;
			do {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter The Size Of Array : ");
				int arraySize = Integer.parseInt(br.readLine());
				if(arraySize>1) {
					System.out.println("Enter The Elements Of Array : ");
				}else {
					System.out.println("Please Enter The Correct Size Of InputArray ");
					System.exit(0);
				}
				int intArray[] = new int[arraySize];
				String[] stringArray = br.readLine().split("\\s");
				for (int arrayIndex = 0; arrayIndex < stringArray.length; arrayIndex++) {
					intArray[arrayIndex] = Integer.parseInt(stringArray[arrayIndex]);
				}
				System.out.println("Enter The Target Sum : ");
				int targetSum = Integer.parseInt(br.readLine());
				int resultIndices[];
				int resultIndicesHashTable[];
				resultIndices = findPairOfTwoSum(intArray, targetSum);
				resultIndicesHashTable=findPairOfTwoSumUsingHashTable(intArray,targetSum);
				// Using Two Pointer
				if(resultIndices!=null && resultIndices.length!=0)
				System.out.println("Index Of Required Pair : " + resultIndices[0] + " " + resultIndices[1]);
				else
					System.out.println(" No Such Pair Found");
				
				// Using HashTable
				if(resultIndicesHashTable!=null && resultIndicesHashTable.length!=0)
					System.out.println("Index Of Required Pair : " + resultIndicesHashTable[0] + " " + resultIndicesHashTable[1]);
					else
						System.out.println(" No Such Pair Found");
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'y' || userChoice == 'Y');
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param intputArray
	 * @param targetsum
	 * @return
	 * Time Complexity =O(N)
	 * Space Complexity = O(1) i.e. Constant Space
	 */
	public static int[] findPairOfTwoSum(int[] intputArray, int targetsum) {
		int[] targetIndices = new int[2];
		int leftpointer = 0;
		int rightpointer = intputArray.length - 1;
		int tempSum = 0;
		 if(intputArray.length==0) {
			 return null;
		 }
		
		while (leftpointer < rightpointer) {
			tempSum = intputArray[leftpointer] + intputArray[rightpointer];
			if (tempSum == targetsum) {
				targetIndices[0] = leftpointer;
				targetIndices[1] = rightpointer;
				return targetIndices;
			} else if (tempSum > targetsum) {
				rightpointer--;
			} else {
				leftpointer++;

			}
		}
		return null;

	}

	/**
	 * @param inputArray
	 * @param targetSum
	 * @return
	 *  Time Complexity =O(N)
	 * Space Complexity = O(N) i.e. Due to New HashTable
	 */
	public static int[] findPairOfTwoSumUsingHashTable(int[] inputArray,int targetSum){
	    int[] pairIndex=new int[2];
		Hashtable<Integer, Integer> pairTable=new Hashtable<>();
		for(int arrayIndex=0;arrayIndex<inputArray.length;arrayIndex++){
		  if(pairTable.containsKey(targetSum-inputArray[arrayIndex])){
		       pairIndex[0]=arrayIndex;
			   pairIndex[1]=pairTable.get(targetSum-inputArray[arrayIndex]);
			} else {
				pairTable.put(inputArray[arrayIndex], arrayIndex);
			}
	
	}
	  return pairIndex;
	}
}
