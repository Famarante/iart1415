package graph;

public class Edge{
		public final Node from;
		public final Node to;
		public final String direction;
		public Edge(Node from, Node to, String direction) {
			this.from = from;
			this.to = to;
			this.direction = direction;
		}
		@Override
		public boolean equals(Object obj) {
			Edge e = (Edge)obj;
			return e.from == from && e.to == to;
		}
		public String getDirection(){
			return direction;
		}
	}