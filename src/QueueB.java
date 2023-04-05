import java.util.Stack;

public class QueueB {



    static class Queue{
        static int arr[];
        static int size;

        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear ==-1;

        }
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Empty");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            int front = arr[0];
            for (int i =0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear --;
            return front;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            return arr[0];
        }

    }
    static class QueueC{
        static int arr[];
        static int size;

        static int rear;
        static int front;

        QueueC(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty(){
            return front ==-1 && rear == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Empty full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] =data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int result = arr[front];

            if(rear == front){
                rear = front = -1;
            }else {
                front = (front +1)%size;

            }
            return result;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty");
                return -1;
            }
            return arr[front];
        }
    }


    public static void main(String[] args) {
//        Queue q = new Queue(5);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//
//        }
//        QueueC qc = new QueueC(3);
//
//        qc.add(1);
//        qc.add(2);
//        qc.add(3);
//
//        while (!qc.isEmpty()){
//            System.out.println(qc.peek());
//            qc.remove();
//        }



        

    }
}
