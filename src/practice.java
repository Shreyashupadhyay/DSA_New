public class practice {

    public static void bubble(){
        int arr[] = {3,8,5,6,2,5,6};
        for(int i = 0 ;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
    public static void buy_and_sell_stock(){
        int price[] = {7,1,5,3,6,4};
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0;i<price.length;i++){
            if(buyprice<price[i]){
                int profit = price[i] -buyprice;
                maxprofit = Math.max(maxprofit, profit);
            }else {
                buyprice = price[i];
            }
        }

        System.out.println(maxprofit);
    }
    public static void subarray_kadence_Algo(int arr[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0;i<arr.length;i++){
            cs = cs + arr[i];
            if(cs<0){
                cs = 0;
            }
            ms = Math.max(cs , ms);
        }
        System.out.println(ms);
    }
    public static void subarray_MAXSUM(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i< arr.length;i++){
            for(int j = i ;j<arr.length;j++){
                int sum = 0;
                for(int k = i ;k<=j;k++){
                    sum = sum + arr[k];
                }
                if(max < sum){
                    max = sum;
                }

            }

        }
        System.out.println(max);
    }
    public static void subarray(int arr[]){
        for(int i = 0;i< arr.length;i++){
            for(int j = i ;j<arr.length;j++){

                for(int k = i ;k<=j;k++){

                    System.out.print(arr[k]+",");

                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void pair_of_array(int arr[]){
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                System.out.print("[" + arr[i] +"," + arr[j] +"]");
            }
        }
    }
    public static void reverse_A_Array(int arr[]){
        int first = 0;
        int last = arr.length-1;
        while (first<last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first ++ ;
            last --;
        }
        for (int i = 0 ;i<arr.length ;i++){
            System.out.print(arr[i] +" ");
        }

    }
    public static void binarySearch(){
        int arr[] = {1 ,4 ,5 , 6 , 9 , 99 ,100};
        int key = 1000;
        int start = 0;
        int last = arr.length-1;
        int mid = (start+last)/2;

        while (start<=last){
            if(key < arr[mid]) {
                    last = mid -1;
            }else if(key == arr[mid]){
                System.out.println("Found");
                break;
            }else {
                start = mid + 1;
            }
            mid = (start+last)/2;
        }
    }
    public static void isprime(){
        int n = 7;
        boolean is = true;
        for (int i = 2 ;i<n;i++){
            if(n%i == 0){
                is = false;
            }
        }
        if (is == true){
            System.out.println("Yes prime");
        }else {
            System.out.println("not prime");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1 ,4 ,5 , 6 , 9 , 99 ,100};
//        isprime();
//        binarySearch();
//        reverse_A_Array(arr);
//        pair_of_array(arr);
//        subarray(arr);
//        subarray_MAXSUM(arr);
//        subarray_kadence_Algo(arr);
//        buy_and_sell_stock();
        bubble();

    }
}
