import java.io.IOException;

public class Test {

	public double calcAccuracy(DTree dPrime, File data){
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String csvFile = "/Users/wang/Desktop/data_sets1/training_set2.csv";
		
		UnitSet testTree = new UnitSet(csvFile);
		
		DTree tree = new DTree(testTree, 0);
		
		System.out.print(tree.root);
	}

}
