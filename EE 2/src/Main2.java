/*Program Information
Author:
Oliver Szavuj
22.04.2019
*/
import java.util.ArrayList;
public class Main2{
	public static final int COUNT = 1000; 
	public static final int SEARCH_COUNT = 100;
	public static int used = 0;
	public static void main(String [] args) {
//		for(int x = 0; x < 100; x++) {
			
			//String stringarr[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
			NodeFactory2<String> nodes = new NodeFactory2<String>();
			ArrayList<String> contents=new ArrayList<String>();
			ArrayList<String> searchOrder=new ArrayList<String>();
			ArrayList<String> contentsRemove = new ArrayList<String>();
			for(int i = 0; i<=COUNT; i++) {
				contents.add(Integer.toString(i));
				contentsRemove.add(Integer.toString(i));
				//nodes.insertStartRandom(nodes.root,Integer.toString(p++));
				//nodes.insertStartRandom(nodes.root,stringarr[i]);
			}
			
			for(int i = 0; i<COUNT; i++) { 
				int nextRand = getRandomInt();
				contentsRemove.get(nextRand);
				nodes.insert(nodes.root,contentsRemove.get(nextRand));
				contentsRemove.remove(nextRand);
			}
			
			for(int i = 0; i<SEARCH_COUNT; i++) {
				searchOrder.add(contents.get(usingMathClass()));
				//System.out.println(searchOrder.get(i));
				//System.out.println("a" + contents.size());
			}
		
			//very stupid thing I used to have to check on nodes
		//		System.out.println("root " + nodes.root.item);
		//		if(nodes.root.left != null) {
		//			System.out.println("left1" + nodes.root.left.item);
		//			if(nodes.root.left.left != null) {
		//				System.out.println("left left 2" + nodes.root.left.left.item);
		//				if(nodes.root.left.left.right != null) {
		//					System.out.println("left left right 3" + nodes.root.left.left.right.item);
		//				}
		//				if(nodes.root.left.left.left != null) {
		//					System.out.println("left left left 3" + nodes.root.left.left.left.item);
		//				}
		//			}
		//			if(nodes.root.left.right != null) {
		//				System.out.println("left right 2" + nodes.root.left.right.item);
		//				if(nodes.root.left.right.left != null) {
		//					System.out.println("left right left 3" + nodes.root.left.right.left.item);
		//				}
		//				if(nodes.root.left.right.right != null) {
		//					System.out.println("left right right 3" + nodes.root.left.right.right.item);
		//				}
		//			}
		// 
		//		}
		//		if(nodes.root.right != null) {
		//			System.out.println("right1" + nodes.root.right.item);
		//			if(nodes.root.right.right != null) {
		//				System.out.println("right right 2" + nodes.root.right.right.item);
		//				if(nodes.root.right.right.right != null) {
		//					System.out.println("right right right 3" + nodes.root.right.right.right.item);
		//				}
		//				if(nodes.root.right.right.left != null) {
		//					System.out.println("right right left 3" + nodes.root.right.right.left.item);
		//				}
		//			}
		//			if(nodes.root.right.left != null) {
		//				System.out.println("right left 2" + nodes.root.right.left.item);
		//				if(nodes.root.right.left.left != null) {
		//					System.out.println("right left left 3" + nodes.root.right.left.left.item);
		//				}
		//				if(nodes.root.right.left.right != null) {
		//					System.out.println("right left right 3" + nodes.root.right.left.right.item);
		//					System.out.println("1" + nodes.root.right.left.right.parent.parent.parent.item);
		//				}
		//			}
		//
		//		}
			//nodes.printInorder(nodes.root);
			//System.out.println();
			//nodes.print2D(nodes.root);
			//System.out.println("******************************************");
			
			long startUnbalanced = System.nanoTime();
			for(int i = 0; i < SEARCH_COUNT; i++) {
				//System.out.println("searching for" + searchOrder.get(i));
				nodes.search(searchOrder.get(i));
			}
			long finishUnbalaced = System.nanoTime();
			long timeElapsedUnbalanced = finishUnbalaced - startUnbalanced;
			System.out.println("unbalanced search:  " + timeElapsedUnbalanced);
			
			long startT2V = System.nanoTime();
			long startLong = System.nanoTime();
			
			//nodes.print2D(nodes.root);
			nodes.treeToVine(nodes.root);
			long finishT2V = System.nanoTime();
			//nodes.print2D(nodes.root);
			//System.out.println("******************************************");
			long startV2T = System.nanoTime();
			nodes.vineToBST();
			long finishV2T = System.nanoTime();
			//System.out.println("Balanced Tree: ******************************************");
			nodes.print2D(nodes.root);
			//System.out.println("root " + nodes.root.item);
			
		
			for(int i = 0; i < SEARCH_COUNT; i++) {
				//System.out.println("searching for" + searchOrder.get(i));
				nodes.search(searchOrder.get(i));
			}
			long finishBlanaced = System.nanoTime();
			long timeElapsedBalanced = finishBlanaced - startLong;
			long timeElapsedT2V = finishT2V - startT2V;
			long timeElapsedV2T = finishV2T - startV2T;
			System.out.println("balance and search: " + timeElapsedBalanced + "  T2V:" + timeElapsedT2V + "  V2T:" + timeElapsedV2T);
			System.out.println("ratio: "+ (double)timeElapsedUnbalanced/(double)timeElapsedBalanced);
		    //nodes.print2D(nodes.sortedListToBalancedTree(0,nodes.count)); 
			//nodes.scripted();
			used = 0;
//		}
	}
	
	
	public static int getRandomInt() {
		int max = COUNT - used; 
        int min = 1; 
        int range = max - min ; 
		int rand = (int)(Math.random() * range) + min; 
		used++;
		return rand;
	}
   public static int usingMathClass() {
	   double randomDouble = Math.random();
	   randomDouble = randomDouble * COUNT + 1;
	   int randomInt = (int) randomDouble;
	   return randomInt;
   }
		
}