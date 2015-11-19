/*
 * Merge Intervals My Submissions Question
Total Accepted: 50784 Total Submissions: 216550 Difficulty: Hard
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

≈≈–Ú£¨»ª∫Û…®√Ë
 */

package test;

import java.util.*;

public class Day16 {
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
		Day16 d = new Day16();
		List<Interval> in = d.create();
		List<Interval> l = d.merge(in);
        for( int i = 0; i < l.size(); i++ ){
	    	System.out.print(l.get(i).start +  " " + l.get(i).end + ", ");
	    }
	    System.out.println();
	}
	
	public List<Interval> create(){
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
