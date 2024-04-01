package TCS;

public class questions {

    public static void areaofCircle(float r){
        float area = (float) (3.14*r*r);
        System.out.println(area);

    }
    public static void factorial(int n){
        int ans = 1;
        while(n>0){
            ans = n * ans;
            n--;
        }
        System.out.println(ans);
    }
    public static boolean isprime(int i){
        if(i == 1){
            return false;
        }
        int flag = 1;
        for(int n = 2;n<=Math.sqrt(n);n++){
            if(i%n == 0){
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            return true;
        }
        return false;

    }

    public static void primeininterval(int a , int b){
        for(int i = a ;i<=b;i++){
            if(isprime(i)){
                System.out.println(i+" ");
            }
        }

    }
    public static void main(String[] args) {
//        factorial(5);
//        areaofCircle(3);
        primeininterval(1, 10);

    }
}
