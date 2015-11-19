/*
 * Binary Tree Level Order Traversal My Submissions Question
Total Accepted: 75104 Total Submissions: 248575 Difficulty: Easy
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


二叉树的层次遍历，利用两个队列，从根节点开始，放到第一个队列中，下一层次的节点放到另一个队列中，以此类推！（注意对空树的处理）
 */

package test;

import java.util.*;

public class Day12 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode( int x ){
			val = x;
		}
	}
	
	public static void main(String[] args){
		Day12 d = new Day12();
		char t[] = {3,9,20,'#','#',15,7};
		TreeNode root = d.create(t);
		List<List<Integer>> ans = d.levelOrder(root);
		for( int i = 0; i < ans.size(); i++ ){
			for( int j = 0; j < ans.get(i).size(); j++ ){
				System.out.print(ans.get(i).get(j) + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public TreeNode create( char t[] ){
		TreeNode root = null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int n = 0;
		if( t.length == 0 || t[n] == '#' ){
			return root;
		}
		
		root = new TreeNode(t[n]);
		q.offer(root);
		n++;
		while( !q.isEmpty() && n < t.length ){
			TreeNode p = q.poll();
			if( n < t.length && !(t[n] == '#') ){
				TreeNode l = new TreeNode(t[n]);
				p.left = l;
				q.offer(l);
			}else{
				p.left = null;
			}
			n++;
			if( n < t.length && !(t[n] == '#') ){
				TreeNode r = new TreeNode(t[n]);
				p.right = r;
				q.offer(r);
			}else{
				p.right = null;
			}
			n++;
		}
		return root;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null ){
        	return ans;
        }
        List<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> qf = new LinkedList<TreeNode>();
        Queue<TreeNode> qs = new LinkedList<TreeNode>();
        int flag = 1;
        qf.offer(root);
        temp.add(root.val);
        ans.add(temp);
        while( !qf.isEmpty() || !qs.isEmpty() ){
        	if( flag == 1 ){
        		List<Integer> temp1 = new ArrayList<Integer>();
        		while( !qf.isEmpty() ){
        			TreeNode p = qf.poll();
        			if( p.left != null ){
        				qs.offer(p.left);
        				temp1.add(p.left.val);
        			}
        			if( p.right != null ){
        				qs.offer(p.right);
        				temp1.add(p.right.val);
        			}
        		}
        		if( temp1.size() > 0 ){
        			ans.add(temp1);
        		}
        		flag = 0;
        	}
        	if( flag == 0 ){
        		List<Integer> temp2 = new ArrayList<Integer>();
        		while( !qs.isEmpty() ){
        			TreeNode p = qs.poll();
        			if( p.left != null ){
        				qf.offer(p.left);
        				temp2.add(p.left.val);
        			}
        			if( p.right != null ){
        				qf.offer(p.right);
        				temp2.add(p.right.val);
        			}
        		}
        		if( temp2.size() > 0 ){
        			ans.add(temp2);
        		}
        		flag = 1;
        	}
        }
        return ans;
    }
}
