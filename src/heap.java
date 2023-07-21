import java.util.*;
public class heap {
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            // add at last
            arr.add(data);
            int x = arr.size()-1;// child
            int par = (x-1)/2;// parent

            while (arr.get(x)<arr.get(par)){
                // swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x= par;
                par = (x-1)/2;
            }


        }
        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i ){
            int left = 2*i +1;
            int right = 2*i +2;
            int minidx = i;

            if(left<arr.size() && arr.get(minidx) >arr.get(left)){
                minidx = left;
            }
            if(right<arr.size() && arr.get(minidx) > arr.get(right)){
                minidx = right;

            }
            if(minidx!= i){
                // swap

                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);
                heapify(i);

            }
        }
        public int delete(){
            int data = arr.get(0);

            // swap from last to root
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size(), temp);

            // remove
            arr.remove(arr.size()-1);
            //heapify to fix disturbance in heap after removal
            heapify(0);
            return data;

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        public void heapify(int arr[] , int i , int size){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxidx = i;

            if(left <size && arr[left] >arr[maxidx] ){
                maxidx = left;

            }

            if(right <size && arr[right] >arr[maxidx]){
                maxidx= right;
            }

            if(maxidx != i){
                int temp = arr[i];
                arr[i] = arr[maxidx];
                arr[maxidx] = temp;

                heapify(arr , maxidx , size);
            }
        }

        public void heapSort(int arr[]){
            // build max heap
            int n = arr.length;
            for (int i = n/2 ;i>= 0;i--){
                heapify(arr ,i, n);
            }

            for (int i = n-1; i>=0;i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr,0,i);
            }
        }


    }

    public static void connectNropes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i< ropes.length;i++){
            pq.add(ropes[i]);

        }
        int cost = 0;
        while (pq.size()>1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min+min2;
            pq.add(min+min2);

        }

        System.out.println("Cost is :" + cost);
    }

    static class Row implements Comparable<Row>{
        int Soldier ;
        int idx;

        public Row(int soldier , int idx){
            this.Soldier= soldier;
            this.idx= idx;
        }



        @Override
        public int compareTo(Row r2) {
            if (this.Soldier == r2.Soldier){
                return this.idx - r2.idx;
            }else {
                return this.Soldier -r2.Soldier;
            }
        }
    }
    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val = val;
            this.idx= idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val; // Descending value
        }
    }

    public static void main(String[] args) {
//        Heap pq =new Heap();

//        int arr[] = {2,1,4,8,5,2};
//        int ropes[] = {2,3,3,4,6};
//
//        int army[][] = {{1,0,0,0},
//                        {1,1,1,1},
//                        {1,0,0,0},
//                        {1,0,0,0}};
//
//        int k = 2;
//        pq.heapSort(arr);
//
//        for (int i = 0;i<arr.length ; i++){
//            System.out.println(arr[i]);
//        }

//        connectNropes(ropes);
//        PriorityQueue<Row> pq = new PriorityQueue<>();
//        for (int i = 0;i< army.length;i++){
//            int count = 0;
//            for(int j = 0;j<army[0].length;j++){
//                count += army[i][j] == 1? 1 :0;
//            }
//            pq.add(new Row(count,i));
//        }
//
//        for (int i= 0;i<k; i++){
//            System.out.println("R"+pq.remove().idx);
//        }

        int arr [] = {1,3,-1,-3,5,3,6,7};
        int k =3; // window size
        int result[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0;i<k ;i++){
            pq.add(new Pair(arr[i] , i));
        }
        result[0] = pq.peek().val;

        for (int i = k;i<arr.length;i++){
            while (pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i] , i));
            result[i-k+1] = pq.peek().val;
        }

        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }




    }
}
