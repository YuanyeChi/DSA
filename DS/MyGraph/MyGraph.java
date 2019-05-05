package DS;
import java.sql.Time;
import java.util.*;

public class MyGraph {
	private int V; 
	private int time; 
	private LinkedList<Integer> adj[]; 
	private int[] prev, d, f;

	//Constructor 
	MyGraph(int v) 
	{ 
		V = v; 
		time = 0;
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
		prev = new int[v];
		d = new int[v];
		f = new int[v];
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) { adj[v].add(w); }
	
    void DFSUtil(int v, boolean visited[]) 
    { 
    	time++;
    	d[v] = time;
        visited[v] = true; 
        
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) {
            	prev[n] = v;
            	DFSUtil(n, visited); 
            }       
        }
        time++;
        f[v] = time;
    }
    
    void DFS() 
    { 
        boolean visited[] = new boolean[V]; 
  
        for (int i = 0; i < V; ++i) 
            if (visited[i] == false) 
                DFSUtil(i, visited); 
    } 
    
	public static void main(String args[]) 
	{ 
		MyGraph g = new MyGraph(10); 
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(0, 3); 
		g.addEdge(1, 4); 
		g.addEdge(1, 5);
		g.addEdge(1, 6);
		g.addEdge(2, 6); 
		g.addEdge(2, 7); 
		g.addEdge(3, 5); 
		g.addEdge(3, 9); 
		g.addEdge(4, 5); 
		g.addEdge(5, 4); 
		g.addEdge(5, 8); 
		g.addEdge(6, 9);
		g.addEdge(7, 8); 
		g.addEdge(8, 9);
		g.addEdge(9, 8); 
		
		g.DFS();
		System.out.println("DFS结果：");
		for (int i = 0; i < g.prev.length; i++) {
			//use stack to reverse the order
			Stack<Integer> stack = new Stack<>();
			int k = i;
			System.out.print("节点" + i + " ");
			while (k != 0) {
				stack.push(k);
				k = g.prev[k];
			}
			System.out.print("0");
			while (!stack.isEmpty()) {
				System.out.print(" " + stack.pop());
			}
			System.out.print(" 发现时间为 " + g.d[i] + " 完成时间为 " + g.f[i]);
			System.out.println();
			
		}
		
		
	} 
}
