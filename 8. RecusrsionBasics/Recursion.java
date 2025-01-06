public class Recursion {
    public static void printNumInDec(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNumInDec(n-1);
    }

    public static void printNumInIncre(int n) {
        if(n == 0) {
            return;
        }
        printNumInIncre(n-1);
        System.out.println(n);
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        return n * fact(n-1);
    }

    public static int sumOfNum(int n) {
        if(n == 0) {
            return 0;
        }
        return n + sumOfNum(n-1);
    }

    public static int fibonacciNum(int n) {
        if(n == 0 || n == 1) {
           return n;
        }
        return fibonacciNum(n-1) + fibonacciNum(n-2);
    }

    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if(i == arr.length-1) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if(i == arr.length-1) {
            return -1;
        }

        int isFound = lastOccurence(arr, key, i+1);
        
        if(isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int pow(int x, int n) {
        if(n == 0) {
            return 1;
        }

        return x * pow(x, n-1);
    }

    public static int optimizedPow(int a, int n) {
        if(n == 0) {
            return 1;
        }

        int halfPow = optimizedPow(a, n/2);
        int halfPowSq = halfPow * halfPow;

        if(n%2 != 0) {
            halfPowSq = a * halfPowSq;
        }
        return halfPowSq;
    }

    public static int tilingProblem(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        //vertical
        int fnm1 = tilingProblem(n-1);

        //horizontal
        int fnm2 = tilingProblem(n-2);

        int totWays = fnm1 + fnm2;

        return totWays;
    }

    public static void removeDuplicate(String str, int idx, StringBuilder sb, boolean map[]) {
        if(idx == str.length()-1) {
            System.out.println(sb);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            //Duplicate
            removeDuplicate(str, idx+1, sb, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx, sb.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        //choice
        //single
        int fnm1 = friendsPairing(n-1);

        //pair
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1) * fnm2;

        //toWays
        int totWays = fnm1 + pairWays;

        return totWays;
    }

    public static void printBinaryString(int n, int lastPlace, String str) {
        //base case
        if(n == 0) {
            System.out.println(str);
            return;
        }

        //kaam
        printBinaryString(n-1, 0, str+"0");

        if(lastPlace == 0) {
            printBinaryString(n-1, 1, str+"1");
        }
    }

    public static void allOccurence(int arr[], int i, int key) {
        if(i == arr.length) {
            return;
        }

        if(arr[i] == key) {
            System.out.print(i + " ");
        }

       allOccurence(arr, i+1, key);
    }

    public static String convertInString(int n, StringBuilder sb) {
        if(n == 0) {
            return sb.toString();
        }
        String str[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        convertInString(n/10, sb);
        sb.append(str[n%10]);
        sb.append(" ");
        return sb.toString();
    }

    public static int length(String str) {
        if(str.length() == 0) {
            return 0;
        }

        return length(str.substring(1))+1;
    }

    public static int countSubstr(String str, int i, int j, int n) {
        if(n == 1) {
            return 1;
        }

        if(n <= 0) {
            return 0;
        }

        int res = countSubstr(str, i+1, j, n-1) + countSubstr(str, i, j-1, n-1) - countSubstr(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }

    public static void inputA() {
        String str = "abcab";
        int n = str.length();
        System.out.println(countSubstr("abcab", 0, n-1, n));
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    public static void inputB() {
        int n = 4;
        towerOfHanoi(n, "A", "B", "C");
    }

    public static String reverse(String str, StringBuilder sb, int idx) {
        if(idx == str.length()) {
            return sb.toString();
        }

        reverse(str, sb, idx+1);
        sb.append(str.charAt(idx));

        return sb.toString();
    }

    public static String moveXInEnd(String str, StringBuilder sb, int idx) {
        if(idx == str.length()) {
            return sb.toString();
        }

        int count = 0;
        if(str.charAt(idx) == 'x') {
            count++;
        } else {
            sb.append(str.charAt(idx));
        }
        moveXInEnd(str, sb, idx+1);

        for(int i = 0; i < count; i++) {
            sb.append('x');
        }

        return sb.toString();
    }

    public static void subSequence(String str, int idx, String newStr) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        //to be
        subSequence(str, idx+1, newStr+currChar);

        //not to be
        subSequence(str, idx+1, newStr);
    }

    public static void printComb(String str, int idx, String combination) {
        if(idx == str.length()) {
            System.out.println(combination);
            return;
        }
        String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for(int i = 0; i < mapping.length(); i++) {
            printComb(str, idx+1, combination+mapping.charAt(i));
        }
    }

    public static void inputC() {
        printComb("23", 0, "");
    }

    public static void printMultiple(int n, int k) {
        if(k == 0)  return;
       
        printMultiple(n, k-1);
        System.out.println(n*k);
    }

    public static int SeriesSum(int n) {
        if(n == 0) {
            return 0;
        }
      
        if(n%2 == 0) {
            return SeriesSum(n-1) - n;
        } else {
           return SeriesSum(n-1) + n;
        }
    }

    public static int findGDC(int x, int y) {
        if(y == 0) {
            return x;
        }

        return findGDC(y, x%y);
    }

    public static void printArray(int arr[], int idx) {
        if(idx == arr.length-1) {
            System.out.print(arr[idx] + " ");
            return;
        }
        System.out.print(arr[idx] + " ");
        printArray(arr, idx+1);
    }

    public static int printMax(int arr[], int idx, int max) {
        if(idx == arr.length) {
            return max;
        }
        if(arr[idx] > max) {
            max = arr[idx];
        }
        return printMax(arr, idx+1, max);
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 6, 7, 9, 10};
        System.out.println(printMax(arr, 0, Integer.MIN_VALUE));
    }
}
