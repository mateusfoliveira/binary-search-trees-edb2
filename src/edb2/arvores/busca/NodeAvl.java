package edb2.arvores.busca;

public class NodeAvl {
	
	int altura;
	int value;
	NodeAvl left;
	NodeAvl right;


	public NodeAvl(int valor) {
		
		this.left = null;
		this.right = null;
		this.value = valor ;
		this.altura = 1;
		
	}
}
