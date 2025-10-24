package edb2.arvores.busca;

public class AvlTree {
	
	private NodeAvl root;
	
	
	public NodeAvl getRoot() {
		return root;
	}


	public void setInicio(NodeAvl root) {
		this.root = root;
	}

	//Busca de arvore binária
	
	public NodeAvl searchValue(NodeAvl node, int value){
		
		if(node == null) return null;
		
		if(node.value == value) {
			return node;
		}
		
		if(node.value < value) {
			return searchValue(node.right, value);
		}
		
		if(node.value > value) {
			return searchValue(node.left, value);
		}
		
		return null;
		
	}
	
	public int alturaNode(NodeAvl node) {
		
		if(node == null) return 0;
		
		return node.altura;
	}
	
	public void updateAltura(NodeAvl node){
		
		if(node != null) {
			
			node.altura = Math.max(alturaNode(node.left), alturaNode(node.right)) + 1;
			
		}
		
		
	}


}
