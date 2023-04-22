import java.util.*;
public class greedy {
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
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,6};
        int end[] = {2,4,6,7,9,9};
        activityselectionNonsorted(start,end);

//        int maxAct = 0;
//        ArrayList<Integer> ans = new ArrayList<>();
//        maxAct = 1;
//        ans.add(0);
//        int lasrEnd = end[0];
//        for (int i = 0;i<end.length;i++){
//            if(start[i]>=lasrEnd){
//                maxAct++;
//                ans.add(i);
//                lasrEnd=end[i];
//            }
//        }
//        System.out.println("Max Activity ="+maxAct);
//        for (int i =0;i<ans.size();i++){
//            System.out.println("A" +ans.get(i)+"");
//        }
//        System.out.println();

    }
}
