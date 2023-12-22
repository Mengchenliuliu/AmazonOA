package code;

import java.util.*;
public class Question10 {

  public static void main(String[] args) {
    int[] res = getMeanRankCount(new int[]{1,2,3,4,5});
    for(int num : res){
      System.out.println(num);
    }
  }

  //时间复杂度为O(n^2)，存在过不了所有case的情况
  public static int[] getMeanRankCount(int[] rank) {
    int n = rank.length;
    // 存储每个平均值出现的次数
    Map<Integer, Integer> averageCountMap = new HashMap<>();
    // 累积和数组
    int[] prefixSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + rank[i - 1];
    }

    // 遍历所有可能的子数组
    for (int start = 0; start < n; start++) {
      for (int end = start + 1; end <= n; end++) {
        int sum = prefixSum[end] - prefixSum[start];
        int length = end - start;
        // 如果 sum 能被 length 整除，则该子数组的平均值是一个整数
        if (sum % length == 0) {
          int average = sum / length;
          averageCountMap.put(average, averageCountMap.getOrDefault(average, 0) + 1);
        }
      }
    }

    // 构造结果数组
    int[] meanCount = new int[n];
    for (int i = 1; i <= n; i++) {
      meanCount[i - 1] = averageCountMap.getOrDefault(i, 0);
    }
    return meanCount;
  }

}
