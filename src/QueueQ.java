import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueQ {
//    static class Queue{
//        static Stack<Integer> s1 = new Stack<>();
//        static Stack<Integer> s2 = new Stack<>();
//        public static boolean isEmpty(){
//            return s1.isEmpty();
//        }
//        public static void add(int data){
//            while (!s1.isEmpty()){
//                s2.push(s1.pop());
//            }
//            s1.push(data);
//            while (!s2.isEmpty()){
//                s1.push(s2.pop());
//            }
//        }
//        public static int remove(){
//            if(s1.isEmpty()){
//                System.out.println("empty");
//                return -1;
//            }
//            return s1.pop();
//        }
//        public static int peek(){
//            if(s1.isEmpty()){
//                System.out.println("empty");
//                return -1;
//            }
//            return s1.peek();
//        }

//}
    public static void printNonRepreating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1+"");
            }else {
                System.out.println(q.peek()+"");
            }
        }
        System.out.println();
    }

    public static void interleafe(Queue<Integer> mainq){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = mainq.size();
        for (int i = 0;i<size/2;i++){
            firstHalf.add(mainq.remove());
        }
        while (!firstHalf.isEmpty()){
            mainq.add(firstHalf.remove());
            mainq.add(mainq.remove());
        }


    }
    public static void reverse(Queue<Integer> mainq){
        Stack<Integer> s = new Stack<>();
        while (!mainq.isEmpty()){
            s.push(mainq.remove());
        }
        while (!s.isEmpty()){
            mainq.add(s.pop());
        }
    }

    public static void main(String[] args) {
//        String str = "aabccxb";
//        printNonRepreating(str);
        Queue<Integer> mainq = new LinkedList<>();
        mainq.add(1);
        mainq.add(2);
        mainq.add(3);
        mainq.add(4);
        mainq.add(5);
        mainq.add(6);
        mainq.add(7);
        mainq.add(8);
        mainq.add(9);
        mainq.add(10);
//        interleafe(mainq);
        reverse(mainq);
        while (!mainq.isEmpty()){
            System.out.print(mainq.remove()+" ");

        }


    }
}
