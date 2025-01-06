public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Methods
    public void addFirst(int data) {
        //Step 1: Create new Node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        //Step 2: newNode points next = head
        newNode.next = head; //link

        //Step 3: head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if(head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void inputA() {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

        ll.print();
    }

    public void add(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        //i = index-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void inputB() {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 9);

        ll.print();
        //System.out.println("size of a linked list: " + ll.size);
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("Linked List is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("Linked List is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0; i < size-2; i++) {
            prev = prev.next;

        }

        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static void inputC() {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(4);
        ll.add(2, 3);

        ll.print();

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();

        //System.out.println(ll.size);
        
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }

    public int recurSearch(int key) {
        return helper(head, key);
    }

    public static void inputD() {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(4);
        ll.add(2, 3);

        ll.print();

        System.out.println(ll.itrSearch(3));
        System.out.println(ll.recurSearch(10));
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;

        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next; //removeFirst
            return;
        }

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;

        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public static void inputE() {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(4);
        ll.add(2, 3);

        ll.print();
        // ll.reverse();

        ll.deleteNthFromEnd(3);
        ll.print();
        
    }

    //Slow-fast Approach
    public Node findMid(Node head) { //helper
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //it is mid
    }

    public boolean checkPalindrome() {
        if(head == null && head.next != null) {
            return true;
        }

        //Step1 - find middle
        Node midNode = findMid(head);

        //Step2 - reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //right half head
        Node left = head; // left half head

        //step3 - check 1st half and 2nd half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void inputF() {
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();
        System.out.println(ll.checkPalindrome());
        
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2

            if(slow == fast) {
                return true; //cycle exist
            }
        }
        return false; //cycle doesn't exist
    }

    public static void inputG() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        //1->2->3->1
        System.out.println(isCycle());
    }

    public static void removeCycle() {
        //step1: detect cycle
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        //step2: find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //step3: Make last next node null
        prev.next = null;
    }

    public static void inputH() {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        //1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; //mid
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        //base case
        if(head == null || head.next == null) {
            return head;
        }
         //find mid
        Node mid = getMid(head);

        //left & right merge Sort
        Node rightHead = mid.next;
        mid.next = null;
        Node head1 = mergeSort(head);
        Node head2 = mergeSort(rightHead);

        //merge
        return merge(head1, head2);
    }

    public static void inputI() {
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alternate merge -> zig-zag
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void inputJ() {
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();

        ll.zigZag();
        ll.print();
    }
    public static void main(String[] args) {
        inputJ();
    }
}
