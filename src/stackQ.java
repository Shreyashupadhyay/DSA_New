import java.util.*;
public class stackQ {

    public static boolean duplicateparenthesis(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while (s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();

                }
            }else {
                s.push(ch);
            }
        }
        return false;

    }

    public static boolean validParenthesi(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0 ;i<str.length();i++){
            char ch = str.charAt(i);
            //
            if(ch =='(' || ch =='{' || ch =='['){
                s.push(ch);

            }else {
                // closing
                if(s.isEmpty()){
                    return false;
                }if((s.peek() == '(' && ch ==')') ||(s.peek() == '{' && ch =='}') || (s.peek() == '[' && ch ==']')){
                    s.pop();

                }else{
                    return false;
                }

            }

        }
        if(s.isEmpty()){
            return true;
        }else {
            return false;
        }


    }

    public static void getNextGreater(int arr[]){
        // Broute force approach
//        int arrj [] = new int[arr.length];
//        for(int i = 0;i<arr.length;i++){
//            for (int j=i+1;j<arr.length;j++){
//                if(arr[i] <arr[j]){
//                    arrj[i] = arr[j];
//                    break;
//                }else {
//                    arrj[i] = -1;
//                }
//            }
//        }
//        arrj[arrj.length-1] = -1;
//        for (int i = 0;i<arrj.length;i++){
//            System.out.println(arrj[i]+"");
//        }
        Stack<Integer> s  = new Stack<>();
        int [] nextGreater = new int[arr.length];


        for(int i = arr.length-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();

            }

            if(s.empty()){
                nextGreater[i] = -1;
            }else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);



        }
        for (int i = 0;i<nextGreater.length;i++){
            System.out.println(nextGreater[i]+"");
        }
        System.out.println();

    }



    private static void stockspan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i<stock.length;i++){
            int cureprice = stock[i];
        while (!s.isEmpty() && cureprice >stock[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            span[i] = i+1;
        }else {
            int prevHight = s.peek();
            span[i] = i-prevHight;
        }
        s.push(i);

        }
    }
    public static void main(String[] args) {
//        int stock[] = {100, 80,60,70,60,85,100};
//        int span[] = new int[stock.length];
//        stockspan(stock,span);
//        for (int i = 0; i<span.length;i++){
//            System.out.println(span[i]+"");
//        }


        int arr[] = {1,2,3,4,3};

        getNextGreater(arr);

//        String str = "({})[]";
//        String str = "((a+b))";
//
//        System.out.println(duplicateparenthesis(str));
    }


}
