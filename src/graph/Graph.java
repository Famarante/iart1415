package graph;

import java.util.HashMap;

public class Graph {

	//public ArrayList<Node> nodes;
	public HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
	
	public void addNode(Integer position, Node node){
		nodes.put(position, node);
	}
	
	public Node getNode(Integer position){
		return nodes.get(position);
	}
	
}