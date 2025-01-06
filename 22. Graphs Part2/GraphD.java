import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphD {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    //created graph for cycle detection
    static void createGraphA(ArrayList<Edge>[] graph) {
        /*
                    0 -----------3
                   / |           |
                  /  |           |
                 1   |           |
                  \  |           |
                   \ |           |
                    2 -----------4
    
         */
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //vertex-0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

         //vertex-1
         graph[1].add(new Edge(1, 0));
         graph[1].add(new Edge(1, 2));

        //vertex-2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        //vertex-3
        graph[3].add(new Edge(3, 0));

        //vertex-4
        graph[4].add(new Edge(4, 2));
    }

    //O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    //cycle exists in one of the part
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case3
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            //case1
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }

            //case2 do nothing -> continue
        }
        return false;
    }

    //created graph for checking bipartite or not
    static void createGraphB(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //vertex-0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

         //vertex-1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        //vertex-2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        //vertex-3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        //vertex-4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];

        for(int i = 0; i < col.length; i++) {
            col[i] = -1; //no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            if(col[i] == -1) { //BFS
                q.add(i);
                col[i] = 0; //yellow
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); //e.dest
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]) {
                            return false; // non bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    //Created graph for cycle detection for directed graph
    public static void createGraphC(ArrayList<Edge>[] graph) { //TRUE cycle
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) { //cycle
                return true;
            }

            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    //Created graph for topological sorting
    public static void createGraphD(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraphD(graph);
        topSort(graph);
    }
}
