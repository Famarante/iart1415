package graph;

import java.util.ArrayList;

public class Node{
	public final String name;
	//public final ArrayList<Edge> edges;
	public Node(String name) {
		this.name = name;
		//edges = new ArrayList<Edge>();
	}
	/*public Node addEdge(Node node, String direction){
		Edge e = new Edge(this, node, direction);
		edges.add(e);
		return this;
	}
	public ArrayList<Edge> getAllEdges(){
		return edges;
	}*/
	@Override
	public String toString() {
		return name;
	}
	
}