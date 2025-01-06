import java.util.PriorityQueue;

public class HeapC {
    //HEAP SORT
    public static void heapify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]) {
        //step 1 - build maxHeap
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //step 2 - push largest at end
        for(int i = n-1; i >= 0; i--) {
            //swap (largest first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    // K-NEAREST CAR
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void kNearestCar() {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        //nearest k cars
        for(int i = 0; i < k; i++) {
            System.out.print("C"+ pq.remove().idx+" ");
        }
    }

    //CONNECT ROPES
    public static void connectNRopes() {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }

        System.out.println("cost of connecting n ropes = " + cost);
    }

    // FIND WEAKEST SOLDIER ROW
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void findWeakestSoldiersRow() {
        int army[][] = {{1, 0, 0, 0}, 
                        {1, 1, 1, 1}, 
                        {1, 0, 0, 0}, 
                        {1, 0, 0, 0}};

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0; i < army.length; i++) {
            int count = 0;
            for(int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for(int i = 0; i < k; i++) {
            System.out.println("R"+ pq.remove().idx);
        }
    }

    // SLIDING WINDOW MAXIMUM
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p2) {
            //ascending order
            //return this.val - p2.val;
            //descending order
            return p2.val - this.val;
        }
    }

    public static void slidingWindowMax() {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7}; // output:- 3 3 5 5 6 7
        int k = 3; //window size
        int res[] = new int[arr.length-k+1]; //n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val; //add largest value in the window

        for(int i = k; i < arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove(); //removing the first element because it has already used
            }

            pq.add(new Pair(arr[i], i)); //add new largest val from the window
            res[i-k+1] = pq.peek().val; //add in result array
        }

        //print result
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 6, 8, 1, 8};
        heapSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
