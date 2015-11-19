/*
 * Populating Next Right Pointers in Each Node My Submissions Question
Total Accepted: 69600 Total Submissions: 191542 Difficulty: Medium
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * 思路：
很棒的一道题，可以认为是先序遍历。
（1）根据题述：左孩子为空，则右孩子一定为空，所以左孩子为空，则return
（2）如果左孩子不为空，则右孩子一定不为空，所以链接左孩子和右孩子即可（左孩子的next赋值为右孩子）
（3）由于先序遍历，所以父节点的next比子节点的next先被设置，故父节点不同的两个子节点进行连接，就可以用到父节点的next，
整题的精华便是：root.right.next = root.next.left;
 */

package test;

import java.util.LinkedList;
import java.util.Queue;

import test.Day12.TreeNode;

public class Day18 {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null, right = null, next = null;
	    TreeLinkNode(int x) { val = x; }
	}
	
	public static void main(String[] args){
		Day18 d = new Day18();
		char t[] = {10, 2, 3, 4, 5, 6, 7, '#', '#', '#', '#', '#', '#', '#', '#'};
		d.connect(d.create(t));
	}
	
	public TreeLinkNode create( char t[] ){
		TreeLinkNode root = null;
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		int n = 0;
		if( t.length == 0 || t[n] == '#' ){
			return root;
		}
		
		root = new TreeLinkNode(t[n]);
		q.offer(root);
		n++;
		while( !q.isEmpty() && n < t.length ){
			TreeLinkNode p = q.poll();
			if( n < t.length && !(t[n] == '#') ){
				TreeLinkNode l = new TreeLinkNode(t[n]);
				p.left = l;
				q.offer(l);
			}else{
				p.left = null;
			}
			n++;
			if( n < t.length && !(t[n] == '#') ){
				TreeLinkNode r = new TreeLinkNode(t[n]);
				p.right = r;
				q.offer(r);
			}else{
				p.right = null;
			}
			n++;
		}
		return root;
	}
	
	public void connect(TreeLinkNode root) {
		if( root == null || root.left == null ){
			return;
		}

    	root.left.next = root.right;
    	if( root.right != null )
    		System.out.println(root.left.val + "   -1-   " + root.right.val );
    	if( root.right != null && root.next != null ){
    		root.right.next = root.next.left;
    		if( root.next.left != null )
    			System.out.println(root.right.val + "   -2-   " + root.next.left.val + " " + root.next.val);
    	}
    	connect(root.left);
    	connect(root.right);
    }
}
