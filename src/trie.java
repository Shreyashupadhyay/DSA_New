public class trie {

    static class QNode{
        QNode [] children  = new QNode[26];
        boolean endofWord = false;

        int freq;

        QNode(){
            for (int i = 0;i<26 ;i++){
                children[i] = null;
            }
            freq =1;
        }
    }
    public static QNode Qroot = new QNode();
    public static void Qinsert(String words){
        QNode curr = Qroot;
        for (int level = 0;level <words.length();level++){
            int idx = words.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new QNode();
            }else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endofWord = true;
    }

   static class Node {
        Node [] children  = new Node[26];
        boolean endofWord = false;

        Node(){
            for (int i = 0;i<26 ;i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

   public static void insert(String words){
       Node curr = root;
       for (int level = 0;level <words.length();level++){
           int idx = words.charAt(level)-'a';
           if(curr.children[idx] == null){
               curr.children[idx] = new Node();
           }
           curr = curr.children[idx];
       }
       curr.endofWord = true;
   }

   public static boolean search(String key){
       Node curr = root;
       for (int level = 0;level <key.length();level++){
           int idx = key.charAt(level)-'a';
           if(curr.children[idx] == null){
               return false;
           }
           curr = curr.children[idx];
       }
       return curr.endofWord == true;

   }

   public static boolean wordbreak(String key){
       if (key.length() == 0){
           return true;
       }
       for (int i = 1;i<=key.length();i++){
           if(search(key.substring(0,i))&& wordbreak(key.substring(i))){
               return true;
           }
       }
       return false;

   }
    public static void main(String[] args) {
//        String words[] = {"the" , "a" , "there" , "their" ,"any" , "thee"};
        String words[] = {"i" , "like" , "sam" , "samsung" ,"any" , "thee"};
        for (int i = 0;i<words.length;i++){
            insert(words[i]);
        }
//        System.out.println(search("thee"));
        String key = "ilikesamsung";
        System.out.println(wordbreak(key));


    }
}
