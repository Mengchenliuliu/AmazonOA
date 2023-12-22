import java.util.*;
public class Question7 {

  public static void main(String[] args) {
    System.out.println(getMinimumFruits(new int[]{1,2,5,6}));
    System.out.println(getMinimumFruits(new int[]{3,3,1,1,2}));
  }
  public static int getMinimumFruits(int[] fruits){
    if(fruits == null || fruits.length == 0){
      return 0;
    }
    Map<Integer, Integer> countMap = new HashMap<>();
    for(int num : fruits){
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
    for(Integer key : countMap.keySet()){
      queue.add(new int[]{key, countMap.get(key)});
    }

    while (queue.size() >= 2){
      int[] arr1 = queue.poll();
      int[] arr2 = queue.poll();
      if(arr1[1] > 1){
        queue.add(new int[]{arr1[0], arr1[1] - 1});
      }
      if(arr2[1] > 1){
        queue.add(new int[]{arr2[0], arr2[1] - 1});
      }
    }
    return queue.isEmpty()? 0 : queue.poll()[1];
  }

}
