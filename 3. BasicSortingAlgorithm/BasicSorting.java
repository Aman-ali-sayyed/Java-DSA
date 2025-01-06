import java.util.*;
public class BasicSorting {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] bubbleSort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int arr[]) {
        int n = arr.length;
        // No. of times 
        for(int i = 0; i < n-1; i++) {
            //consider initially minPos = i = 0
            int minPos = i;
            //always start j = i+1 one number ahead from i
            for(int j = i+1; j < n; j++) {
                //then compare minPos and j to get least min position
                if(arr[minPos] > arr[j]) {
                    //if miniPos initially large then it will become smaller gradually
                    minPos = j;
                }
            }
            //then swapping between minPos and i
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int curr = arr[i];
            int prev = i-1;

             //finding out the correct position to insert
            while(prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }

             //insertion
            arr[prev+1] = curr;
        }
        return arr;
    }

    public static int[] countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];

        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        return arr;
     }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printArray(countingSort(arr));

        sc.close();
    }
}