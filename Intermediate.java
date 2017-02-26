import java.util.*;

/*

Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}

*/

public class Intermediate {
    public static class Interval {
        final int start;
        final int end;

        Interval(int s, int e) { this.start = s; this.end = e; }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
    // The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals.

    public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<Interval>();
 
    if(intervals==null||intervals.size()==0)
        return result;
 
    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            if(i1.start != i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        }
    });
 
    Interval pre = intervals.get(0);
    for(int i=0; i< intervals.size(); i++){
        Interval curr = intervals.get(i);
        if(curr.start > pre.end){
            result.add(pre);
            pre = curr;
        }else{
            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
            pre = merged;
        }
    }
    result.add(pre);
 
    return result;
}
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        List<Interval> output = new ArrayList<Interval>();

        //Given [1,3],[2,6],[8,10],[15,18],

        input.add(new Interval(1,3));

        input.add(new Interval(8,10));

        input.add(new Interval(15,18));

        input.add(new Interval(2,6));

        output = merge(input);
        System.out.println("input interval: " + input);
        System.out.println("merged interval: " + merge(input));

    }

}