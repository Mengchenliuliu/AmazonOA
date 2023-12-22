package code;

import java.util.*;

public class Question2 {

  public static void main(String[] args) {
    int[] priority = new int[]{6,6,6,1,2,2};
    int[] res = getPrioritiesAfterExecution(priority);
    for(int num : res){
      System.out.println(num);
    }
  }

  public static int[] getPrioritiesAfterExecution(int[] priority){
    if(priority == null || priority.length == 0){
      return new int[0];
    }
    Map<Integer, PriorityQueue<Integer>> indexMap = new HashMap<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b -a);
    for(int i = 0; i < priority.length; i++){
      if(!indexMap.containsKey(priority[i])){
        indexMap.put(priority[i], new PriorityQueue<>());
        queue.add(priority[i]);
      }
      indexMap.get(priority[i]).add(i);
    }

    while (!queue.isEmpty()){
      Integer pr = queue.poll();
      if(pr == 0){
        break;
      }
      if(indexMap.get(pr).size() < 2){
        continue;
      }
      PriorityQueue<Integer> list = indexMap.get(pr);
      int index1 = list.poll();
      int index2 = list.poll();
      if(list.size() == 0){
        indexMap.remove(pr);
      }else {
        queue.add(pr);
        indexMap.put(pr, list);
      }
      int newOne = pr/2;
      priority[index1] = Integer.MIN_VALUE;
      priority[index2] = newOne;
      if(!indexMap.containsKey(newOne)){
        indexMap.put(newOne, new PriorityQueue<>());
        queue.add(newOne);
      }
      indexMap.get(newOne).add(index2);
    }

    List<Integer> res = new ArrayList<>();
    for(int i = 0; i < priority.length; i++){
      if(priority[i] != Integer.MIN_VALUE){
        res.add(priority[i]);
      }
    }

    int[] result = new int[res.size()];
    for(int i = 0; i < res.size(); i++){
      result[i] = res.get(i);
    }
    return result;
  }

}
