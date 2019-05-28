import java.util.*;

enum Navigation {
	UP, DOWN, RIGHT, LEFT
}
class Node {
	private static ArrayList<Node> nodeArrayList = new ArrayList<>();
	private static int rightMax = 1;
	private static int downMax = 1;
	public static long timeLimit;
	private long time;
	private static int lengthOfGrid = 0;
	private boolean visited = false;
	private EnumMap<Navigation, Integer> data;
	private int index;
	private Node () {
	}
	
	private Node (int index, long value, int lengthOfGrid) {
		data = new EnumMap<>(Navigation.class);
		this.time = value;
		this.index = index;
		data.put(Navigation.UP, (index - lengthOfGrid) > 0 ? (index - lengthOfGrid) : -1);
		data.put(Navigation.DOWN, (index + lengthOfGrid) <= lengthOfGrid * lengthOfGrid ? (index + lengthOfGrid) : -1);
		data.put(Navigation.RIGHT, (index % lengthOfGrid == 0) ? -1 : index + 1);
		data.put(Navigation.LEFT, ((index - 1) % lengthOfGrid != 0) ? (index - 1) : -1);
	}
	
	static void addNode (int index, int value, int lengthOfGrid) {
		Node.lengthOfGrid = lengthOfGrid;
		nodeArrayList.add(new Node(index, value, lengthOfGrid));
	}
	
	static Node getFirst () {
		return nodeArrayList.get(0);
	}
	
	static void traverseNode (Node e, long time) {
		Node minNode = e.getMinNode();
		if (rightMax == lengthOfGrid && downMax == lengthOfGrid) {
			System.out.println(rightMax * downMax);
		} else {
			if (minNode != null) {
				timeLimit -= minNode.getTime();
				if (timeLimit > 0) {
					minNode.visit();
					traverseNode(minNode, time - minNode.getTime());
				} else {
					//				System.out.println("ANS1 : " + rightMax + " " + downMax + " " + timeLimit);
					System.out.println(rightMax * downMax);
				}
			} else {
				makeAllVisible(e);
				if (timeLimit > 0) {
					traverseNode(e, time);
				} else {
					//				System.out.println("ANS2 : " + rightMax + " " + downMax + " " + timeLimit);
					System.out.println(rightMax * downMax);
				}
			}
		}
	}
	
	
	private static void makeAllVisible (Node e) {
		try {
			if (e.getLeft()) {
				if (Objects.requireNonNull(e.getLeftNode()).isVisited()) {
					e.getLeftNode().visited = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (e.getDown()) {
				if (Objects.requireNonNull(e.getDownNode()).isVisited()) {
					e.getLeftNode().visited = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			if (e.getUp()) {
				if (Objects.requireNonNull(e.getUpNode()).isVisited()) {
					e.getLeftNode().visited = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			if (e.getRight()) {
				if (Objects.requireNonNull(e.getRightNode()).isVisited()) {
					e.getLeftNode().visited = false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void visit () {
		this.visited = true;
	}
	
	private boolean isVisited () {
		return !visited;
	}
	
	private boolean getUp () {
		return getUpNode() != null;
	}
	
	private boolean getDown () {
		return getDownNode() != null;
	}
	
	private boolean getRight () {
		return getRightNode() != null;
	}
	
	private boolean getLeft () {
		return getLeftNode() != null;
	}
	
	private Node getUpNode () {
		if (data.get(Navigation.UP) != -1) {
			return nodeArrayList.get(data.get(Navigation.UP) - 1);
		}
		return null;
	}
	
	private Node getDownNode () {
		if (data.get(Navigation.DOWN) != -1) {
			return nodeArrayList.get(data.get(Navigation.DOWN) - 1);
		}
		return null;
	}
	
	private Node getLeftNode () {
		if (data.get(Navigation.LEFT) != -1) {
			return nodeArrayList.get(data.get(Navigation.LEFT) - 1);
		}
		return null;
	}
	
	private Node getRightNode () {
		if (data.get(Navigation.RIGHT) != -1) {
			return nodeArrayList.get(data.get(Navigation.RIGHT) - 1);
		}
		return null;
	}
	
	private long getTime () {
		return time;
	}
	
	private Node getMinNode () {
		ArrayList<Long> min = new ArrayList<>();
		Node right = getRightNode(), left = getLeftNode(), top = getUpNode(), bottom = getDownNode();
		long minTime = 0;
		if (right != null) {
			if (right.isVisited()) {
				min.add(right.getTime());
			}
		}
		if (bottom != null) {
			if (bottom.isVisited()) {
				min.add(bottom.getTime());
			}
		}
		if (top != null) {
			if (top.isVisited()) {
				min.add(top.getTime());
			}
		}
		if (left != null) {
			if (left.isVisited()) {
				min.add(left.getTime());
			}
		}
		if (!min.isEmpty()) {
			minTime = Collections.min(min);
			if (top != null) {
				if (top.getTime() == minTime && top.isVisited() && (timeLimit - top.getTime()) >= 0) {
					return top;
				}
			}
			if (bottom != null) {
				if (bottom.getTime() == minTime && bottom.isVisited() && (timeLimit - bottom.getTime()) >= 0) {
					if (downMax < lengthOfGrid && ((bottom.index / lengthOfGrid) + 1 > downMax)) {
						downMax++;
					}
					return bottom;
				}
			}
			
			if (left != null) {
				if (left.getTime() == minTime && left.isVisited() && (timeLimit - left.getTime()) >= 0) {
					return left;
				}
			}
			
			if (right != null) {
				if (right.getTime() == minTime && right.isVisited() && (timeLimit - right.getTime()) >= 0) {
					if (rightMax < lengthOfGrid) {
						rightMax++;
					}
					return right;
				}
			}
		}
//
//		if(minTime>timeLimit){
//			if(right!=null && right.getTime()==minTime)return right;
//			else if(left!=null && left.getTime()==minTime)return left;
//			else if(top!=null && top.getTime()==minTime)return top;
//			else if(bottom!=null && bottom.getTime()==minTime)return bottom;
//		}
		return null;
	}
	
	
	@Override
	public String toString () {
		return "[" +
				"time=" + time +
				"    data=" + data +
				"    visited= " + visited +
				']' + "\n";
	}
	
	void printNodes () {
		for (Node n : nodeArrayList) {
			System.out.println(n);
		}
	}
}

public class TestClass {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt(), time = sc.nextInt();
		
		for (int i = 1; i <= length * length; i++) {
			Node.addNode(i, sc.nextInt(), length);
		}
		Node.timeLimit = time;
		Node.traverseNode(Node.getFirst(), time);
		try {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}