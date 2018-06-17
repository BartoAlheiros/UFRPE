package grafo;

import java.util.ArrayList;

public class Node {
  public String v; // valor do vértice 
  public ArrayList<Node> adj; // lista de adjacências do vértice

  public Node(String v) {
  	this.v = v;
  	this.adj = new ArrayList<Node>();
  }
  
  public void setAdj(ArrayList<Node> adj) {
    this.adj = adj;
  }
  
  public String toString() {
	return this.v;  
  }
  
  public boolean equals(String v) {
  	if (v.contentEquals(v)) 
  		return true;
  	else
  		return false;
  } 
}
