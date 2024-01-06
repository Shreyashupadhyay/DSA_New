package TCS;

public class tcs {

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
        onlykeepalphbet();


    }
}
