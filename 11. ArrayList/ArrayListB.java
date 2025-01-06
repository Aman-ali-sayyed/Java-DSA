import java.util.*;
public class ArrayListB {

    public static void swap(ArrayList<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    public static void multiDimensional() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i = 1; i <= 5; i++) {
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for(int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            System.out.print("list" + (int)(i+1) + " : ");
            for(int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }

    //Brute force Approach - O(n^2)
    public static void findMaxWaterContainer() { 
       ArrayList<Integer> height = new ArrayList<>();

       height.add(1);
       height.add(8);
       height.add(6);
       height.add(2);
       height.add(5);
       height.add(4);
       height.add(8);
       height.add(3);
       height.add(7);

       int max = Integer.MIN_VALUE;
       int water = 0;

       for(int i = 0; i < height.size(); i++) {
        for(int j = i+1; j < height.size(); j++) {
            int hght = Math.min(height.get(i), height.get(j));
            int width = j-i;
            water = hght * width;
        }
        max = Math.max(max, water);
       }
       System.out.println(max);
    }

    //Optimized => 2 pointer Approach - O(n)
    public static void maxWaterContainer() {
       ArrayList<Integer> height = new ArrayList<>();

       height.add(1);
       height.add(8);
       height.add(6);
       height.add(2);
       height.add(5);
       height.add(4);
       height.add(8);
       height.add(3);
       height.add(7);

       int left = 0, right = height.size()-1;
       int max = 0;

       while(left < right) {
            int ht = Math.min(height.get(left), height.get(right));
            int width = right-left;
            int water = ht * width;
            max = Math.max(max, water);

            if(height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
       }
       System.out.println(max);
    }

    //brute force Approach
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Two pointer Approach
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size()-1;

        while(left < right) {
            if(list.get(left) + list.get(right) == target) {
                return true;
            } else if(list.get(left) + list.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void inputA() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;

        System.out.println(pairSum2(list, target));
    }

    public static boolean pairSumRotatedArray(ArrayList<Integer> list, int target) {
        int bp = -1; //breaking point
        int n = list.size();

        for(int i = 0; i < n; i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }

        int lp = bp+1; //left pointer - smallest
        int rp = bp; //right pointer - largest

        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            } else if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1) % n;
            } else {
                rp = (n+rp-1) % n;
            }
        }
        return false;
    }

    public static void inputB() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        System.out.println(pairSumRotatedArray(list, target));
    }

    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean inc = true, dec = true;

        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                inc = false;
            }
            if(list.get(i) < list.get(i+1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void inputC() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(isMonotonic(list));
    }

    public static void findLonely(ArrayList<Integer> list) {
        Collections.sort(list);
        int n = list.size();
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 1; i < n-1; i++) {
            if(list.get(i-1)+1 < list.get(i) && list.get(i)+1 < list.get(i+1)) {
                nums.add(list.get(i));
            }
        }

        //for size = 1
        if(list.size() == 1) {
            nums.add(list.get(0));
        }

        //for size > 1
        if(list.get(0)+1 < list.get(1)) {
            nums.add(list.get(0));
        }

        //for final element in list
        if(list.get(list.size()-2)+1 < list.get(list.size()-1)) {
            nums.add(list.get(list.size()-1));
        }

        System.out.println(nums);
    }

    
    public static void inputD() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);

        findLonely(list);
    }

    public static int mostFrequent(ArrayList<Integer> list, int key) {
        int result[] = new int[1000];

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == key) {
                result[list.get(i+1)-1]++;
            }
        }

        int ans = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 1000; i++) {
            if(result[i] > max) {
                max = result[i];
                ans = i+1;
            }
        }
        System.out.println(max);
        return ans;
    }

    
    public static void inputE() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);

        System.out.println(mostFrequent(list, 1));
    }

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i = 2; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(Integer el: ans) {
                if(2*el <= n) temp.add(el*2);
            }

            for(Integer el: ans) {
                if(2*el-1 <= n) temp.add(el*2-1);
            }

            ans = temp;
        }
        return ans;
    }

    public static ArrayList<Integer> beautifulArray2(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConque(1, 1, res, n);
        return res;
    }

    public static void divideConque(int start, int iterate, ArrayList<Integer> res, int n) {
        if(start+iterate > n) {
            res.add(start);
            return;
        }
        divideConque(start, 2*iterate, res, n);
        divideConque(start+iterate, 2*iterate, res, n);
    }
    public static void main(String[] args) {
       System.out.println(beautifulArray2(4));
    }
}
