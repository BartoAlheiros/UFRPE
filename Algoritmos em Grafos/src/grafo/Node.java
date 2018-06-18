package grafo;

import java.util.ArrayList;

public class Node {
  public String r; // r�tulo do N�
  public int v; // valor do N�
  public ArrayList<Node> adj; // lista de adjac�ncias do N�

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
