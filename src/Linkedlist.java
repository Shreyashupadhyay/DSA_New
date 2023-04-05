public class Linkedlist {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
            this.next = null;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(tail == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode = null;

    }
    public void addMiddle(int idx , int data){
        if (idx ==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next= newNode;
    }
    public static void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");

            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Size : "+ size);


    }

    public int removeFirst(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail= null;
            size = 0;
            return val;
        }
        int val = head.data;
        head= head.next;
        size--;
        return val;

    }
    public int removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next=null;
        size--;
        return val;
        
    }
    public int seach(int key){
        Node temp = head;
        int c = 0;
        while (temp!=null){
            if(key == temp.data){
                System.out.println(c);

            }
            temp = temp.next;
            c++;

        }
        return -1;
    }
    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx= helper(head.next , key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int seeachrecursiv(int key){
        return helper(head,key);

    }


    public void reverse(){
        Node prev = null;
        Node curr = tail= head;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deletenthnodefromend(int n ){
        // calculate size
        int size = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            head = head.next;
            return;

        }
        int i = 1;
        int idxfromend = size-n;
        Node prev = head;
        while( i < idxfromend){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    public boolean checkforpalindron(){
        if(head == null || head.next== null){
            return true;
        }
        Node midNode = getMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        while (right!=null){
            if (left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                cycle = true;
                break;
            }
            if (cycle == false){
                return;
            }
        }
        // find meeting ponit

        slow =head;
        Node prev = null;
        while (slow!= fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // last to null

        prev.next = null;
    }

    public static Node getMidformergesort(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
    public static Node merge(Node head1 , Node head2){
        Node mergell = new Node(-1);
        Node temp = mergell;
        while (head1!= null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            }else {
                temp.next= head2;
                head2 = head2.next;
                temp= temp.next;
            }
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next= head2;
            head2 = head2.next;
            temp= temp.next;
        }
        return mergell.next;
    }
    public static Node mergsort(Node head){
        if (head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMidformergesort(head);
        // left and right merge sort
        Node rightHand = mid.next;
        mid.next = null;
        Node newLeft = mergsort(head);
        Node newRight = mergsort(rightHand);

        // merge
         return merge( newLeft, newRight);
    }

    public void zigZag(){
        // find mid
        Node mid = getMidformergesort(head);

        // 2nd half reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alter merge

        while ( left!= null&& right!= null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

        // alternate merge
    }






    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
//        linkedlist.addFirst(1);
//        linkedlist.addFirst(2);
//        linkedlist.addFirst(22);
//        linkedlist.addFirst(33);
//        linkedlist.addFirst(44);
//        linkedlist.addMiddle(2,20);
////        linkedlist.removeFirst();
//        linkedlist.seach(22);
//        System.out.println(linkedlist.seeachrecursiv(1));
//        print();
//        linkedlist.reverse();
//        print();
//        linkedlist.deletenthnodefromend(3);
//        print();
//
//        head = new Node(1);
////        Node temp = new Node(2);
////        head.next = temp;
//        head.next= new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = head;
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());
//        linkedlist.addLast(1);
//        linkedlist.addLast(2);
//        linkedlist.addFirst(3);
//        linkedlist.addFirst(4);
//        linkedlist.addFirst(5);
//        print();
//        linkedlist.head = linkedlist.mergsort(head);
//        print();
//        System.out.println("Zig Zag");
//        linkedlist.zigZag();
//        print();




    }
}

