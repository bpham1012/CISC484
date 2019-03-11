
public class VTree {
	
	Node root = null;
	int N = 0;
	
	//Input:	UnitSet
	//			Depth --- to count how many "| " should add.
	//DTree:	To draw the whole tree.
	public VTree(UnitSet uset, int depth) {
		this.root = this.genVNode(uset, depth);
	}
	
	public VTree(Node root, int depth) {
		this.root = root;
	}

	public Node genVNode(UnitSet uset, int depth) {

		int attriId = -1; //Initialize to -1
		attriId = uset.getBestVarianceAttriId(); //Calculate the root Id

		Node current = new Node(attriId, depth); //Initialize the Root
		if (attriId == -1) {
			// set is pure
			current.setClassType(uset.getMainClassType());
		} else {
			// recursive call left and right node
			current.setLeft(genVNode(uset.getLeft(attriId), depth + 1));
			N++;
			current.setRight(genVNode(uset.getRight(attriId), depth + 1));
			N++;
		}
		return current;
	}
	



}
