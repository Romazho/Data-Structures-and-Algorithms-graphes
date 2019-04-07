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
		this.graph = g;
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

		s.distance = 0;
		s.found = true;
		int currentLength = 0;
		
		//dijkstraTable[0].put(s, arg1)
		
		while(trouve == false) {
			//la liste avec les edges de la source
			ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
		
			
			//l'update
			for(int i=0;i<list.size();++i) {
				List<Node> tmpNodeList = graph.getNodes();
				int tmpIndex = tmpNodeList.indexOf(list.get(i));
				// On update la distance des noeuds qui sont la destination du noeud source
				tmpNodeList.get(tmpIndex).distance = list.get(i).getDistance() + currentLength;// modifie le node et non le edge
			}
			int min = INFINITY;
			
			// Trouver le prochain noeud
			Node bestNode = new Node();
			int bestNodeIndex = 0;
			int i =0;
			
			
			
			for(Node node : graph.getNodes()) {
				if(!node.found && node.distance < min) {
					min = node.distance;
					bestNode = node; // El bestos nodos
					bestNodeIndex =i;
				}
				i++;
			}
			
			graph.getNodes().get(bestNodeIndex).found = true;
			
			//Pas sur s'il faut parcourir la liste
			for(Edge edge : list) {
				//A-> 		B 					bestNode
				if(edge.getDestination() == graph.getNodes().get(bestNodeIndex)) {// Trouver le edge en fction du node
					edge.
					currentLength += edge.getDistance();
					break;
				}
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
