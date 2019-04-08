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
		
		// A complÃ©ter
		
		final int INFINITY = 99999;
		
		for(int i=0;i < graph.getNodes().size();++i) {
			graph.getNodes().get(i).distance = INFINITY;
		}

		s.distance = 0;
		s.found = true;
		
		//la liste avec les edges de la source
		ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
		
		//l'update autour du noeud source
		for(int i=0;i<list.size();++i) {
			List<Node> tmpNodeList = graph.getNodes();
			int tmpIndex = tmpNodeList.indexOf(list.get(i));
			// On update la distance des noeuds qui sont la destination du noeud source
			// modifie le node et non le edge
			tmpNodeList.get(tmpIndex).distance = list.get(i).getDistance() + s.distance;
		}
		
		
		//int currentLength = 0;
		
		
		
		int iteration = 0;
		while(d.found == false) {
			
			int min = INFINITY;
			
			// Trouver le prochain noeud
			Node bestNode = new Node();
			int bestNodeIndex = 0;
			{	int i = 0;
				//on parcours tous les nodes
				for(Node node : graph.getNodes()) {
					//si le node n'est pas dans l'ensemble et si sa valeur est plus petite
					if( (node.found == false) && (node.distance < min) ) {
						min = node.distance;
						bestNode = node; // El bestos nodos
						bestNodeIndex = i;
					}
					i++;
				}
			}			

			
			//le node trouvé fait partie de l'ensemble.
			graph.getNodes().get(bestNodeIndex).found = true;
			
			Edge bestEdge = new Edge();
			
			//il faut trouver le edge min et l'ajouté au path
			//pas bon car il faut parcourir tous les edges our tous les nodes
			for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getDestination() == graph.getNodes().get(bestNodeIndex))
					bestEdge = list.get(i);
			}
			
			//put DestinationNode, edge
			dijkstraTable[iteration].put(bestNode, bestEdge);
			
			//ajout du edge au path
			//faire un while
			int iteration2 = iteration;
			while( bestEdge.getSource() != dijkstraTable[iteration2].get(bestNode).getSource()) {
				path.pop();
				iteration2--;
			}
			
			do {
				path.add(bestEdge);
			}
			while( bestEdge.getSource() == dijkstraTable[iteration].get(bestNode).getSource());
			
			
			/*//on choisi le meilleur edge
			//Pas sur s'il faut parcourir la liste
			for(Edge edge : list) {
				//A-> 		B 					bestNode
				if(edge.getDestination() == graph.getNodes().get(bestNodeIndex)) {// Trouver le edge en fction du node
					currentLength += edge.getDistance();
					break;
				}
			}*/
			
			//la liste avec les edges du bestNode
			list = new ArrayList<Edge>(graph.getEdgesGoingFrom(bestNode));
			
			//l'update
			for(int i=0;i<list.size();++i) {
				//List<Node> tmpNodeList = graph.getNodes();
				//retourne l'index du noeud de destination
				int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
				// On update la distance des noeuds qui sont la destination du noeud source
				// modifie le node et non le edge
				
				//il faut vérifier si la nouvelle somme est plus petite et si oui on update.
				int distanceEdge = list.get(i).getDistance();
				int distanceNoeud = bestNode.distance;
				if( (distanceEdge + distanceNoeud) < graph.getNodes().get(tmpIndex).distance)
					graph.getNodes().get(tmpIndex).distance = list.get(i).getDistance() + bestNode.distance;
			}
			
			iteration++;
			///////////////////////////////dijkstra fini///////////////////////////////
			
			//ajout du edge dans le path
			
			
			
			
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
