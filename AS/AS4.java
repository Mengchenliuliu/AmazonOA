package AS;

import java.util.*;

public class AS4 {

  public static void main(String[] args) {
    System.out.println(getDistictPairs(new int[]{5,7,9,13,11,6,6,3,3}, 12));
    System.out.println(getDistictPairs(new int[]{1,3,46,1,3,9}, 47));
    System.out.println(getDistictPairs(new int[]{6,6,3,9,3,5,1}, 12));

  }
  public static int getDistictPairs(int[] stocksProfit, int target){
    if(stocksProfit == null || stocksProfit.length == 0){
      return 0;
    }
    Set<String> pairSet = new HashSet<>();
    Set<Integer> profitSet = new HashSet<>();
    for(int profit : stocksProfit){
      int value = target - profit;
      if(profitSet.contains(value)){
        String str = value >= profit? value + "," + profit : profit + "," + value;
        pairSet.add(str);
      }
      profitSet.add(profit);
    }
    return pairSet.size();
  }

}
