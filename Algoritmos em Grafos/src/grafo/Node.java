package grafo;

import java.util.ArrayList;

public class Node {
  public String v; // valor do v�rtice 
  public ArrayList<Node> adj; // lista de adjac�ncias do v�rtice

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
