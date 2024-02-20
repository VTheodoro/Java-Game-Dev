package aula_02_condicoes;

public class teste_condicoes {

	public static void main(String[] args) {
		String nome = "Victor"; //Palavras e Letras
		int idade = 17; //Numeros Inteiros
		
		if(nome.equals("Victor")) {
			System.out.println("O nome é Victor");
		}
		else {
			System.out.println("O nome não é Victor, O nome é "+nome);
		}
		
		
if(idade == 17) { // Se a idade for igual a 17...
	System.out.println("A idade é igual a 17");
}
else { //Caso Contrario...
	System.out.println("A idade não é 17. A idade é "+idade);
}
	}	
}
