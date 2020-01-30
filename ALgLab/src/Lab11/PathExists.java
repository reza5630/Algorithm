package Lab11;



public class PathExists extends BreadthFirstSearch {
	
	public PathExists(Graph graph) {
		super(graph);
	}

	private Vertex end;
	boolean pathExists;
	private int componentCounter;


	@Override
	protected void additionalProcessing() {
		componentCounter++;
	}

	@Override
	protected void processVertex(Vertex w) {
		if(w.equals(end) && componentCounter==0)	pathExists = true;
	}
	//TO-DO
	public boolean pathExists(Vertex u, Vertex v) {
		end = v;	pathExists = false;	componentCounter = 0;
		start(u);
		return pathExists;
	}
	
}
