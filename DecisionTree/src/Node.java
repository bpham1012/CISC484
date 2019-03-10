
public class Node {
	
	int depth;
	int attriId;
	int classType = -1;
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
	}
	
	public void setLeft(Node lnode) {
		this.left = lnode;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < depth; i++) {
			sb.append("| ");
		}
		
		
		sb.append("Node:{");
		if (this.attriId >= 0)
		sb.append(Util.list.get(this.attriId));
		sb.append(":");
		if (classType >= 0)
			sb.append(this.classType);
		sb.append("}\n");
		if (this.left != null)
		{
			sb.append(this.left);
		}
		if (this.right != null) 
		{

			sb.append(this.right);
		}
	
		
		
		return sb.toString();
	}
	

}
