package grafo;

import java.util.ArrayList;

public class Node {
  public String r; // rótulo do Nó
  public int v; // valor do Nó
  public ArrayList<Node> adj; // lista de adjacências do Nó

  public Node(int v) {
  	this.v = v;
  	this.adj = new ArrayList<Node>();
  }
  
  public Node(String r, int v) {
  	this.v = v;
  	this.r = r;
  	this.adj = new ArrayList<Node>();
  }
  
  public String toString() {
  	return Integer.toString(this.v);  
  }
  
  public boolean equals(String r, int v) {
  	if (this.r.equals(r) || this.v == v) 
  		return true;
  	else
  		return false;
  } 
}
