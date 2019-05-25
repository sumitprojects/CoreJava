import chapter7.Navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Scanner;

class Node {
	private static ArrayList<Node> nodeArrayList = new ArrayList<>();
	private static int rightMax = 1;
	private static int downMax = 1;
	private long time;
	private boolean visited = false;
	private EnumMap<Navigation, Integer> data;
	private Node current;
	
	private Node () {
	}
	
	private Node (int index, int value, int lengthOfGrid) {
		data = new EnumMap<>(Navigation.class);
		this.time = value;
		data.put(Navigation.UP, (index - lengthOfGrid) > 0 ? (index - lengthOfGrid) : -1);
		data.put(Navigation.DOWN, (index + lengthOfGrid) <= lengthOfGrid * lengthOfGrid ? (index + lengthOfGrid) : -1);
		data.put(Navigation.RIGHT, (index % lengthOfGrid == 0) ? -1 : index + 1);
		data.put(Navigation.LEFT, ((index - 1) % lengthOfGrid != 0) ? (index - 1) : -1);
	}
	
	static Node getInstance () {
		return new Node();
	}
	
	static void addNode (int index, int value, int lengthOfGrid) {
		nodeArrayList.add(new Node(index, value, lengthOfGrid));
	}
	
	static Node getFirst () {
		return nodeArrayList.get(0);
	}
	
	static void traverseNode (Node e, long time) {
		Node minNode = e.getMinNode();
		if (minNode != null) {
			if (time > minNode.getTime() && time > 0) {
				minNode.visit();
				traverseNode(minNode, time - minNode.getTime());
			}
		} else {
			System.out.println(rightMax * downMax);
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
		Node right, left, top, bottom;
		long minTime;
		if (getRight()) {
			min.add((this.getRightNode()).getTime());
		}
		if (getDown()) {
			min.add((this.getDownNode()).getTime());
		}
		if (this.getUp()) {
			min.add((this.getUpNode()).getTime());
		}
		if (this.getLeft()) {
			min.add((this.getLeftNode()).getTime());
		}
		minTime = Collections.min(min);
		if (this.getRight()) {
			if ((this.getRightNode()).getTime() == minTime && this.getRightNode().isVisited()) {
				if (rightMax < (nodeArrayList.size() / 2)) {
					rightMax++;
				}
				return this.getRightNode();
			}
		}
		
		if (getDown()) {
			if ((getDownNode()).getTime() == minTime && getDownNode().isVisited()) {
				if (downMax < (nodeArrayList.size() / 2)) {
					downMax++;
				}
				return getDownNode();
			}
		}
		
		if (getUp()) {
			if ((getUpNode()).getTime() == minTime && getUpNode().isVisited()) {
				return getRightNode();
			}
		}
		
		if (getLeft()) {
			if ((getLeftNode()).getTime() == minTime && getLeftNode().isVisited()) {
				return getLeftNode();
			}
		}
		
		return null;
	}
	
	
	@Override
	public String toString () {
		return "[" +
				"time=" + time +
				"    data=" + data +
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
		try {
			Node.traverseNode(Node.getFirst(), time);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}