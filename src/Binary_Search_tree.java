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
    public static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void main(String[] args) {

        int val[] = { 5,1 ,3,4,2,7};
        Node root = null;
        for (int i = 0;i<val.length;i++){
            root= insert(root,val[i]);
        }

        inorder(root);
        if(search(root, 7)){
            System.out.println("found");
        }else {
            System.out.println("Not found");
        }



    }


}
