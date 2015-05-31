package graph;

public class Node{
	public String name;
	public final String id;
	public Node(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void changeName(String name){
		this.name = name;
	}
	
	public String getId(){
		return this.id;
	}
}