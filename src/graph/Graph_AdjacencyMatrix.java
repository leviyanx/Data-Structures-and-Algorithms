package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph_AdjacencyMatrix implements Graph{
	
	public Graph_AdjacencyMatrix() {
		this(MaxNumEdges);
	}
	public Graph_AdjacencyMatrix( int sz ) {
		// constructor
		for( int i = 0; i < sz; i++ )
			for( int j = 0; j < sz; j++ )
				this.edge[i][j] = 0;
		this.currentEdges = 0;
	}
	public boolean graphEmpty() { return verticesList.isEmpty(); }
	public boolean graphFull() {
		return this.verticesList.isFull() || this.currentEdges == this.MaxNumEdges; }
	}
	
	public int numberOfVertices() { return this.verticesList.last; }
	public int numberOfEdges() {return this.currentEdges; }
	public Vertex getValue( int i ) {
		return i >= 0 && i < verticesList.last ? verticesList.data.get(i) : null; 
	}
	public int getWeight( int v1, int v2 ) {}
	
	public int getFirstNeighbor( int v ) { //求顶点V的第一个邻接顶点的位置
		if( v != -1 ) {
			for( int col=0; col < currentVertices; col++ )
				if( edge[v][col]>0 && edge[v][col]<max)
					return col;
		}
		return -1;
	} 
	public int getNextNeighbor( int v1, int v2 ) {}
	
	public void insertVertex( Vertex v ) {}
	public void insertEdge( int v1, int v2, int weight ) {}
	public void removeVertex( int v ) {}
	public void removeEdge( int v1, int v2 ) {}
	
	// private
	private static final int MaxNumEdges = 50; // 最大边数
	private static final int MaxNumVertices = 10; //最大顶点数
	private VerticesList verticesList = new VerticesList(MaxNumVertices); //顶点表
	private int [][] edge = new int [MaxNumVertices] [MaxNumVertices]; //邻接矩阵
	private int currentEdges; // 当前边数
	
	private int findVertex(VerticesList l, Vertex v) 
		{ return l.find(v); }
	private int getVertexPos(Vertex v) //给出顶点在图中的位置
		{ return this.findVertex(this.verticesList, v);}
}

class VerticesList {
	public VerticesList(int MaxNumVertices) {
		this.data = new ArrayList<Vertex>(MaxNumVertices);
		this.last = 0;
	}
	public boolean isEmpty() {return false;}
	
	public int find( Vertex v ) {return 0;}
	
	List<Vertex> data;
	int last;
}

class Vertex {
	
}

class Edge {
	
}