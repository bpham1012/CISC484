import java.io.IOException;
import java.lang.Integer;

import javax.lang.model.util.ElementScanner6;

import java.util.Random;

public class Test {

	int l;
	int k;
	String trainingSetLocation;
	String validationSetLocation;
	String testSet;
	boolean toPrint;
	DTree d;
	UnitSet testtree;
	
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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//String csvFile = "/Users/Rachel/Desktop/DT/training_set2.csv";
		
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
			System.out.println('Please enter "yes" or "no" for toPrint value');
			System.exit(0);
		}
		
		testTree = new UnitSet(csvFile);
		
		DTree d = new DTree(testTree, 0); // Original tree
		
		/* algorithm call here */		
		postPruning(l, k);
		
		System.out.print(d.root);

		// PRUNING STARTS HERE

	}

}
