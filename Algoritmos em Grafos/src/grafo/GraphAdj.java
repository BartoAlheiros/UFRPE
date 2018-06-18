package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphAdj extends Graph {
	ArrayList<Node> nodes;

	public GraphAdj(ArrayList<Node> nodes) {
		super();
		this.nodes = nodes;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void carregaArquivo() {
		FileReader arq;

		try {
			arq = new FileReader("./grafos/grafo1.grf");

			BufferedReader lerArq = new BufferedReader(arq);

			// lê a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* Laço que percorre todas as linhas do arquivo e salva(...)*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = "", r = ""; // r é o rótulo do nó.
				String[] strB = linha.split(" ");
				ArrayList<Node> adj = new ArrayList<>(); // adj é a lista de adjacências do nó. 

				/* Preenche a lista de adjacências adj */
				while (strB[j].equals('\n') == false) {
					Node node = new Node(strB[0], Integer.parseInt(strB[j])); // cria um novo nó para comparar com o nó da iteração(for each). Se não existir nenhum nó com o mesmo rótulo ou valor, o novo nó é adicionado à lista de nós do grafo.
					if (j == 0 & !(this.nodes.contains(node))) {
						r = strB[0]; // se a posição do contador for 0, insere a string lida em uma variável v do tipo String.
						adj.add(node);
					} else {

					}
				}
				j++;	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
