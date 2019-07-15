/*Program Information
Author:
Oliver Szavuj
22.04.2019
*/


public class NodeFactory2<Item>{
	public BinaryNode root;
	public int depth;
	public int maxDepth;
	public int spaceCount = 3; 
	
	
	public class BinaryNode{
		public Item item;
		BinaryNode left;
		BinaryNode right;
		BinaryNode parent;
		public int height;
		public BinaryNode(Item newItem, BinaryNode parent, int depth){
			this.item = newItem;
			this.left =null;
			this.right = null;
			this.parent = parent;
			this.height = depth;
		}
		
		public BinaryNode(){
			this.item =null;
			this.left =null;
			this.right = null;
			this.parent = null;
		}
	}


	public void insertStartRandom(BinaryNode currentNode, Item newItem, int depth) {
		depth++;
		if(root == null) {
			insertRoot(newItem);
			return;
		}
//        int max = 1; 
//        int min = 0; 
//        int range = max - min + 1; 
//  
//		int rand = (int)(Math.random() * range) + min; 
		//System.out.println(rand);
		if(Integer.valueOf(currentNode.item.toString()) > Integer.valueOf(newItem.toString())) {
			if (currentNode.left != null) {
				insertStartRandom(currentNode.left, newItem, depth);
			} else {
				if(Integer.valueOf(currentNode.item.toString()) > Integer.valueOf(newItem.toString())) {
					currentNode.left = new BinaryNode(newItem, currentNode, depth);
					if (depth>maxDepth) {
						maxDepth = depth;
					}
					depth = 1;
					return;
				}
				else if(Integer.valueOf(currentNode.item.toString()) < Integer.valueOf(newItem.toString())) {
					currentNode.right = new BinaryNode(newItem, currentNode, depth);
					if (depth>maxDepth) {
						maxDepth = depth;
					}
					depth = 1;
					return;
				}
			}
		}
		else if(Integer.valueOf(currentNode.item.toString()) < Integer.valueOf(newItem.toString())) {
			if (currentNode.right != null) {
				insertStartRandom(currentNode.right, newItem, depth);
			} else {
				if(Integer.valueOf(currentNode.item.toString()) > Integer.valueOf(newItem.toString())) {
					currentNode.left = new BinaryNode(newItem, currentNode, depth);
					if (depth>maxDepth) {
						maxDepth = depth;
					}
					depth = 1;
					return;
				}
				else if(Integer.valueOf(currentNode.item.toString()) < Integer.valueOf(newItem.toString())) {
					currentNode.right = new BinaryNode(newItem, currentNode, depth);
					if (depth>maxDepth) {
						maxDepth = depth;
					}
					depth = 1;
					return;
				}
			}
		}
		
	}
	
	public void insertRoot(Item newItem) {
		root = new BinaryNode();
		root.item = newItem;
		root.height = 1;
		System.out.println("wE IN");
		maxDepth = 1;
	}


	public void printInorder(BinaryNode current){ 
        if (current == null) 
            return; 
        printInorder(current.left); //left side
        
        //data
        System.out.print(current.item + " ");
  
        //right side
        printInorder(current.right); 
    }
	
	public void print2DUtil(BinaryNode root, int space)  {   
	    if (root == null)  
	        return;  
	    space += spaceCount;
	    print2DUtil(root.right, space);  
 
	    System.out.print("\n");  
	    for (int i = spaceCount; i < space; i++)  
	        System.out.print(" ");  
	    System.out.print(root.item );  
	    
	    print2DUtil(root.left, space);  
	}  
	  
	public void print2D(BinaryNode root){  
	    print2DUtil(root, 0);  
	} 
	
	//Flight stuff
	
//	public  void treeToVine() {
//		BinaryNode tail = root;
//		BinaryNode rest = tail.right;
//		while(rest!= null) {
//			System.out.println(rest.item);
//			if(rest.left == null) {
//				tail = rest;
//				rest = rest.right;
//			}else {
//				BinaryNode temp = rest.left;
//				rest.left = temp.right;
//				temp.right = rest;
//				rest = temp;
//				tail.right = temp;	
//			}
//		}
	
	public int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
	public void rightRotate(BinaryNode y) {
		BinaryNode temp = y.parent;
		y.parent.left = y.right;
		y.right.parent = y.parent;
		//y.right = null;
		y.right = y.parent;
		//C is free of A

		//SWITCH PARENTS
		if (temp.item.toString().equals(root.item.toString())) {
			root = y;
			System.out.println("aaa");
		} else if (temp.parent.left.item.toString().equals(temp.item.toString())) {
			temp.parent.left = y;
			y.parent = temp.parent;
		} else {
			System.out.println("aaa");
			temp.parent.right = y;
			y.parent = temp.parent;
		}
		
		public void leftRotate(BinaryNode y) {
			BinaryNode temp = y.parent;
			y.parent.left = y.right;
			y.right.parent = y.parent;
			//y.right = null;
			y.right = y.parent;
			//C is free of A

			//SWITCH PARENTS
			if (temp.item.toString().equals(root.item.toString())) {
				root = y;
				System.out.println("aaa");
			} else if (temp.parent.left.item.toString().equals(temp.item.toString())) {
				temp.parent.left = y;
				y.parent = temp.parent;
			} else {
				System.out.println("aaa");
				temp.parent.right = y;
				y.parent = temp.parent;
			}
		
		
//		Let P be Q's left child.
//		Set Q's left child to be P's right child.
//		[Set P's right-child's parent to Q]
//		Set P's right child to be Q.
//		[Set Q's parent to P]
    } 
  
    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
	BinaryNode leftRotate(BinaryNode x) { 
		BinaryNode y = x.right; 
		BinaryNode T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights
        if(y.left != null && y.right != null)
        	y.height = max(y.left.height, y.right.height) + 1; 
        if(x.left != null && x.right != null)
        	x.height = max(x.left.height, x.right.height) + 1;  
  
        // Return new root 
        return y; 
    }
	void scripted(){
		Item b = (Item) "B";
		Item a = (Item) "A";
		Item d = (Item) "d";
		Item c = (Item) "c";
		Item y = (Item) "y";
	
		insertRoot(b);
		root.left = new BinaryNode(a, root, 2);
		root.left.left = new BinaryNode(d, root.left, 3);
		root.left.right = new BinaryNode(c, root.left, 3);
		root.right = new BinaryNode(y, root.right, 2);
		System.out.println("here is the beef:" + root.left.parent.item.toString());
		print2D(root);
		rightRotate(root.left);
		print2D(root);
	}
	
}
