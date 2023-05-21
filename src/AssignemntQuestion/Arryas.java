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

    public static int buyandseestock(int prices[]){
        int max_profit = 0;
        int buy_price = Integer.MAX_VALUE;
        for(int i =0;i<prices.length;i++){
            if(buy_price < prices[i]){
                int profit = prices[i] - buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price = prices[i];
            }
        }
        return max_profit;
    }

    public static int trapiingrainwater(int height[]){

        int n = height.length;
        // cal left max boundar - array
        int left_max[] = new int[n];
        left_max[0] = height[0];
        for (int i = 1;i<n;i++){
            left_max[i] = Math.max(height[i],left_max[i-1]);
        }

        // cal right max
        int right_max[] = new int[n];
        right_max[n-1] = height[n-1];
        for (int i = n-2;i>=0;i--){
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }

        int trapped_water =0;
        for (int i = 0;i<n;i++){
            int waterlever = Math.min(left_max[i],right_max[i]);
            trapped_water += waterlever-height[i];
        }
        return trapped_water;
    }




    public static void main(String[] args) {
        int arr [] = { 1, 1, 3, 3, 4, 3, 2, 4, 2};

        int prices [] = { 7, 1, 5, 3, 6,  4};
        int height [] = {4,2,0,6,3,2,5};
//        appeartwice(arr);
//        System.out.println(buyandseestock(prices));
        System.out.println(trapiingrainwater(height));

    }
}
