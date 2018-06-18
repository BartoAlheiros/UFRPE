package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphAdj extends Graph {
	ArrayList<Node> nodes;
	
	/* Construtor para inicializar o grafo. A diferenca � que escolhemos utilizar 
	 * ArrayList em vez de Array. N�o sendo, dessa forma, necess�rio passar como
	 * argumento o n�mero de N de N�s.*/
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

			// l� a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* La�o que percorre todas as linhas do arquivo*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = lerArq.readLine(), r = ""; // r � o r�tulo do n�.
				String[] strB = linha.split(" ");
				ArrayList<Node> adj = new ArrayList<>(); // lista de adjac�ncias do n�. 

				/* Preenche a lista de adjac�ncias (adj) do n�. */
				while ( !(strB[j].equals('\n') ) ) {
					Node node = new Node(strB[j], Integer.parseInt(strB[j + 1]));		/* cria um novo n�. */
				
					if ( j == 0 & !(this.nodes.contains(node)) ) {
						r = strB[j]; // salva o r�tulo do n� em r.
						
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
