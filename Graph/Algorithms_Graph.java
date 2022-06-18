package graph;

import graph.Graph;

public class Algorithms_Graph {

	public void DFS() {
		// initiate
		int [] visited = new int[numVertices];
		for( int i=0; i<numVertices; i++)
			visited[i] = 0;

		// DFS
		DFS(0, visited);
	}
	
	public void DFS( int v, int [] visited ) {
		System.out.println( graph.getValue( v ) );
		visited[ v ] = 1;
		int w = graph.getFirstNeighbor( v );
		while( w!=-1 ) {
			if( visited[ w ] == 0 ) 
				DFS( w, visited );
			w = graph.getNextNeighbor( v, w );
		}
	}
	
	public void components() {
		// DFS
		int [] visited = new int[ numVertices ];
		for( int i=0; i<numVertices; i++) {
			if( visited[ i ] == 0 ) {
				DFS( i, visited );
				// output New Component
			}
		}
	}
	
	public void BFS( int v ) {
		int [] visited = new int[ numVertices ]; // 记录被访问的节点
		
		// 初始化
		for( int i=0; i<numVertices; i++ )
			visited[ i ] = 0;
		System.out.println( graph.getValue( v ) );
		visited[ v ] = 1;
		Queue q; // 控制访问的队列
		q.enQueue( v );
		while( !q.isEmpty() ) {
			v = q.deQueue(); // v 已经访问过了
			int w = graph.getFirstNeighbor( v );
			while( w != -1 ) {
				if( visited[ w ] == 0 ) {// w not visited 
					System.out.println( graph.getValue( w ) );
					visited[ w ] = 1; // w visited;
					q.enQueue( w );
				}
				// w's next neighbor
				w = graph.getNextNeighbor( v ,  w );
			}	
		}
		
	}
	
	private int numVertices;
	private Graph graph;
}

class Queue{
	public Queue() {
		
	}

	public int deQueue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void enQueue(int v) {
		// TODO Auto-generated method stub
		
	}
}