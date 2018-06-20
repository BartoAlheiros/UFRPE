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
			int c = entradaFormatada.read();
			
			while( c!=-1){
				if ((char) c == '\n')
					System.out.println("Achei um enter!");
	    	System.out.print( (char) c);
	    	c = entradaFormatada.read();
	    }
		
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo: %s.\n", e.getMessage());
		}

	}

}
