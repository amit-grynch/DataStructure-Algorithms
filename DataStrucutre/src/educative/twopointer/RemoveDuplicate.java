package educative.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author amitg
 *
 */
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int resultantArray[];
		int arraySize;
		try {
			char userChoice;
			do {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(" Enter The Size Of Array : ");
				arraySize = Integer.parseInt(br.readLine());
				if (arraySize >= 1) {
					System.out.println(" Enter The Elements Of Array : ");
				} else {
					System.out.println(" Please Enter The Correct Size Of Array ");
				}

				int[] inputArray = new int[arraySize];
				String[] stringArray = br.readLine().split("\\s");
				for (int arrayIndex = 0; arrayIndex < stringArray.length; arrayIndex++) {
					inputArray[arrayIndex] = Integer.parseInt(stringArray[arrayIndex]);
				}

				resultantArray = removeDuplicate(inputArray);
				userChoice = br.readLine().charAt(0);
			} while (userChoice == 'y' || userChoice == 'Y');
		} catch (Exception ex) {

		}
	}
	
	
	public static int[] removeDuplicate(int[] intputArray) {
		return intputArray;
		
	}

}
