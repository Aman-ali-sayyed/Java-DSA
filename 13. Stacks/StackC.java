import java.util.*;

public class StackC {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void inputA() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void inputB() {
        String str = "abc";
        String result = reverseString(str);
        System.out.println(result);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    } 

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void inputC() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);
        printStack(s);
    }

    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] =  i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void inputD() {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i = 0; i < span.length; i++) {
            System.out.println(span[i]+" ");
        }
    }

    public static void nextGreater() {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        
        for(int i = arr.length-1; i >= 0; i--) {  //next greater right
            //1. while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            //2. if-else
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }
            //3. push in s
            s.push(i);
        }

        for(int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }

        //next greater right
        //next greater left
        //next small right
        //next small left
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //opening
            if(ch == '{' || ch == '(' || ch == '[') {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                //closing
                if(s.peek() == '(' && ch == ')' || s.peek() == '{' && ch == '}' || s.peek() == '[' && ch == ']') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void inputE() {
        String str = "({[]}())"; //true
        System.out.println(isValid(str));
    }

    public static boolean isDuplicate(String str) { //O(n)
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            //closing
            if(ch == ')') {
                int count = 0;
                while(s.pop() != '(') {
                    count++;
                }
                if(count < 1) {
                    return true; //Duplicate
                }
            } else {
                //opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void inputF() {
        String str1 = "((a+b))";
        String str2 = "(a+b)";
        String str3 = "(((a+b) + (c+d)))";

        System.out.println(isDuplicate(str1));
        System.out.println(isDuplicate(str2));
        System.out.println(isDuplicate(str3));
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //next smaller left
        s = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //area => width = j-i-1 => nsr[i]-nsl[i]-1
        for(int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Maximum area in histogram is: " + maxArea);
    }
    public static void main(String[] args) {
       int arr[] = {2, 1, 5, 6, 2, 3}; //heights in histogram
       maxArea(arr);
    }
}