/*
 * Binary Tree Zigzag Level Order Traversal My Submissions Question
Total Accepted: 46755 Total Submissions: 173512 Difficulty: Medium
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * 
 */

package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import test.Day12.TreeNode;

public class Day13 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode( int x ){
			val = x;
		}
	}
	
	public static void main(String[] args){
		Day13 d = new Day13();
		char t[] = {3,9,20,'#','#',15,7};
		TreeNode root = d.create(t);
		List<List<Integer>> ans = d.zigzagLevelOrder(root);
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
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        			List<Integer> t = new ArrayList<Integer>();
        			for( int i = temp1.size()-1; i >= 0; i-- ){
        				t.add(temp1.get(i));
        			}
        			ans.add(t);
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
