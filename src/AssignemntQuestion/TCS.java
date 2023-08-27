package AssignemntQuestion;

import java.util.Scanner;

public class TCS {
    public static void crossbike(){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i =0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 0 ;i<arr.length;i++){
            for (int j = i+1 ;j<arr.length;j++){
                if(arr[i] != arr[j] && i<j){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void party(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] l = new int[t]; // member enter
        int [] e = new int[t]; // member leaving
        for (int i =0;i<l.length;i++){
            l[i] = sc.nextInt();
        }
        for (int i= 0;i<e.length;i++){
            e[i] = sc.nextInt();
        }
        int sum = 0;
        int max = sum;
        for(int i = 0;i<l.length;i++){
            sum = sum+l[i]-e[i];
            if(max <sum){
                max= sum;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
//        party();
        crossbike();

    }
}
