import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
public class greedy {

    public static  void min_absolute_differnce_pair(){
        int a[] = {4,1,8,7};
        int b[] = {2,3,6,5};

        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for(int i = 0;i<a.length;i++){
            sum = sum + Math.abs(a[i] - b[i]);
        }

        System.out.println(sum);
    }

    public static void fractional_Knapsak(){
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50;
        double [][] ratio = new double[value.length][2];

        for(int i = 0 ;i<value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];

        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        double val = 0;

        for (int i = ratio.length-1;i>=0 ;i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                capacity = capacity - weight[idx];
                val = val + value[idx];
            }else{
                val = val + (ratio[i][1] * capacity);
//                capacity = 0;  // un comment this line if somme test case failes;
                break;

            }
        }

        System.out.println(val);



    }

    public static void activity_selection_when_array_issorted(int start[] , int end[]){
        ArrayList<Integer> ans = new ArrayList<>(); // take index of activty

        // 1st activity
        int maxactivity = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i = 0 ;i< end.length;i++){
            if(start[i] >= lastEnd){
                maxactivity++;
                ans.add(i);
                lastEnd = end[i];
            }


        }

        System.out.println("total Activity = "+maxactivity);
        for (int i = 0;i<ans.size();i++){
            System.out.println("A"+ans.get(i));
        }


    }
    public static void activityselectionNonsorted(int [] start, int [] end) {

        int activity[][] = new int[start.length][3];
        for (int i = 0;i<start.length;i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));
        int max= 1;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(activity[0][0]);
        int last = activity[0][2];
        for (int i = 0;i<end.length;i++){
            if (activity[i][1]>=last){
                max++;
                a.add(activity[i][0]);
                last= activity[i][2];

            }
        }
        System.out.println("Max Activity ="+max);
        for (int i =0;i<a.size();i++){
            System.out.println("A" +a.get(i)+"");
        }
        System.out.println();

    }

    public static boolean validAnagram(String s , String t){
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i = 0;i<s.length() ;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch , 0)+1);
        }

        for (int i = 0;i<t.length() ;i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) -1);
                }
            }else {
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,6};
        int end[] = {2,4,6,7,9,9};
//        activityselectionNonsorted(start,end);
//        activity_selection_when_array_issorted(start ,end);
//        fractional_Knapsak();
        min_absolute_differnce_pair();




    }
}
