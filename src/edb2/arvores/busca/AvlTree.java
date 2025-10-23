package edb2.arvores.busca;

public class AvlTree {
	
	private NodeAvl inicio;
	
	
	public NodeAvl getInicio() {
		return inicio;
	}


	public void setInicio(NodeAvl inicio) {
		this.inicio = inicio;
	}

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

}
