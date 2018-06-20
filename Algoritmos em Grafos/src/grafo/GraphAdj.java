package grafo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraphAdj extends Graph {
	ArrayList<Node> nodes;

	/* Construtor para inicializar o grafo. A diferenca � que escolhemos utilizar 
	 * ArrayList em vez de Array. N�o sendo, dessa forma, necess�rio passar como
	 * argumento o n�mero N de N�s.*/
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
			
			// l� a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* La�o que percorre todas as linhas do arquivo ap�s a primira.*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = lerArq.readLine();
				/* Pega pr�xima linha e a divide em cada espaco(" ") e salva em um Array(str). */
				String[] str = linha.split(" "); 
				ArrayList<Node> adj = new ArrayList<>(); // instanciando lista de adjac�ncias do n�. 
				Node node = new Node(str[j]);		/* cria um novo n�, passando o r�tulo do mesmo.*/

				/* adiciona o n� � lista nodes desta inst�ncia de grafo(this).*/
				this.nodes.add(node);
				j++;
				
				/* Preenchendo a lista de adjac�ncias (adj) do n�. */
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
