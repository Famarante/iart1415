package graph;

import java.util.ArrayList;

public class Node{
	public String name;
	public final int id;
	//public final ArrayList<Edge> edges;
	public Node(String name, int id) {
		this.name = name;
		this.id = id;
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
	public String getName() {
		return name;
	}
	
	public void changeName(String name){
		this.name = name;
	}
}