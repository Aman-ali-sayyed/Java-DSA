import java.util.*;

public class Array {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int linearSearch(int arr[], int key) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largestInArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length-1;
       
        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == key) {
                return mid;
            }
            if(arr[mid] > key) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int[] reverseInArray(int arr[]) {
        int start = 0, end = arr.length-1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; 
            end--;
        }
        return arr;
    }

    public static void pairsInAnArray(int arr[]) {
        int n = arr.length;
        int tp = 0;                   // Finding Total no. of Pairs formula = n(n-1)/2;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Number of Pairs is: " + tp);
    }

    public static void printSubArrays(int arr[]) {
        int n = arr.length;                
        int ts = 0;                     // Finding Total no. of subArrays formula = n(n+1)/2;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    ts++;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of subArrays is: " + ts);
    }

    //Brute Force Approach
    public static void maxSubArraySumI(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int currSum = 0;
                for(int k = i; k <= j; k++) {
                    currSum += arr[k];
                    max = Math.max(max, currSum);
                }
            }
        }
        System.out.println(max);
    }

    //Prefix Sum
    public static int maxSubArraySumII(int arr[]) {
        int n = arr.length;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < n; i++) {
            int start = i;
            for(int j = i+1; j < n; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start];  
            }
            if(currSum > max) {
                max = currSum;
            }
        }
        return max;
    }

    //Kadane's Algorithm
    public static int maxSubArraySumIII(int arr[]) {
        int n = arr.length;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            currSum += arr[i];
            if(currSum < 0) {
                currSum = 0;
            }
            max = Math.max(max, currSum);
        }
        return max;
    }

    public static int trappingRainwater(int height[]) {
        int n = height.length;

        //Find leftMax boundary in Auxiliary(helper) array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //Find rightMax boundary in Auxiliary(helper) array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int trappedWater = 0;
        //loop
        for(int i = 0; i < n; i++) {
            //Finding minimum left or right boundary in waterLevel
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //formula
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    public static int buyAndSellStocks(int prices[]) {
        int n = prices.length;
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    }
}

