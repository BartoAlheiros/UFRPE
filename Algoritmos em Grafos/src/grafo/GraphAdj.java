package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphAdj extends Graph {
	ArrayList<Node> nodes;
	
	/* Construtor para inicializar o grafo. A diferenca é que escolhemos utilizar 
	 * ArrayList em vez de Array. Não sendo, dessa forma, necessário passar como
	 * argumento o número de N de Nós.*/
	public GraphAdj() {
		this.nodes = new ArrayList<>();
	}
	
	public GraphAdj(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void carregaArquivo() {
		FileReader arq;

		try {
			arq = new FileReader("./grafos/grafo1.grf");
			Graph g = new GraphAdj();

			BufferedReader lerArq = new BufferedReader(arq);

			// lê a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* Laço que percorre todas as linhas do arquivo*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = lerArq.readLine(), r = ""; // r é o rótulo do nó.
				String[] strB = linha.split(" ");
				ArrayList<Node> adj = new ArrayList<>(); // lista de adjacências do nó. 

				/* Preenche a lista de adjacências (adj) do nó. */
				while ( !(strB[j].equals('\n') ) ) {
					Node node = new Node(strB[j], Integer.parseInt(strB[j + 1]));		/* cria um novo nó. */
				
					if ( j == 0 & !(this.nodes.contains(node)) ) {
						r = strB[j]; // salva o rótulo do nó em r.
						
					} else if ( j != 0 & !(this.nodes.contains(node) ) ) {
						adj.add(node);
					}
				}
				
				j++;
				
			}
			lerArq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
