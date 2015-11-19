/*
 * Insert Interval My Submissions Question
Total Accepted: 45963 Total Submissions: 206009 Difficulty: Hard
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test.Day16.Interval;

public class Day17 {
	public class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	public static void main(String[] args){
		Day17 d = new Day17();
		List<Interval> in = d.create();
		Interval ins = d.newIn();
		List<Interval> l = d.insert(in, ins);
        for( int i = 0; i < l.size(); i++ ){
	    	System.out.print(l.get(i).start +  " " + l.get(i).end + ", ");
	    }
	    System.out.println();
	}
	
	public List<Interval> create(){
		List<Interval> in = new ArrayList<Interval>();
		in.add(new Interval(1, 2));
		in.add(new Interval(3, 5));
		in.add(new Interval(6, 7));
		in.add(new Interval(8, 10));
		in.add(new Interval(12, 16));
//		in.add(new Interval(1, 3));
//		in.add(new Interval(1, 3));
		return in;
	}
	public Interval newIn(){
		return new Interval(4, 9);
	}
	public List<Interval> newCreate(){
		List<Interval> in = new ArrayList<Interval>();
		in.add(new Interval(1, 4));
		in.add(new Interval(4, 5));
//		in.add(new Interval(2, 2));
//		in.add(new Interval(3, 4));
//		in.add(new Interval(3, 4));
		//in.add(new Interval(1, 3));
		//in.add(new Interval(1, 3));
		return in;
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        if( newInterval == null ){
        	return ans;
        }
        intervals.add(newInterval);
        ans = merge(intervals);
        return ans;
    }
    
    public List<Interval> merge(List<Interval> intervals) {
		List<Interval> l = new ArrayList<Interval>();
		if( intervals.size() == 0 ){
			return l;
		}
	    Collections.sort(intervals, new Comparator<Interval>() {
		    public int compare(Interval arg0, Interval arg1) {
		        if( arg0.start != arg1.start ){
		        	return arg0.start > arg1.start? 1 : -1;
		        }
		        return arg0.end > arg1.end? -1 : 1;
		    }
		});

	    int x = intervals.get(0).start;
	    int y = intervals.get(0).end;
        for( int i = 0; i < intervals.size(); ){
        	int flag = 0;
        	while( i < intervals.size() && intervals.get(i).start <= y ){
        		y = Math.max(intervals.get(i).end, y);
        		i++;
        		flag = 1;
        	}
    		l.add(new Interval(x, y));
    		if( flag == 0 ){
    			i++;
    		}
    		if( i < intervals.size() ){
	    		x = intervals.get(i).start;
	    	    y = intervals.get(i).end;
	    	    if( i == intervals.size() - 1 ){
	    	    	l.add(new Interval(x, y));
	        		break;
	    	    }
	    	}else{
	    		break;
	    	}
        }

		return l;
	}
	
}
