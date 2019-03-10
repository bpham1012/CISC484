import java.io.IOException;
import java.lang.Integer;

public class Test {

	public static void post_pruning(int l, int k){
		/* code here */
		//return new Dtree(testtree,0);
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
