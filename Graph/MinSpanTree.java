package graph;

public class MinSpanTree {

	public static final int MAXINT;
	public MinSpanTree() {
		this( numVertices-1 );
	}
	public MinSpanTree( int sz ) {
		this.maxSize = sz;
		n = 0;
		this.edgeValue = new MSTEdgeNode[ this.maxSize ];
	}
	
	
	MSTEdgeNode [] edgeValue; //边值数组
	int maxSize; //数组的最大元素个数和
	int n; //当前个数
}

class MSTEdgeNode{
	int tail, head;
	int cost;
}

