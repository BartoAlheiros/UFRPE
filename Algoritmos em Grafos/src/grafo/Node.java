package grafo;

import java.util.ArrayList;

public class Node {
	private String r; // rótulo do Nó
	public int v; // valor do Nó
	private ArrayList<Node> adj; // lista de adjacências do Nó

	public Node() {}

	public Node(String r) {
		this.v = 0;
		this.r = r;
		this.adj = new ArrayList<>();
	}

	public Node(String r, int v) {
		this.r = r;
		this.v = v;
		this.adj = new ArrayList<Node>();
	}

	public void setR(String r) {
		this.r = r;
	}
	
	public void setV(int v) {
		this.v = v;
	}

	public ArrayList<Node> getAdj() {
		return this.adj;
	}

	public String toString() {
		return Integer.toString(this.v);  
	}

	public boolean equals(String r, int v) {
		if ( this.r.equals(r) ) 
			return true;
		else
			return false;
	} 
}
