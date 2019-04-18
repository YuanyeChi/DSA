
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {
	//public static int[] ans = new int[10];
	//public static int i = 0;
    public void DFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
        
    }
    
    private void DFSUtil(Vertex<Integer> v,Set<Long> visited){
        //visited.add(v.getId());
		//ans[i++] = (int)v.getId();
		System.out.print(v.getId() + " ");
        for(Vertex<Integer> vertex : v.getAdjacentVertexes()){
            if(!visited.contains(vertex.getId()))
                DFSUtil(vertex,visited);
        }
    }
    
    public void BFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();
        
        for(Vertex<Integer> vertex: graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                q.add(vertex);
                visited.add(vertex.getId());
                while(q.size() != 0){
                    Vertex<Integer> vq = q.poll();
                    System.out.print(vq.getId()+ " ");
                    for(Vertex<Integer> v : vq.getAdjacentVertexes()){
                        if(!visited.contains(v.getId())){
                            q.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }
        
    }
    
    
    public static void main(String args[]){
        
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 7);
		graph.addEdge(5, 4);
		graph.addEdge(5, 8);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(7, 8);
		graph.addEdge(8, 4);
		graph.addEdge(9, 8);
		    
        GraphTraversal g = new GraphTraversal();
		g.DFS(graph);
		//for (int j = 0; j < ans.length; j++) {
		//	for (int k = 0; k < j; k++) {
		//		System.out.println(ans[k] + "");
		//	}
			//	System.out.println("长度为" + j);
			//	System.out.println();
		}
    
}
