package AssignemntQuestion;

public class sorting {

    public static void insertionsort_decending(int arr[]){
        for (int i = 0;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev] < curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            //intersition
            arr[prev+1] = curr;
        }

        for(int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void selectionsort_decending(int height[]){
        for (int i = 0 ;i<height.length-1;i++){
            int minPOS = i;
            for (int j = i+1;j<height.length;j++){
                if(height[minPOS]< height[j]){
                    minPOS =j;
                }
            }
            int temp = height[minPOS];
            height[minPOS] = height[i];
            height[i] = temp;
        }

        for(int i = 0 ;i<height.length;i++){
            System.out.println(height[i]);
        }
    }

    public static void bubbleSort_descending(int arr[]){
        for (int i = 0;i< arr.length;i++){
            for (int j = 0;j< arr.length-1-i;j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,2,4,6,2,7};
        insertionsort_decending(arr);

    }
}
