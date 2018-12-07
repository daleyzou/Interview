package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 56. 合并区间
 * @Date: Created in 15:27 2018-10-12
 * @Modified By:
 */
public class LeetCode56 {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int size = intervals.size();
        int[] starts = new int[size];
        int[] ends = new int[size];

        for (int i = 0; i < size; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0;
        while (i < size){
            int st = i;
            while (i < size - 1 && starts[i + 1] <= ends[i])  i++;
            result.add(new Interval(starts[st], ends[i]));

            i++;
        }

        return result;
    }
}
