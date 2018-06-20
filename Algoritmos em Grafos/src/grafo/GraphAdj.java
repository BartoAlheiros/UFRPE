package grafo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraphAdj extends Graph {
	ArrayList<Node> nodes;

	/* Construtor para inicializar o grafo. A diferenca é que escolhemos utilizar 
	 * ArrayList em vez de Array. Não sendo, dessa forma, necessário passar como
	 * argumento o número N de Nós.*/
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
		FileInputStream entrada;

		try {
			arq = new FileReader("./grafos/grafo1.grf");
			entrada = new FileInputStream("./grafos/grafo1.grf");
			InputStreamReader entradaFormatada = new InputStreamReader(entrada);
			Graph g = new GraphAdj();
			BufferedReader lerArq = new BufferedReader(arq);
			
			// lê a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* Laço que percorre todas as linhas do arquivo após a primira.*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = lerArq.readLine();
				/* Pega próxima linha e a divide em cada espaco(" ") e salva em um Array(str). */
				String[] str = linha.split(" "); 
				ArrayList<Node> adj = new ArrayList<>(); // instanciando lista de adjacências do nó. 
				Node node = new Node(str[j]);		/* cria um novo nó, passando o rótulo do mesmo.*/

				/* adiciona o nó à lista nodes desta instância de grafo(this).*/
				this.nodes.add(node);
				j++;
				
				/* Preenchendo a lista de adjacências (adj) do nó. */
				while ( !(str[j].equals('\n') ) ) {
					if ( j == 0 & !(this.nodes.contains(node)) ) {
						node.setR(str[j]);
					} else if ( j != 0 ) {
						adj.add(node);
					}
					j++;
				}
				this.nodes.add(node);
			}
			lerArq.close();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo: %s.\n", e.getMessage());
		}

	}

}
