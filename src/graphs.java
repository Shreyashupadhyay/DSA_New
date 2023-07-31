import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graphs {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s ,int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void creategraph(ArrayList<Edge> graphs[]){
        for (int i = 0;i<graphs.length;i++){
            graphs[i] = new ArrayList<>();
        }
        // 0 -> vertex
        graphs[0].add(new Edge(0,1,1));
        graphs[0].add(new Edge(0,2,1));

        // 1 -> vertex
        graphs[1].add(new Edge(1,0,1));
        graphs[1].add(new Edge(1,3,1));

        // 2 -> vertex
        graphs[2].add(new Edge(2,0,1));
        graphs[2].add(new Edge(2,4,1));
        // 3 -> vertex
        graphs[3].add(new Edge(3,1,1));
        graphs[3].add(new Edge(3,4,1));
        graphs[3].add(new Edge(3,5,1));

        // 4 vertex
        graphs[4].add(new Edge(4,2,1));
        graphs[4].add(new Edge(4,3,1));
        graphs[4].add(new Edge(4,5,1));
        // 5 vertex
        graphs[5].add(new Edge(5,3,1));
        graphs[5].add(new Edge(5,4,1));
        graphs[5].add(new Edge(5,6,1));

        graphs[5].add(new Edge(6,5,1));

    }
    public static void bfs(ArrayList<Edge> [] graphs){
        Queue<Integer> q = new LinkedList<>();
        boolean vist[] = new boolean[graphs.length];
        q.add(0); // source
        while (!q.isEmpty()){
            int curr = q.remove();
            if(!vist[curr]){
                System.out.printf(curr+ " ");
                vist[curr] = true;
                for (int i = 0;i<graphs[curr].size();i++){
                    Edge e = graphs[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graphs = new ArrayList[v];
        creategraph(graphs);
        bfs(graphs);



//        // 2's nabhor
//        for (int i = 0;i<graphs[2].size();i++){
//            Edge e = graphs[2].get(i);
//            System.out.println(e.dest);
//        }
        
    }
}
