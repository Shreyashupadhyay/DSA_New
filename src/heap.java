import java.util.*;
public class heap {
    public class Heap{
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
    }
    public void main(String[] args) {
        Heap pq =new Heap();


    }
}
