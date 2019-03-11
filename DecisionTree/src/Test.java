import java.io.IOException;
import java.lang.Integer;

import javax.lang.model.util.ElementScanner6;

import java.util.Random;

public class Test {

	
	
	public static DTree postPruning(int l, int k){

		DTree d = new DTree(testtree,0);
		DTree dBest = d;
		int dBestAcc;

		for (int i = 1; i <= l; i++) {
			DTree dPrime = d;
			Random rand = new Random();
			int m = rand.nextInt(k) + 1;
			
			for (int j = 1; j <= m; j++) {
				int N = dPrime.N; 
				//order the nodes in D' from 1 to N
				Node[] treeAsList = convertToList(n); 
				int p = rand.nextInt(N) + 1;
				//replace subtree rooted at P in D' by a leaf node
				//assign majority class of the data subset at P to the leaf node
			}
			
			//evaluate the accuracy of D' on validation set
			int dPrimeAcc;
			if (dPrimeAcc > dBestAcc) {
				dBest = dPrime;
				dBestAcc = dPrimeAcc;
			}
		}
		return dBest;
	}
	
	private static List<Node> convertToList(Node n) {
		List<Node> result = new ArrayList<>();
		if (n.left != null) {
			result.addAll(convertToList(n.left);
		}
	
		if (n.right != null) {
			result.addAll(convertToList(n.right()));
		}
	
		result.add(n);
	
		return result;
	}
	
	public double calcAccuracy(DTree dPrime, String csvFile){
		UnitSet data = new UnitSet(csvFile);
		int correctInst = 0; //number of correctly classified instances
		Node root = dPrime.root;
		Node currNode; //current Node we're on

		for (List row : data){
			currNode = root;
			int attribute = root.attriId;
			int actualClass = row.get(row.size() - 1);
			int predClass = -1; //predicted class
			while(currNode.left != null || currNode.right != null){
				if(row.get(attribute) == 1 && currNode.left != null){
					currNode = currNode.left;
				}
				elif(row.get(attribute) == 0 && currNode.right != null){ // == 0
					currNode = currNode.right;
				}
			}//end while

			predClass = currNode.classType //assign predicted class to the instance
			if (actualClass == predClass){
				correctInst++;
			}

		} // end for		
	
		double accuracy = correctInst/(data.size());

		
	}
	public static void main(String[] args) throws IOException {
		int l;
		int k;
		String trainingSetLocation;
		String validationSetLocation;
		String testSet;
		boolean toPrint;
		DTree d;
		UnitSet testTree;
		
		// TODO Auto-generated method stub

		String csvFile = "/Users/Rachel/Desktop/DT/training_set2.csv";
		
		/* user input */
		if(args.length != 6){
			System.out.println("Incorrect number of parameters, need 6");
			System.out.println("args length: " + args.length);
			System.exit(0);
		}

		/* assigning variables */
		l = Integer.parseInt(args[0]);
		k = Integer.parseInt(args[1]);
		trainingSetLocation = args[2];
		validationSetLocation = args[3];
		testSet = args[4];
		if(args[5] == "yes")
			toPrint = true;
		else if(args[5] == "no")
			toPrint = false;
		else{
			System.out.println("Please enter 'yes' or 'no' for toPrint value");
			System.exit(0);
		}
		
		testTree = new UnitSet(csvFile);
		
		d = new DTree(testTree, 0); // Original tree
		
		/* algorithm call here */		
		postPruning(l, k);
		
		System.out.print(d.root);

		// PRUNING STARTS HERE

	}

}
