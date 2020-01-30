package Lab11;

import java.util.ArrayList;


public class HasCycle extends BreadthFirstSearch {

	int numberOfSpanningEdge;
	public HasCycle(Graph graph) {
		super(graph);
	}

	protected void processEdge(Edge e) {
		numberOfSpanningEdge++;
	}

	public boolean hasCycle() {
		numberOfSpanningEdge = 0;
		start();
		return numberOfSpanningEdge < graph.edges.size();
	}

}
