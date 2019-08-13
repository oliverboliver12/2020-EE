import java.util.ArrayList;
import java.util.Stack;

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
	boolean changedRoot = false;
	//public ArrayList<BinaryNode> BinaryNodeArrayList = new ArrayList<BinaryNode>();
	int nodeCount = 0;
	
	
	public class BinaryNode{
		public Item item;
		BinaryNode left = null;
		BinaryNode right = null;
		BinaryNode parent = null;
		public int height;
		public BinaryNode(Item newItem, BinaryNode parent, int depth){
			this.item = newItem;
			this.left =null;
			this.right = null;
			this.parent = parent;
			this.height = depth;
		}
		public BinaryNode(Item newItem){ // I use this for the balancing of my tree
			this.item = newItem;
			this.left =null;
			this.right = null;
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
		root.parent = null;
		root.item = newItem;
		root.height = 1;
		maxDepth = 1;
	}


	public void printInorder(BinaryNode current){ 
		BinaryNode pRoot = new BinaryNode();
        if (current == null) 
            return; 
        printInorder(current.left);
        
        //BinaryNodeArrayList.add(current);
        pRoot.right = current;
  
        printInorder(current.right);
        print2D(pRoot);
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
	    System.out.print("\n"); 
	}  
	  
	public void print2D(BinaryNode root){  
	    print2DUtil(root, 0);  
	} 

	
//	BinaryNode sortedListToBalancedTree(int start, int end) { 
//		if (start > end) { 
//			return null; 
//		} 
//		int mid = (start + end) / 2; 
//        BinaryNode node = new BinaryNode(BinaryNodeArrayList.get(mid).item); 
//		node.left = sortedListToBalancedTree(start, mid - 1); 
//		node.right = sortedListToBalancedTree(mid + 1, end);   
//		return node; 
//    } 
  
      
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
	
//	public int max(int a, int b) { 
//        return (a > b) ? a : b; 
//    } 
//	public boolean checkConditions(BinaryNode pivot) {
//		if(pivot.parent != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	public void rightRotate(BinaryNode y) {
		BinaryNode doubleParent = null;
		BinaryNode parent = y.parent;
		BinaryNode yRightChild = y.right;
		
//		try {
			if(y.parent != null) {
				y.parent = parent.parent;
				if(parent.parent != null) {
					doubleParent = parent.parent;
					System.out.println("PARENT ASSIGNED");
					System.out.println(doubleParent);
				}
				
			}
			parent.parent  = y;
			parent.left = null;
			parent.left = yRightChild;
			//yRightChild.parent = null;
			if(yRightChild != null)
				yRightChild.parent = parent;
			y.right = parent;
			//yRightChild = parent;
			//y.right.right.parent = y.right;
			//y.right.left.parent = y.right;
			//C is free of A
//		} catch(NullPointerException e) {
//			System.out.println("EXCEPTION");
//		}
		//SWITCH PARENTS
		if (parent.item.toString().equals(root.item.toString())) {
			System.out.println("changedRoot");
			changedRoot = true;
			root.parent = y;
			root = y;
		}
		if(doubleParent != null) {
			System.out.println("null1 entered: " + doubleParent.item);
			if(doubleParent.left != null) {
				System.out.println("null2 entered");
				if (doubleParent.left.item.toString().compareTo(parent.item.toString()) == 0) {
					System.out.println("DING2");
					doubleParent.left = y;
				}
			}
			if(doubleParent.right != null) {
				System.out.println("null3 entered");
				 if (doubleParent.right.item.toString().compareTo(parent.item.toString()) == 0){
					 System.out.println("DING3");
					 doubleParent.right = y;
				 }
			}
			
		}
		
	}
	public void leftRotate(BinaryNode y) {
		BinaryNode doubleParent = null;
		BinaryNode parent = y.parent;
		BinaryNode yLeftChild = y.left;
		
//		try {
		if(y.parent != null) {
			y.parent = parent.parent;
			if(parent.parent != null) {
				doubleParent = parent.parent;
				System.out.println("PARENT ASSIGNED");
				System.out.println(doubleParent);
			}
			
		
		parent.parent  = y;
		parent.right = null;
		parent.right = yLeftChild;
		//yRightChild.parent = null;
		if(yLeftChild != null)
			yLeftChild.parent = parent;
		y.left = parent;
//		} catch(NullPointerException e) {
//			System.out.println("EXCEPTION");
//		}
		//SWITCH PARENTS
			if (parent.item.toString().equals(root.item.toString())) {
				System.out.println("changedRoot");
				changedRoot = true;
				root.parent = y;
				root = y;
			}
			if(doubleParent != null) {
				System.out.println("null1 entered: " + doubleParent.item);
				if(doubleParent.left != null) {
					System.out.println("null2 entered");
					if (doubleParent.left.item.toString().compareTo(parent.item.toString()) == 0) {
						System.out.println("DING2");
						doubleParent.left = y;
					}
				}
				if(doubleParent.right != null) {
					System.out.println("null3 entered");
					 if (doubleParent.right.item.toString().compareTo(parent.item.toString()) == 0){
						 System.out.println("DING3");
						 doubleParent.right = y;
					 }
				}
				
			}
		} else if (y.parent == null) {
			BinaryNode yRightChild = y.right;
			
			y.parent = yRightChild;
			yRightChild.left = y;
			y.right = null;
			root = yRightChild;
			root.parent = null;
		}
			
	}
	
