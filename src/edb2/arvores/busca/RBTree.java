package edb2.arvores.busca;

class NodeRB{
	
	//Red = 1, Black  = 0
	Boolean color;
	int data;
	NodeRB parent;
	NodeRB left;
	NodeRB right;
	
	public NodeRB(int data) {
		
		color = true;
		this.data = data;
		parent = null;
		left = null;
		right = null;
	}
}

public class RBTree {
	
	private NodeRB root;

	public NodeRB getRoot() {
		return root;
	}

	public void setRoot(NodeRB root) {
		this.root = root;
	}
	

	
	private NodeRB rotateLeft(NodeRB node) {
		
		NodeRB nodeRight = node.right;
		NodeRB nodeRL = nodeRight.left;
		
		nodeRight.left = node;
		node.right = nodeRL;

	    nodeRight.parent = node.parent; 
	    
	    node.parent = nodeRight;
	    
	    if (nodeRL != null) {
	    	
	        nodeRL.parent = node;
	        
	    }
		
		return nodeRight;
		
	}
	
	private NodeRB rotateRight(NodeRB node) {
		
		NodeRB nodeLeft = node.left;
		
		NodeRB nodeLR = nodeLeft.right;
		
		nodeLeft.right = node;
		
		node.left = nodeLR;
		
	    nodeLeft.parent = node.parent;
	    
	    node.parent = nodeLeft;
	    
	    if (nodeLR != null) {
	    	
	        nodeLR.parent = node;
	        
	    }
		
		return nodeLeft;
		
	}
	

	public NodeRB searchValue(NodeRB node, int value){
		
		if(node == null) return null;
		
		if(node.data == value) {
			return node;
		}
		
		if(node.data < value) {
			return searchValue(node.right, value);
		}
		
		if(node.data > value) {
			return searchValue(node.left, value);
		}
		
		return null;
		
	}
	
	public void insertValue(int value) {
	    
	    NodeRB node = new NodeRB(value);

	    NodeRB y = null;
	    NodeRB x = this.root;

	    while (x != null) {
	    	
	        y = x;
	        
	        if (node.data < x.data) {
	        	
	            x = x.left;
	            
	        } else {
	        	
	            x = x.right;
	            
	        }
	    }
	    
	    node.parent = y;
	    
	    if (y == null) {
	    	
	        root = node;
	        
	    } else if (node.data < y.data) {
	    	
	        y.left = node;
	        
	    } else {
	    	
	        y.right = node;
	        
	    }


	    fixupInsert(node);
	}
	
	private void fixupInsert(NodeRB node) {
	    
	    while (node != root && node.parent.color == true) { 
	        
	        NodeRB father = node.parent;
	        NodeRB grandpa = father.parent;

	        if (father == grandpa.left) {
	            NodeRB uncle = grandpa.right;

	            if (uncle != null && uncle.color == true) {
	                father.color = false;
	                uncle.color = false;
	                grandpa.color = true;
	                node = grandpa; 
	                continue; 
	            } 
	            
	            if (node == father.right) {
	                node = father; 
	                grandpa.left = rotateLeft(node);
	                father = node.parent;
	                grandpa = father.parent;
	            }

	            NodeRB greatGrandpa = grandpa.parent;
	            
	            father.color = false;
	            grandpa.color = true;

	            NodeRB newSubRoot = rotateRight(grandpa);
	            
	            if (greatGrandpa == null) {
	                root = newSubRoot;
	            } else if (grandpa == greatGrandpa.left) { 
	                greatGrandpa.left = newSubRoot;
	            } else {
	                greatGrandpa.right = newSubRoot;
	            }
	            
	            break; 
	        } 
	        
	        else {
	            NodeRB uncle = grandpa.left;

	            if (uncle != null && uncle.color == true) {
	                father.color = false;
	                uncle.color = false;
	                grandpa.color = true;
	                node = grandpa; 
	                continue;
	            }

	            if (node == father.left) {
	                node = father;
	                grandpa.right = rotateRight(node);
	                father = node.parent;
	                grandpa = father.parent;
	            }

	            NodeRB greatGrandpa = grandpa.parent;
	            
	            father.color = false;
	            grandpa.color = true;

	            NodeRB newSubRoot = rotateLeft(grandpa);
	            
	            if (greatGrandpa == null) {
	                root = newSubRoot;
	            } else if (grandpa == greatGrandpa.left) {
	                greatGrandpa.left = newSubRoot;
	            } else {
	                greatGrandpa.right = newSubRoot;
	            }
	            
	            break; 
	        }
	    }
	    
	    root.color = false;
	}
	
    void printTree(NodeRB node){
    	
        if(node == null){
            System.out.println("\nA árvore está vazia");
            return;
        }

        if(node.left != null) printTree(node.left);
        
        System.out.print(node.data + " ");
        
        if(node.right != null) printTree(node.right);
    }
	
}
	