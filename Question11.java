import java.util.Stack;

import java.util.*;
public class Question11 {

  public static void main(String[] args) {
    System.out.println(countSpikes(new int[]{1,2,8,5,3,4}, 2));
  }

  //利用treemap，将查询有多少个小的数时间复杂度降低到O(logn),整体时间复杂度为O(nlogn).
  public static int countSpikes(int[] prices, int k) {
    if(prices == null || prices.length == 0){
      return 0;
    }
    int n = prices.length;
    int[] leftSmaller = new int[n];
    int[] rightSmaller = new int[n];
    int res = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for(int i = 0; i < n; i++){
      leftSmaller[i] = map.headMap(prices[i]).values().stream().mapToInt(Integer::intValue).sum();
      map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
    }

    map.clear();
    for(int i = n-1; i >= 0; i--){
      rightSmaller[i] = map.headMap(prices[i]).values().stream().mapToInt(Integer::intValue).sum();
      map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
    }

    for(int i = 0; i < n; i++){
      if(leftSmaller[i] >= k && rightSmaller[i] >= k){
        res++;
      }
    }


    return res;

  }

}
