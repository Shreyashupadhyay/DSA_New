package AssignemntQuestion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Arryas {

    public static void appeartwice(int arr[]){
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                System.out.println("True");
                break;
            }else {
                System.out.println("false");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr [] = { 1, 1, 3, 3, 4, 3, 2, 4, 2};
        appeartwice(arr);

    }
}
