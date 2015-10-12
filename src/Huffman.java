package amagi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Huffman {
	static int MAX = 100;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		
		Node root = constructTree(strs);
		root.val = 100;
		System.out.println(findWays(root));
	}

	private static int findWays(Node root) {
		int total = root.val;
		Node left = root.left;
		Node right = root.right;

		if (left == null && right == null) {
			 return 1;
		}

		int ways = 0;
		for (int i = total / 2; i > 0; i--) {
				root.left.val = i;
				root.right.val = total - i;
				if(!validateFreq(root)){
					continue;
				}
				if (root.right.val <= MAX) {
					int l = findWays(root.left);
					int r = findWays(root.right);

					ways += l * r;
				}
				if (root.val == 100) {
					root.levelOrder(root);
					System.out.println("");
				}
		}
		return ways;
	}

	private static boolean validateFreq(Node root) {
		Node leftSibling = root.leftSibling;
		if(null!=leftSibling){
			Node left = root.left;
			Node right = root.right;
			Node lleft  = leftSibling.left;
			Node lright = leftSibling.right;
			
			if(left.val > leftSibling.val || right.val > leftSibling.val){
				return false;
			}
			if(null !=lright){
				if(left.val < lright.val  || right.val < lright.val){
					return false;
				}
			}
			
		}
		return true;
	}

	private static Node constructTree(String[] args) {
		Node root = new Node(100, null, null, null);
		for (String arg : args) {
			constructPath(root, arg);
		}
		return root;
	}

	public static void constructPath(Node n, String arg) {
		Node tmp = n;
		for (char c : arg.toCharArray()) {
			tmp = tmp.find(c);
		}
	}

	public static class Node {
		Integer val;
		Node left;
		Node right;
		Node leftSibling;

		private Node(Integer val, Node left, Node right, Node leftSibling) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.leftSibling = leftSibling;
		}

		public Node find(char c) {
			if (c == '0') {
				left = left != null ? left : new Node(null, null, null, null);
				return left;
			} else if (c == '1') {
				right = right != null ? right : new Node(null, null, null, left);
				return right;
			}
			return null;
		}

		private static void levelOrder(Node root) {
			Queue<Node> printQ = new LinkedList<Node>();
			printQ.add(root);

			while (!printQ.isEmpty()) {
				Node temp = printQ.poll();
				if (null != temp) {
					System.out.print(temp.val + "\t");
					printQ.add(temp.left);
					printQ.add(temp.right);

				}
			}

		}
	}

}