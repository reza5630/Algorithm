package Lab11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ShortestPath extends BreadthFirstSearch {
	private HashMap<Vertex, Integer> levelsMap = new HashMap<Vertex, Integer>();
	private HashMap<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();
	private List<Vertex> vertexes;

	/** Assumes g is connected */
	public ShortestPath(Graph g) {
		super(g);
		vertexes = new ArrayList();
	}

	@Override
	protected void processVertex(Vertex w) {
		vertexes.add(w);
	}

	@Override
	protected void processEdge(Edge e) {
		if(!e.v.equals(vertexes.size()-1))
			vertexes.add(e.v);
		parentMap.put(e.u, vertexes.get(vertexes.size()-1));
	}

	private int countLevel(Vertex prev){
		if(prev.equals(vertexes.get(0)))	return 0;
		return 1+ countLevel(parentMap.get(prev));
	}

	//TO-DO
	public int computeShortestPathLength(Vertex s, Vertex v) {
		parentMap.put(s, s);
		start(s);
		return countLevel(v);
	}
}
