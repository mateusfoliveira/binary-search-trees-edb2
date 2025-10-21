package edb2.arvores.busca;

import java.util.Scanner;

public class Sistema {
	
	public void menu(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual árvore você deseja visualizar?");
		
		System.out.println("1 - AVL/ n 2 - Rubro-Negra");
		
		int entrada = scanner.nextInt();
		
		switch(entrada){
			case 1:
				//criarArvoreAvl();
				break;
			
			case 2:
				//criarArvoreRB();
				break;
		}
		scanner.close();
	}
	
	public void criarArvoreAvl() {
		
	}
	
	public void criarArvoreRB() {
		
	}
	
}
