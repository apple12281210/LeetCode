/*
 * Populating Next Right Pointers in Each Node II My Submissions Question
Total Accepted: 49588 Total Submissions: 153776 Difficulty: Hard
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
Subscribe to see which companies asked this question
 * 思路：
http://www.cnblogs.com/x1957/p/3521212.htmll
思路依然是层次遍历，由于层次之间有next指针，所以不用开队列，但是需要找到下一层的起始节点作为下一次连接的根结点，再记录一个上一次的连接节点。
 */

package test;

import java.util.LinkedList;
import java.util.Queue;

public class Day19 {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null, right = null, next = null;
	    TreeLinkNode(int x) { val = x; }
	}
	
	public static void main(String[] args){
		Day19 d = new Day19();
		char t[] ={2,1,3,0,7,9,1,2,'#',1,0,'#','#',8,8,'#','#','#','#',7};
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
		while( root != null ){
			TreeLinkNode start = null;
			TreeLinkNode pre = null;
			while( root != null ){
				//getStart
				if( start == null ){
					if( root.left != null ){
						start = root.left;
					}else if( root.right != null ){
						start = root.right;
					}
				}
				
				if( root.left != null ){
					if( pre == null ){
						pre = root.left;
					}else{
						pre.next = root.left;
						//System.out.println(pre.val + " " + root.left.val);
						pre = root.left;
					}
				}
				if( root.right != null ){
					if( pre == null ){
						pre = root.right;
					}else{
						pre.next = root.right;
						//System.out.println(pre.val + " " + root.right.val);
						pre = root.right;
					}
				}
				root = root.next;
			}
			root = start;
		}
    }
	

}
