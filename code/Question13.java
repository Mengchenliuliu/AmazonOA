package code;

import java.util.Arrays;

public class Question13 {

  public static void main(String[] args) {
    System.out.println(findMinimumOperations(new int[]{5,5,8,7}));
    System.out.println(findMinimumOperations(new int[]{2,4,1}));
    System.out.println(findMinimumOperations(new int[]{4,4,4,4,4,4,4}));
  }
  public static long findMinimumOperations(int[] boxes) {
    long res = 0;
    if(boxes == null || boxes.length == 0){
      return res;
    }
    Arrays.sort(boxes);
    long sum = 0;
    int n = boxes.length;
    for(int i = 0; i < n; i++){
      sum += boxes[i];
    }
    long average = sum/n, remain = sum % n;
    for(int i = n - 1; i >= 0; i--){
      if(remain == 0 && boxes[i] <= average){
        break;
      }
      if(remain > 0){
        res += boxes[i] - average - 1;
        remain--;
      }else {
        res += boxes[i] - average;
      }
    }
    return res;
  }

}
