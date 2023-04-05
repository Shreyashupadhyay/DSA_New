
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.min;


public class Arraylist {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        multidime();
//        System.out.println("2 pointer aproach"+ containwater2pointer());
//        System.out.println(containwaterBruteforce());
//        System.out.println(pairSum());

//        findMax(list);
//        reverseList(list);


    }

//    public static boolean pairSum() {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        int target = 5;
////        for(int i = 0;i<list.size();i++){
////            for(int j = i+1;j<list.size();j++){
////                if(list.get(i)+ list.get(j)==target){
////                    return true;
////                }
////            }
////        }
////        return false;
//        int lp = 0;
//        int rp = list.size() - 1;
//
//
//    }


//    public static void multidime(){
//        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        ArrayList<Integer> list3 = new ArrayList<>();
//
//        for(int i = 1 ;i<5;i++){
//            list1.add(i*1);
//            list2.add(i*2);
//            list3.add(i*3);
//        }
//        mainlist.add(list1);
//        mainlist.add(list2);
//        mainlist.add(list3);
//        for (int i = 0;i<mainlist.size();i++){
//            ArrayList<Integer> currlist = mainlist.get(i);
//            for (int j = 0;j<currlist.size();j++){
//                System.out.print(currlist.get(j)+"");
//            }
//            System.out.println();
//        }
//        System.out.println(mainlist);
//
//
//    }
//    public static int containwaterBruteforce(){
//        int maxwater = Integer.MIN_VALUE;
//        ArrayList<Integer> height = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(3);
//        height.add(7);
//        for(int i = 0;i<height.size();i++){
//            for(int j= i+1;j<height.size();j++){
//                int heights = Math.min(height.get(i),height.get(j));
//                int weidth = j-i;
//                int water = weidth*heights;
//                maxwater = Math.max(maxwater,water);
//            }
//        }
//        return maxwater;
//    }
//
//    public static int containwater2pointer(){
//
//        ArrayList<Integer> height = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(3);
//        height.add(7);
//        int maxwater = 0;
//        int lp = 0;
//        int rp = height.size()-1;
//        while (lp<rp){
//            int ht = Math.min(height.get(lp),height.get(rp));
//            int width = rp-lp;
//            int currwater = ht*width;
//            maxwater = Math.max(maxwater,currwater);
//            if(height.get(lp)<height.get(rp)){
//                lp++;
//            }else{
//                rp--;
//            }
//
//        }
//        return maxwater;
//
//    }


    //    private static void findMax(ArrayList<Integer> list) {
//        int Max = Integer.MIN_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) > Max) {
//                Max = list.get(i);
//            }
//            // or
//            Max = Math.max(Max, list.get(i));
//        }
//
//
//        System.out.println(Max);
//
//    }

//    private static void reverseList(ArrayList<Integer> list) {
//        for (int i = list.size() - 1; i >= 0; i--) {
//            System.out.print(list.get(i));
////        }
//        }
//    }



}