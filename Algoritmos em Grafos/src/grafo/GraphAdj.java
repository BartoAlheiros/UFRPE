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

			// l� a primeira linha do arquivo e armazena na variavel inteira numVertices
			int numVertices = Integer.parseInt(lerArq.readLine());   

			/* La�o que percorre todas as linhas do arquivo e salva(...)*/
			for (int i = 0; i < numVertices; i++) {
				int j = 0;
				String linha = "", r = ""; // r � o r�tulo do n�.
				String[] strB = linha.split(" ");
				ArrayList<Node> adj = new ArrayList<>(); // adj � a lista de adjac�ncias do n�. 

				/* Preenche a lista de adjac�ncias adj */
				while (strB[j].equals('\n') == false) {
					Node node = new Node(strB[0], Integer.parseInt(strB[j])); // cria um novo n� para comparar com o n� da itera��o(for each). Se n�o existir nenhum n� com o mesmo r�tulo ou valor, o novo n� � adicionado � lista de n�s do grafo.
					if (j == 0 & !(this.nodes.contains(node))) {
						r = strB[0]; // se a posi��o do contador for 0, insere a string lida em uma vari�vel v do tipo String.
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
