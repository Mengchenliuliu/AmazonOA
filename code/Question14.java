package code;
import java.util.*;

public class Question14 {

  public static void main(String[] args) {
    int[] res = maximumBookCopies(new int[]{6, 6, 2, -6, -2, - 6});
    for(int num : res){
      System.out.println(num);
    }
  }
  //时间复杂度为O(nlogn)
  public static int[] maximumBookCopies(int[] portalUpdate) {
    if(portalUpdate == null || portalUpdate.length == 0){
      return new int[0];
    }
    int n = portalUpdate.length;
    int[] res = new int[n];
    Map<Integer, Integer> bookMap = new HashMap<>();
    TreeMap<Integer, Integer> countMap = new TreeMap<>();
    int index = 0;

    for(int p : portalUpdate){
      int id = Math.abs(p);
      int change = p > 0? 1 : -1;
      int preCount = bookMap.getOrDefault(id, 0);
      int curCount = preCount + change;

      if(curCount > 0){
        bookMap.put(id, curCount);
      }else {
        bookMap.remove(id);
      }

      if(countMap.containsKey(preCount)){
        if(countMap.get(preCount) == 1){
          countMap.remove(preCount);
        }else {
          countMap.put(preCount, countMap.get(preCount) - 1);
        }
      }
      countMap.put(curCount, countMap.getOrDefault(curCount,0) + 1);
      res[index++] = countMap.isEmpty()? 0 : countMap.lastKey();

    }
    return res;

  }

}
