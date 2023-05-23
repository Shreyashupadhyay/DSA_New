import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {
    static class Node{
        int data;
        Node left ;
        Node right;
        Node(int data){
            this.data= data;
            this.left= null;
            this.right = null;
        }
    }

    static class BIneryClass{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
       }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);

        }
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        public static int NodeCount(Node root){
            if(root == null){
                return 0 ;

            }
            int lcount = NodeCount(root.left);
            int rcount = NodeCount(root.right);
            return lcount+rcount+1;
        }
        public static int sumofNode(Node root){
            if (root == null){
                return 0;
            }
            int lsum = sumofNode(root.left);
            int rsum = sumofNode(root.right);
            return lsum+rsum+ root.data;
        }
        public static int Diameter(Node root){
            if(root == null){
                return 0;

            }
            int leftDia = Diameter(root.left);
            int leftHt = height(root.left);
            int rightDia = Diameter(root.right);
            int rightHt = height(root.right);

            int selfDia = leftHt +rightHt +1;
            return Math.max(selfDia , Math.max(leftDia , rightDia));
        }
        static class Info{
            int dia ;
            int ht;
            public Info(int dia, int ht){
                this.dia = dia;
                this.ht = ht;

            }
        }

        public static Info Diameterapproach2(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info linfo = Diameterapproach2(root.left);
            Info rinfo = Diameterapproach2(root.right);

            int dia = Math.max(Math.max(linfo.dia , rinfo.dia), linfo.ht + rinfo.ht+1);
            int ht = Math.max(linfo.ht , rinfo.ht)+1;

            return new Info(dia,ht);

        }



    }
    public static boolean isidentical(Node node , Node subroot){
        if(node == null && subroot ==null){
            return true;
        }else if (node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if(!isidentical(node.left ,subroot.left)){
            return false;
        }
        if(!isidentical(node.right, subroot.right)){
            return false;
        }
        return true;

    }
    public static boolean issubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isidentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.left , subroot) || issubtree(root.right,subroot);
    }

    public static void LevelorderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println("null");
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(currNode);
                }
            }else {
                System.out.println(currNode.data);
                if ((currNode.left !=null)){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }

        }

    }

    public static void Klevel(Node root , int level , int k ){
        if (root == null){
            return;
        }
        if(level == k){
            System.out.println(root.data);
            return;
        }
        Klevel(root.left , level+1,k);
        Klevel(root.right, level +1, k);
    }

    static class info{
        Node node;
        int hd ;
        public info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void TopViewoftree(Node root){
        Queue<info> q  = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(new info(root , 0));
        q.add(null);
        while (!q.isEmpty()){
            info curr = q.remove();
            if (curr == null) {

                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd , curr.node);
                }
                if(curr.node.left != null){
                    q.add(new info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right !=null){
                    q.add(new info(curr.node.right , curr.hd+1));
                    max= Math.max(max,curr.hd+1);
                }
            }


        }
        for (int i = min ;i<=max ;i++ ){
            System.out.println(map.get(i).data+" ");
        }


    }

    public static Node lca2(Node root , int n1 ,int n2){
        if( root==  null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftlca = lca2(root.left , n1 , n2);
        Node rightlca = lca2(root.right , n1,n2);

        // if leftlca return val and right lca return null then
        if(rightlca == null){
            return leftlca;
        }
        // if rightlca retunr val and leftlca return null then
        if(leftlca == null){
            return rightlca;
        }
        return root;


    }
    public static int lcaDist(Node root, int n ){
        if(root== null){
            return -1;
        }
        if(root.data == n ){
            return 0;
        }
        int leftDist  = lcaDist(root.left , n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist ==-1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else {
            return leftDist +1;
        }
    }


    public static int minDis(Node root , int n1 , int n2){

        Node lca = lca2(root, n1 , n2);
        int Dist1 = lcaDist(lca , n1);
        int Dist2 = lcaDist(lca , n2);

        return Dist1 + Dist1;

    }

    public static int KthAncestoe(Node root , int n , int k ){
        if (root == null){
            return -1;
        }
        if(root.data ==  n){
            return 0;
        }
        int leftDist = KthAncestoe(root.left , n , k);
        int rightDist = KthAncestoe(root.right,n,k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist , rightDist);
        if((max+1) == k){
            System.out.println(root.data);
        }
        return max+1;
    }




    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        Binarytree tree = new Binarytree();

        BIneryClass t = new BIneryClass();
        Node root = new Node(1);
        root.left = new Node(2); 
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        ;
//        Node root = t.buildTree(nodes);
//        System.out.println(root.data);
//        t.preorder(root);
//        System.out.println();
//        t.inorder(root);
//        System.out.println();
//        t.postorder(root);

//        System.out.println(t.height(root));
//        System.out.println(t.NodeCount(root));
//        System.out.println(t.sumofNode(root));
//        System.out.println(t.Diameter(root));
//        System.out.println(t.Diameterapproach2(root).dia);
//        System.out.println(isidentical(root, subroot));
//        LevelorderTraversal(root);
//        TopViewoftree(root);
//        Klevel(root , 1 ,2);

//        System.out.println(lca2(root,1 , 7).data);
//        System.out.println(minDis(root , 4, 6 ));
        KthAncestoe(root,5,2);






    }
}
