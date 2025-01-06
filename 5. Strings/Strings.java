import java.util.*;

public class Strings {
    public static void printChar(String name) {
        for(int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i) + " ");
        }
    }

    public static boolean checkPalindrome(String name) {
        int n = name.length();
        for(int i = 0; i <= n/2; i++) {
            if(name.charAt(i) != name.charAt(n-1-i)) {
                System.out.println(name + " is not palindrome.");
                return false;
            }
        }
        System.out.println(name + " is palindrome.");
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        
        for(int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if(dir == 'E') {
                x++;
            }
            else if(dir == 'W') {
                x--;
            }
            else if(dir == 'N') {
                y++;
            }
            else {
                y--;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;

        return (float)Math.sqrt(X2+Y2);
    }

    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for(int i = si; i < ei; i++) {
            subStr += str.charAt(i);
        }
        return subStr;
    }

    public static String largeString(String[] fruits) {     //In lexicographical order
        String largest = fruits[0];

        for(int i = 1; i < fruits.length; i++) {
            if(largest.compareToIgnoreCase(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }

        return largest;
    }

    public static void addInString(StringBuilder sb) { // This method does not take any extra space in the heap memory and it is mutable
        for(char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
    } 

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        // sb.append(Character.toUpperCase(str.charAt(0)));
        sb.append(str.toUpperCase().charAt(0));

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                // sb.append(Character.toUpperCase(str.charAt(i)));
                sb.append(str.toUpperCase().charAt(i));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static int countVowel(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void isAnagrams(String str, String str2) {
        str.toLowerCase();
        str2.toLowerCase();

        if(str.length() == str2.length()) {
            char[] strCharArray = str.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            Arrays.sort(strCharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(strCharArray, str2CharArray);

            if(result) {
                System.out.println(str + " and " + str2 + " are anagrams to each other");
            } else {
                System.out.println(str + " and " + str2 + " are not anagrams to each other");
            }
        } else {
            System.out.println(str + " and " + str2 + " are not anagrams to each other");
        }
    }

    public static String toggleChar(StringBuilder str) {

        for(int i = 0; i < str.length(); i++) {
            int asci = (int)str.charAt(i);
            if(asci < 97) {
                asci += 32;
                str.setCharAt(i, (char)asci);
            } else {
                asci -= 32;
                str.setCharAt(i, (char)asci);
            }
        }
        return str.toString();
    }

    public static String reverseEachWord(String str) {
        StringBuilder sb = new StringBuilder("");
        String ans = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ' ') {
                sb.append(ch);
            } else {
                sb.reverse();
                ans += sb;
                ans += " ";
                sb = new StringBuilder("");
            }
        }
        sb.reverse();
        ans += sb;
        return ans;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter name: ");
        // String name = sc.nextLine();
        String str = "hi, i am aman ali sayyed";
        System.out.println(reverseEachWord(str));
    
        sc.close();
    }
}

// String path = "WNEENESENNN";
// String fruits[] = {"apple", "mango", "banana"};
//  StringBuilder sb = new StringBuilder("");
// String str = "hi, i am aman ali sayyed";
// String str = "aaabbcccddssss";
// StringBuilder str = new StringBuilder("PhySiCs");