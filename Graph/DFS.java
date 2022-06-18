package graph;
public class DFS {
	public void DFS( int v, int [] visited ) {
		graph.getValue( v );
		visited[ v ] = 1; // visited
		w = graph.getFirstNeighbor( v );
		while( w != -1 ) {
			if( visited[ w ] == 0) // neighbor not visited
				DFS( w, visited ); // visit w

			// w visited, w's next neighbor
			w = graph.getNextNeighbor( w );
		}
	}
}
