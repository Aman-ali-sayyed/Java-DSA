import java.util.*;
import java.util.LinkedList;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class QueueG {
    public static void firstNonRepeating(String str) {
        int freq[] = new int[26]; //'a' - 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void inputA() {
        String str = "aabccxb";
        firstNonRepeating(str);
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i = 0; i < size/2; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void inputB() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
    }

    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void inputC() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverseQueue(q);
        
        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
    }

    //Implement Stack using deque(double ended queue)
    static class Stacks {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void inputD() {
        Stacks s = new Stacks();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek = "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    //Implement Queue using deque(double ended queue)
    static class Queues {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public static void inputE() {
        Queues q = new Queues();
        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

    public static void generatebinary(int n) {
        Queue<String> q = new LinkedList<>();
        int num = n;
        q.add("1");
        while(n--> 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(num-n + " => "+ s1);
            String s2 = s1;
            q.add(s1 + "1");
            q.add(s2 + "0");
        }
    }

    public static void inputF() {
        int n = 5;
        generatebinary(n);
    }

    //connect n ropes with minimum cost
    public static int minCost(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int rope: ropes) {
            pq.add(rope);
        }

        int totalCost = 0;
        while(pq.size() > 1) {
            int rope1 = pq.poll();
            int rope2 = pq.poll();
            int cost = rope1 + rope2;
            totalCost += cost;
            pq.add(cost);
        }
        return totalCost;
    }

    public static void inputG() {
        int ropes[] = {4, 3, 2, 6};
        System.out.println(minCost(ropes));
    }


    //see Job class on the top
    public static void jobSequencing(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for(Job job: jobs) {
            if(job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        Queue<Character>[] slots = new LinkedList[maxDeadline+1];

        for(int i = 0; i <= maxDeadline; i++) {
            slots[i] = new LinkedList<>();
        }

        for(Job job: jobs) {
            for(int j = Math.min(maxDeadline, job.deadline); j > 0; j--) {
                if(slots[j].isEmpty()) {
                    slots[j].add(job.id);
                    break;
                }
            }
        }

        System.out.print("Scheduled Jobs: ");
        for(int i = 1; i <= maxDeadline; i++) {
            if(!slots[i].isEmpty()) {
                System.out.print(slots[i].peek() + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 4, 20),
            new Job('b', 1, 10),
            new Job('c', 1, 40),
            new Job('d', 1, 30)
        };

        jobSequencing(jobs);
    }
}
