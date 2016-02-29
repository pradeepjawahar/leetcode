import java.io.*;
import java.util.*;

/*
*  Mininimum sub array size
*/

public class MinSubArraySum {
    private static int getMinSubArraySize(int[] inputArray, int targetSum) {
        // Check base case
        if(inputArray == null || inputArray.length == 0) {
            return 0;
        }
        int runningSum = 0;
        int startIndex = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        for (int i=0; i < inputArray.length; i++) {
            runningSum = runningSum + inputArray[i];
            while (runningSum >= targetSum && startIndex <= i) {
                minSubArrayLength = Math.min(minSubArrayLength, i - startIndex + 1);
                runningSum = runningSum - inputArray[startIndex];
                startIndex++;
            }
        }
        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }
    public static void print(int returnValue) {
        System.out.println("Min SubArray Length: " + returnValue);
    }
    public static void main(String[] args) {
        int[] testArray1 = {8,9,1,5,8,9,15};
        int[] testArray2 = {11,-1,0,-2,4,5};
        int[] testArray3 = {1};
        int[] testArray4 = {};
        print(getMinSubArraySize(testArray1, 9)); // -> 1
        print(getMinSubArraySize(testArray1, 32)); // -> 3
        print(getMinSubArraySize(testArray2, 10));; // -> 2
        print(getMinSubArraySize(testArray2, 3));; // -> 0
        print(getMinSubArraySize(testArray3, 1)); // -> 1
        print(getMinSubArraySize(null, 5)); // -> 0
        print(getMinSubArraySize(testArray4, 5)); // -> 0
    }
}
