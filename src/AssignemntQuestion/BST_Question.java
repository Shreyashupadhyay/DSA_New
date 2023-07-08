package AssignemntQuestion;

public class BST_Question {

   public static class Node {
        int data ;
        Node left ;
        Node right;

         Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

    }


    public static int Range_Q1(Node root ,int L , int R){
       int sum = 0;
       if(root == null){
           return -1;
       }

       if(root.data >= L && root.data <= R){
           Range_Q1(root.left, L , R);
           System.out.println(root.data+" ");
           sum = sum + root.data;
           System.out.println(sum);
           Range_Q1(root.right , L, R);
       }else if (root.data < L){
           Range_Q1(root.left, L, R);

       }else {
           Range_Q1(root.right, L,R);
       }
       return  sum;
    }


    public static void main(String[] args) {
       Node root = new Node(9);
       root.left = new Node(5);
       root.left.left = new Node(3);
       root.left.right = new Node(6);
       root.right = new Node(11);
       root.right.right = new Node(20);

       Range_Q1(root,3,20);



    }
}
