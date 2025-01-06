import java.util.*;

public class HashMapA {
    public static void hashMap() {
        HashMap<String, Integer> hm = new HashMap<>();
        
        //Add in map O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 8);
        hm.put("Nepal", 6);

        System.out.println(hm);

        //for update the key value
        hm.put("India", 130);
        System.out.println(hm);

        //get value O(1)
        System.out.println(hm.get("India")); //100
        System.out.println(hm.get("Indonesia")); //mull

        //check exist or not O(1)
        System.out.println(hm.containsKey("US")); //true
        System.out.println(hm.containsKey("Indonesia")); //false

        //remove O(1)
        System.out.println(hm.remove("China")); //150
        System.out.println(hm.remove("Indonesia")); //null
        System.out.println(hm); //remove element map

        //Iteration on HashMap
        Set<String> keys = hm.keySet();

        System.out.println(keys);

        for(String k : keys) {
            System.out.println("key = " + k + ", value = " + hm.get(k));
        }
    }

    public static void linkedHashMap() {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Indonesia", 8);
        lhm.put("Nepal", 6);

        System.out.println(lhm);
    }

    public static void treeMap() {
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 8);
        tm.put("Nepal", 6);

        System.out.println(tm);
    }

    public static void allSets() {
        HashSet<Integer> set = new HashSet<>();

        set.add(2);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(1);

        Iterator<Integer> it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        HashSet<String> hs = new HashSet<>();

        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Noida");
        hs.add("Bengaluru");

        System.out.println(hs);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();

        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");

        System.out.println(ts);
    }
    public static void main(String[] args) {

    }
}
