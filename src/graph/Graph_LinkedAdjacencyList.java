package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_LinkedAdjacencyList implements Graph {

	public Graph_LinkedAdjacencyList() {
		this(defaultSize);
	}
	public Graph_LinkedAdjacencyList( int sz ) {
		int numVertices, numEdges, k, j;
		String name, tail, head;
		int weight;
		this.nodeTable = new ArrayList<Vertex>(this.maxNumVertices);
		
		Scanner scanner = new Scanner(System.in);
		// 输入顶点数
		numVertices = scanner.nextInt();
		for( int i=0; i<numVertices; i++ ) {
			name = scanner.nextLine();
			insertVertex(name);
		}
		// 输入边数
		numEdges = scanner.nextInt();
		for( int i=0; i<numEdges; i++) {
			tail = scanner.nextLine();
			head = scanner.nextLine();
			weight = scanner.nextInt();
			k = getVertexPos(tail);
			j = getVertexPos(head);
			insertEdge(k, j, weight);
		}
	}
	public boolean graphEmpty() {
		return this.numVertices == 0;
	}
	public boolean graphFull() {
		return this.numVertices == this.maxNumVertices;
	}

	public int numberOfVertices() 
		{ return this.numVertices; }
	public int numberOfEdges() 
		{ return this.numEdges; }
	public String getValue(int i) {
		return i>=0 && i<this.numVertices ? this.nodeTable.get(i).data : null;
	}
	public int getWeight(int v1, int v2) {
		return 0;
	}

	public int getFirstNeighbor(int v) {
		if( v != -1 ) {
			Edge p = nodeTable.get(v).adj;
			if( p != null )
				return p.dest;
		}
		return -1;
	}
	public int getNextNeighbor(int v1, int v2) {
		if( v1 != -1 ) {
			Edge p = nodeTable.get(v1).adj;
			while( p != null ) {
				if( p.dest==v2 && p.link!=null)
					return p.link.dest; //下一条边指向的节点
				else p = p.link;
			}
		}
		return -1;
	}

	public void insertVertex(String data) { }
	public void insertEdge(int v1, int v2, int weight) { }
	public void removeVertex(int v) { }
	public void removeEdge(int v1, int v2) { }
	
	// private 
	private static final int defaultSize = 10;
	
	private List<Vertex> nodeTable; //顶点表
	private int numVertices; //当前顶点 数
	private int maxNumVertices; //最大顶点个数
	private int numEdges; //当前边数
	
	private int getVertexPos( String v ) {
		for( int i=0; i<this.numVertices; i++)
			if( this.nodeTable.get(i).data == v) 
				return i;
		return -1;
	}

}

class Edge {
	Edge() {}
	Edge( int D, int C ) {
		this.dest = D;
		this.cost = C;
		this.link = null;
	}
	
	int dest; //边的另一顶点在顶点表中的位置
	int cost; //边上的权
	Edge link; //下一条边的链指针
}

class Vertex {
	String data; //顶点名字
	Edge adj; //出边表头指针
}