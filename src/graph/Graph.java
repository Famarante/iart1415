package graph;

import java.util.Map;

public class Graph {

	//public ArrayList<Node> nodes;
	public Map<String,Node> nodes;
	
	public void addNode(String name, Node node){
		nodes.put(name, node);
	}
	
	public Node getNode(String name){
		return nodes.get(name);
	}
	
}