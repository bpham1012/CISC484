
public class Node {
	
	int depth;
	int attriId;
	int classType = -1;
	boolean isLeft; //1 if it's left child, 0 if it's right child
	int orderNum = -1;
	Node left, right;
	
	public Node(int item, int depth) {
		
		attriId = item;
		this.depth = depth;
		left = null;
		right = null;
		
	}
	
	public void setClassType(int num) {
		this.classType = num;
	}
	
	public void setRight(Node rnode) {
		this.right = rnode;
		rnode.isLeft = false;
	}
	
	public void setLeft(Node lnode) {
		this.left = lnode;
		lnode.isLeft = true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		// Print the left branch header
		for (int i = 0; i < depth; i++)
			sb.append("| ");
		sb.append(Util.list.get(attriId));
		sb.append(" = 0 : ");
		if (this.left != null) {
			if (this.left.classType >= 0) {
			// If left is a leaf node add class type
				sb.append(this.left.classType);
				sb.append("\n");
			} 
			else {
				sb.append("\n");
				sb.append(this.left);
			}
		}
		// Print the right branch header
		for (int i = 0; i < depth; i++)
			sb.append("| ");
		sb.append(Util.list.get(attriId));
		sb.append(" = 1 : ");
		if (this.right != null) {
			if (this.right.classType >= 0) {
			// If right is a leaf node add class type
				sb.append(this.right.classType);
				sb.append("\n");
			} else {
				sb.append("\n");
				sb.append(this.right);
			}
		}
		return sb.toString();
	}

}
