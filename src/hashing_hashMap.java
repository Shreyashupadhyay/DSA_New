import java.util.*;
public class hashing_hashMap {
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

    public static int countDistinctelement(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0;i<arr.length;i++){
            hs.add(arr[i]);
        }

        return hs.size();
    }

    public static void UnionANDIntersection(){
        int arr1 [] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> hs = new HashSet<>();

        // Union
        for (int i = 0; i <arr1.length ;i++){
            hs.add(arr1[i]);
        }

        for (int i = 0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }

        System.out.println(hs.size());

        hs.clear();
        // Intersection
        for (int i = 0; i <arr1.length ;i++){
            hs.add(arr1[i]);
        }

        int count = 0;
        for (int i = 0;i<arr2.length ;i++){
            if(hs.contains(arr2[i])){
                count++;
                hs.remove(arr2[i]);
            }
        }
        System.out.println(hs.size());



    }

    public static String getStart(HashMap<String , String> ticket){
        HashMap<String , String> revMap = new HashMap<>();
        for (String key : ticket.keySet()) {
            revMap.put(ticket.get(key),key);
        }
        for (String key : ticket.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void largestsubarraywith0sum( ){
        int [] arr = {15,-2,2,-8,1,7,10,23};
        HashMap <Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int j = 0;j<arr.length ;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len , j-map.get(sum));
            }else {
                map.put(sum ,j);
            }
        }
        System.out.println(len);
    }
    public static void subarraysumequaltoK(){
        int [] arr = {10, 2,-2,-20,10};
        int k = -10;

        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,1);
        int sum  = 0 ;
        int  ans = 0;
        for (int j = 0;j<arr.length ;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum , map.getOrDefault(sum , 0) +1);

        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

//        String s = "race";
//        String t = "care";
//        int[] arr = {4,3,2,5,6,7,3,4,2,1};
//
//       System.out.println(validAnagram(s,t));
//        System.out.println(countDistinctelement(arr));
//          UnionANDIntersection();

//        HashMap<String , String> ticket = new HashMap<>();
//        ticket.put("Chennai" , "Bengaluru");
//        ticket.put("Mumabai" , "Delhi");
//        ticket.put("Goa" , "Chennai");
//        ticket.put("Delhi" , "Goa");
//
////        https://youtube.com/shorts/9vKhET4Epk4?feature=share
////        https://youtube.com/shorts/iSICfAcFnsA?feature=share
//        String start = getStart(ticket);
//        System.out.print(start);
//        for (String key: ticket.keySet()) {
//            System.out.print("->"+ ticket.get(start));
//            start = ticket.get(start);
//
//        }
//        largestsubarraywith0sum();
        subarraysumequaltoK();

//        int[] arr = {1,3,2,5,1,1,1,1,1};
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int j : arr) {
//            if (map.containsKey(j)) {
//                map.put(j, map.get(j + 1));
//            } else {
//                map.put(j, 1);
//
//            }
//        }
//
//        Set<Integer> keySet = map.keySet();
//        for (Integer key: keySet) {
//            if(map.get(key) > arr.length){
//                System.out.println(key);
//            }
//
//        }
    }
}
