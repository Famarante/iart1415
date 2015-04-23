package graph;

import java.util.HashMap;

public class Graph {

	//public ArrayList<Node> nodes;
	public HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
	
	public void addNode(Integer position, Node node){
		
		if(nodes.get(position) != null)
			System.out.println("A node with position "+position+" already exists!");
		else
			nodes.put(position, node);
	}
	
	public Node getNode(Integer position){
		
		 return nodes.get(position);
	}
	
	public void replace(int p1, int p2, String n1, String n2){
		nodes.get(p1).changeName(n1);
		nodes.get(p2).changeName(n2);
	}
	
}