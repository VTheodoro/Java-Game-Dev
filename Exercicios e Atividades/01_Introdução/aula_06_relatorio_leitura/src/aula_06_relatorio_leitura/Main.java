package aula_06_relatorio_leitura;

import java.util.Scanner; 
public class Main {

	public static void main(String[] args) {
		String nome, cidade;
		int anoNasc;
		
		Scanner in = new Scanner(System.in); 
				
		System.out.println("Digite seu nome:"); 
		nome = in.nextLine(); 

		System.out.println("Digite o nome da sua cidade:"); 
		cidade = in.nextLine(); 
		
		System.out.println("Digite seu ano de nascimento:"); 
		String inputAnoNasc = in.nextLine();  //lê o ano de nascimento em string.

		anoNasc = Integer.parseInt(inputAnoNasc); //Converte de String para Int.
		int idade = 2024-anoNasc; //realiza a subtração para descobrir a idade.
		
		System.out.println("Nome: "+nome);
		System.out.println("Cidade: "+cidade);
		System.out.println("Em 2024, "+nome+" tinha "+idade+" anos");
		
	}
}
