public class BitManip {
    public static void evenOrOdd(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            System.out.println("even number.");
        } else {
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        int ans = (n | bitMask);
        return ans;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastIBits(int n, int i) {
        int bitMask = (-1) << i; //or I ~(0) << i;
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = (~(0) << (j+1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) != 0) { //check LSB
                count++;
            } 
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpoToFindPow(int a, int n) {
        int ans = 1;
        while(n > 0) {
            if((n & 1) != 0) { //check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    } 

    public static void swapTwoNum(int a, int b) {
       System.out.println("a = " + a + " and b = " + b);
       a = a ^ b;
       b = a ^ b;
       a = a ^ b;
       System.out.println("a = " + a + " and b = " + b);
    }

    public static void addToAnInteger(int x) {
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = -4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);
    }

    public static void toUpperCase() {
        for(char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print((char)(ch ^ ' ') + " ");
        }
    }

    public static void toLowerCase() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char)(ch | ' ') + " ");
        }
    }
    public static void main(String[] args) {
        // toUpperCase();
        // System.out.println();
        // toLowerCase();
    }
}
