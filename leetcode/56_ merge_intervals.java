/*56. Merge Intervals
Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public List<Interval> merge(List<Interval> intervals) {
    List<Interval> ans = new ArrayList<>();
    if (intervals.size() == 0)
        return ans; 
    //将第一个节点加入，作为合并好的节点列表
    ans.add(new Interval(intervals.get(0).start, intervals.get(0).end));
    //遍历其他的每一个节点
    for (int i = 1; i < intervals.size(); i++) {
        Interval start = null;
        Interval end = null;
        //新加入节点的左端点
        int i_start = intervals.get(i).start;
        //新加入节点的右端点
        int i_end = intervals.get(i).end;
        int size = ans.size();
        //情况 6，保存囊括的节点，便于删除
        List<Interval> in = new ArrayList<>(); 
        //遍历合并好的每一个节点
        for (int j = 0; j < size; j++) {
            //找到左端点在哪个节点内
            if (i_start >= ans.get(j).start && i_start <= ans.get(j).end) {
                start = ans.get(j);
            }
            //找到右端点在哪个节点内
            if (i_end >= ans.get(j).start && i_end <= ans.get(j).end) {
                end = ans.get(j);
            }
            //判断新加入的节点是否囊括当前旧节点，对应情况 6
            if (i_start < ans.get(j).start && i_end >ans.get(j).end) {
                in.add(ans.get(j));
            } 

        }
        //删除囊括的节点
        if (in.size() != 0) { 
            for (int index = 0; index < in.size(); index++) {
                ans.remove(in.get(index));
            } 
        }
        //equals 函数作用是在 start 和 end 有且只有一个 null，或者 start 和 end 是同一个节点返回 true，相当于情况 2 3 4 中的一种
        if (equals(start, end)) {
            //如果 start 和 end 都不等于 null 就代表情况 4

            // start 等于 null 的话相当于情况 3
            int s = start == null ? i_start : start.start;
            // end 等于 null 的话相当于情况 2
            int e = end == null ? i_end : end.end;
            ans.add(new Interval(s, e));
            // start 和 end 不是同一个节点，相当于情况 1
        } else if (start!= null && end!=null) {
            ans.add(new Interval(start.start, end.end));
            // start 和 end 都为 null，相当于情况 5 和 情况 6 ，加入新节点
        }else if (start == null) {
            ans.add(new Interval(i_start, i_end));
        }
        //将旧节点删除
        if (start != null) {
            ans.remove(start);
        }
        if (end != null) {
            ans.remove(end);
        }

    }
    return ans;
}

private boolean equals(Interval start, Interval end) { 
    if (start == null && end == null) {
        return false;
    }
    if (start == null || end == null) {
        return true;
    }
    if (start.start == end.start && start.end == end.end) {
        return true;
    }
    return false;
}

//解法二，先按左节点排序
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
}

public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new IntervalComparator());

    LinkedList<Interval> merged = new LinkedList<Interval>();
    for (Interval interval : intervals) {
        //最开始是空的，直接加入
        //然后对应情况 1，新加入的节点的左端点大于最后一个节点的右端点
        if (merged.isEmpty() || merged.getLast().end < interval.start) {
            merged.add(interval);
        }
        //对于情况 2 ，更新最后一个节点的右端点
        else {
            merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        }
    }

    return merged;
}

}

https://leetcode.windliang.cc/leetCode-56-Merge-Intervals.html