//	public BinaryNode leftRotateAdapted(BinaryNode n) {
//		if(n.right != null) {
//			BinaryNode rightChild = n.right;
//			n.right = rightChild.right;
//			rightChild.right = rightChild.left;
//			rightChild.left = n.left;
//			n.left = rightChild;
//			
//			String temp = n.item.toString();
//			n.item = rightChild.item;
//			rightChild.item = (Item) temp;
//			
//		}
//		return n;
//		
//	}
	
	void rightRotateTest(BinaryNode root) {
	    try {
	    	BinaryNode rootLeftChild = root.left;
	    	root.left = rootLeftChild.right;
	    	rootLeftChild.right = root;
	    	root.parent = rootLeftChild;
	    	}
	    catch(NullPointerException e) {
	    
	    }
	}
	    
		public void rotateLeft(BinaryNode grandParent, BinaryNode parent, BinaryNode rightChild) {
			if (null != grandParent) {
				grandParent.right = rightChild;
			} else {
				root = rightChild;
			}
			parent.right = rightChild.left;
			rightChild.left = parent;
		}
  
    
	void scripted(){

		Item b = (Item) "B";
		Item a = (Item) "A";
		Item d = (Item) "d";
		Item c = (Item) "c";
		Item y = (Item) "y";
		//Item o = (Item) "o";
		//Item p = (Item) "p";
	
		insertRoot(b);
		root.left = new BinaryNode(a, root, 1);
		//root.left.left = new BinaryNode(d, root.left, 3);
		//root.left.right = new BinaryNode(c, root.left, 3);
		//root.right = new BinaryNode(y, root.right, 3);
		//root.left.right.left = new BinaryNode(o, root.left.right, 4);
		//root.left.left.right = new BinaryNode(p, root.left.left, 4);
		print2D(root);
		rightRotate(root.left);
		print2D(root);
		leftRotate(root.right);
		print2D(root);

	}
	


	void LLRotate (BinaryNode curent) {
		changedRoot = false;
		BinaryNode tempRoot = root;
		BinaryNode currentNode = curent;
		while (currentNode != null) {

			while(currentNode.left != null) {
				System.out.println("AAA" + currentNode.left.item);
				rightRotate(currentNode.left);
				currentNode = currentNode.parent;
				if(changedRoot == true) {
					System.out.println("BBB");
					LLRotate(root);
					return;
				}
			}
//			System.out.println("currently" + currentNode.item);
//			System.out.println("_______________________");
//			print2D(root);
//			System.out.println("_______________________");
			currentNode = currentNode.right;
			nodeCount++;
		}	
	}
	
//	void t2v(BinaryNode root) {
//		BinaryNode tail = root;
//		BinaryNode rest = tail.right;
//		while (rest != null) {
//			if (rest.left == null) {
//				tail = rest;
//				rest = rest.right;
//			} else {
//				BinaryNode temp = rest.left;
//				rest.left = temp.right;
//				temp.right = rest;
//				rest = temp;
//				tail.right = temp;
//			}
//		}
//	}
	
//	void rebuildTree() {
//		double expected = 2;
//		//double expected = (nodeCount - Math.pow(2,((Math.log(nodeCount) / Math.log(2)))));
//		System.out.println("   " + expected);
//		BinaryNode currentNode1 = root;
//		for(int i = 0; i< expected; i++) {
//			if(i==0) {
//				leftRotate(currentNode1);
//				currentNode1 = root;
//				print2D(root);
//				//System.out.println(root.right.item);
//			} else {
//				leftRotateAdapted(currentNode1.right);
//				currentNode1 = currentNode1.right;
//			}
//		}
//		int count = nodeCount; 
//		while (count > 1) {
//			count /= 2;
//			leftRotateAdapted(root);
//			BinaryNode currentNode2 = root;
//			for(int i = 0; i < count - 1; i++) {
//				leftRotateAdapted(currentNode2.right);
//				currentNode2 = currentNode2.right;
//			}
//		}
//		
//		
//		
////		for(int i = 0; i <expected; i++) {
////			newRoot = leftRoateCopy(newRoot);
////			root = newRoot.right;
////			for(int j = 0; j < nodeCount / 2 - 1; j++) {
////				root = leftRoateCopy(root);
////				root = root.right;
////			}
////			nodeCount >>=1;
////		}
////		print2D(root);
//
//	}
	
	public void createPerfectBST(){
		int m = greatestPowerOf2LessThanN(nodeCount + 1) - 1;
		makeRotations(nodeCount - m);
		while (m > 1)
			makeRotations(m /= 2);
	}
		 
	private int greatestPowerOf2LessThanN(int n){
		int x = MSB(n);//MSB
		return (1 << x);//2^x
	}
		 
	public int MSB(int n){
		int ndx = 0;
		while (1 < n) {
			n = (n >> 1);
			ndx++;
		}
		return ndx;
	}
	
	public void makeRotations(int bound){
		BinaryNode grandParent = null;
		BinaryNode parent = root;
		BinaryNode child = root.right;
		for (; bound > 0; bound--) {
			try {
				if (null != child) {
					rotateLeft(grandParent, parent, child);
					grandParent = child;
					parent = grandParent.right;
					child = parent.right;
					} else {
						break;
					}
				} catch (NullPointerException e) {
					break;
					}
			}
		}
}

