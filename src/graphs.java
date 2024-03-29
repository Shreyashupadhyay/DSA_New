import java.awt.image.AreaAveragingScaleFilter;
import java.security.interfaces.EdECKey;
import java.util.*;

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
    public static void bfs(ArrayList<Edge> [] graphs){ //for the graphs which has connected components
        boolean vist[] = new boolean[graphs.length];
        for (int i = 0;i<graphs.length;i++){
            if(!vist[i]){
                bfsutil(graphs,vist);
            }
        }
    }


    public static void bfsutil(ArrayList<Edge> [] graphs, boolean vist[]){
        Queue<Integer> q = new LinkedList<>();
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
    public static void Bfs(ArrayList<Edge> [] graphs){ // Normal code for the normal graphs with no broke graphs O(
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
    public static void dfs(ArrayList<Edge> [] graphs){
        boolean vist[] = new boolean[graphs.length];
        for (int i = 0;i<graphs.length;i++){
            dfsutil(graphs,i,vist);
        }

    }
    public static void dfsutil(ArrayList<Edge> [] graphs, int curr , boolean vis[]){
        // visit
        System.out.print(curr+" ");
        vis[curr] = true;
        for (int i = 0;i<graphs[curr].size() ;i++){
            Edge e = graphs[curr].get(i);
            if (!vis[e.dest]){
                dfsutil(graphs,e.dest,vis);
            }
        }


    }
    public static void Dfs(ArrayList<Edge> [] graphs, int curr , boolean vis[]){
        // visit
        System.out.print(curr+" ");
        vis[curr] = true;
        for (int i = 0;i<graphs[curr].size() ;i++){
            Edge e = graphs[curr].get(i);
            if (!vis[e.dest]){
                Dfs(graphs,e.dest,vis);
            }
        }


    }

    public static boolean hasPath(ArrayList<Edge> [] graphs , int src , int dest , boolean visit[]){
        if(src == dest){
            return true;

        }
        visit[src] = true;
        for (int i = 0;i<graphs[src].size();i++){
            Edge e = graphs[src].get(i);
            // e.dest = neighor
            if(!visit[e.dest] && hasPath(graphs , e.dest, dest, visit)){
                return true;
            }
        }
        return false;
    }

    public static boolean DetectCycle(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis,i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> [] graph, boolean vis[] , int curr, int parent){
        vis[curr] = true;
        for (int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[curr]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // case 1
            else if (vis[e.dest] && e.dest != parent) {
                return true;
            }
            // case 2 .. just Continue
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> [] graphs){
        int col [] = new int[graphs.length];
        for(int i = 0;i<col.length;i++){
            col[i] = -1;
         }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i<graphs.length;i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0; // Yellow
                while (!q.isEmpty()){
                    int curr = q.remove();
                    for (int j = 0;i<graphs[curr].size();i++){
                        Edge e = graphs[curr].get(j); // e.dest
                        if(col[e.dest] == -1){
                            int nextcol = col[curr] == 0?1:0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);

                        }else if(col[e.dest] == col[curr]){
                            return false; // not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isCycleutil(ArrayList<Edge>[] graphs , int curr, boolean vis[] , boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0;i<graphs[curr].size();i++){
            Edge e = graphs[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleutil(graphs , e.dest , vis , stack)){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graphs){
        boolean vis[] = new boolean[graphs.length];
        boolean stack[] = new boolean[graphs.length];
        for (int i = 0;i<graphs.length;i++){
            if(!vis[i]){
                if(isCycleutil(graphs , i , vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void topSort(ArrayList<Edge> [] graphs){
        boolean vis[] = new boolean[graphs.length];
        Stack<Integer> s = new Stack<>();
        for (int i= 0;i< graphs.length;i++){
            if(!vis[i]){
                topSortutil(graphs , i ,vis , s);
            }
        }
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortutil(ArrayList<Edge> []graphs, int curr, boolean vis[] , Stack<Integer> s){
        vis[curr]=true;
        for (int i = 0;i<graphs[curr].size();i++){
            Edge e = graphs[curr].get(i);
            if(!vis[e.dest]){
                topSortutil(graphs, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void printAllPath(ArrayList<Edge> [] graphs , int sur , int dest , String path){
        if(sur == dest){
            System.out.println(path+dest);
            return;
        }
        for (int i = 0;i<graphs[sur].size();i++){
            Edge e = graphs[sur].get(i);
            printAllPath(graphs , e.dest ,dest , path+sur);
        }
    }

    static class Pair implements Comparable<Pair>{
        int n ;
        int path;
        public Pair(int n ,int path){
            this.n= n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void Dijkstra(ArrayList<Edge> [] graphs , int src){
        int dist[] = new int[graphs.length];
        for (int i = 0;i<graphs.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Boolean vist[] = new Boolean[graphs.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vist[curr.n]){
                vist[curr.n] = true;
                for (int i= 0;i<graphs[curr.n].size();i++){
                    Edge e = graphs[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] + wt <dist[v]){
                        dist[v] = dist[u] +wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for (int i = 0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graphs = new ArrayList[v];
        creategraph(graphs);
//        bfs(graphs);
//        Dfs(graphs , 0,new boolean[v]);
//        dfs(graphs);
//        System.out.println(hasPath(graphs,0,5,new boolean[v]));
//        System.out.println(DetectCycle(graphs));
//        System.out.println(isCycle(graphs));
//        topSort(graphs);
//        printAllPath(graphs , 0, 6 , "");
        Dijkstra(graphs, 0);




//        // 2's nabhor
//        for (int i = 0;i<graphs[2].size();i++){
//            Edge e = graphs[2].get(i);
//            System.out.println(e.dest);
//        }
        
    }
}
