/*UFRPE - Universidade Federal Rural de Pernambuco
 *DC - Departamento de Computa��o 
 * Aluno: Jos� Bartolomeu Alheiros Dias Neto */

package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*Classe que se refere ao Grafo em si e todas as suas componentes.*/
public class Graph {
  public ArrayList<Node> nodes;

  public Graph () {
  	
  }
  
  public Graph (ArrayList<Node> n) {
    this.nodes = n;
  }
  
  /*public void carregaArquivo () {
  	FileReader arq;

		try {
			arq = new FileReader("./grafos/grafo1.grf");

			BufferedReader lerArq = new BufferedReader(arq);

		// l� a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   
			
			/* La�o que percorre todas as linhas do arquivo e salva(...)*/
			/*for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = "", v = ""; // v � o valor do n�.
				String[] strB = linha.split(" ");
				ArrayList<Node> adj = new ArrayList<>(); // adj � a lista de adjac�ncias do n�. 
				
				/* Preenche a lista de adjac�ncias adj */
				/*while (strB[j].equals('\n') == false) {
					if (j == 0) {
						v = strB[0]; // se a posi��o do contador for 0, insere a string lida em uma vari�vel v do tipo String.
					} else {
						for (Node n: this.nodes) {
							if ( !n.adj.contains( new Node(strB[j]) ) ) {
								adj.add(new Node(strB[j]));
							} else {
								adj.add( n.adj.get( n.adj.indexOf( new Node( strB[j] ) ) ) );
							}
							
						}
					}
					j++;	
				}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }*/
  
  /*public boolean existe() {
    	
  }
  
  public boolean insereAresta(String x, String y) {
    for (Node vertice: this.nodes) {
    	if(vertice.e.indexOf(x) != -1 || vertice.e.indexOf(y) != -1) {
    		vertice.e.add(new Aresta(y));
    	} else if (vertice.v.equals(y)){
    		vertice.e.add(new Aresta(x));
    	}
    }	
  }*/
}
