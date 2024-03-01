package aula_05_leitura;

import java.util.Scanner; //Importa o método de scanner(leitura).

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); //Cria o Scanner de leitura.
		System.out.println("Digite seu nome:"); //Pergunta o nome.
		String nome = in.nextLine(); //Lê o nome digitado no console e o declara com variavel nome.
		System.out.println("Seu nome é "+nome); //Exibe o nome digitado com o conteúdo scanneado na variavel nome.		
	}
}
