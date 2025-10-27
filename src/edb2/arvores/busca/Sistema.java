package edb2.arvores.busca;

import java.util.Scanner;

public class Sistema {
	
	public void menu(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual árvore você deseja visualizar?");
		
		System.out.println("1 - AVL \n2 - Rubro-Negra\n3 - Encerrar programa");
		
		int entrada = scanner.nextInt();
		
		switch(entrada){
			case 1:
				criarArvoreAvl(scanner);
				break;
			
			case 2:
				criarArvoreRb(scanner);
				break;
				
			case 3:
				scanner.close();
				return;
		}
		
		scanner.close();
	}
	
	public void criarArvoreAvl(Scanner scanner) {
		
		AvlTree tree = new AvlTree();
		
		while(true) {
			
			System.out.println("Escolha uma das opções:\n1 - Inserir elemento\n2 - Remover elemento\n3 - Buscar elemento\n4 - Visualizar árvore\n5 - Sair");
			
			int entrada = scanner.nextInt();
			scanner.nextLine();
		
			switch(entrada){

				case 1:
					System.out.println("Digite o valor que você deseja inserir:");
					
					int elemento = scanner.nextInt();
					scanner.nextLine();
					
					if(tree.searchValue(tree.getRoot(), elemento) != null) {
						System.out.println("O elemento já está na árvore!");
						break;
					}
					
					tree.setRoot(tree.insertValue(tree.getRoot(), elemento));
					
					System.out.println("AVL tree: ");
					tree.printTree(tree.getRoot());
					System.out.println("\n");
					
					break;
					
				case 2:
					System.out.println("Digite o valor que você deseja remover:");
					
					int removeElemento = scanner.nextInt();
					scanner.nextLine();
					
					if(tree.searchValue(tree.getRoot(), removeElemento) == null) {
						System.out.println("O elemento não está na árvore!\n");
						break;
					}
					
					tree.setRoot(tree.removeValue(tree.getRoot(), removeElemento));
					
					System.out.println("AVL tree: ");
					tree.printTree(tree.getRoot());
					System.out.println("\n");
					break;
					
				case 3:
					System.out.println("Digite o valor que você deseja buscar:");
					
					int acharElemento = scanner.nextInt();
					scanner.nextLine();
					
					NodeAvl foundNode = tree.searchValue(tree.getRoot(), acharElemento);
					
					if(foundNode != null) System.out.println("O valor " + foundNode.value + "foi encontrado!");
					
					else {
						System.out.println("Elemento não encontrado!");
					}
					
					break;
					
				case 4:
					tree.printTree(tree.getRoot());
					System.out.println("\n");
					break;
					
				case 5:
					scanner.close();
					return;
			}

		}
	}
	
	public void criarArvoreRb(Scanner scanner) {
		
		RBTree tree = new RBTree();
		
		while(true) {
			
			System.out.println("Escolha uma das opções:\n1 - Inserir elemento\n2 - Buscar elemento\n3 - Visualizar árvore\n4 - Sair");
			
			int entrada = scanner.nextInt();
			scanner.nextLine();
		
			switch(entrada){

				case 1:
					System.out.println("Digite o valor que você deseja inserir:");
					
					int elemento = scanner.nextInt();
					scanner.nextLine();
					
					if(tree.searchValue(tree.getRoot(), elemento) != null) {
						System.out.println("O elemento já está na árvore!");
						break;
					}
					
					tree.insertValue(elemento);
					
					System.out.println("AVL tree: ");
					tree.printTree(tree.getRoot());
					System.out.println("\n");
					
					break;
					
					
				case 2:
					System.out.println("Digite o valor que você deseja buscar:");
					
					int acharElemento = scanner.nextInt();
					scanner.nextLine();
					
					NodeRB foundNode = tree.searchValue(tree.getRoot(), acharElemento);
					
					if(foundNode != null) System.out.println("O valor " + foundNode.data + "foi encontrado!");
					
					else {
						System.out.println("Elemento não encontrado!");
					}
					
					break;
					
				case 3:
					
					tree.printTree(tree.getRoot());
					System.out.println("\n");
					break;
					
				case 4:
					scanner.close();
					return;
			}

		}
		
		
	}
	
}
