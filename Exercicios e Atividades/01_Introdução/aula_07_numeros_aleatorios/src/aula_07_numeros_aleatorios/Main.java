package aula_07_numeros_aleatorios;

import java.util.Random;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in); //declara o scanner.
		Random rand = new Random(); //declara o random.
		
		int num;
		
		System.out.println("Digite um número:");
		String numInput = in.nextLine();
		
		num = Integer.parseInt(numInput); //converte o numero String para Int.
		
		double numAleatorio = rand.nextInt(num); //gera um numero aleatorio entre 0 até o numero determinado.
		//nesse caso, estamos pedindo um numero para ser definido como limite
		
		System.out.println("O número aleatório gerado entre 0 e "+num+" foi:");
		System.out.println(numAleatorio); //pega o numero aleatorio gerado
	}
	
}
