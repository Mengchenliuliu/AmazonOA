package AS;

import java.util.*;

public class OverlapArray {

  public static void main(String[] args) {
    int[][] res = getMergedIntervals(new int[][]{{7,7}, {2,3}, {6,11}, {1,2}});
    for(int[] arr : res){
      System.out.println(arr[0] + " " + arr[1]);
    }
  }
  public static int[][] getMergedIntervals(int[][] intervals){
    if(intervals == null || intervals.length == 0){
      return new int[0][0];
    }
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    int[] compare = intervals[0];
    List<int[]> res = new ArrayList<>();
    for(int i = 1; i < intervals.length; i++){
      if(compare[1] >= intervals[i][0]){
        compare[1] = Math.max(compare[1], intervals[i][1]);
      }else {
        res.add(compare);
        compare = intervals[i];
      }
    }
    res.add(compare);
    int[][] result = new int[res.size()][2];
    for(int i = 0; i < res.size(); i++){
      result[i] = res.get(i);
    }
    return result;
  }

}
