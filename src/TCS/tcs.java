package TCS;

import java.util.Arrays;
import java.util.HashMap;

public class tcs {

    public static void  sort_according_to_rank(){
        int arr[] = {20,15,26,2,98,6};
        int temp = 1;
        HashMap<Integer , Integer> hm = new HashMap<>();
        int dummpy[] = new int[arr.length];
        for(int i = 0;i< dummpy.length;i++){
            dummpy[i] = arr[i];
        }
        Arrays.sort(dummpy);
        for (int i = 0;i<dummpy.length;i++){
            if(hm.get(dummpy[i]) == null){
                hm.put(dummpy[i], temp);
                temp++;
            }
        }
        for (int i = 0;i<dummpy.length;i++){
            System.out.print(hm.get(arr[i]) + " ");
        }
    }

    public static void equilibrium_index(){
        int arr[] = {2,3,-1,8,4};
        int total_sum = 0;
        for(int i = 0;i<arr.length;i++){
            total_sum += arr[i];
        }
        int left_sum = 0, rright_sum = total_sum;
        for (int i = 0;i<arr.length;i++){
            rright_sum -= arr[i];
            if (left_sum == rright_sum){
                System.out.println(i);
            }
            left_sum += arr[i];
        }
    }

    public static void binarySeach(){
        int arr1[] = {2,4,3,1,7,5,15};
        int key = 5;
        int start = 0;
        int end = arr1.length-1;
        int mid = (start+end)/2;
        while(start <= end){

            if(arr1[mid] < key){
                start = mid +1;
            }else if (arr1[mid] == key){
                System.out.println("found");
                break;
            }else{
                end = mid-1;
            }
            mid = (start+end)/2;

        }
    }

    public static void check_arr_is_subset_of_array(){
        int arr1[] = {1,3,4,5,2};
        int arr2[] = {2,4,3,1,7,5,15};


        for(int i = 0;i< arr1.length;i++){
            boolean ch = false;
            for(int j = 0;j< arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    ch = true;
                }

            }
            if(ch == false){
                System.out.println("not subset");
            }


        }

    }

    public static void reverseString(){

    }

    public static void onlykeepalphbet(){
        String str = "take12% *&u ^$#forward";
        int n = str.length();
        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int ascii = (int) str.charAt(i); //ascii value

            if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) // if alphabets
                ans.append(str.charAt(i));
        }

        System.out.println(ans);
    }

    public static void removeSpaces(){
        String str = "Shreyash Upadhyay";
        String str1 = "";
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == ' ' ){
                continue;
            }
            str1 = str1 + str.charAt(i);

        }
        System.out.println(str1);

    }

    public static void removeVowel(){
        String str = "Shreyash Upadhyay";
        String str1 = "";
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'o' || str.charAt(i) == 'u' ){
                continue;
            }
            str1 = str1 + str.charAt(i);

        }
        System.out.println(str1);
    }
    public static void ASCII(char ch){
        int n = ch;
        System.out.println(n);
    }
    public static void countnoofVowelconsonentandspace(String str){
        int v = 0 , c = 0, space = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'o' || str.charAt(i) == 'u' ){
                v++;
            } else if (str.charAt(i) == ' ') {
                space++;
            }else{
                c++;
            }
        }
        System.out.println("No. of Vowel :"+v);
        System.out.println("No. of consonent :"+c);
        System.out.println("No. of Space :"+space);
    }
    public static boolean ispalindrne(String str){
        str = str.toLowerCase();
        int left = 0, right = str.length()-1;
        while (left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
//        String rev ="";
//        for(int i = str.length()-1;i>=0 ;i--){
//            rev = rev+str.charAt(i);
//        }
//        if(str.equals(rev)){
//            return true;
//        }
//        return false;

    }


    public static void main(String[] args) {
//        String str = "ABCDCBA";
//        System.out.println(ispalindrne(str));
//        String str = "Shreyash Upadhyay";
//        countnoofVowelconsonentandspace(str);
//        ASCII('A');
//        removeVowel();
//        removeSpaces();
//        onlykeepalphbet();
//        check_arr_is_subset_of_array();
//        binarySeach();
//        equilibrium_index();
          sort_according_to_rank();


    }
}
