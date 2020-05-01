import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GraphImplementation implements Graph{

	private boolean [][] adjacentMatrix;
	int vertices;

	public GraphImplementation(int vertices){
		this.vertices = vertices;
		adjacentMatrix = new boolean[vertices][vertices];
	}

	public void addEdge(int v1, int v2) throws Exception{
		adjacentMatrix[v1][v2] = true;
		adjacentMatrix[v2][v1] = true;
	}

	public List<Integer> topologicalSort(){
		List<Integer>schedule = new ArrayList<Integer>();
		int[]incident = new int[vertices];
		for(int v = 0; v < vertices; v++){
			System.out.println("New Column");
			for(int w = 0; w < vertices; w++){
				System.out.println(adjacentMatrix[v][w]);
				if(adjacentMatrix[v][w] == true){
					incident[v]+=1;
				} 
			}
		}

		for(int x = 0; x < vertices; x++)
			System.out.print(incident[x]);

		for(int i = 0; i < vertices; i++){
			int v = noIncidents(incident);
			schedule.add(v);
			incident[v] = -1;
			for(int j = 0; j < vertices; j++){
				if(adjacentMatrix[v][j] == true){
					incident[j] -= 1;
				}
			}
		}
		return schedule;
		
	}

	protected int noIncidents(int [] incident){
		for(int i = 0; i < incident.length; i++){
			//System.out.println(incident[i]);
			if(incident[i] == 0)
				return i;
		}
		return -1;
	}

	public List<Integer> neighbors(int vertex) throws Exception{
		if (vertex >= vertices)
    		throw new Exception();
		List<Integer>neighbors = new ArrayList<Integer>();
		for(int i = 0; i < vertices; i++){
			if(adjacentMatrix[vertex][i] != false){
				neighbors.add(i);
			}	
		}
		return neighbors;
	}
}