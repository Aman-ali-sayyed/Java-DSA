import java.util.Stack;
//Queue using 2 stacks  => Time complexity: add => O(1), remove => O(n), peek => O(n)
public class QueueE {
    static class Queue {
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();

       public static boolean isEmpty() {
            return s2.isEmpty() && s1.isEmpty();
       }

       public static void add(int data) { //O(1)
            s1.push(data);
       }

       public static int remove() { //O(n)
            if(s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
       }

       public static int peek() { //O(n)
            if(s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
       }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
