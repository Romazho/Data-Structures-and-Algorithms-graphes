import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	

	public Dijkstra (Graph g) {
		this.graph = new Graph(g);
	}

	public void findPath (Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		
		//4C dans le tableau a la place de 4D a la palce E5.
		
		// A compléter
		
		boolean trouve = false;
		final int INFINITY = 99999;
		for(int i=0;i < graph.getNodes().size();++i) {
			graph.getNodes().get(i).distance = INFINITY;
		}
		/*
		for(Node node : graph.getNodes()) {
			node.distance = INFINITY;
		}
		*/
		s.distance = 0;
		int currentLength = 0;
		dijkstraTable[0].put(s, arg1)
		
		//dijkstraTable[0].
		
		while(trouve == false) {
			
			//la liste avec les edges de la source
			ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
		
			
			//l'update
			for(int i=0;i<list.size();++i) {
				list.get(i).g
			}
			
			
			//on choisi le meilleur edge
			
			
			
		}
		
		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		//pas finit... faire attention aux objets nulls...
		if( e1.getDistance() < e2.getDistance() ) {
			return e1;
		}
		else {
			return e2;
		}
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
	}

	public void afficherTable () {
		// A completer
		
	}
}
