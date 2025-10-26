package edb2.arvores.busca;

class NodeAvl{
	
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

public class AvlTree{
	
	private NodeAvl root;
	
	
	public NodeAvl getRoot() {
		return root;
	}
	
	public void setRoot(NodeAvl node) {
		this.root = node;
	}
	
	public AvlTree() {
		super();
		this.root = null;
	}


	//Busca de árvore binária
	

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
	
	private int alturaNode(NodeAvl node) {
		
		if(node == null) return 0;
		
		return node.altura;
	}
	
	private void updateAltura(NodeAvl node){
		
		if(node != null) {
			
			node.altura = Math.max(alturaNode(node.left), alturaNode(node.right)) + 1;
			
		}
	}
	
	private NodeAvl rotateLeft(NodeAvl node) {
		
		NodeAvl nodeRight = node.right;
		
		NodeAvl nodeRL = nodeRight.left;
		
		nodeRight.left = node;
		
		node.right = nodeRL;
		
		updateAltura(node);
		
		updateAltura(nodeRight);
		
		return nodeRight;
		
	}
	
	
	
	private NodeAvl rotateRight(NodeAvl node) {
		
		NodeAvl nodeLeft = node.left;
		
		NodeAvl nodeLR = nodeLeft.right;
		
		nodeLeft.right = node;
		
		node.left = nodeLR;
		
		updateAltura(node);
		
		updateAltura(nodeLeft);
		
		return nodeLeft;
		
	}
	
	private NodeAvl rotateRL(NodeAvl node){
		
		node.right = rotateRight(node.right);
		node = rotateLeft(node);
		
		return node;
	}
	
	private NodeAvl rotateLR(NodeAvl node) {
		
		node.left =  rotateLeft(node.left);
		node = rotateRight(node);
		
		return node;
		
	}
	
	
	public NodeAvl insertValue(NodeAvl node, int value) {
		
		if(node == null) return new NodeAvl(value);
		
		else{
			if(value < node.value) {
				
				node.left = insertValue(node.left, value);
				
				if(alturaNode(node.left) - alturaNode(node.right) == 2) {
					
					if(value < node.left.value) node = rotateRight(node);
					
					else {
						node = rotateLR(node);
					}
				}
			}
			else{
				node.right = insertValue(node.right, value);
				
				if(alturaNode(node.right) - alturaNode(node.left) == 2) {
					
					if(value > node.right.value) node = rotateLeft(node);
					
					else {
						node = rotateRL(node);
					}
				}
			}
			updateAltura(node);
		}
		return node;
	}
	
	private NodeAvl Sucessor(NodeAvl node) {
		
        if (node.left != null)
            return Sucessor (node.left);

        else
            return node;
	    
	}
	
	public NodeAvl removeValue(NodeAvl node, int key){

	        if (node == null) return node;

	        if (key < node.value) node.left = removeValue(node.left, key);

	        else if (key > node.value) node.right = removeValue(node.right, key);

	        else{
	        	
	            if (node.right == null) return node.left;

	            else if (node.left == null) return node.right;

	            else{
	            	
	                NodeAvl temp = Sucessor(node.right);
	                
	                node.value = temp.value;
	                
	                node.right = removeValue(node.right, node.value);
	            }
	        }

	        updateAltura(node);

	        int balance = alturaNode(node.left) - alturaNode(node.right);

	        if (balance > 1) {

	            if (alturaNode(node.left.left) - alturaNode(node.left.right) >= 0) {

	                node = rotateRight(node);
	            } else {

	                node = rotateLR(node);
	            }
	        }
	        
	        else if (balance < -1) {

	            if (alturaNode(node.right.left) - alturaNode(node.right.right) <= 0) {

	                node = rotateLeft(node);
	            } else {

	                node = rotateRL(node);
	            }
	        }

	        return node;
	    
	 }
	
    void printTree(NodeAvl node){
    	
        if(node == null){
            System.out.println("\nA árvore está vazia");
            return;
        }

        if(node.left != null) printTree(node.left);
        
        System.out.print(node.value + " ");
        
        if(node.right != null) printTree(node.right);
    }
}
