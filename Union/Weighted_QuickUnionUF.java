public class Weighted_QuickUnionUF {
	private int[] id;
	private int[] sz;

	public Weighted_QuickUnionUF(int N){
		id = new int[N];
		for(int i=0; i<N; i++) {
			id[i] = i;
		}
	}

	public int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	};

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) return;
		if (sz[i] < sz[j]){
			 id[i] = j; 
			 sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}



