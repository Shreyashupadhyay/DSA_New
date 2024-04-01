package TCS;

public class String_Questions {

    public static void check_palindrame(){
        String str = "nitin";
        int left = 0;
        int right = str.length()-1;
        while (right>left){
            char l = str.charAt(left) , r = str.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }else if(!Character.isLetterOrDigit(r)){
                right--;
            }else if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                System.out.println("False");
                break;
            }else {
                right --;
                left ++;
            }

        }
    }
    public static void main(String[] args) {
        check_palindrame();

    }
}
