package graph;

public interface Graph {
	
	public boolean graphEmpty();
	public boolean graphFull();
	
	public int numberOfVertices();
	public int numberOfEdges();
	public Vertex getValue( int i );
	public int getWeight( int v1, int v2 );
	
	public int getFirstNeighbor( int v ); //求顶点V的第一个邻接顶点的位置
	public int getNextNeighbor( int v1, int v2 );
	
	public void insertVertex( Vertex v );
	public void insertEdge( int v1, int v2, int weight );
	public void removeVertex( int v );
	public void removeEdge( int v1, int v2 );
	
}
