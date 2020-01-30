package Lab11;

public class IsConnected extends BreadthFirstSearch {
	private int componentCounter;
	public IsConnected(Graph graph) {
		super(graph);
	}

	@Override
	protected void additionalProcessing() {
		componentCounter++;
	}

	//TO-DO
	public boolean isConnected() {
		componentCounter = 0;
		start();
		return componentCounter==1;
	}

	public int numberOfComponents(){
		return componentCounter;
	}
}