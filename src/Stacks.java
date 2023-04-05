import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Stack;

public class Stacks {
    static class stackarraylist{
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size()==0;
        }
        // push

        public static void push(int data){
            list.add(data);
        }

        //pop
        public static int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek
        public static int peek(){
            return list.get(list.size()-1);
        }
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class stacklinkedlist{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
        }



    }
    public static void pushAtButtom(Stack<Integer> s , int data){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtButtom(s, data);
        s.push(top);
    }
    public static String  reverseString(String str ){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx>str.length()){
            s.push(str.charAt(idx));
            idx++;

        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();

    }




    public static void main(String[] args) {
//        stackarraylist s = new stackarraylist();
//        stacklinkedlist s = new stacklinkedlist();
        String str = "abc";
        String re = reverseString(str);
        System.out.println(re);
//        Stack<Integer> s = new Stack<>();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        pushAtButtom(s , 4);
//
//        while(!s.isEmpty()){
//            System.out.println(s.peek());
//            s.pop();
        }
    }


