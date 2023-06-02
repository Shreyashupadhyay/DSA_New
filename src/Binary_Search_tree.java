import java.io.FilterOutputStream;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;

public class Binary_Search_tree {
    static class Node{
        int data;
        Node left ;
        Node right;

        Node(int data){
            this.data = data;
        }

    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if (root.data> val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static boolean search(Node root , int val){
        if(root == null){
            return false;

        }
        if(root.data == val){
            return true;
        }
        if(root.data>val){
            return search(root.left,val);
        }else {
            return search(root.right,val);
        }

    }

    public static Node Delete(Node root ,int val){
        if(root.data > val){
            root.left=  Delete(root.left, val);
        }else if(root.data <val){
            root.left =  Delete(root.right ,val);
        }else {
            if(root.right == null && root.left == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
             Node IS = findInderSuccesor(root.right);
            root.data = IS.data;
            root.right = Delete(root.right , IS.data);

        }
        return root;
    }

    // helper function
    public static Node findInderSuccesor(Node root){
        while ( root.left != null){
            root = root.left;
        }
        return root;

    }

    public static void RangeRange(Node root , int k1 , int k2){
        if(root == null){
            return;
        }
        if( root.data >= k1 && root.data <= k2){
            RangeRange(root.left , k1 ,k2);
            System.out.println(root.data+" ");
            RangeRange(root.right,k1,k2);
        } else if (root.data <k1) {
            RangeRange(root.left,k1,k2);
        }else {
            RangeRange(root.right,k1,k2);
        }
    }
    public static void  printPath(ArrayList<Integer> path){
        for (int i = 0 ;i<path.size() ;i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST( Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max!= null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left , min , root) && isValidBST( root.right , root,max);
    }

    public static Node mirroe ( Node root){
        if(root == null){
            return null;
        }
        Node leftSubtress_mirror = mirroe(root.left);
        Node rightSubtree_mirror = mirroe(root.right);
        root.left= rightSubtree_mirror;
        root.right = leftSubtress_mirror;
        return root;
    }
    public static Node balanceBSt(int arr[] , int st , int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = balanceBSt(arr , st , mid-1);
        root.right = balanceBSt(arr , mid+1 , end);
        return root;
    }
    public static void getinorder(Node root , ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getinorder(root.left , inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }

    // is not convert a given bST in balnced
    public static Node balanceBSt_convert(ArrayList<Integer> inorder , int st , int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = balanceBSt_convert(inorder , st , mid-1);
        root.right = balanceBSt_convert(inorder , mid+1 , end);
        return root;
    }
    public static Node balaneceBST(Node root){
        ArrayList<Integer> inoder = new ArrayList<>();
        getinorder(root,inoder);

        // sorted inorder -> balanceed BST

        root =balanceBSt_convert(inoder, 0 , inoder.size()-1);
        return root;
    }




    public static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void preorder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }



    public static void main(String[] args) {
//        Node root = new Node(8 );
//        root.left = new Node(5);
//        root.right = new Node(10);
//        root.left.left = new Node(3);
//        root.left.right = new Node(6);
//        root.right.right = new Node(11);

        int arr[] = { 3,5,6,8,10,11,12};

//        int val[] = {8,5,3,1,4,6,10,11,14};
//        Node root = null;
//        for (int i = 0;i<val.length;i++){
//            root= insert(root,val[i]);
//        }

//        inorder(root);
//        System.out.println();
//
//        root = Delete(root ,3);
//        inorder(root);
//        if(search(root, 7)){
//            System.out.println("found");
//        }else {
//            System.out.println("Not found");
//        }
//        RangeRange(root,5,13);
//        printRoot2Leaf(root , new ArrayList<>());
//        if(isValidBST(root,null , null)){
//            System.out.println("Is Valid");
//        }else {
//            System.out.println("NOt valid");
//        }
//        root = mirroe(root);
//        preorder(root);
//        Node root = balanceBSt(arr , 0, arr.length-1);
//        preorder(root);






    }


}
