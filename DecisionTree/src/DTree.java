
public class DTree {
	Node root = null;
	int N = 0;
	
	//Input:	UnitSet
	//			Depth --- to count how many "| " should add.
	//DTree:	To draw the whole tree.
	public DTree(UnitSet uset, int depth) {
		this.root = this.genDTNode(uset, depth);
	}
	
	public DTree(Node root, int depth) {
		this.root = root;
	}

	public Node genDTNode(UnitSet uset, int depth) {

		int attriId = -1; //Initialize to -1
		attriId = uset.getBestEntroAttriId(); //Calculate the root Id

		Node current = new Node(attriId, depth); //Initialize the Root
		if (attriId == -1) {
			// set is pure
			current.setClassType(uset.getMainClassType());
		} else {
			// recursive call left and right node
			current.setLeft(genDTNode(uset.getLeft(attriId), depth + 1));
			N++;
			current.setRight(genDTNode(uset.getRight(attriId), depth + 1));
			N++;
		}
		return current;
	}
	


}
