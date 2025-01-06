import java.util.*;

public class HashMapB {
    public static void majorityElement() {
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        int n = arr.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }

        Set<Integer> keys = hm.keySet();

        for(int key : keys) {
            if(hm.get(key) > n/3) {
                System.out.println("key = " + key + " value "  + hm.get(key));
                break;
            }
        }
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch)-1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void inputA() {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));
    }

    //count distinct elements
    public static int countUnique(int arr[]) {
        int n = arr.length;
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }

        ans = hs.size();

        // Iterator<Integer> it = hs.iterator();

        // while(it.hasNext()) {
        //     ans++;
        //     it.next();
        // }

        return ans;
    }

    public static void inputB() {
        int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        System.out.println("ans = " + set.size());
    }

    public static void UnionAndIntersection(int arr1[], int arr2[]) {
       HashSet<Integer> hs = new HashSet<>();
       int count = 0;

       for(int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
       }

       for(int j = 0; j < arr2.length; j++) {
            hs.add(arr2[j]);
       }

       System.out.print("Union: ");
       Iterator<Integer> it = hs.iterator();
       while(it.hasNext()) {
            System.out.print(it.next()+" ");
            count++;
       }

       System.out.println();
       System.out.println("Count of union = "+ count);

       hs.clear();

       System.out.println();

       for(int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
       }

       count = 0;
       System.out.print("Intersection: ");
       for(int j = 0; j < arr2.length; j++) {
            if(hs.contains(arr2[j])) {
                System.out.print(arr2[j] + " ");
                count++;
                hs.remove(arr2[j]);
            }
        } 

        System.out.println();
        System.out.println("Count of Intersection = "+ count);

    }

    public static void inputC() {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        UnionAndIntersection(arr1, arr2);
    }

    //Find itenerary from tickets
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void InputDFindJourney() {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }

    public static void largestSubArray() {
        int arr[] = {15, -2, 2, -8, 1, 7, 10};

        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int sum = 0;
        int len = 0;

        for(int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(hm.containsKey(sum)) {
                len = Math.max(len, j-hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        System.out.println("Largest subArray with sum 0 is: "+ len);
    }

    public static void subArraySumEqualK() {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(hm.containsKey(sum-k)) {
                ans += hm.get(sum-k);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Subarray sum equal to k is: " + ans);
    }

    static class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.hd = Integer.MAX_VALUE;
            this.left = this.right = null;
        }
    }

    public static void bottomViewHelper(Node root, int curr, int hd, TreeMap<Integer, int[]> map) {
        if(root == null) {
            return;
        }

        if(!map.containsKey(hd)) {
            map.put(hd, new int[] {root.data, curr});
        } else {
            int[] p = map.get(hd);
            if(p[1] <= curr) {
                p[1] = curr;
                p[0] = root.data;
            }
            map.put(hd, p);
        }

        bottomViewHelper(root.left, curr+1, hd-1, map);

        bottomViewHelper(root.right, curr+1, hd+1, map);
    }

    public static void printBottomView(Node root) {
        TreeMap<Integer, int[]> map = new TreeMap<>();

        bottomViewHelper(root, 0, 0, map);

        for(int val[] : map.values()) {
            System.out.print(val[0]+" ");
        }
    }

    public static void inputE() {
         /*
                    20
                   /  \
                  8    22
                 / \   / \
                5   3 4   25
                   / \
                 10   14
        */
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        printBottomView(root);
    }

    public static int[] twoSum(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
             //diff = given target - number given at ith index
            int diff = target - arr[i];
             // check if found difference is present in the MAP list
            if(map.containsKey(diff)) {
                //if difference in map matches with the ith index element in array
                return new int[]{i, map.get(diff)};
            } else {
                //add arr element in map to match with future element if forms a pair
                map.put(arr[i], i);
            }
        }
        //if no matches are found
        return new int[]{0, 0};
    }

    public static void inputF() {
        int arr[] = {2, 3, 4};
        int target = 7;

        int n[] = twoSum(arr, target);

        for(int i = 0; i < n.length; i++) {
            System.out.print(n[i]+" ");
        }
    }
    public static void main(String[] args) {
        String s = "free";

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)) {
                hm.put(ch, 1);
            } else {
                hm.put(ch, hm.getOrDefault(ch, 0)+1);
            }
        }

        Set<Character> keys = hm.keySet();

        System.out.println(keys);

        for(Character key : keys) {
            System.out.println("key: " + key + " value: " + hm.get(key));
        }

    }
}
