import java.io.IOException;
import java.lang.Integer;

public class Test {

	public static void post_pruning(int l, int k){
		/* code here */
		//return new Dtree(testtree,0);
	}
	
	public double calcAccuracy(DTree dPrime, String csvFile){
		UnitSet data = new UnitSet(csvFile);
		int correctInst = 0; //number of correctly classified instances
		Node root = dPrime;
		Node currNode; //current Node we're on

		for (List row : data){
			currNode = root;
			int attribute = root.attriId;
			int actualClass = row.get(row.size() - 1);
			int predClass = -1; //predicted class
			while(currNode.left != null && currNode.right != null){
				if(row.get(attribute) == 1){
					currNode = currNode.left;
				}
				else{ // == 0
					currNode = currNode.right;
				}
			}//end while

			predClass = currNode.classType //assign predicted class to the instance
			if (actualClass == predClass){
				correctInst++;
			}

		} // end for		



		
		//return accuracy = percentage of correctly classified examples

		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String csvFile = "/Users/Rachel/Desktop/DT/training_set2.csv";
		
		/* user input */
		if(args.length != 6){
			System.out.println("Incorrect number of parameters, need 6");
			System.out.println("args length: " + args.length);
			System.exit(0);
		}
		
		UnitSet testTree = new UnitSet(csvFile);
		
		DTree d = new DTree(testTree, 0); // Original tree
		
		/* algorithm call here */		
		post_pruning(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		
		System.out.print(d.root);

		// PRUNING STARTS HERE

	}

}
